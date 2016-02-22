/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem.GUIs;

import static PublicTransportationSystem.GUIs.AppSwitchboard.mainUI;
import PublicTransportationSystem.SystemRole;
import PublicTransportationSystem.TravelSystem;
import PublicTransportationSystem.TypeEnums;
import PublicTransportationSystem.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author jonathondickson
 */
public class WebsiteUI extends javax.swing.JFrame {

    static JFrame adminUI = new AdminUI();

    /**
     * Creates new form WebsiteUI
     */
    public WebsiteUI() {
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

        loginPopup = new javax.swing.JDialog();
        pnl_loginCont = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        lbl_password = new javax.swing.JLabel();
        pass_Password = new javax.swing.JPasswordField();
        lbl_loginTitle = new javax.swing.JLabel();
        btn_loginPopup = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        registerPopup = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        lbl_fullname = new javax.swing.JLabel();
        txt_Firstname = new javax.swing.JTextField();
        lbl_Username = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        txt_Password = new javax.swing.JLabel();
        txtPass_Password = new javax.swing.JPasswordField();
        btn_Register = new javax.swing.JButton();
        txt_Surname = new javax.swing.JTextField();
        lbl_fullname1 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        lbl_Username1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_websiteUITitle = new javax.swing.JLabel();

        loginPopup.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        loginPopup.setTitle("Login");
        loginPopup.setResizable(false);

        pnl_loginCont.setBackground(new java.awt.Color(204, 204, 204));

        lbl_username.setText("Username");

        txt_username.setText("JD");
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        lbl_password.setText("Password");

        pass_Password.setText("p");

        lbl_loginTitle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        lbl_loginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_loginTitle.setText("Login");

        btn_loginPopup.setText("Login");
        btn_loginPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginPopupActionPerformed(evt);
            }
        });

        btn_register.setText("Register");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_loginContLayout = new javax.swing.GroupLayout(pnl_loginCont);
        pnl_loginCont.setLayout(pnl_loginContLayout);
        pnl_loginContLayout.setHorizontalGroup(
            pnl_loginContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginContLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_loginContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_loginTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_loginContLayout.createSequentialGroup()
                        .addGroup(pnl_loginContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_loginContLayout.createSequentialGroup()
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_loginPopup, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addComponent(txt_username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pass_Password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_loginContLayout.createSequentialGroup()
                                .addGroup(pnl_loginContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnl_loginContLayout.setVerticalGroup(
            pnl_loginContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_loginContLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_loginTitle)
                .addGap(18, 18, 18)
                .addComponent(lbl_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pass_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_loginContLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_loginPopup)
                    .addComponent(btn_register)
                    .addComponent(btn_cancel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginPopupLayout = new javax.swing.GroupLayout(loginPopup.getContentPane());
        loginPopup.getContentPane().setLayout(loginPopupLayout);
        loginPopupLayout.setHorizontalGroup(
            loginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPopupLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(pnl_loginCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        loginPopupLayout.setVerticalGroup(
            loginPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPopupLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(pnl_loginCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        registerPopup.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                registerPopupWindowClosing(evt);
            }
        });

        lbl_fullname.setText("First Name");

        txt_Firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FirstnameActionPerformed(evt);
            }
        });

        lbl_Username.setText("Username");

        txt_Password.setText("Password");

        btn_Register.setText("Register");
        btn_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegisterActionPerformed(evt);
            }
        });

        lbl_fullname1.setText("Surname");

        lbl_Username1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Register)
                .addGap(96, 96, 96))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_fullname)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_Firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_fullname1)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Username)
                            .addComponent(lbl_Username1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_Email, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_Username, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPass_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Password))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_fullname1)
                    .addComponent(lbl_fullname))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Username1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Register)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout registerPopupLayout = new javax.swing.GroupLayout(registerPopup.getContentPane());
        registerPopup.getContentPane().setLayout(registerPopupLayout);
        registerPopupLayout.setHorizontalGroup(
            registerPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPopupLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        registerPopupLayout.setVerticalGroup(
            registerPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPopupLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Website UI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lbl_websiteUITitle.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lbl_websiteUITitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_websiteUITitle.setText("Website GUI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_websiteUITitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_websiteUITitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        mainUI.setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        loginPopup.dispose();
        this.dispose();
        mainUI.setEnabled(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_loginPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginPopupActionPerformed
        String username = txt_username.getText();
        String password = new String(pass_Password.getPassword());

        try {
            User user = TravelSystem.getInstance().getUsers().getUserByUsername(username);
            if (user != null) {
                if (user.authenticateUser(password)) {
                    if (user.getSystemRole().isAdmin()) {
                        openAdminUI();
                    } else {
                        openWebsiteUI();
                        System.out.println("Turd 1");
                    }
                } else {
                    System.out.println("Turd 2");
                }
            } else {
                System.out.println("Turd 3");
            }
        } catch (Throwable ex) {
            System.out.println("yolo" + ex);
        }
    }//GEN-LAST:event_btn_loginPopupActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loginPopup.pack();
        loginPopup.setVisible(true);
        loginPopup.setAlwaysOnTop(true);
        this.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        // TODO add your handling code here:
        this.setEnabled(false);
        this.setAlwaysOnTop(false);
        loginPopup.setEnabled(false);
        registerPopup.pack();
        registerPopup.setAlwaysOnTop(true);
        registerPopup.setVisible(true);
        registerPopup.setEnabled(true);
    }//GEN-LAST:event_btn_registerActionPerformed

    private void txt_FirstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FirstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FirstnameActionPerformed

    private void btn_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegisterActionPerformed
        String firstName = txt_Firstname.getText();
        String surname = txt_Surname.getText();
        String username = txt_Username.getText();
        String email = txt_Email.getText();
        String password = new String(txtPass_Password.getPassword());
        SystemRole newSysRole = new SystemRole(TypeEnums.UserType.USER);

        if (firstName.isEmpty() || surname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println("Idiots");
        } else {
            try {
                TravelSystem.getInstance()
                        .registerUser(firstName, surname, username, email, password, newSysRole);
            } catch (Throwable ex) {
                Logger.getLogger(WebsiteUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            openWebsiteUI();
            this.dispose();
        }
    }//GEN-LAST:event_btn_RegisterActionPerformed

    private void registerPopupWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_registerPopupWindowClosing
        loginPopup.setEnabled(true);
        loginPopup.setAlwaysOnTop(true);
    }//GEN-LAST:event_registerPopupWindowClosing

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void openAdminUI() {
        loginPopup.dispose();
        this.setEnabled(false);
        this.setVisible(false);

        adminUI.setVisible(true);
        adminUI.setAlwaysOnTop(true);
        adminUI.setResizable(false);
    }

    private void openWebsiteUI() {
        loginPopup.dispose();
        this.setEnabled(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
            java.util.logging.Logger.getLogger(WebsiteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebsiteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebsiteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebsiteUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WebsiteUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Register;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_loginPopup;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Username;
    private javax.swing.JLabel lbl_Username1;
    private javax.swing.JLabel lbl_fullname;
    private javax.swing.JLabel lbl_fullname1;
    private javax.swing.JLabel lbl_loginTitle;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel lbl_websiteUITitle;
    private javax.swing.JDialog loginPopup;
    private javax.swing.JPasswordField pass_Password;
    private javax.swing.JPanel pnl_loginCont;
    private javax.swing.JDialog registerPopup;
    private javax.swing.JPasswordField txtPass_Password;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Firstname;
    private javax.swing.JLabel txt_Password;
    private javax.swing.JTextField txt_Surname;
    private javax.swing.JTextField txt_Username;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
