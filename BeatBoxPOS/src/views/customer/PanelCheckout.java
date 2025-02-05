package views.customer;

import entity.Discount;
import entity.InventoryItem;
import entity.Order;
import entity.OrderDetail;
import java.awt.Color;
import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import util.CartManager;
import util.DatabaseManager;
import util.ReportManager;
import util.StateManager;
import util.ValidationManager;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: GUI panel for the customer checkout. Handles all user actions and events pertaining to checking out.
 */
public class PanelCheckout extends javax.swing.JPanel {

    private PanelCustomer panelCustomer;
    private CartManager cartManager;

    public PanelCheckout(PanelCustomer panelCustomer, CartManager cart) {
        initComponents();

        this.panelCustomer = panelCustomer;
        this.cartManager = cart;

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

        splitPane = new javax.swing.JSplitPane();
        panelTotals = new javax.swing.JPanel();
        scrollTotal = new javax.swing.JScrollPane();
        labelSubtotal = new javax.swing.JLabel();
        labelDiscountedSubtotal = new javax.swing.JLabel();
        labelTax = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        panelControls = new javax.swing.JPanel();
        panelCredentials = new javax.swing.JPanel();
        fieldCardName = new javax.swing.JTextField();
        fieldCardNumber = new javax.swing.JTextField();
        fieldCardExpiration = new javax.swing.JTextField();
        fieldCardCCV = new javax.swing.JTextField();
        labelErrorName = new javax.swing.JLabel();
        labelErrorNumber = new javax.swing.JLabel();
        labelErrorExpiration = new javax.swing.JLabel();
        labelErrorCCV = new javax.swing.JLabel();
        panelPromo = new javax.swing.JPanel();
        btnApply = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        fieldPromoCode = new javax.swing.JTextField();
        labelNotification = new javax.swing.JLabel();
        btnCompleteOrder = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();

        setName("Customer"); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        splitPane.setDividerLocation(200);

        panelTotals.setLayout(new java.awt.GridBagLayout());

        scrollTotal.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelTotals.add(scrollTotal, gridBagConstraints);

        labelSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelSubtotal.setText("Subtotal: $0.00");
        labelSubtotal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelTotals.add(labelSubtotal, gridBagConstraints);

        labelDiscountedSubtotal.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelDiscountedSubtotal.setText("Discounted Subtotal: $0.00");
        labelDiscountedSubtotal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelTotals.add(labelDiscountedSubtotal, gridBagConstraints);
        labelDiscountedSubtotal.setVisible(false);

        labelTax.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        labelTax.setText("Tax: $0.00");
        labelTax.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        panelTotals.add(labelTax, gridBagConstraints);

        labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelTotal.setText("Total: $0.00");
        labelTotal.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 10);
        panelTotals.add(labelTotal, gridBagConstraints);

        splitPane.setLeftComponent(panelTotals);

        panelControls.setLayout(new java.awt.GridBagLayout());

        panelCredentials.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment Information"));
        panelCredentials.setLayout(new java.awt.GridBagLayout());

