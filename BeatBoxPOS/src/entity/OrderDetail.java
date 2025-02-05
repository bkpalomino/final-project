package entity;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Entity object created for or from the OrderDetails Table
 */

public class OrderDetail {

    private int orderDetailsID;
    private int orderID;
    private int inventoryID;
    private Integer discountID;
    private int quantity;

    public OrderDetail(int orderDetailsID, int orderID, int inventoryID, Integer discountID, int quantity) {
        this.orderDetailsID = orderDetailsID;
        this.orderID = orderID;
        this.inventoryID = inventoryID;
        this.discountID = discountID;
        this.quantity = quantity;
    }

    public int getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(int orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Integer discountID) {
        this.discountID = discountID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderDetailsID=" + orderDetailsID + ", orderID=" + orderID + ", inventoryID=" + inventoryID + ", discountID=" + discountID + ", quantity=" + quantity + '}';
    }

    
    
}
