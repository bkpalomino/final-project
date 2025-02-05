package util;

import entity.Discount;
import entity.InventoryItem;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import views.customer.PanelCustomer;
import views.customer.PanelProductCard;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: An class object that keeps track of InventoryItem Objects and quantaties as well as handles all checkout logic (Calculations).
 */
public class CartManager {

    private HashMap<InventoryItem, Integer> cart;

    private final double TAX = .0825;
    private final int DISCOUNT_PERCENTAGE = 1;
    private final int DISCOUNT_DOLLAR_AMOUNT = 2;

    private Discount discount;
    private boolean discountApplied;

    private PanelCustomer panelCustomer;

    public CartManager(PanelCustomer panelCustomer) {
        cart = new HashMap<>();
        discount = null;
        discountApplied = false;
        this.panelCustomer = panelCustomer;
    }

    // Adds Item to cart hashmap
    public void addItem(InventoryItem item, int quantity) {
        Integer result = cart.putIfAbsent(item, quantity);
        if (result != null) {
            if (result != quantity) {
                cart.put(item, quantity);
            }
        }
    }

    // Removes specified Item from cart hashmap
    public void removeItem(InventoryItem item) {
        cart.remove(item);
    }

    // Removes all items from cart hashmap
    public void removeAllItems() {
        cart.clear();
    }

