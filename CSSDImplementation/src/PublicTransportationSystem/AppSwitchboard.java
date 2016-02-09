/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author jonathondickson
 */
public class AppSwitchboard extends javax.swing.JFrame {
    static JFrame mainUI = new AppSwitchboard();
    /**
     * Creates new form AppSwitchboard
     */
    public AppSwitchboard() {
        initComponents();
        
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
        btn_switchWebsiteUI = new javax.swing.JButton();
        btn_switchAdminUI = new javax.swing.JButton();
        btn_buttonTemplate = new javax.swing.JButton();
        lbl_mainSwitchTitle = new javax.swing.JLabel();
        lbl_mainSwitchAuthors = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Switchboard UI");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("jFrame_Switchboard"); // NOI18N
        setResizable(false);

        btn_switchWebsiteUI.setText("Website UI");
        btn_switchWebsiteUI.setToolTipText("");
        btn_switchWebsiteUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_switchWebsiteUIActionPerformed(evt);
            }
        });

        btn_switchAdminUI.setText("Management UI");
        btn_switchAdminUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_switchAdminUIActionPerformed(evt);
            }
        });

        btn_buttonTemplate.setText("Next Button...?");
        btn_buttonTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buttonTemplateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_switchWebsiteUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_switchAdminUI, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(btn_buttonTemplate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_switchWebsiteUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_switchAdminUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buttonTemplate)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        lbl_mainSwitchTitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lbl_mainSwitchTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainSwitchTitle.setText("Public Management System");

        lbl_mainSwitchAuthors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainSwitchAuthors.setText("By 3 Snakes & a Bootlace (c)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mainSwitchAuthors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_mainSwitchTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 133, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_mainSwitchTitle)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(lbl_mainSwitchAuthors)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_switchWebsiteUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_switchWebsiteUIActionPerformed
        // Opens the website ui
        JFrame websiteUI = new WebsiteUI();
        websiteUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainUI.setEnabled(false);
        websiteUI.setVisible(true);
        
    }//GEN-LAST:event_btn_switchWebsiteUIActionPerformed

    private void btn_switchAdminUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_switchAdminUIActionPerformed
        // Opens the admin ui
        JFrame adminUI = new AdminUI();
        adminUI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainUI.setEnabled(false);
        adminUI.setVisible(true);
        
    }//GEN-LAST:event_btn_switchAdminUIActionPerformed

    private void btn_buttonTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buttonTemplateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buttonTemplateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainUI.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buttonTemplate;
    private javax.swing.JButton btn_switchAdminUI;
    private javax.swing.JButton btn_switchWebsiteUI;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_mainSwitchAuthors;
    private javax.swing.JLabel lbl_mainSwitchTitle;
    // End of variables declaration//GEN-END:variables
}
