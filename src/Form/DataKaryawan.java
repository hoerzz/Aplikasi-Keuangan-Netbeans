/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hoerzz
 */
public class DataKaryawan extends javax.swing.JFrame {
    private final DefaultTableModel tabModel;

    /**
     * Creates new form Pemasukkan
     */
    public DataKaryawan() {
        initComponents();
        setLocationRelativeTo(null);
        new Fungsi.Koneksi().koneksiDatabase();
        String[] row = {"Kode","Nama Karyawan","Umur","Tanggal Lahir","No.Tlp","Alamat"};
        tabModel = new DefaultTableModel(null,row);
        tbPemasukkan.setModel(tabModel);
        tampilDataKeTabel();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void tampilDataKeTabel(){
        try {
            String sql = "select * from data_karyawan";
            Statement stat = new Fungsi.Koneksi().konek.createStatement();
            ResultSet res = stat.executeQuery(sql);
          
            while(res.next()){
                String kode = res.getString("id");
                String nama = res.getString("nmkaryawan");
                String devisi = res.getString("umur");
                String jumlah = res.getString("ttl");
                String tlp = res.getString("notelp");
                String alamat = res.getString("alamat");
                String data[] = {kode,nama,devisi,jumlah,tlp,alamat};
                tabModel.addRow(data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void hapusPadaForm(){
        int row = tabModel.getRowCount();
        for (int i = 0; i < row; i++) {
            tabModel.removeRow(0);
        }
    }
    
    private void getDataFromTable() throws ParseException{
        int i = this.tbPemasukkan.getSelectedRow();
        if (i==-1) {
            return ;
        }
        String kode = (String) tabModel.getValueAt(i, 0);
        String nama = (String) tabModel.getValueAt(i, 1);
        String umr = (String) tabModel.getValueAt(i, 2);
        String tanggal = (String) tabModel.getValueAt(i, 3);
        String tlpn = (String) tabModel.getValueAt(i, 4);
        String alt = (String) tabModel.getValueAt(i,5);
        
        tfKode.setText(kode);
        n_karyawan.setText(nama);
        umur.setText(umr);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(tanggal); 
        ttl.setDate(date);
        tlp.setText(tlpn);
        alamat.setText(alt);
        
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
        keyType();
    }
    
    private void keyType(){
        if (!(n_karyawan.getText().equals(""))&&!(umur.getText().equals(""))) {
            btnSimpan.setEnabled(true);
            btnBatal.setEnabled(true);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        n_karyawan = new javax.swing.JTextField();
        umur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfKode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        ttl = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        tlp = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPemasukkan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CV.Bumi Indah :: Data Karyawan");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        n_karyawan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                n_karyawanPropertyChange(evt);
            }
        });
        n_karyawan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                n_karyawanKeyTyped(evt);
            }
        });

        umur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                umurKeyTyped(evt);
            }
        });

        jLabel2.setText("Nama Karyawan");

        jLabel3.setText("Umur");

        jLabel4.setText("Kode");

        tfKode.setEditable(false);

        jLabel5.setText("Alamat");

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane2.setViewportView(alamat);

        jLabel7.setText(" Tanggal Lahir");

        jLabel8.setText("No.Tlp");

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Save.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Erase.png"))); // NOI18N
        btnBatal.setText("Batal");
        btnBatal.setEnabled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Close.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Modify.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Vista_icons_09.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(54, 54, 54)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(umur, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(n_karyawan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfKode, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ttl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tlp))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(tfKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(n_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(umur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(ttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel5)
                        .addGap(69, 69, 69))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbPemasukkan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbPemasukkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPemasukkanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPemasukkan);

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo-removebg-preview (1).png"))); // NOI18N
        jLabel6.setText("CV. Bumi Indah");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (!(umur.getText().equals(""))&&!(n_karyawan.getText().equals(""))) {
            try {
                String sql = "INSERT INTO `data_karyawan`(`nmkaryawan`, `umur`, `ttl`, `alamat`, `notelp`) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement prestat = new Fungsi.Koneksi().konek.prepareStatement(sql);
                prestat.setString(1,n_karyawan.getText());
                prestat.setString(2,umur.getText());
                String date=new SimpleDateFormat("yyyy-MM-dd").format(ttl.getDate());
                prestat.setString(3,date);
                prestat.setString(4,alamat.getText());
                prestat.setString(5,tlp.getText());
                prestat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data telah disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                hapusPadaForm();
                tampilDataKeTabel();
                tfKode.setText("");
                n_karyawan.setText("");
                umur.setText("");
                ttl.setDate(null);
                alamat.setText("");
                tlp.setText("");
            } catch (Exception e) {
                System.out.println(""+e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data harus diisi!","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        tfKode.setText("");
        n_karyawan.setText("");
        umur.setText("");
        ttl.setDate(null);
        alamat.setText("");
        tlp.setText("");
        keyType();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void tbPemasukkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPemasukkanMouseClicked
        try {
            // TODO add your handling code here:
            getDataFromTable();
        } catch (ParseException ex) {
            Logger.getLogger(DataKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tbPemasukkanMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (!(umur.getText().equals(""))&&!(n_karyawan.getText().equals(""))) {
            try {
                String sql = "UPDATE data_karyawan SET nmkaryawan = ?, umur = ?, ttl = ?, alamat = ?, notelp = ? WHERE id = "+tfKode.getText();
                PreparedStatement prestat = new Fungsi.Koneksi().konek.prepareStatement(sql);
                prestat.setString(1,n_karyawan.getText());
                prestat.setString(2,umur.getText());
                String date=new SimpleDateFormat("yyyy-MM-dd").format(ttl.getDate());
                prestat.setString(3,date);
                prestat.setString(4,alamat.getText());
                prestat.setString(5,tlp.getText());
                prestat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data telah diedit","Informasi",JOptionPane.INFORMATION_MESSAGE);
                hapusPadaForm();
                tampilDataKeTabel();
                tfKode.setText("");
                n_karyawan.setText("");
                umur.setText("");
                ttl.setDate(null);
                alamat.setText("");
                tlp.setText("");
            } catch (Exception e) {
                System.out.println(""+e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data harus diisi!","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
            if (JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus?","warning", 2)== JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM data_karyawan WHERE id ="+tfKode.getText();
                Statement stat = new Fungsi.Koneksi().konek.createStatement();
                int hasil = stat.executeUpdate(sql);
                
                if (hasil == 1) {
                    JOptionPane.showMessageDialog(null, "Data telah dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }
                hapusPadaForm();
                tampilDataKeTabel();
                
            }
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void umurKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_umurKeyTyped
        // TODO add your handling code here:
        keyType();
    }//GEN-LAST:event_umurKeyTyped

    private void n_karyawanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_n_karyawanPropertyChange
        // TODO add your handling code here:
        keyType();
    }//GEN-LAST:event_n_karyawanPropertyChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setVisible(false);
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void n_karyawanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n_karyawanKeyTyped
        // TODO add your handling code here:
        keyType();
    }//GEN-LAST:event_n_karyawanKeyTyped

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
            java.util.logging.Logger.getLogger(DataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField n_karyawan;
    private javax.swing.JTable tbPemasukkan;
    private javax.swing.JTextField tfKode;
    private javax.swing.JTextField tlp;
    private com.toedter.calendar.JDateChooser ttl;
    private javax.swing.JTextField umur;
    // End of variables declaration//GEN-END:variables
}