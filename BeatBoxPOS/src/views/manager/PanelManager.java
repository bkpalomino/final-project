package views.manager;

import views.manager.inventory.PanelInventory;
import entity.Notification;
import entity.Person;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import util.ImageManager;
import util.NotificationManager;
import util.ResourceLoader;
import util.StateManager;
import views.customer.PanelCustomer;
import views.logon.PanelCreateAccount;
import views.manager.promos.PanelPromo;
import views.manager.reports.PanelReports;
import views.manager.users.PanelUsers;

/**
 *
 * @author MrBea
 */
public class PanelManager extends javax.swing.JPanel {

    private StateManager panelState;
    private NotificationManager notificationManager;

    private PanelCustomer panelCustomer;
    private PanelReports panelReports;
    private PanelUsers panelUsers;
    private PanelPromo panelPromos;
    private PanelManageAccount panelAccount;

    private Person user;

    public PanelManager(StateManager panelState) {
        this.panelState = panelState;
        this.panelCustomer = new PanelCustomer(panelState);

        initComponents();
        setPrivileges();
        loadPage();

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

        btnGroupManageOptions = new javax.swing.ButtonGroup();
        panelNotificationsInner = new javax.swing.JPanel();
        labelNotification = new javax.swing.JLabel();
        panelControls = new javax.swing.JPanel();
        panelOptions = new javax.swing.JPanel();
        toggleSales = new javax.swing.JToggleButton();
        toggleInventory = new javax.swing.JToggleButton();
        toggleReports = new javax.swing.JToggleButton();
        toggleUsers = new javax.swing.JToggleButton();
        togglePromos = new javax.swing.JToggleButton();
        toggleAccount = new javax.swing.JToggleButton();
        toggleNotifications = new javax.swing.JToggleButton();
        btnBack = new javax.swing.JButton();
        panelCenterScreen = new javax.swing.JPanel();
        splitPane = new javax.swing.JSplitPane();
        panelNotifications = new javax.swing.JPanel();
        scrollNotifications = new javax.swing.JScrollPane();

        panelNotificationsInner.setLayout(new javax.swing.BoxLayout(panelNotificationsInner, javax.swing.BoxLayout.Y_AXIS));

        panelNotificationsInner.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelNotificationsInner.setAlignmentY(Component.TOP_ALIGNMENT);

        labelNotification.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNotification.setText("No Notifications");
        labelNotification.setToolTipText("");

        setName("Manager"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelControls.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelControls.setLayout(new java.awt.GridBagLayout());

        panelOptions.setLayout(new java.awt.GridBagLayout());

        toggleSales.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupManageOptions.add(toggleSales);
        toggleSales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        toggleSales.setForeground(new java.awt.Color(255, 255, 255));
        toggleSales.setSelected(true);
        toggleSales.setText("Sales");
        toggleSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleSalesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(toggleSales, gridBagConstraints);

        toggleInventory.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupManageOptions.add(toggleInventory);
        toggleInventory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        toggleInventory.setForeground(new java.awt.Color(255, 255, 255));
        toggleInventory.setText("Inventory");
        toggleInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleInventoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(toggleInventory, gridBagConstraints);

        toggleReports.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupManageOptions.add(toggleReports);
        toggleReports.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        toggleReports.setForeground(new java.awt.Color(255, 255, 255));
        toggleReports.setText("Reports");
        toggleReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleReportsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(toggleReports, gridBagConstraints);

        toggleUsers.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupManageOptions.add(toggleUsers);
        toggleUsers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        toggleUsers.setForeground(new java.awt.Color(255, 255, 255));
        toggleUsers.setText("Users");
        toggleUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleUsersActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(toggleUsers, gridBagConstraints);

        togglePromos.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupManageOptions.add(togglePromos);
        togglePromos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        togglePromos.setForeground(new java.awt.Color(255, 255, 255));
        togglePromos.setText("Promos");
        togglePromos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglePromosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(togglePromos, gridBagConstraints);

        toggleAccount.setBackground(new java.awt.Color(0, 153, 153));
        btnGroupManageOptions.add(toggleAccount);
        toggleAccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        toggleAccount.setForeground(new java.awt.Color(255, 255, 255));
        toggleAccount.setText("Account");
        toggleAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleAccountActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(toggleAccount, gridBagConstraints);

        toggleNotifications.setBackground(new java.awt.Color(0, 153, 153));
        toggleNotifications.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        toggleNotifications.setForeground(new java.awt.Color(255, 255, 255));
        toggleNotifications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleNotificationsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelOptions.add(toggleNotifications, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        panelControls.add(panelOptions, gridBagConstraints);

        btnBack.setBackground(new java.awt.Color(0, 153, 153));
        btnBack.setText("Back");
        btnBack.setName("Action"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        panelControls.add(btnBack, gridBagConstraints);
        btnBack.setVisible(false);

        add(panelControls, java.awt.BorderLayout.NORTH);

        panelCenterScreen.setLayout(new java.awt.BorderLayout());

        panelNotifications.setLayout(new java.awt.GridBagLayout());

        scrollNotifications.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notifications", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        scrollNotifications.setPreferredSize(new java.awt.Dimension(206, 47));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelNotifications.add(scrollNotifications, gridBagConstraints);

        splitPane.setRightComponent(panelNotifications);
        panelNotifications.setVisible(false);

        panelCenterScreen.add(splitPane, java.awt.BorderLayout.CENTER);

        add(panelCenterScreen, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnBackActionPerformed

    private void toggleSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleSalesActionPerformed
        // TODO add your handling code here:
        splitPane.setLeftComponent(new PanelCustomer(panelState));
        revalidate();
        repaint();
    }//GEN-LAST:event_toggleSalesActionPerformed

    private void toggleInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleInventoryActionPerformed
        // TODO add your handling code here:
        splitPane.setLeftComponent(new PanelInventory(panelState));
        revalidate();
        repaint();
    }//GEN-LAST:event_toggleInventoryActionPerformed

    private void toggleNotificationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleNotificationsActionPerformed
        // TODO add your handling code here:
        if (toggleNotifications.isSelected()) {
            panelNotifications.setVisible(true);
        } else {
            panelNotifications.setVisible(false);
        }

        splitPane.setDividerLocation(splitPane.getMaximumDividerLocation() - 200);

        revalidate();
        repaint();
    }//GEN-LAST:event_toggleNotificationsActionPerformed

    private void toggleReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleReportsActionPerformed
        // TODO add your handling code here:
        splitPane.setLeftComponent(panelReports);
        revalidate();
        repaint();
    }//GEN-LAST:event_toggleReportsActionPerformed

    private void toggleUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleUsersActionPerformed
        // TODO add your handling code here:
        splitPane.setLeftComponent(panelUsers);
        panelUsers.fireTabbedPane();
        revalidate();
        repaint();
    }//GEN-LAST:event_toggleUsersActionPerformed

