/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Lab Informatika
 */
public class Login extends JFrame implements ActionListener {
    JLabel tulisanbesar = new JLabel("Selamat Datang!");
    JLabel tulisankecil = new JLabel("Silakan Masuk Untuk Lanjutkan");
    JLabel labelusername = new JLabel("Username");
    JTextField inputusername = new JTextField();
    JLabel labelpassword = new JLabel("Password");
    JTextField inputpassword = new JTextField();
    JLabel labeljenis = new JLabel("Jenis Kelamin");
    JRadioButton pilihlaki = new JRadioButton("Laki-Laki", true);
    JRadioButton pilihperempuan = new JRadioButton("Perempuan");
    JButton buttonlogin = new JButton("Login");

    Login() {
        setVisible(true);
        setSize(720, 550);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        add(tulisanbesar);
        tulisanbesar.setBounds(40, 20, 300, 35);
        tulisanbesar.setFont(new Font("Arial", Font.PLAIN, 30));

        add(tulisankecil);
        tulisankecil.setBounds(40, 55, 300, 35);
        tulisankecil.setFont(new Font("Arial", Font.ITALIC, 15));

        add(labelusername);
        labelusername.setBounds(40, 90, 300, 35);
        labelusername.setFont(new Font("Arial", Font.BOLD, 15));

        add(inputusername);
        inputusername.setBounds(40, 120, 500, 35);

        add(labelpassword);
        labelpassword.setBounds(40, 170, 300, 35);
        labelpassword.setFont(new Font("Arial", Font.BOLD, 15));

        add(inputpassword);
        inputpassword.setBounds(40, 200, 500, 35);

        add(labeljenis);
        labeljenis.setBounds(40, 245, 300, 35);
        labeljenis.setFont(new Font("Arial", Font.BOLD, 15));
        
        ButtonGroup pilihjenis =new ButtonGroup();
        pilihjenis.add(pilihlaki);
        pilihjenis.add(pilihperempuan);

        add(pilihlaki);
        pilihlaki.setBounds(40, 285, 150, 35);
        pilihlaki.setFont(new Font("Arial", Font.BOLD, 15));

        add(pilihperempuan);
        pilihperempuan.setBounds(250, 285, 150, 35);
        pilihperempuan.setFont(new Font("Arial", Font.BOLD, 15));

        add(buttonlogin);
        buttonlogin.setBounds(40, 340, 500, 35);

        //action listener button login
        buttonlogin.addActionListener(this);
    }

    //alt+insert implement method
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        //System.out.println("Kepencet!");//aksi ketika button login dipencet
        String username = inputusername.getText();
        String jeniskelamin = pilihlaki.isSelected() ? "L" : "P";
        String password = inputpassword.getText();
        
        if (username.isEmpty()){
            throw new Exception ("Jangan kosong,Gus.");
        }else if(password.isEmpty()) {
            throw new Exception ("Jangan Kosong");
        }
        new Menu();
        this.dispose();
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
   }
}