        fieldCardName.setToolTipText("Example:\nJohn Doe");
        fieldCardName.setBorder(javax.swing.BorderFactory.createTitledBorder("Cardholder Name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelCredentials.add(fieldCardName, gridBagConstraints);
        fieldCardName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validateForm();
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
            }
        });

        fieldCardNumber.setToolTipText("Example:\n1234-5678-1234-5678");
        fieldCardNumber.setBorder(javax.swing.BorderFactory.createTitledBorder("Card Number"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelCredentials.add(fieldCardNumber, gridBagConstraints);
        fieldCardNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validateForm();
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
            }
        });

        fieldCardExpiration.setToolTipText("Example:\n08/2024\n08/24\n10/2024\n10/24");
        fieldCardExpiration.setBorder(javax.swing.BorderFactory.createTitledBorder("Expiration Date"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelCredentials.add(fieldCardExpiration, gridBagConstraints);
        fieldCardExpiration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                validateForm();
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
            }
        });

        fieldCardCCV.setToolTipText("Example:\n123");
        fieldCardCCV.setBorder(javax.swing.BorderFactory.createTitledBorder("CCV"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelCredentials.add(fieldCardCCV, gridBagConstraints);
        fieldCardCCV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (fieldCardCCV.getText().length() >= 3) {
                    evt.consume();
                }
                validateForm();
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (fieldCardCCV.getText().length() >= 3) {
                    evt.consume();
                }
            }
        });

        labelErrorName.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        labelErrorName.setText("name error");
        labelErrorName.setToolTipText("");
        labelErrorName.setName("The name must follow the format of \"[A-Z] followed by [a-z]\". Example (\"John Doe\")"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCredentials.add(labelErrorName, gridBagConstraints);
        labelErrorName.setText(" ");

        labelErrorNumber.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        labelErrorNumber.setText("number error");
        labelErrorNumber.setName("Incorrect format. Must follow ####-####-####-####"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCredentials.add(labelErrorNumber, gridBagConstraints);
        labelErrorNumber.setText(" ");

        labelErrorExpiration.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        labelErrorExpiration.setText("date error");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCredentials.add(labelErrorExpiration, gridBagConstraints);
        labelErrorExpiration.setText(" ");

        labelErrorCCV.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        labelErrorCCV.setText("ccv error");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        panelCredentials.add(labelErrorCCV, gridBagConstraints);
        labelErrorCCV.setText(" ");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.7;
        gridBagConstraints.insets = new java.awt.Insets(1, 0, 1, 0);
        panelControls.add(panelCredentials, gridBagConstraints);

        panelPromo.setLayout(new java.awt.GridBagLayout());

        btnApply.setBackground(new java.awt.Color(0, 153, 153));
        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(10, 7, 10, 7);
        panelPromo.add(btnApply, gridBagConstraints);

        btnClear.setBackground(new java.awt.Color(204, 102, 0));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(10, 7, 10, 7);
        panelPromo.add(btnClear, gridBagConstraints);

        fieldPromoCode.setBorder(javax.swing.BorderFactory.createTitledBorder("Promo Code"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 12, 10);
        panelPromo.add(fieldPromoCode, gridBagConstraints);

        labelNotification.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNotification.setText("Promo Code Results");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPromo.add(labelNotification, gridBagConstraints);
        labelNotification.setText(" ");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        panelControls.add(panelPromo, gridBagConstraints);

        btnCompleteOrder.setBackground(new java.awt.Color(0, 153, 153));
        btnCompleteOrder.setText("Complete Order");
        btnCompleteOrder.setEnabled(false);
        btnCompleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteOrderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelControls.add(btnCompleteOrder, gridBagConstraints);

        progress.setForeground(new java.awt.Color(0, 153, 153));
        progress.setBorder(javax.swing.BorderFactory.createTitledBorder("Processing"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelControls.add(progress, gridBagConstraints);
        progress.setVisible(false);

        splitPane.setRightComponent(panelControls);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(splitPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
        setUpPageView();
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnCompleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteOrderActionPerformed
        // TODO add your handling code here:
        btnCompleteOrder.setText("Placing Order...");
        btnCompleteOrder.setEnabled(false);

        for (Component c : splitPane.getComponents()) {
            c.setEnabled(false);
        }

        completeOrder();
    }//GEN-LAST:event_btnCompleteOrderActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        fieldPromoCode.setText(null);
        labelNotification.setForeground(new Color(187, 187, 187));
        labelNotification.setText(" ");
    }//GEN-LAST:event_btnClearActionPerformed

    private void setUpPageView() {
        splitPane.setDividerLocation(600);

        // Set the discount in the cart and gather totals
        Discount discount = DatabaseManager.getDiscount(fieldPromoCode.getText());

        if (discount != null) {
            if (discount.getUnavailable()) {
                discount = null;
            }
        }
        cartManager.setDiscount(discount);

        String subtotal = CartManager.doubleAsCurrency(cartManager.getSubtotal(false));
        String subtotalDiscounted = CartManager.doubleAsCurrency(cartManager.getSubtotal(true));
        String totalSaved = CartManager.doubleAsCurrency(cartManager.getTotalSaved());
        String taxRate = CartManager.doubleAsPercantage(cartManager.getTaxRate());
        String tax = CartManager.doubleAsCurrency(cartManager.getTax());
        String total = CartManager.doubleAsCurrency(cartManager.getTotal());

        boolean discountUsed = cartManager.isDiscountUsed();

        labelDiscountedSubtotal.setVisible(discountUsed);

        labelSubtotal.setText("Subtotal: " + subtotal);
        labelTax.setText("Tax (" + taxRate + "): " + tax);
        labelTotal.setText("Total: " + total);
        scrollTotal.getVerticalScrollBar().setValue(0);

        scrollTotal.setViewportView(cartManager.getCartAsCheckoutTable());

        if (!fieldPromoCode.getText().isEmpty()) {
            if (!discountUsed && discount != null) {
                labelNotification.setForeground(UIManager.getDefaults().getColor("Actions.Yellow"));
                labelSubtotal.setForeground(new Color(187, 187, 187));
                labelNotification.setText("Code was not used");
            } else if (discountUsed) {
                labelNotification.setForeground(UIManager.getDefaults().getColor("Actions.Green"));
                labelSubtotal.setForeground(UIManager.getDefaults().getColor("Actions.Green"));
                labelNotification.setText("Code applied: " + discount.getDescription());
                labelDiscountedSubtotal.setText("(" + discount.getDiscountTypeStr() + " OFF) " + "Discounted Subtotal: " + subtotalDiscounted);
                labelSubtotal.setText("Subtotal: " + subtotal + " - " + totalSaved);
            } else if (discount == null) {
                labelNotification.setForeground(UIManager.getDefaults().getColor("Actions.Red"));
                labelSubtotal.setForeground(new Color(187, 187, 187));
                labelNotification.setText("Invalid or Expired code");
            }
        }
    }

    private ArrayList<JTextField> getCardFields() {
        ArrayList<JTextField> fields = new ArrayList<>();

        fields.add(fieldCardName);
        fields.add(fieldCardNumber);
        fields.add(fieldCardExpiration);
        fields.add(fieldCardCCV);

        return fields;
    }

    private ArrayList<JLabel> getErrorLabels() {
        ArrayList<JLabel> labels = new ArrayList<>();

        labels.add(labelErrorName);
        labels.add(labelErrorNumber);
        labels.add(labelErrorExpiration);
        labels.add(labelErrorCCV);

        return labels;
    }

    private boolean validateForm() {
        String cardName = fieldCardName.getText();
        String cardNumber = fieldCardNumber.getText();
        String cardExpiration = fieldCardExpiration.getText();
        String cardCVC = fieldCardCCV.getText();
        boolean canCheckout = true;

        ArrayList<JLabel> errorLabels = getErrorLabels();
        ArrayList<Boolean> results = ValidationManager.validateCardInformation(cardName, cardNumber, cardExpiration, cardCVC, errorLabels);
        ArrayList<JTextField> cardFields = getCardFields();

        for (int i = 0; i < cardFields.size(); i++) {
            if (results.get(i)) {
                cardFields.get(i).setBackground(new Color(70, 73, 75));
            } else {
                cardFields.get(i).setBackground(UIManager.getDefaults().getColor("Actions.Red"));
                canCheckout = false;
            }

        }

        btnCompleteOrder.setEnabled(canCheckout);

        return canCheckout;
    }

    private void completeOrder() {
        if (validateForm()) {
            progress.setVisible(true);
            progress.setMaximum(cartManager.getCartCount());

            // Gather date details for report
            String[] dateParts = fieldCardExpiration.getText().split("/");
            int enteredMonth = Integer.parseInt(dateParts[0]);
            int enteredYear = (dateParts[1].length() == 2) ? 2000 + Integer.parseInt(dateParts[1]) : Integer.parseInt(dateParts[1]);

            // Gather order information for order object
            String currentState = panelCustomer.getState().getCurrentState();
            Integer employeeID;

            if (currentState.equals("Employee") || currentState.equals("Manager")) {
                employeeID = StateManager.getCurrentUser().getPersonID();
            } else {
                employeeID = null;
            }

            Integer discountID = (cartManager.getDiscount() != null) ? cartManager.getDiscount().getDiscountID() : null;
            int personID = panelCustomer.getCustomer().getPersonID();
            LocalDate date = LocalDate.now();
            String cardNumber = fieldCardNumber.getText();
            String expDate = LocalDate.of(enteredYear, enteredMonth, 1).format(DateTimeFormatter.ofPattern("MM/yyyy"));
            String CVC = fieldCardCCV.getText();

            Thread threadProcessOrder = new Thread(new Runnable() {
                @Override
                public void run() {
                    // Create Order Object
                    Order order = new Order(0, discountID, personID, employeeID, date, cardNumber, expDate, CVC);

                    // Create Detail Object(s)
                    ArrayList<OrderDetail> details = new ArrayList<>();

                    // Iterate throught the cart                    
                    for (InventoryItem item : cartManager.getCart().keySet()) {
                        // Get item
                        int inventoryID = item.getInventoryID(); // Create detail object and add to details
                        int quantity = cartManager.getCart().get(item);
                        int newQty = item.getQuantity() - cartManager.getCart().get(item);
                        details.add(new OrderDetail(0, 0, inventoryID, discountID, quantity));

                        DatabaseManager.updateItem(item.getInventoryID(), newQty); // update item quantity

                        progress.setValue(progress.getValue() + 1);
                    }

                    DatabaseManager.save(order, details);

                    btnCompleteOrder.setText("Generating Report...");
                    // Generate report
                    ReportManager.generateCustomerReceipt(cartManager);

                    // Notify user           
                    panelCustomer.showNotification();
                }
            });

            threadProcessOrder.start();

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCompleteOrder;
    private javax.swing.JTextField fieldCardCCV;
    private javax.swing.JTextField fieldCardExpiration;
    private javax.swing.JTextField fieldCardName;
    private javax.swing.JTextField fieldCardNumber;
    private javax.swing.JTextField fieldPromoCode;
    private javax.swing.JLabel labelDiscountedSubtotal;
    private javax.swing.JLabel labelErrorCCV;
    private javax.swing.JLabel labelErrorExpiration;
    private javax.swing.JLabel labelErrorName;
    private javax.swing.JLabel labelErrorNumber;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelTax;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JPanel panelControls;
    private javax.swing.JPanel panelCredentials;
    private javax.swing.JPanel panelPromo;
    private javax.swing.JPanel panelTotals;
    private javax.swing.JProgressBar progress;
    private javax.swing.JScrollPane scrollTotal;
    private javax.swing.JSplitPane splitPane;
    // End of variables declaration//GEN-END:variables
}
