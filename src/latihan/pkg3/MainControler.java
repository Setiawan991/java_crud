/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package latihan.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainControler implements Initializable {

 @FXML
private TableColumn<user, String> colFullname;

@FXML
private TableColumn<user, String> colPassword;

@FXML
private TableColumn<user, String> colUsername;

@FXML
private TableView<user> tblViewUsers;

    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Button btnUpdate;
    @FXML private TextField txtFullname;
    @FXML private TextField txtPassword;
    @FXML private TextField txtUsername;

private user selectedUser;
private void loadDataUsers(){
    ObservableList<user> userList = userDAO.getUsers();
    tblViewUsers.setItems(userList);
}

@Override
public void initialize(URL url, ResourceBundle rb) {
    // Bind the TableView columns to the corresponding properties of the 'user' class
    colUsername.setCellValueFactory(new PropertyValueFactory<user, String>("username"));
    colPassword.setCellValueFactory(new PropertyValueFactory<user, String>("password"));
    colFullname.setCellValueFactory(new PropertyValueFactory<user, String>("fullname"));
    loadDataUsers();
    tblViewUsers.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> selectUser(newValue)
    );
    }



private void clearFields() {
    txtUsername.clear();
    txtPassword.clear();
    txtFullname.clear();
    selectedUser = null; // Reset selected user
}

// Metode untuk menampilkan pesan alert
private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}
        // Metode untuk memilih user dari TableView
private void selectUser(user user) {
    if (user != null) {
        selectedUser = user;
        txtUsername.setText(user.getUsername());
        txtPassword.setText(user.getPassword());
        txtFullname.setText(user.getFullname());
    }
    
}
// Metode untuk menyimpan user baru (Create)
@FXML
private void addUser() {
    String username = txtUsername.getText();
    String password = txtPassword.getText();
    String fullname = txtFullname.getText();

    if (username.isEmpty() || password.isEmpty() || fullname.isEmpty()) {
        showAlert("Input Error", "Field tidak boleh kosong!");
        return;
    }

    user newUser = new user(username, password, fullname);
    userDAO.addUser(newUser);
    loadDataUsers(); // Memuat ulang data setelah menambahkan user baru
    clearFields();
}


@FXML
    private void updateUser() {
        if (selectedUser == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }

        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String fullname = txtFullname.getText();

        if (username.isEmpty() || password.isEmpty() || fullname.isEmpty()) {
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }

        selectedUser.setUsername(username);
        selectedUser.setPassword(password);
        selectedUser.setFullname(fullname);

        userDAO.updateUser(selectedUser);
        loadDataUsers(); 
        clearFields();
    }

    @FXML
    private void deleteUser() {
        if (selectedUser == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }

        userDAO.DeleteUser(selectedUser.getUsername());
        loadDataUsers(); 
        clearFields();
    }



}

