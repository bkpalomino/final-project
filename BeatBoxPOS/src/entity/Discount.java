
package entity;

import java.util.Date;
import util.CartManager;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Entity object created for or from the Discounts Table
 */

public class Discount {
    
    private int discountID;
    private String discountCode;
    private String description;
    private Integer discountLevel;
    private Integer inventoryID;
    private Integer discountType;
    private Double discountPercentage;
    private Double discountDollarAmount;
    private Date startDate;
    private Date expirationDate;
    private Boolean unavailable;

    public Discount(int discountID, String discountCode, String description, Integer discountLevel, Integer inventoryID, Integer discountType, Double discountPercentage, Double discountDollarAmount, Date startDate, Date expirationDate, Boolean unavailable) {
        this.discountID = discountID;
        this.discountCode = discountCode;
        this.description = description;
        this.discountLevel = discountLevel;
        this.inventoryID = inventoryID;
        this.discountType = discountType;
        this.discountPercentage = discountPercentage;
        this.discountDollarAmount = discountDollarAmount;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
        this.unavailable = unavailable;
    }

    public Discount(Discount discount) {
        this.discountID = discount.getDiscountID();
        this.discountCode = discount.getDiscountCode();
        this.description = discount.getDescription();
        this.discountLevel = discount.getDiscountLevel();
        this.inventoryID = discount.getInventoryID();
        this.discountType = discount.getDiscountType();
        this.discountPercentage = discount.getDiscountPercentage();
        this.discountDollarAmount = discount.getDiscountDollarAmount();
        this.startDate = discount.getStartDate();
        this.expirationDate = discount.getExpirationDate();
    }

    public Discount() {
        
    }

    public Boolean getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Boolean unavailable) {
        this.unavailable = unavailable;
    }
    
    
    
    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscountLevel() {
        return discountLevel;
    }

    public void setDiscountLevel(Integer discountLevel) {
        this.discountLevel = discountLevel;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(Integer inventoryID) {
        this.inventoryID = inventoryID;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Double getDiscountDollarAmount() {
        return discountDollarAmount;
    }

    public void setDiscountDollarAmount(Double discountDollarAmount) {
        this.discountDollarAmount = discountDollarAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDiscountTypeStr() {
        return (discountType == 1) ? 
                    CartManager.doubleAsPercantage(getDiscountPercentage()) : 
                    CartManager.doubleAsCurrency(getDiscountDollarAmount());
    }
    
    @Override
    public String toString() {
        return discountCode;
    }  

}
