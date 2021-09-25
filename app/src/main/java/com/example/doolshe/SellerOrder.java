package com.example.doolshe;

public class SellerOrder {

    private String orderName;
    private String phoneNumber;
    private String homeAddress;
    private String description;
    private String paymentMethod;
    private String itemName;
    private String itemQuantity;
    private String itemPrice;

    public SellerOrder() {

    }

    public SellerOrder(String orderName, String phoneNumber, String homeAddress, String description, String paymentMethod, String itemName, String itemQuantity, String itemPrice) {
        this.orderName = orderName;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}