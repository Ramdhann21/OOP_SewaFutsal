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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class GUI_penyewa extends javax.swing.JFrame {

    /**
     * Creates new form GUI_penyewa
     */
    public GUI_penyewa() {
        initComponents();
        tampil();
    }

    public void clear() {
        txtsewa.setText("");
        txtnama.setText("");
        txtmulai.setText("");
        txtselesai.setText("");
        txtpembayaran.setText(" ");
    }

    public void batal() {
        txtsewa.setText("");
        txtnama.setText("");
        txtmulai.setText("");
        txtselesai.setText("");
        txtpembayaran.setText(" ");
    }
    public Connection conn;

    String nama1, idsewa1, mulai1, pembayaran1, tanggal1, selesai1;

    public void itempilih() {
        txtnama.setText(nama1);
        txtsewa.setText(idsewa1);
        txtmulai.setText(mulai1);
        txtselesai.setText(selesai1);
        txtpembayaran.setText(pembayaran1);
    }

    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("kode");
        tabelhead.addColumn("nama");
        tabelhead.addColumn("pembayaran");
        tabelhead.addColumn("waktu_mulai");
        tabelhead.addColumn("waktu_selesai");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_penyewaan";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5),});
            }
            tablesewa.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }

    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/penyewaan_futsal?user=root&password=");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI_penyewa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(GUI_penyewa.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(GUI_penyewa.class.getName()).log(Level.SEVERE, null, es);
        }
    }

    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_penyewa WHERE nama='" + txtnama.getText() + "'";
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
        new GUI_penyewa().setVisible(true);
        this.setVisible(false);
    }

    public void update() {
        String nama = txtnama.getText();
        String idsewa = txtsewa.getText();
        String pembayaran = txtpembayaran.getText();
        String waktumulai = txtmulai.getText();
        String waktuselesai = txtselesai.getText();
         String idsewalama = idsewa;
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_penyewaan SET idsewa='" + nama + "'," + "idsewa='" + idsewa + "',"
                   + "'" + "',pembayaran='" + pembayaran + "',waktumulai ='"
                    + waktumulai + "',waktuselesai = '" + waktuselesai  +"'WHERE idsewa ='"+ idsewa + "'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Mahasiswa Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }

//    public void insert() {
//        try {
//            nama1 = txtnama.getText();
//            idsewa1 = txtsewa.getText();
//            mulai1 = txtmulai.getText();
//            selesai1 = txtselesai.getText();
//            pembayaran1 = txtpembayaran.getText();
//            Statement statement = conn.createStatement();
//            statement.executeUpdate("INSERT INTO tb_penyewaan_futsal VALUES('" + nama1 + "','" + idsewa1 + "','" + mulai1 + "','" + selesai1 + "','" + pembayaran1 + "')");
//            statement.close();
//            JOptionPane.showMessageDialog(null, "Berhasil Memasukkan Data penyewaan" + "\n");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error : " + e);
//        }
//        refresh();
//    }
       public void insert() {
           idsewa1 = txtsewa.getText();
     nama1 = txtnama.getText();
        pembayaran1 = txtpembayaran.getText();
        mulai1 = txtmulai.getText();
        selesai1 = txtselesai.getText();
        try {
            koneksi();
            Statement statement = conn.createStatement();
//            statement.executeUpdate("INSERT INTO tb_penyewaan (nama1, idsewa1,pembayaran1, mulai1, selesai1)"
//                    + "VALUES('" + nama1 + "','" + idsewa1 + "','" + pembayaran1 + "','" + mulai1 + "','" + selesai1 +"')" );
//              statement.executeUpdate("INSERT INTO tb_penyewaan SET nama ='" + nama1 + "'," + "kode'" + idsewa1 + "',"
//                   +"',pembayaran='" + pembayaran1 + "',waktu_mulai ='"
//                    + mulai1 + "',waktu_selesai = '" + selesai1 +"'WHERE kode ='"+"'");
                statement.executeUpdate("INSERT INTO tb_penyewaan (kode, nama,pembayaran, waktu_mulai, waktu_selesai)"
                    + "VALUES('" + idsewa1 + "','" + nama1 + "','" + pembayaran1 + "','" + mulai1 + "','" + selesai1 + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Mahasiswa!" + "\n" + selesai1);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablesewa = new javax.swing.JTable();
        btnsimpan = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtpembayaran = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtsewa = new javax.swing.JTextField();
        txtmulai = new javax.swing.JTextField();
        txtselesai = new javax.swing.JTextField();
        btnupdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablesewa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id sewa", "nama", "pembayaran", "waktu mulai", "waktu selesai"
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

        jLabel9.setText("pembayaran");

        txtnama.setText(" ");

        jLabel1.setText("data penyewa LP futsal");

        jLabel2.setText("Nama");

        jLabel5.setText("id sewa");

        jLabel6.setText("waktu mulai");

        jLabel10.setText("waktu selesai");

        btnupdate.setText("update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsewa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtpembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(txtnama, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addComponent(txtmulai)
                        .addComponent(txtselesai)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnclose)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnupdate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(btnupdate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtmulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtselesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
     insert();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
      delete();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btncloseActionPerformed

    private void tablesewaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablesewaMouseClicked
        // TODO add your handling code here:
                int tabel = tablesewa.getSelectedRow();
        nama1= tablesewa.getValueAt(tabel, 0).toString();
        idsewa1 = tablesewa.getValueAt(tabel, 1).toString();
        mulai1 = tablesewa.getValueAt(tabel, 2).toString();
        pembayaran1 = tablesewa.getValueAt(tabel, 3).toString();
        tanggal1 = tablesewa.getValueAt(tabel, 4).toString();
        selesai1 = tablesewa.getValueAt(tabel, 5).toString();
        itempilih();
    }//GEN-LAST:event_tablesewaMouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnupdateActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_penyewa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_penyewa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablesewa;
    private javax.swing.JTextField txtmulai;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtpembayaran;
    private javax.swing.JTextField txtselesai;
    private javax.swing.JTextField txtsewa;
    // End of variables declaration//GEN-END:variables
}
