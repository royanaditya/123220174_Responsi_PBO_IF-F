/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.Login;
import Model.Connector;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class ControllerLogin {
     private Login viewLogin;
    
    public void showViewLogin() {
        
        viewLogin.setLocationRelativeTo(null); // Atur lokasi relatif jika diperlukan
        viewLogin.setVisible(true); // Tampilkan tampilan login
    }

    public void inputLogin(String username, String password) {
        // Cek apakah username atau password kosong
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan password tidak boleh kosong", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Connector connect = new Connector(username, password);

        if (connect.checkLogin()) {
            ControllerTampilan mc = new ControllerTampilan();
            mc.showTampilPage(connect);
            viewLogin.dispose(); // Tutup tampilan login setelah login berhasil
        } else {
            JOptionPane.showMessageDialog(null, "Login gagal, username atau password salah", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
