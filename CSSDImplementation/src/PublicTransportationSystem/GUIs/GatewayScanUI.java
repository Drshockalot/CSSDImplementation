/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem.GUIs;

import PublicTransportationSystem.Gateway;
import PublicTransportationSystem.SetOfGateways;
import PublicTransportationSystem.SetOfStationSystems;
import PublicTransportationSystem.SetOfTravelCards;
import PublicTransportationSystem.StationSystem;
import PublicTransportationSystem.TravelCard;
import PublicTransportationSystem.TravelSystem;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drshockalotz
 */
public class GatewayScanUI extends javax.swing.JFrame {

    TravelSystem system;
    SetOfStationSystems stations;

    /**
     * Creates new form GatewayScanUI
     */
    public GatewayScanUI() throws Throwable {
        this.system = TravelSystem.getInstance();
        stations = system.getStationSystems();
        initComponents();
        this.rejectedMessage.setVisible(false);
        this.approvedMessage.setVisible(false);
        this.scanOutCard1.setEnabled(false);
        this.scanOutCard2.setEnabled(false);
        this.scanOutCard3.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gatewayTitle = new javax.swing.JLabel();
        scanInCard1 = new javax.swing.JButton();
        scanOutCard1 = new javax.swing.JButton();
        scanInCard2 = new javax.swing.JButton();
        scanOutCard2 = new javax.swing.JButton();
        scanInCard3 = new javax.swing.JButton();
        scanOutCard3 = new javax.swing.JButton();
        rejectedMessage = new javax.swing.JLabel();
        approvedMessage = new javax.swing.JLabel();
        scanInHeader = new javax.swing.JLabel();
        scanOutHeader = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        gatewayTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        gatewayTitle.setText("Gateway Simulation");

        scanInCard1.setLabel("Travel Card 1");
        scanInCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanInCard1MouseClicked(evt);
            }
        });
        scanInCard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanInCard1ActionPerformed(evt);
            }
        });

        scanOutCard1.setText("Travel Card 1");
        scanOutCard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanOutCard1ActionPerformed(evt);
            }
        });

        scanInCard2.setText("Travel Card 2");
        scanInCard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanInCard2ActionPerformed(evt);
            }
        });

        scanOutCard2.setText("Travel Card 2");
        scanOutCard2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanOutCard2ActionPerformed(evt);
            }
        });

        scanInCard3.setText("Travel Card 3");
        scanInCard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanInCard3ActionPerformed(evt);
            }
        });

        scanOutCard3.setText("Travel Card 3");
        scanOutCard3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanOutCard3ActionPerformed(evt);
            }
        });

        rejectedMessage.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        rejectedMessage.setForeground(new java.awt.Color(255, 0, 51));
        rejectedMessage.setText("REJECTED");

        approvedMessage.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        approvedMessage.setForeground(new java.awt.Color(51, 255, 0));
        approvedMessage.setText("APPROVED");

        scanInHeader.setText("Scan In");

        scanOutHeader.setText("Scan Out");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scanInCard1)
                    .addComponent(scanInCard3)
                    .addComponent(scanInCard2)
                    .addComponent(rejectedMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scanOutCard3)
                    .addComponent(scanOutCard2)
                    .addComponent(scanOutCard1)
                    .addComponent(approvedMessage, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gatewayTitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scanInHeader)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scanOutHeader)
                        .addGap(96, 96, 96))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gatewayTitle)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanInHeader)
                    .addComponent(scanOutHeader))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanOutCard1)
                    .addComponent(scanInCard1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanInCard2)
                    .addComponent(scanOutCard2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scanInCard3)
                    .addComponent(scanOutCard3))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rejectedMessage)
                    .addComponent(approvedMessage))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scanInCard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanInCard1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scanInCard1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        AppSwitchboard.mainUI.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void scanInCard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanInCard1MouseClicked
        StationSystem station = stations.getStationSystemById(1);
        SetOfGateways gateways = station.getStationGateways();
        Gateway gateway = gateways.getGatewayById(1);
        SetOfTravelCards travelCards = system.getTravelCards();
        TravelCard travelCard = travelCards.getTravelCardById(1);

        try {
            boolean result = gateway.PerformScanIn(travelCard);

            if (result) {
                this.approvedMessage.setVisible(true);
                this.rejectedMessage.setVisible(false);
                this.scanInCard1.setEnabled(false);
                this.scanOutCard1.setEnabled(true);
            } else {
                this.rejectedMessage.setVisible(true);
                this.approvedMessage.setVisible(false);
            }
        } catch (NullPointerException ex) {
            this.rejectedMessage.setVisible(true);
            this.approvedMessage.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanInCard1MouseClicked

    private void scanInCard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanInCard2ActionPerformed
        StationSystem station = stations.getStationSystemById(2);
        SetOfGateways gateways = station.getStationGateways();
        Gateway gateway = gateways.getGatewayById(2);
        SetOfTravelCards travelCards = system.getTravelCards();
        TravelCard travelCard = travelCards.getTravelCardById(2);

        try {
            boolean result = gateway.PerformScanIn(travelCard);

            if (result) {
                this.approvedMessage.setVisible(true);
                this.rejectedMessage.setVisible(false);
                this.scanInCard2.setEnabled(false);
                this.scanOutCard2.setEnabled(true);
            } else {
                this.rejectedMessage.setVisible(true);
                this.approvedMessage.setVisible(false);
            }
        } catch (NullPointerException ex) {
            this.rejectedMessage.setVisible(true);
            this.approvedMessage.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanInCard2ActionPerformed

    private void scanInCard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanInCard3ActionPerformed
        StationSystem station = stations.getStationSystemById(3);
        SetOfGateways gateways = station.getStationGateways();
        Gateway gateway = gateways.getGatewayById(3);
        SetOfTravelCards travelCards = system.getTravelCards();
        TravelCard travelCard = travelCards.getTravelCardById(3);

        try {
            boolean result = gateway.PerformScanIn(travelCard);

            if (result) {
                this.approvedMessage.setVisible(true);
                this.rejectedMessage.setVisible(false);
                this.scanInCard3.setEnabled(false);
                this.scanOutCard3.setEnabled(true);
            } else {
                this.rejectedMessage.setVisible(true);
                this.approvedMessage.setVisible(false);
            }
        } catch (NullPointerException ex) {
            this.rejectedMessage.setVisible(true);
            this.approvedMessage.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanInCard3ActionPerformed

    private void scanOutCard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanOutCard1ActionPerformed
        StationSystem station = stations.getStationSystemById(1);
        SetOfGateways gateways = station.getStationGateways();
        Gateway gateway = gateways.getGatewayById(1);
        SetOfTravelCards travelCards = system.getTravelCards();
        TravelCard travelCard = travelCards.getTravelCardById(1);

        try {
            boolean result = gateway.PerformScanOut(travelCard);

            if (result) {
                this.approvedMessage.setVisible(true);
                this.rejectedMessage.setVisible(false);
                this.scanOutCard1.setEnabled(false);
                this.scanInCard1.setEnabled(true);
            } else {
                this.rejectedMessage.setVisible(true);
                this.approvedMessage.setVisible(false);
            }
        } catch (NullPointerException ex) {
            this.rejectedMessage.setVisible(true);
            this.approvedMessage.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanOutCard1ActionPerformed

    private void scanOutCard2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanOutCard2ActionPerformed
        StationSystem station = stations.getStationSystemById(2);
        SetOfGateways gateways = station.getStationGateways();
        Gateway gateway = gateways.getGatewayById(2);
        SetOfTravelCards travelCards = system.getTravelCards();
        TravelCard travelCard = travelCards.getTravelCardById(2);

        try {
            boolean result = gateway.PerformScanOut(travelCard);

            if (result) {
                this.approvedMessage.setVisible(true);
                this.rejectedMessage.setVisible(false);
                this.scanOutCard2.setEnabled(false);
                this.scanInCard2.setEnabled(true);
            } else {
                this.rejectedMessage.setVisible(true);
                this.approvedMessage.setVisible(false);
            }
        } catch (NullPointerException ex) {
            this.rejectedMessage.setVisible(true);
            this.approvedMessage.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanOutCard2ActionPerformed

    private void scanOutCard3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanOutCard3ActionPerformed
        StationSystem station = stations.getStationSystemById(3);
        SetOfGateways gateways = station.getStationGateways();
        Gateway gateway = gateways.getGatewayById(3);
        SetOfTravelCards travelCards = system.getTravelCards();
        TravelCard travelCard = travelCards.getTravelCardById(3);

        try {
            boolean result = gateway.PerformScanOut(travelCard);

            if (result) {
                this.approvedMessage.setVisible(true);
                this.rejectedMessage.setVisible(false);
                this.scanOutCard3.setEnabled(false);
                this.scanInCard3.setEnabled(true);
            } else {
                this.rejectedMessage.setVisible(true);
                this.approvedMessage.setVisible(false);
            }
        } catch (NullPointerException ex) {
            this.rejectedMessage.setVisible(true);
            this.approvedMessage.setVisible(false);
        } catch (Throwable ex) {
            Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_scanOutCard3ActionPerformed

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
            java.util.logging.Logger.getLogger(GatewayScanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GatewayScanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GatewayScanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GatewayScanUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GatewayScanUI().setVisible(true);
                } catch (Throwable ex) {
                    Logger.getLogger(GatewayScanUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel approvedMessage;
    private javax.swing.JLabel gatewayTitle;
    private javax.swing.JLabel rejectedMessage;
    private javax.swing.JButton scanInCard1;
    private javax.swing.JButton scanInCard2;
    private javax.swing.JButton scanInCard3;
    private javax.swing.JLabel scanInHeader;
    private javax.swing.JButton scanOutCard1;
    private javax.swing.JButton scanOutCard2;
    private javax.swing.JButton scanOutCard3;
    private javax.swing.JLabel scanOutHeader;
    // End of variables declaration//GEN-END:variables
}
