/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem.GUIs;

import PublicTransportationSystem.TravelSystem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * GUI providing quick access to main areas of application
 *
 * @author jonathondickson
 */
public class AppSwitchboard extends javax.swing.JFrame {

    static JFrame mainUI = new AppSwitchboard();

    /**
     * Creates new form AppSwitchboard
     */
    @SuppressWarnings("static-access")
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
        btn_switchInspectorUI = new javax.swing.JButton();
        btn_switchScannerUI = new javax.swing.JButton();
        btn_loginUI = new javax.swing.JButton();
        btn_resetData = new javax.swing.JButton();
        lbl_mainSwitchTitle = new javax.swing.JLabel();
        lbl_mainSwitchAuthors = new javax.swing.JLabel();
        lbl_mainSwitchTitle1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Switchboard UI");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("jFrame_Switchboard"); // NOI18N
        setResizable(false);

        btn_switchInspectorUI.setText("Inspector UI");
        btn_switchInspectorUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_switchInspectorUIActionPerformed(evt);
            }
        });

        btn_switchScannerUI.setText("Scanner UI");
        btn_switchScannerUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_switchScannerUIActionPerformed(evt);
            }
        });

        btn_loginUI.setText("Login");
        btn_loginUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginUIActionPerformed(evt);
            }
        });

        btn_resetData.setText("Reset Data");
        btn_resetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_switchScannerUI, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btn_switchInspectorUI, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(btn_loginUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_resetData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_loginUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_switchInspectorUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_switchScannerUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btn_resetData)
                .addContainerGap())
        );

        lbl_mainSwitchTitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lbl_mainSwitchTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainSwitchTitle.setText("Public Transport Management Switchboard");

        lbl_mainSwitchAuthors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainSwitchAuthors.setText("3 Snakes & a Bootlace 2016 (c)");

        lbl_mainSwitchTitle1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        lbl_mainSwitchTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_mainSwitchTitle1.setText("For demonstration purposes only");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_mainSwitchAuthors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_mainSwitchTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_mainSwitchTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_mainSwitchTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_mainSwitchTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_mainSwitchAuthors)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_switchInspectorUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_switchInspectorUIActionPerformed
        // Initialise portable reader user interface, and set location to centre screen
        JFrame portableReader = new PortableReaderUI();
        mainUI.setEnabled(false);
        portableReader.setLocationRelativeTo(null);
        portableReader.setVisible(true);
    }//GEN-LAST:event_btn_switchInspectorUIActionPerformed

    private void btn_switchScannerUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_switchScannerUIActionPerformed
        // initialise gateway scanner ui, set location to centre screen
        JFrame gatewayScanUI = null;
        try {
            gatewayScanUI = new GatewayScanUI();
        } catch (Throwable ex) {
            Logger.getLogger(AppSwitchboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainUI.setEnabled(false);
        gatewayScanUI.setLocationRelativeTo(null);
        gatewayScanUI.setVisible(true);
    }//GEN-LAST:event_btn_switchScannerUIActionPerformed

    private void btn_loginUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginUIActionPerformed
        // initialise website ui, set location to centre screen
        JFrame websiteUI = new WebsiteUI();
        mainUI.setEnabled(false);
        websiteUI.setLocationRelativeTo(null);
        websiteUI.setVisible(true);
    }//GEN-LAST:event_btn_loginUIActionPerformed

    private void btn_resetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetDataActionPerformed
        // function purely for debugging, resets data back to a standard base inside
        // travel system
        try {
            TravelSystem.getInstance().resetData();
        } catch (Throwable ex) {
            Logger.getLogger(AppSwitchboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_resetDataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainUI.setLocationRelativeTo(null);
                mainUI.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loginUI;
    private javax.swing.JButton btn_resetData;
    private javax.swing.JButton btn_switchInspectorUI;
    private javax.swing.JButton btn_switchScannerUI;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_mainSwitchAuthors;
    private javax.swing.JLabel lbl_mainSwitchTitle;
    private javax.swing.JLabel lbl_mainSwitchTitle1;
    // End of variables declaration//GEN-END:variables
}
