/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan.pkg3;

/**
 *
 * @author User
 */
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class userDAO {

    public static ObservableList<user> getUsers() {
        // ObservableList untuk menyimpan data user
        ObservableList<user> userList = FXCollections.observableArrayList();
        String query = "SELECT * FROM users";

        try {
            // Membuat koneksi ke database
            Connection koneksi = DBConnection.getConnection();
            // Membuat statement
            Statement stmt = koneksi.createStatement();
            // Query untuk mengambil data user
            ResultSet rs = stmt.executeQuery(query);

            // Menambahkan data ke ObservableList
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");

                userList.add(new user(
                    username,
                    password,
                    fullname
                ));
            }

            // Menutup koneksi
            rs.close();
            stmt.close();
            koneksi.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
    
    
    public static void addUser(user User){
        String query = "INSERT INTO users (username,password,fullname) VALUES (?,MD5(?),?)";
        
        try{
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query);
            
            smt.setString(1, User.getPassword());
            smt.setString(2, User.getFullname());
            smt.setString(3, User.getUsername());
            
            smt.execute();
            koneksi.close();
        }catch(SQLException e){
                e.printStackTrace();
                
        }
    }
     
     
      public static void updateUser(user User){
        String query = "UPDATE users SET password = MD5(?),fullname = ? WHERE username = ?";
        
        try{
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query);
            
            smt.setString(1, User.getPassword());
            smt.setString(2, User.getFullname());
            smt.setString(3, User.getUsername());
            
            smt.execute();
            koneksi.close();
        }catch(SQLException e){
                e.printStackTrace();
                
        }
    }
      
       public static void DeleteUser(String username){
        String query = "DELETE FROM users WHERE username = ?";
        
        try{
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query);
            
            smt.setString(1, username);
            
            
            smt.execute();
            koneksi.close();
        }catch(SQLException e){
                e.printStackTrace();
                
        }
    }
   }




