package pertemuan.pkg16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pertemuan.pkg16.dbkoneksi.koneksi;

/**
 *
 * @author Ivan l
 */
public class fPDAM extends javax.swing.JFrame {

    DefaultTableModel DM = new DefaultTableModel();
    
    public fPDAM() throws SQLException {
        initComponents();
        TM.setModel(DM);
        DM.addColumn("Nama");
        DM.addColumn("No Samb.");
        DM.addColumn("Area");
        DM.addColumn("Alamat");
        DM.addColumn("No HP");
        
        cleartextfield();
        this.ListDT();
        tombol(false);
        cTAMBAH.setEnabled(true);
        fieldIsian(false);
    }
    
    private void storedta()throws SQLException{
        if (!txSAMBUNGAN.getText().equals("")){
            
            Connection cnn = koneksi();
            if(!cnn.isClosed()){
                PreparedStatement PS = cnn.prepareStatement("INSERT INTO pda (`Nama`, `No Sambungan`, `Area`, `Alamat`, `No HP`) VALUES(?,?,?,?,?);");
                PS.setString(1, txNAMA.getText());
                PS.setString(2, txSAMBUNGAN.getText());
                PS.setString(3, txAREA.getText());
                PS.setString(4, txALAMAT.getText());
                PS.setString(5, txHP.getText());
                PS.executeUpdate();
                cnn.close();
            }
            
        }         
        
    }

