package entity;

import com.mysql.cj.jdbc.Blob;
import java.net.URL;
import javax.swing.ImageIcon;
import util.ImageManager;
import util.ResourceLoader;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Entity object created for or from the Inventory Table
 */
public class InventoryItem implements Comparable<InventoryItem> {

    private int inventoryID;
    private String itemName;
    private String itemDescription;
    private double retailPrice;
    private double cost;
    private int quantity;
    private int restockThreshold;
    private Blob itemImage;
    private boolean discontinued;
    private int categoryId;

    public InventoryItem(int itemID, String itemName, String itemDescription, double retailPrice, double cost, int quantity, int restockThreshold, Blob itemImage, boolean discontinued, int categoryId) {
        this.inventoryID = itemID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.retailPrice = retailPrice;
        this.cost = cost;
        this.quantity = quantity;
        this.restockThreshold = restockThreshold;
        this.itemImage = itemImage;
        this.discontinued = discontinued;
        this.categoryId = categoryId;

    }

    public InventoryItem() {
        this.inventoryID = -1;
        this.itemName = "";
        this.itemDescription = "";
        this.retailPrice = 0.00;
        this.cost = 0.00;
        this.quantity = 0;
        this.restockThreshold = 0;
        this.itemImage = null;
        this.discontinued = false;
        this.categoryId = 1;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRestockThreshold() {
        return restockThreshold;
    }

    public void setRestockThreshold(int restockThreshold) {
        this.restockThreshold = restockThreshold;
    }

    public Blob getItemImage() {
        return itemImage;
    }

    public void setItemImage(Blob itemImage) {
        this.itemImage = itemImage;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public ImageIcon getImageIcon(int size) {

        ImageIcon icon = (itemImage != null)
                ? ImageManager.getScaledImageIcon(getByteArrayFromImage(), size)
                : ResourceLoader.getResourceIcon("icons/no-image.jpg", size);

        return icon;
    }

    @Override
    public String toString() {
        if (inventoryID == -1) {
            return "No Target Item";
        } else {
            return itemName;
        }
    }

    public byte[] getByteArrayFromImage() {
        byte[] array = null;

        try {
            array = itemImage.getBytes(1, (int) itemImage.length());
        } catch (Exception ex) {

        }

        return array;
    }

    @Override
    public int compareTo(InventoryItem item) {
        return Integer.compare(this.inventoryID, item.getInventoryID());
    }

}
