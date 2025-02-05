package entity;

import java.time.LocalDate;
import java.util.ArrayList;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Entity object created for or from the Orders Table
 */
public class Order {

    private int orderID;
    private Integer discountID;
    private int personID;
    private Integer employeeID;
    private LocalDate date;
    private String cardNumber;
    private String expDate;
    private String CCV;

    private ArrayList<OrderDetail> details;

    public Order(int orderID, Integer discountID, int personID, Integer employeeID, LocalDate date, String cardNumber, String expDate, String CCV) {
        this.orderID = orderID;
        this.discountID = discountID;
        this.personID = personID;
        this.employeeID = employeeID;
        this.date = date;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.CCV = CCV;
    }

    public Order() {
        orderID = -1;
    }

    public ArrayList<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<OrderDetail> details) {
        this.details = details;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Integer getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Integer discountID) {
        this.discountID = discountID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCCV() {
        return CCV;
    }

    public void setCCV(String CCV) {
        this.CCV = CCV;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", discountID=" + discountID + ", personID=" + personID + ", employeeID=" + employeeID + ", date=" + date + ", cardNumber=" + cardNumber + ", expDate=" + expDate + ", CCV=" + CCV + '}';
    }

}
