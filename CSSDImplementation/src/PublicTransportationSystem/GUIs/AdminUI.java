/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem.GUIs;

import static PublicTransportationSystem.GUIs.AppSwitchboard.mainUI;
import PublicTransportationSystem.Journey;
import PublicTransportationSystem.TravelSystem;
import PublicTransportationSystem.Zone;
import PublicTransportationSystem.ZoneList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author jonathondickson
 */
public class AdminUI extends javax.swing.JFrame {

    /**
     * Creates new form AdminUI
     */
    public AdminUI() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        dlg_adminJourneyEdit = new javax.swing.JDialog();
        lbl_adminJourneyEditTitle = new javax.swing.JLabel();
        cmb_departure = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_arrival = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_offPeakPrice = new javax.swing.JTextField();
        txt_onPeakPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_savePriceChanges = new javax.swing.JButton();
        btn_closeEditJourney = new javax.swing.JButton();
        lbl_error = new javax.swing.JLabel();
        pnl_adminGUITitle = new javax.swing.JPanel();
        lbl_managementUITitle = new javax.swing.JLabel();
        pnl_adminGUITabs = new javax.swing.JPanel();
        tab_admin = new javax.swing.JTabbedPane();
        pnl_adminHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnl_adminTT = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnl_adminStats = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl_adminAdmin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnl_adminJourney = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btn_editJourneys = new javax.swing.JButton();

