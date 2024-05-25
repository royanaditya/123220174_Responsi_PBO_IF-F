/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class ControllerDosen {
    ViewData halamanTable;
    InputData halamanInput;
    EditData halamanEdit;

    InterfaceDAODosen daoDosen;

    // Membuat variabel "daftarMahasiswa" untuk menyimpan data mahasiswa yg diambil dari DB.
    List<ModelDosen> daftarDosen;
    public ControllerDosen(ViewData halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(InputData halamanInput) {
        this.halamanInput = halamanInput;
        this.daoDosen = new DAODosen();
    }
    
    public ControllerDosen(EditData halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoDosen = new DAODosen();
    }

    public void showAllDosen() {      
        daftarDosen = daoDosen.getAll();       
        ModelTable table = new ModelTable(daftarDosen);
        halamanTable.getTableDosen().setModel(table);
    }
     public void deleteDosen(Integer baris) {
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );
        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {           
            daoDosen.delete(id);
            
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllDosen();
        }
       
    }
    public void insertDosen() {
        try {
            ModelDosen dosenBaru = new ModelDosen();
           
            String nama = halamanInput.getInputNama();
            String email = halamanInput.getInputEmail();

            
            if ("".equals(nama) || "".equals(email)) {
                throw new Exception("Nama atau NIM tidak boleh kosong!");
            }
            
            dosenBaru.setNama(nama);
            dosenBaru.setEmail(email);

            daoDosen.insert(dosenBaru);
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");
            halamanInput.dispose();
            new ViewData();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void editDosen(int id) {
        try {
            ModelDosen dosenYangMauDiedit = new ModelDosen();
           
            String nama = halamanEdit.getInputNama();
            String email = halamanEdit.getInputEmail();

            if ("".equals(nama) || "".equals(email)) {
                throw new Exception("Nama atau Email tidak boleh kosong!");
            }
            
            // Mengisi id, nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setEmail(email);
            daoDosen.update(dosenYangMauDiedit);
            JOptionPane.showMessageDialog(null, "Data Dosen berhasil diubah.");

            halamanEdit.dispose();
            new ViewData();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");
            showAllDosen();
        }
    }
    public void kembali (){
        new Main.Menu();         
    }
}