    // Sets the current discount for cart object
    public void setDiscount(Discount discount) {
        this.discount = discount;
        discountApplied = false;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getCartCount() {
        int amt = 0;

        for (InventoryItem item : cart.keySet()) {
            amt += cart.get(item);
        }

        return amt;
    }

    // Checkout methods
    public String checkoutString() {
        StringBuilder checkout = new StringBuilder();

        int targetID = (discount != null) ? discount.getInventoryID() : -1;

        for (InventoryItem item : cart.keySet()) {
            String name = item.getItemName();
            String qty = String.valueOf(cart.get(item));
            String cost = doubleAsCurrency(item.getCost());
            String total = doubleAsCurrency(getItemTotal(item, cart.get(item), true));

            checkout.append("Name: ").append(name).append("\n");
            checkout.append("Quantity: ").append(qty).append("\n");
            checkout.append("Cost: ").append(cost).append("\n");
            checkout.append("Total: ").append(total).append("\n");
            if (targetID == item.getInventoryID()) {
                checkout.append("**" + discount.getDiscountCode() + "**: ").append(discount.getDescription()).append("\n\n");
            } else {
                checkout.append("\n\n");
            }
        }

        if (targetID <= 0 && discount != null) {
            checkout.append("\n\n\n\n**" + discount.getDiscountCode() + ": ").append(discount.getDescription()).append("**");
        }

        return checkout.toString();
    }

    public ArrayList<String[]> getCartStringValues() {
        ArrayList<String[]> stringList = new ArrayList<>();

        int targetID = (discount != null) ? discount.getInventoryID() : -1;

        for (InventoryItem item : cart.keySet()) {
            String name = item.getItemName();
            String desc = item.getItemDescription();
            String cost = doubleAsCurrency(item.getCost());
            String qty = String.valueOf(cart.get(item));
            String total = doubleAsCurrency(getItemTotal(item, cart.get(item), true));

            if (targetID == item.getInventoryID()) {
                String[] itemArray = {"Item", name, desc, cost, qty, total};
                String[] discountArray = {"Discount", discount.getDiscountCode(), discount.getDescription()};
                stringList.add(itemArray);
                stringList.add(discountArray);
            } else {
                String[] itemArray = {"Item", name, desc, cost, qty, total};
                stringList.add(itemArray);
            }
        }

        if (targetID <= 0 && discount != null) {
            String[] discountArray = {"Discount", discount.getDiscountCode(), discount.getDescription()};
            stringList.add(discountArray);
        }

        return stringList;
    }

    public double getSubtotal(boolean discounted) {
        double subtotal = 0;

        for (InventoryItem item : cart.keySet()) {
            double itemTotal = getItemTotal(item, cart.get(item), discounted);

            subtotal += itemTotal;
        }

        if (discount != null && discounted) {

            int discountType = discount.getDiscountType();
            int discountLevel = discount.getDiscountLevel();
            int targetID = discount.getInventoryID();

            if (targetID <= 0 && discountLevel == 2) {
                switch (discountType) {
                    case DISCOUNT_PERCENTAGE:
                        double percentDeduction = subtotal * discount.getDiscountPercentage();
                        subtotal -= percentDeduction;
                        discountApplied = true;
                        break;
                    case DISCOUNT_DOLLAR_AMOUNT:
                        double dollarDeduction = discount.getDiscountDollarAmount();
                        subtotal -= dollarDeduction;
                        discountApplied = true;
                        break;
                }
            }

        }

        subtotal = Math.max(subtotal, 0);
        
        return subtotal;
    }

    public double getTax() {
        double total = getSubtotal(true);
        double totalTax = total * TAX;

        return totalTax;
    }

    public double getTaxRate() {
        return TAX;
    }

    public double getTotal() {
        double total = getSubtotal(true);
        double totalTax = total * TAX;

        total += totalTax;

        return total;
    }

    public double getTotalSaved() {
        return getSubtotal(false) - getSubtotal(true);
    }

    public double getItemTotal(InventoryItem item, int qty, boolean discounted) {
        double total = 0;
        double cost = item.getCost();

        // Check if there IS a discount...
        if (discount != null && discounted) {
            int discountType = discount.getDiscountType();
            int discountLevel = discount.getDiscountLevel();
            int targetID = discount.getInventoryID();

            // if the discount's id matches the items id, apply the discount
            if (targetID == item.getInventoryID() && discountLevel == 1) {
                switch (discountType) {
                    case DISCOUNT_PERCENTAGE:
                        double percentDeduction = cost * discount.getDiscountPercentage();
                        total = (cost * qty) - percentDeduction;
                        discountApplied = true;
                        break;
                    case DISCOUNT_DOLLAR_AMOUNT:
                        double dollarDeduction = discount.getDiscountDollarAmount();
                        total = Math.max((cost * qty) - dollarDeduction, 0);
                        
                        discountApplied = true;
                        break;
                }
            } else {
                total = (cost * qty);
            }
        } else {
            total = (cost * qty);
        }

        return total;
    }

    public boolean isDiscountUsed() {
        return discountApplied;
    }

    public JTable getCartAsCheckoutTable() {
        String[] columns = new String[]{"Name", "Item Cost", "Quantity", "Total"};
        Object[][] data = new Object[cart.size()][columns.length];

        // Get table data
        int i = 0;
        for (InventoryItem item : cart.keySet()) {
            Object[] row = new Object[columns.length];

            row[0] = item;
            row[1] = doubleAsCurrency(item.getCost());
            row[2] = cart.get(item);
            row[3] = doubleAsCurrency(getItemTotal(item, cart.get(item), true));

            data[i] = row;

            i++;
        }

        JTable table = new JTable(data, columns);

        table.setRowHeight(50);

        table.getColumnModel().getColumn(0).setPreferredWidth((int) (table.getPreferredSize().width / 1.15));

        return table;
    }

    public ArrayList<PanelProductCard> getCartAsPanelCards(PanelCustomer panelCustomer) {
        ArrayList<PanelProductCard> cards = new ArrayList<>();

        for (InventoryItem item : cart.keySet()) {
            cards.add(new PanelProductCard(panelCustomer, item, this));
        }

        return cards;
    }

    public HashMap<InventoryItem, Integer> getCart() {
        return cart;
    }

    public void validateCart() {
        for (InventoryItem item : cart.keySet()) {
            if (item.isDiscontinued()) {
                removeItem(item);
            }
        }
    }

    public PanelCustomer getCustomerPanel() {
        return panelCustomer;
    }

    // Static util methods
    public static String doubleAsCurrency(double number) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(number);
    }

    public static String doubleAsPercantage(double number) {
        NumberFormat formatter = NumberFormat.getPercentInstance();

        formatter.setMinimumFractionDigits(0);
        formatter.setMaximumFractionDigits(2);
        return formatter.format(number);
    }

}