        dlg_adminJourneyEdit.setResizable(false);
        dlg_adminJourneyEdit.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                dlg_adminJourneyEditWindowOpened(evt);
            }
        });

        lbl_adminJourneyEditTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lbl_adminJourneyEditTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_adminJourneyEditTitle.setText("Edit Journey");

        cmb_departure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_departure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_departureActionPerformed(evt);
            }
        });
        cmb_departure.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb_departurePropertyChange(evt);
            }
        });

        jLabel5.setText("Departure Zone");

        jLabel6.setText("Arrival Zone");

        cmb_arrival.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_arrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_arrivalActionPerformed(evt);
            }
        });
        cmb_arrival.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmb_arrivalPropertyChange(evt);
            }
        });

        jLabel7.setText("Off Peak");

        jLabel8.setText("On Peak");

        btn_savePriceChanges.setText("Save");
        btn_savePriceChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_savePriceChangesActionPerformed(evt);
            }
        });

        btn_closeEditJourney.setText("Cancel");
        btn_closeEditJourney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeEditJourneyActionPerformed(evt);
            }
        });

        lbl_error.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error.setText("Off Peak is greater than On Peak");

        javax.swing.GroupLayout dlg_adminJourneyEditLayout = new javax.swing.GroupLayout(dlg_adminJourneyEdit.getContentPane());
        dlg_adminJourneyEdit.getContentPane().setLayout(dlg_adminJourneyEditLayout);
        dlg_adminJourneyEditLayout.setHorizontalGroup(
            dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_adminJourneyEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_adminJourneyEditTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_departure, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_arrival, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlg_adminJourneyEditLayout.createSequentialGroup()
                        .addGroup(dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txt_offPeakPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dlg_adminJourneyEditLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_closeEditJourney)
                                .addGap(1, 1, 1)
                                .addComponent(btn_savePriceChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dlg_adminJourneyEditLayout.createSequentialGroup()
                                .addComponent(lbl_error)
                                .addGap(0, 19, Short.MAX_VALUE))))
                    .addGroup(dlg_adminJourneyEditLayout.createSequentialGroup()
                        .addComponent(txt_onPeakPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dlg_adminJourneyEditLayout.setVerticalGroup(
            dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlg_adminJourneyEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_adminJourneyEditTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_departure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_arrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_offPeakPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error))
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_onPeakPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(dlg_adminJourneyEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_closeEditJourney)
                    .addComponent(btn_savePriceChanges))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Management UI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_managementUITitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lbl_managementUITitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_managementUITitle.setText("Management GUI");

        javax.swing.GroupLayout pnl_adminGUITitleLayout = new javax.swing.GroupLayout(pnl_adminGUITitle);
        pnl_adminGUITitle.setLayout(pnl_adminGUITitleLayout);
        pnl_adminGUITitleLayout.setHorizontalGroup(
            pnl_adminGUITitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_managementUITitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_adminGUITitleLayout.setVerticalGroup(
            pnl_adminGUITitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminGUITitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_managementUITitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Useful statistics ");

        javax.swing.GroupLayout pnl_adminHomeLayout = new javax.swing.GroupLayout(pnl_adminHome);
        pnl_adminHome.setLayout(pnl_adminHomeLayout);
        pnl_adminHomeLayout.setHorizontalGroup(
            pnl_adminHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_adminHomeLayout.setVerticalGroup(
            pnl_adminHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminHomeLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        tab_admin.addTab("Home", pnl_adminHome);

        jLabel3.setText("...");

        javax.swing.GroupLayout pnl_adminTTLayout = new javax.swing.GroupLayout(pnl_adminTT);
        pnl_adminTT.setLayout(pnl_adminTTLayout);
        pnl_adminTTLayout.setHorizontalGroup(
            pnl_adminTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_adminTTLayout.createSequentialGroup()
                .addContainerGap(636, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(44, 44, 44))
        );
        pnl_adminTTLayout.setVerticalGroup(
            pnl_adminTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminTTLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel3)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        tab_admin.addTab("Timetable", pnl_adminTT);

        jLabel2.setText("Statistics dashboard with search functionality");

        javax.swing.GroupLayout pnl_adminStatsLayout = new javax.swing.GroupLayout(pnl_adminStats);
        pnl_adminStats.setLayout(pnl_adminStatsLayout);
        pnl_adminStatsLayout.setHorizontalGroup(
            pnl_adminStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_adminStatsLayout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(44, 44, 44))
        );
        pnl_adminStatsLayout.setVerticalGroup(
            pnl_adminStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminStatsLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel2)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        tab_admin.addTab("Statistics", pnl_adminStats);

        jLabel4.setText("...");

        javax.swing.GroupLayout pnl_adminAdminLayout = new javax.swing.GroupLayout(pnl_adminAdmin);
        pnl_adminAdmin.setLayout(pnl_adminAdminLayout);
        pnl_adminAdminLayout.setHorizontalGroup(
            pnl_adminAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_adminAdminLayout.createSequentialGroup()
                .addContainerGap(636, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(44, 44, 44))
        );
        pnl_adminAdminLayout.setVerticalGroup(
            pnl_adminAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminAdminLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel4)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        tab_admin.addTab("Admin", pnl_adminAdmin);

        btn_editJourneys.setText("Edit Journeys");
        btn_editJourneys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editJourneysActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(btn_editJourneys)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btn_editJourneys)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_adminJourneyLayout = new javax.swing.GroupLayout(pnl_adminJourney);
        pnl_adminJourney.setLayout(pnl_adminJourneyLayout);
        pnl_adminJourneyLayout.setHorizontalGroup(
            pnl_adminJourneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminJourneyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_adminJourneyLayout.setVerticalGroup(
            pnl_adminJourneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminJourneyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab_admin.addTab("Journey", pnl_adminJourney);

        javax.swing.GroupLayout pnl_adminGUITabsLayout = new javax.swing.GroupLayout(pnl_adminGUITabs);
        pnl_adminGUITabs.setLayout(pnl_adminGUITabsLayout);
        pnl_adminGUITabsLayout.setHorizontalGroup(
            pnl_adminGUITabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab_admin, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnl_adminGUITabsLayout.setVerticalGroup(
            pnl_adminGUITabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_adminGUITabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab_admin))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_adminGUITitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnl_adminGUITabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_adminGUITitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_adminGUITabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openAdminUI() {
//        adminLoginPopup.dispose();
        this.setEnabled(true);
        this.setAlwaysOnTop(true);
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        adminLoginPopup.pack();
//        adminLoginPopup.setVisible(true);
//        adminLoginPopup.setAlwaysOnTop(true);
//        this.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void dlg_adminJourneyEditWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dlg_adminJourneyEditWindowOpened
        lbl_error.setVisible(false);
    }//GEN-LAST:event_dlg_adminJourneyEditWindowOpened

    private void btn_editJourneysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editJourneysActionPerformed
        try {
            ZoneList zones = TravelSystem.getInstance().getZones();
            cmb_departure.setModel(new DefaultComboBoxModel(zones));
            cmb_arrival.setModel(new DefaultComboBoxModel(zones));

            dlg_adminJourneyEdit.pack();
            dlg_adminJourneyEdit.setAlwaysOnTop(true);
            dlg_adminJourneyEdit.show();
        } catch (Throwable ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_editJourneysActionPerformed

    private void cmb_departureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_departureActionPerformed
        if (cmb_departure.getItemCount() > 0 && cmb_arrival.getItemCount() > 0) {
            displayPrices();
        }
    }//GEN-LAST:event_cmb_departureActionPerformed

    private void cmb_arrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_arrivalActionPerformed
        if (cmb_departure.getItemCount() > 0 && cmb_arrival.getItemCount() > 0) {
            displayPrices();
        }
    }//GEN-LAST:event_cmb_arrivalActionPerformed

    private void cmb_departurePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb_departurePropertyChange
        if (cmb_departure.isShowing() && cmb_arrival.isShowing()) {
            displayPrices();
        }
    }//GEN-LAST:event_cmb_departurePropertyChange

    private void cmb_arrivalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmb_arrivalPropertyChange
        if (cmb_departure.isShowing() && cmb_arrival.isShowing()) {
            displayPrices();
        }
    }//GEN-LAST:event_cmb_arrivalPropertyChange

    private void btn_closeEditJourneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeEditJourneyActionPerformed
        dlg_adminJourneyEdit.dispose();
    }//GEN-LAST:event_btn_closeEditJourneyActionPerformed

    private void btn_savePriceChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savePriceChangesActionPerformed
        if (cmb_departure.getItemCount() > 0 && cmb_arrival.getItemCount() > 0) {
            Object departure = cmb_departure.getSelectedItem();
            Zone departureZone = ((Zone) departure);
            Object arrival = cmb_arrival.getSelectedItem();
            Zone arrivalZone = ((Zone) arrival);

            try {
                float offPeakPrice = Float.valueOf(txt_offPeakPrice.getText());
                float onPeakPrice = Float.valueOf(txt_onPeakPrice.getText());
                if (offPeakPrice > onPeakPrice) {
                    lbl_error.setVisible(true);
                } else {
                    lbl_error.setVisible(false);
                    editJourney(offPeakPrice, onPeakPrice, departureZone, arrivalZone);
                }
            } catch (Throwable ex) {
                Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_savePriceChangesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        mainUI.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    private void displayPrices() {
        Object departure = cmb_departure.getSelectedItem();
        Zone departureZone = ((Zone) departure);
        Object arrival = cmb_arrival.getSelectedItem();
        Zone arrivalZone = ((Zone) arrival);

        try {
            Journey journey = TravelSystem.getInstance().getJourneys().getJourney(departureZone, arrivalZone);
            txt_offPeakPrice.setText(Float.toString(journey.getOffPeakPrice()));
            txt_onPeakPrice.setText(Float.toString(journey.getOnPeakPrice()));
        } catch (Throwable ex) {
            Logger.getLogger(AdminUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void editJourney(float newOffPeakPrice, float newOnPeakPrice, Zone startZone, Zone endZone) throws Throwable {
        TravelSystem.getInstance().getJourneys().getJourney(startZone, endZone).setOnPeakPrice(newOnPeakPrice);
        TravelSystem.getInstance().getJourneys().getJourney(startZone, endZone).setOffPeakPrice(newOffPeakPrice);
        System.out.println(TravelSystem.getInstance().getJourneys().getJourney(startZone, endZone).getOffPeakPrice());
        System.out.println(TravelSystem.getInstance().getJourneys().getJourney(startZone, endZone).getOnPeakPrice());
    }

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
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_closeEditJourney;
    private javax.swing.JButton btn_editJourneys;
    private javax.swing.JButton btn_savePriceChanges;
    private javax.swing.JComboBox<String> cmb_arrival;
    private javax.swing.JComboBox<String> cmb_departure;
    private javax.swing.JDialog dlg_adminJourneyEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_adminJourneyEditTitle;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbl_managementUITitle;
    private javax.swing.JPanel pnl_adminAdmin;
    private javax.swing.JPanel pnl_adminGUITabs;
    private javax.swing.JPanel pnl_adminGUITitle;
    private javax.swing.JPanel pnl_adminHome;
    private javax.swing.JPanel pnl_adminJourney;
    private javax.swing.JPanel pnl_adminStats;
    private javax.swing.JPanel pnl_adminTT;
    private javax.swing.JTabbedPane tab_admin;
    private javax.swing.JTextField txt_offPeakPrice;
    private javax.swing.JTextField txt_onPeakPrice;
    // End of variables declaration//GEN-END:variables
}