    private void updatedta()throws SQLException{
        Connection cnn = koneksi();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("UPDATE pda SET `Nama`=?, `Area`=?, `Alamat`=?, `No HP`=? WHERE `No Sambungan`=?;");
            PS.setString(1, txNAMA.getText());
            PS.setString(2, txAREA.getText());
            PS.setString(3, txALAMAT.getText());
            PS.setString(4, txHP.getText());
            PS.setString(5, txSAMBUNGAN.getText());
            PS.executeUpdate();
            cnn.close();
        }
    }
    
    private void destroydta(String sambungan) throws SQLException{
        Connection cnn = koneksi();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("DELETE FROM pda WHERE `No Sambungan`=?;");
            PS.setString(1, sambungan);
            PS.executeUpdate();
            cnn.close();
        }
    }
    
    private void tombol(boolean opsi){
        cTAMBAH.setEnabled(opsi);
        cEDIT.setEnabled(opsi);
        cHAPUS.setEnabled(opsi);
    }
    
    private void fieldIsian (boolean opsi){
        txNAMA.setEnabled(opsi);
        txSAMBUNGAN.setEnabled(opsi);
        txAREA.setEnabled(opsi);
        txALAMAT.setEnabled(opsi);
        txHP.setEnabled(opsi);
    }
    
    private void cleartextfield(){
        txNAMA.setText("");
        txSAMBUNGAN.setText("");
        txAREA.setText("");
        txALAMAT.setText("");
        txHP.setText("");
    }
    
    private void ListDT() throws SQLException{
        Connection cnn = koneksi();
        
        DM.getDataVector().removeAllElements();
        DM.fireTableDataChanged();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement("SELECT * FROM pda;");
            ResultSet RS = PS.executeQuery();
            
            while(RS.next()){
                Object[] data = new Object[5];
                data[0] = RS.getString("Nama");
                data[1] = RS.getString("No Sambungan");
                data[2] = RS.getString("Area");
                data[3] = RS.getString("Alamat");
                data[4] = RS.getString("No HP");
                
                DM.addRow(data);
            }
            
            cnn.close();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TM = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txALAMAT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txSAMBUNGAN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txHP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txAREA = new javax.swing.JTextField();
        cTAMBAH = new javax.swing.JButton();
        cEDIT = new javax.swing.JButton();
        cHAPUS = new javax.swing.JButton();
        cKELUAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("DATA PELANGGAN PDAM");

        TM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "No Samb.", "Area", "Alamat", "No HP"
            }
        ));
        TM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TM);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Nama");

        txNAMA.setText("jTextField1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Alamat");

        txALAMAT.setText("jTextField1");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("No Sambungan");

        txSAMBUNGAN.setText("jTextField1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("No Hp");

        txHP.setText("jTextField1");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Area");

        txAREA.setText("jTextField1");

        cTAMBAH.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cTAMBAH.setText("Tambah");
        cTAMBAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cTAMBAHActionPerformed(evt);
            }
        });

        cEDIT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cEDIT.setText("Edit");
        cEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cEDITActionPerformed(evt);
            }
        });

        cHAPUS.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cHAPUS.setText("Hapus");
        cHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cHAPUSActionPerformed(evt);
            }
        });

        cKELUAR.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        cKELUAR.setText("Keluar");
        cKELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cKELUARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(435, 435, 435))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txSAMBUNGAN, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(365, 365, 365)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txHP)
                                .addGap(45, 45, 45))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(txALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cTAMBAH, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(cEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(cHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cKELUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6)
                            .addComponent(txAREA, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addGap(360, 360, 360)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txALAMAT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txSAMBUNGAN)
                    .addComponent(txHP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txAREA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cKELUAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cEDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cTAMBAH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cHAPUS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TMMouseClicked
        txNAMA.setText(TM.getValueAt(TM.getSelectedRow(), 0).toString());
        txSAMBUNGAN.setText(TM.getValueAt(TM.getSelectedRow(), 1).toString());
        txAREA.setText(TM.getValueAt(TM.getSelectedRow(), 2).toString());
        txALAMAT.setText(TM.getValueAt(TM.getSelectedRow(), 3).toString());
        txHP.setText(TM.getValueAt(TM.getSelectedRow(), 4).toString());
        cEDIT.setEnabled(true);
        cHAPUS.setEnabled(true);
    }//GEN-LAST:event_TMMouseClicked

    private void cTAMBAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cTAMBAHActionPerformed
        if(cTAMBAH.getText().equals("Tambah")){
            cTAMBAH.setText("Simpan");
            cKELUAR.setText("Batal");
            cEDIT.setEnabled(false);
            cHAPUS.setEnabled(false);
            cleartextfield();
            fieldIsian(true);
        }else{
            cTAMBAH.setText("Tambah");
            cKELUAR.setText("Keluar");
        
            try {
                storedta();
                ListDT();
            } catch (SQLException ex) {
                Logger.getLogger(fPDAM.class.getName()).log(Level.SEVERE, null, ex);
            }
            cleartextfield();
            fieldIsian(false);
        }
    }//GEN-LAST:event_cTAMBAHActionPerformed

    private void cEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cEDITActionPerformed
        if(cEDIT.getText().equals("Edit")){
            cEDIT.setText("Simpan");
            cKELUAR.setText("Batal");
            cTAMBAH.setEnabled(false);
            cHAPUS.setEnabled(false);
            fieldIsian(true);
            txSAMBUNGAN.setEditable(false);
            
        }else{
            cEDIT.setText("Edit");
            cKELUAR.setText("Keluar");
        
            try {
                updatedta();
                ListDT();
            } catch (SQLException ex) {
                Logger.getLogger(fPDAM.class.getName()).log(Level.SEVERE, null, ex);
            }
            cleartextfield();
            fieldIsian(false);
            cTAMBAH.setEnabled(true);
            cEDIT.setEnabled(false);
        }
    }//GEN-LAST:event_cEDITActionPerformed

    private void cHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cHAPUSActionPerformed
        if(cHAPUS.getText().equals("Hapus")){
            String sambungan = txSAMBUNGAN.getText();
            int jwb = JOptionPane.showOptionDialog(this,
                    "Yakin akan menghapus data No Sambungan"+ sambungan, 
                    "Confirmasi Hapus Data", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.ERROR_MESSAGE, 
                    null, null, null);
        
            if(jwb == JOptionPane.YES_OPTION){
                try {
                    destroydta(sambungan);
                    ListDT();
                } catch (SQLException ex) {
                    Logger.getLogger(fPDAM.class.getName()).log(Level.SEVERE, null, ex);
                }
                    cleartextfield();
                    fieldIsian(false);
                    cTAMBAH.setEnabled(true);
                    cEDIT.setEnabled(false);
                    cHAPUS.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cHAPUSActionPerformed

    private void cKELUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKELUARActionPerformed
        if(cKELUAR.getText().equals("Keluar")){
            int jwb = JOptionPane.showOptionDialog(this,
                        "Yakin akan menutup aplikasi?", 
                        "Confirmasi Tutup Aplikasi", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.ERROR_MESSAGE, 
                        null, null, null);
            if (jwb == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        } else{
            cKELUAR.setText("Keluar");
            cTAMBAH.setText("Tambah");
            cEDIT.setText("Edit");
            cTAMBAH.setEnabled(true);
            cHAPUS.setEnabled(false);
            cEDIT.setEnabled(false);
            cleartextfield();
            fieldIsian(false);
        }
    }//GEN-LAST:event_cKELUARActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(fPDAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fPDAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fPDAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fPDAM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fPDAM().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fPDAM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TM;
    private javax.swing.JButton cEDIT;
    private javax.swing.JButton cHAPUS;
    private javax.swing.JButton cKELUAR;
    private javax.swing.JButton cTAMBAH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txALAMAT;
    private javax.swing.JTextField txAREA;
    private javax.swing.JTextField txHP;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txSAMBUNGAN;
    // End of variables declaration//GEN-END:variables
}
