package bab10;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.RadioButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class GUI_futsal extends javax.swing.JFrame {

    /**
     * Creates new form GUI_futsal
     */
    public GUI_futsal() {
        initComponents();
        tampil();
        tampil_nama();

    }

    public void Clear() {
        txtlapangan.setText("");
        txttanggal.setText("");
        txtharga.setText("");
        txtwaktu.setText("");
        txtpembayaran.setText("");

    }

    public void batal() {
        txtlapangan.setText("");
        txttanggal.setText("");
        txtharga.setText("");
        txtwaktu.setText("");
        txtpembayaran.setText("");
    }
    public Connection conn;

    String nama1, nolapangan1, uk, tanggalsewa1, harga1, waktu1, pembayaran1, ukuranlapangan, jenislapangan;

    //masukkan method itempilih()
    public void itempilih() {
        cmbnama.setSelectedItem(nama1);
        txtlapangan.setText(nolapangan1);
        txttanggal.setText(tanggalsewa1);
        txtharga.setText(harga1);
        txtwaktu.setText(waktu1);
        txtpembayaran.setText(pembayaran1);
        if (uk.equalsIgnoreCase("kecil")) {
            txtkecil.setSelected(true);
        } else if (uk.equalsIgnoreCase("sedang")) {
            txtsedang.setSelected(true);
        } else {
            txtbesar.setSelected(true);
        }
        if (uk.equalsIgnoreCase("sintetetis")) {
            txtsin.setSelected(true);
        } else if (uk.equalsIgnoreCase("interlock")) {
            txtinter.setSelected(true);
        } else {
            txtvin.setSelected(true);
        }
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("nama");
        tabelhead.addColumn("no lapangan");
        tabelhead.addColumn("tanggal sewa");
        tabelhead.addColumn("ukuran lapangan");
        tabelhead.addColumn("jenis lapangan");
        tabelhead.addColumn("harga");
        tabelhead.addColumn("waktu");
        tabelhead.addColumn("pembayaran");

        try {
            koneksi();
            String sql = "SELECT * FROM tb_futsal";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(6),});
            }
            tablesewa.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

        public void tampil_nama() {
        try {
            koneksi();
            String sql = "SELECT nama FROM tb_penyewaan order by nama asc";
            Statement stt = conn.createStatement();
            ResultSet res = stt.executeQuery(sql);
            while (res.next()) {
                Object[] ob = new Object[3];
                ob[0] = res.getString(1);
                cmbnama.addItem((String) ob[0]);
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/penyewaan_futsal?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_futsal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_futsal.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_futsal.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_mahasiswa WHERE nama='" + cmbnama.getSelectedItem() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }

    public void refresh() {
        new GUI_futsal().setVisible(true);
        this.setVisible(false);
    }

    public void update() {
        String nama = (String) cmbnama.getSelectedItem();
        String nolapangan = txtlapangan.getText();
        String uk;
        if (txtkecil.isSelected()) {
            uk = "kecil";
        } else if (txtsedang.isSelected()) {
            uk = "sedang";
        } else {
            uk = "besar";
        }
        if (txtsin.isSelected()) {
            uk = "sintetis";
        } else if (txtinter.isSelected()) {
            uk = "Interlock";
        } else {
            uk = "Vinyl";
        }
        String hargasewa = txtharga.getText();
        String waktusewa = txtwaktu.getText();
        String pembayaran = txtpembayaran.getText();
        String namalama = nama1;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_mahasiswa SET nama='" + nama + "'," + "nama='" + nama + "',"
                    + "uk='" + uk + "'" + ",nolapangan='" + nolapangan + "',hargasewa='" + hargasewa + "',waktusewa='"
                    + waktusewa + "'pembayaran ='" + pembayaran + "' WHERE nama = '" + namalama + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Mahasiswa Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

    public void insert() {
        String nama = (String) cmbnama.getSelectedItem();
        String nolapangan = txtlapangan.getText();
        String uk = null;
        if (uk.equalsIgnoreCase("kecil")) {
            txtkecil.setSelected(true);
        } else if (uk.equalsIgnoreCase("sedang")) {
            txtsedang.setSelected(true);
        } else {
            txtbesar.setSelected(true);
        }
        if (uk.equalsIgnoreCase("sintetetis")) {
            txtsin.setSelected(true);
        } else if (uk.equalsIgnoreCase("interlock")) {
            txtinter.setSelected(true);
        } else {
            txtvin.setSelected(true);
        }
        String tanggalsewa = txttanggal.getText();
        String hargasewa = txtharga.getText();
        String waktusewa = txtwaktu.getText();
        String pembayaran = txtpembayaran.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_penyewaan (nama,uk, nolapangan,tanggalsewa,hargasewa,waktusewa,pembayaran)"
                    + "VALUES('" + nama + "','" + nolapangan + "','" + uk + "','" + tanggalsewa + "','" + hargasewa + "','" + waktusewa + "','" + pembayaran + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Mahasiswa!" + "\n" + nolapangan);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtlapangan = new javax.swing.JTextField();
        txttanggal = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtwaktu = new javax.swing.JTextField();
        txtpembayaran = new javax.swing.JTextField();
        txtkecil = new javax.swing.JRadioButton();
        txtsedang = new javax.swing.JRadioButton();
        txtbesar = new javax.swing.JRadioButton();
        txtsin = new javax.swing.JRadioButton();
        txtinter = new javax.swing.JRadioButton();
        txtvin = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablesewa = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        cmbnama = new javax.swing.JComboBox<>();
        btnbatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("sewa lapangan Futsal");

        jLabel2.setText("Nama");

        jLabel3.setText("no lapangan");

        jLabel4.setText("tanggal sewa");

        jLabel5.setText("ukuran lapangan");

        jLabel6.setText("jenis lapangan");

        jLabel7.setText("harga sewa");

        jLabel8.setText("waktu sewa");

        jLabel9.setText("pembayaran");

        txtkecil.setText("kecil");

        txtsedang.setText("sedang");

        txtbesar.setText("besar");

        txtsin.setText("Rumpu Sintetis");

        txtinter.setText("Interlock");

        txtvin.setText("Vinyl");

        tablesewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "nama", "no lapangan", "tanggal sewa ", "ukurabn lapangan", "jenis lapangan ", "harga sewa", "waktu sewa", "pembayaran"
            }
        ));
        tablesewa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablesewaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablesewa);

        btnsimpan.setText("simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnhapus.setText("hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        cmbnama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama" }));
        cmbnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnamaActionPerformed(evt);
            }
        });

        btnbatal.setText("batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(16, 16, 16)))
                                    .addComponent(jLabel9))
                                .addGap(12, 12, 12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtsedang)
                                            .addComponent(txtkecil)
                                            .addComponent(txtbesar)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(txtlapangan)
                                            .addComponent(cmbnama, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtsin)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtpembayaran)
                                        .addComponent(txtvin, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtinter, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtharga, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtwaktu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(btnsimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnclose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbatal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan)
                            .addComponent(btnhapus)
                            .addComponent(btnclose)
                            .addComponent(btnbatal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(cmbnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtlapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtkecil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsedang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbesar)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtsin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtinter)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(txtvin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtwaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tablesewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesewaMouseClicked
        // TODO add your handling code here:
        int tabel = tablesewa.getSelectedRow(); //0
        nama1 = tablesewa.getValueAt(tabel, 0).toString();
        nolapangan1 = tablesewa.getValueAt(tabel, 1).toString();
        uk = tablesewa.getValueAt(tabel, 2).toString();
        tanggalsewa1 = tablesewa.getValueAt(tabel, 3).toString();
        harga1 = tablesewa.getValueAt(tabel, 4).toString();
        waktu1 = tablesewa.getValueAt(tabel, 5).toString();
        pembayaran1 = tablesewa.getValueAt(tabel, 6).toString();
        ukuranlapangan = tablesewa.getValueAt(tabel, 7).toString();
        jenislapangan = tablesewa.getValueAt(tabel, 8).toString();
        itempilih();
    }//GEN-LAST:event_tablesewaMouseClicked

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_btnbatalActionPerformed

    private void cmbnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnamaActionPerformed
        // TODO add your handling code here:
//         new GUI_penyewa().setVisible(true);
    }//GEN-LAST:event_cmbnamaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_futsal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_futsal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_futsal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_futsal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_futsal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cmbnama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablesewa;
    private javax.swing.JRadioButton txtbesar;
    private javax.swing.JTextField txtharga;
    private javax.swing.JRadioButton txtinter;
    private javax.swing.JRadioButton txtkecil;
    private javax.swing.JTextField txtlapangan;
    private javax.swing.JTextField txtpembayaran;
    private javax.swing.JRadioButton txtsedang;
    private javax.swing.JRadioButton txtsin;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JRadioButton txtvin;
    private javax.swing.JTextField txtwaktu;
    // End of variables declaration//GEN-END:variables
}
