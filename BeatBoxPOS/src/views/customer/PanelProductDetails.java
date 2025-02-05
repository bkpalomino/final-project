package views.customer;

import entity.InventoryItem;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import util.ImageManager;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: GUI panel for InventoryItem Object. Handles some user actions and events pertaining to browsing and cart actions.
 */

public class PanelProductDetails extends javax.swing.JPanel {

    private InventoryItem item;
    private PanelCustomer panelCustomer;

    private Color originalButtonColor;
    private Color originalFontColor;
    private Color originalComboColor;

    public PanelProductDetails(PanelCustomer panelCustomer, InventoryItem item) {
        initComponents();

        this.panelCustomer = panelCustomer;
        this.item = item;

        setUpPageView();
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

        labelImage = new javax.swing.JLabel();
        panelActions = new javax.swing.JPanel();
        textAreaName = new javax.swing.JTextPane();
        labelPrice = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comboQuantity = new javax.swing.JComboBox<>();
        scrollDescription = new javax.swing.JScrollPane();
        textAreaDescription = new javax.swing.JTextPane();

        setName("Customer"); // NOI18N
        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        add(labelImage, gridBagConstraints);

        panelActions.setLayout(new java.awt.GridBagLayout());

        textAreaName.setEditable(false);
        textAreaName.setBorder(null);
        textAreaName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textAreaName.setText("This is where the product name goes");
        textAreaName.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelActions.add(textAreaName, gridBagConstraints);

        labelPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelPrice.setText("$999.00");
        labelPrice.setFocusable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelActions.add(labelPrice, gridBagConstraints);

        btnAdd.setBackground(new java.awt.Color(0, 153, 153));
        btnAdd.setText("Add to Cart");
        btnAdd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnAddFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAddFocusLost(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 2, 10, 10);
        panelActions.add(btnAdd, gridBagConstraints);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantity"));

        comboQuantity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboQuantity.setBorder(null);
        comboQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comboQuantityFocusLost(evt);
            }
        });
        jPanel1.add(comboQuantity);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panelActions.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(panelActions, gridBagConstraints);

        scrollDescription.setFocusable(false);

        textAreaDescription.setEditable(false);
        textAreaDescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        textAreaDescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAreaDescription.setFocusable(false);
        scrollDescription.setViewportView(textAreaDescription);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(scrollDescription, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        int quantity = Integer.parseInt(comboQuantity.getSelectedItem().toString());

        panelCustomer.addToCart(item, quantity);

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddFocusGained
        // TODO add your handling code here:
        btnFocusGained(evt);
    }//GEN-LAST:event_btnAddFocusGained

    private void btnAddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddFocusLost
        // TODO add your handling code here:
        btnFocusLost(evt);
    }//GEN-LAST:event_btnAddFocusLost

    private void comboQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboQuantityFocusGained
        // TODO add your handling code here:
        originalComboColor = evt.getComponent().getBackground();
        originalFontColor = evt.getComponent().getForeground();
        
        evt.getComponent().setBackground(originalComboColor.brighter());
        evt.getComponent().setForeground(originalFontColor.brighter());
    }//GEN-LAST:event_comboQuantityFocusGained

    private void comboQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboQuantityFocusLost
        // TODO add your handling code here:
        evt.getComponent().setBackground(originalComboColor);
        evt.getComponent().setForeground(originalFontColor);
    }//GEN-LAST:event_comboQuantityFocusLost

    private void setUpPageView() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        String itemName = item.getItemName();
        String itemPrice = formatter.format(item.getCost());
        ImageIcon itemImage = item.getImageIcon(ImageManager.SIZE_PREVIEW);
        String itemDescription = item.getItemDescription();

        textAreaName.setText(itemName);
        labelPrice.setText(itemPrice);
        labelImage.setIcon(itemImage);
        textAreaDescription.setText(itemDescription);

        comboQuantity.removeAllItems();
        for (int i = 1; i <= item.getQuantity(); i++) {
            String val = String.valueOf(i);

            comboQuantity.addItem(val);
        }

        if (item.getQuantity() == 0) {
            comboQuantity.addItem("0");
            comboQuantity.setEnabled(false);
            btnAdd.setText("This item is out of stock");
            btnAdd.setEnabled(false);
        }
        
        if (item.isDiscontinued()) {
            comboQuantity.setEnabled(false);
            btnAdd.setText("This item has been discontinued");
            btnAdd.setEnabled(false);
        }

        if (panelCustomer.isCustomerActive() == false) {
            btnAdd.setText("Sign in to shop!");
            btnAdd.setEnabled(false);
            comboQuantity.setEnabled(false);
        }

    }
    
    // EVENTS
    private void btnFocusGained(FocusEvent evt) {
        originalButtonColor = evt.getComponent().getBackground();
        originalFontColor = evt.getComponent().getForeground();

        evt.getComponent().setBackground(originalButtonColor.brighter());
        evt.getComponent().setForeground(originalFontColor.brighter());
    }

    private void btnFocusLost(FocusEvent evt) {
        evt.getComponent().setBackground(originalButtonColor);
        evt.getComponent().setForeground(originalFontColor);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> comboQuantity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImage;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JPanel panelActions;
    private javax.swing.JScrollPane scrollDescription;
    private javax.swing.JTextPane textAreaDescription;
    private javax.swing.JTextPane textAreaName;
    // End of variables declaration//GEN-END:variables
}
