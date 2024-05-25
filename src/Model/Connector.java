/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lab Informatika
 */
public class Connector {
   private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String nama_db = "university";
    private static String url_db = "jdbc:mysql://localhost:3306/" + nama_db;
    private static String username_db = "root";
    private static String password_db = "";

    static Connection conn;
    private String username;
    private String password;
    // Mencoba menghubungkan program kita dengan ke database MySQL.
    public static Connection Connect() {
        try {
            // 1. Register driver yang akan dipakai
            Class.forName(jdbc_driver);
            
            // 2. Buat koneksi ke database
            conn = DriverManager.getConnection(url_db, username_db, password_db);

            // 3. Menampilkan pesan "Connection Success" jika berhasil terhubung ke database.
            System.out.println("MySQL Connected");
        } catch (ClassNotFoundException | SQLException exception) {
            // Menampilkan pesan error ketika MySQL gagal terhubung.
            System.out.println("Connection Failed: " + exception.getLocalizedMessage());
        }
        return conn;
    }

    public Connector(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public boolean checkLogin() {
        String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet hasil = preparedStatement.executeQuery();

            if (hasil.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
