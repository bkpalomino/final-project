package views.logon;

import util.DatabaseManager;
import entity.Logon;
import entity.Person;
import java.awt.event.KeyEvent;
import util.StateManager;
import views.customer.PanelCustomer;
import views.manager.PanelManager;

/*
Author: Braeden Palomino
Date: 10/08/24
Description: A Panel that has the logon gui. the user can login or reset their password.
 */
public class PanelLogon extends javax.swing.JPanel {

    private StateManager panelState;

    /**
     * Creates new form EnterLoginPanel
     */
    public PanelLogon(StateManager panelState) {
        initComponents();
        this.panelState = panelState;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        displayPanel = new javax.swing.JPanel();
        fieldUsername = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        fieldPassword = new javax.swing.JPasswordField();
        btnForgotPassword = new javax.swing.JButton();
        btnToggle = new javax.swing.JToggleButton();
        labelUsername = new javax.swing.JLabel();
        labelNotification = new javax.swing.JLabel();

        setName("Logon"); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        displayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "BeatBox Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)))); // NOI18N
        displayPanel.setLayout(new java.awt.GridBagLayout());

        fieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldUsernameKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        displayPanel.add(fieldUsername, gridBagConstraints);

        labelPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPassword.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        displayPanel.add(labelPassword, gridBagConstraints);

        btnLogin.setBackground(new java.awt.Color(0, 153, 153));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        displayPanel.add(btnLogin, gridBagConstraints);

        fieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldPasswordKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        displayPanel.add(fieldPassword, gridBagConstraints);

        btnForgotPassword.setBackground(new java.awt.Color(0, 153, 153));
        btnForgotPassword.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnForgotPassword.setText("Forgot Password?");
        btnForgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForgotPasswordActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(11, 11, 11, 11);
        displayPanel.add(btnForgotPassword, gridBagConstraints);

        btnToggle.setBackground(new java.awt.Color(0, 153, 153));
        btnToggle.setText("👁️");
        btnToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowPassword(evt);
            }
        });
        btnToggle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnToggleKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        displayPanel.add(btnToggle, gridBagConstraints);

        labelUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelUsername.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        displayPanel.add(labelUsername, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        add(displayPanel, gridBagConstraints);

        labelNotification.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNotification.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        labelNotification.setText("Error");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(labelNotification, gridBagConstraints);
        labelNotification.setText(" ");
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowPassword(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPassword
        // TODO add your handling code here:
        if (btnToggle.isSelected()) {
            fieldPassword.setEchoChar((char) 0);
        } else {
            fieldPassword.setEchoChar('\u002A');
        }
    }//GEN-LAST:event_btnShowPassword

    private void btnLoginClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginClicked
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_btnLoginClicked

    private void fieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPasswordKeyPressed
        // TODO add your handling code here:
        labelNotification.setText(" ");
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_fieldPasswordKeyPressed

    private void fieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldUsernameKeyPressed
        // TODO add your handling code here:
        labelNotification.setText(" ");
    }//GEN-LAST:event_fieldUsernameKeyPressed

    private void btnToggleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnToggleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnToggle.doClick();
        }
    }//GEN-LAST:event_btnToggleKeyPressed

    private void btnForgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForgotPasswordActionPerformed
        // TODO add your handling code here:
        panelState.changePanel(new PanelResetPassword(panelState));
    }//GEN-LAST:event_btnForgotPasswordActionPerformed

    private void login() {
        Logon logon = null;
        Person person = null;
        String user = fieldUsername.getText();
        String pass = new String(fieldPassword.getPassword());

        logon = DatabaseManager.getLogon(user, pass);

        if (logon != null && logon.isAccountDeleted() == false && logon.isAccountDisabled() == false) {

            person = DatabaseManager.getPerson(logon.getPersonID());

            panelState.setCurrentUser(logon, person);
            
            switch (logon.getPositionTitle()) {
                case "Customer":
                    panelState.changePanel(new PanelCustomer(panelState));
                    break;
                case "Employee":
                    panelState.changePanel(new PanelManager(panelState));
                case "Manager":
                    panelState.changePanel(new PanelManager(panelState));
                    break;
            }


        } else {
            labelNotification.setText("Incorrect Login Information");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnForgotPassword;
    private javax.swing.JButton btnLogin;
    private javax.swing.JToggleButton btnToggle;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables
}
