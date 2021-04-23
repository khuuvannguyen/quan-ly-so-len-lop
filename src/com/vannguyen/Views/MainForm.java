/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vannguyen.Views;

/**
 *
 * @author Nguyen
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    InputSinhvien inputSinhvien;
    InputLop inputLop;
    InputGiaovien giaovien;
    InputDonvi donvi;
    InputMonhoc monhoc;
    InputSoLL inputSoLL;
//    InputTrang inputTrang;

    public MainForm() {
        initComponents();
        inputSinhvien = new InputSinhvien();
        inputLop = new InputLop();
        giaovien = new InputGiaovien();
        donvi = new InputDonvi();
        monhoc = new InputMonhoc();
        inputSoLL = new InputSoLL();
//        inputTrang = new InputTrang();

        Tab.add("Sinh viên", inputSinhvien);
        Tab.add("Lớp", inputLop);
        Tab.add("Giáo viên", giaovien);
        Tab.add("Đơn vị", donvi);
        Tab.add("Môn học", monhoc);
        Tab.add("Sổ lên lớp", inputSoLL);
//        Tab.add("Trang", inputTrang);

    }

//    public MainForm(String name) {
//        inputSinhvien = new InputSinhvien(name);
//        inputLop = new InputLop();
//        giaovien = new InputGiaovien();
//        donvi = new InputDonvi();
//        monhoc = new InputMonhoc();
//        Tab.add("Sinh viên", inputSinhvien);
//        Tab.add("Lớp", inputLop);
//        Tab.add("Giáo viên", giaovien);
//        Tab.add("Đơn vị", donvi);
//        Tab.add("Môn học", monhoc);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Tab = new javax.swing.JTabbedPane();
        jSeparator1 = new javax.swing.JSeparator();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Sổ lên lớp điện tử");

        btnLogOut.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnLogOut.setText("Đăng xuất");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
                        .addComponent(btnLogOut))
                    .addComponent(Tab))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnLogOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(Tab, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Tab;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}