    private void togglePromosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglePromosActionPerformed
        // TODO add your handling code here:
        splitPane.setLeftComponent(panelPromos);
        panelPromos.fireTabbedPane();
        revalidate();
        repaint();
    }//GEN-LAST:event_togglePromosActionPerformed

    private void toggleAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleAccountActionPerformed
        // TODO add your handling code here:
        splitPane.setLeftComponent(panelAccount);
        revalidate();
        repaint();
    }//GEN-LAST:event_toggleAccountActionPerformed

    // Methods
    private void setPrivileges() {
        user = StateManager.getCurrentUser();

        if (user != null) {

            ImageIcon personIcon = user.getImageIcon(ImageManager.SIZE_ICON);
            ImageIcon salesIcon = ResourceLoader.getResourceIcon("icons/sales.png", ImageManager.SIZE_ICON);
            ImageIcon reportsIcon = ResourceLoader.getResourceIcon("icons/reports.png", ImageManager.SIZE_ICON);
            ImageIcon inventoryIcon = ResourceLoader.getResourceIcon("icons/inventory.png", ImageManager.SIZE_ICON);
            ImageIcon usersIcon = ResourceLoader.getResourceIcon("icons/users.png", ImageManager.SIZE_ICON);
            ImageIcon promoCodesIcon = ResourceLoader.getResourceIcon("icons/promo.png", ImageManager.SIZE_ICON);

            toggleAccount.setText(user.getNameFirst());
            toggleAccount.setIconTextGap(5);
            toggleAccount.setIcon(personIcon);

            toggleSales.setIcon(salesIcon);
            toggleReports.setIcon(reportsIcon);
            toggleInventory.setIcon(inventoryIcon);
            toggleUsers.setIcon(usersIcon);
            togglePromos.setIcon(promoCodesIcon);

        }
    }

    private void loadPage() {
        splitPane.setLeftComponent(new PanelCustomer(panelState));

        toggleReports.setEnabled(false);
        toggleUsers.setEnabled(false);
        togglePromos.setEnabled(false);
        toggleAccount.setEnabled(false);

        Thread loadOtherTabs = new Thread(() -> {
            panelReports = new PanelReports(panelState);
            panelUsers = new PanelUsers(panelState);
            panelPromos = new PanelPromo(panelState);
            panelAccount = new PanelManageAccount(panelState);

            toggleReports.setEnabled(true);
            toggleUsers.setEnabled(true);
            togglePromos.setEnabled(true);
            toggleAccount.setEnabled(true);
        });

        loadOtherTabs.start();

        notificationManager = new NotificationManager(this, toggleNotifications);
    }

    public void loadNotifications() {
        ArrayList<Notification> notifications = notificationManager.getNotifications();

        if (notifications.size() > 0) {
            panelNotificationsInner.removeAll();
            for (Notification notification : notifications) {
                notification.setPreferredSize(new Dimension(scrollNotifications.getPreferredSize().width, (int) ((int) (notification.getPreferredSize().height) / 1.5)));
                panelNotificationsInner.add(notification);
            }
            scrollNotifications.setViewportView(panelNotificationsInner);
        } else {
            scrollNotifications.setViewportView(labelNotification);
        }

    }

    public void refreshPages() {
        if (StateManager.refresh == true) {


            Thread refresh = new Thread(() -> {
                panelReports.reload();
            });

            refresh.start();
            StateManager.refresh = false;
            
            revalidate();
            repaint();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup btnGroupManageOptions;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JPanel panelCenterScreen;
    private javax.swing.JPanel panelControls;
    private javax.swing.JPanel panelNotifications;
    private javax.swing.JPanel panelNotificationsInner;
    private javax.swing.JPanel panelOptions;
    private javax.swing.JScrollPane scrollNotifications;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JToggleButton toggleAccount;
    private javax.swing.JToggleButton toggleInventory;
    private javax.swing.JToggleButton toggleNotifications;
    private javax.swing.JToggleButton togglePromos;
    private javax.swing.JToggleButton toggleReports;
    private javax.swing.JToggleButton toggleSales;
    private javax.swing.JToggleButton toggleUsers;
    // End of variables declaration//GEN-END:variables
}
