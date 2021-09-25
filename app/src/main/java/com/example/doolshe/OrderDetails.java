package com.example.doolshe;

public class OrderDetails {

    private String itemName;
    private String quantity;
    private String price;
    private String cname;
    private Integer phoneNumber;
    private String address;
    private String date;
    private String payment;
    private String message;

    public OrderDetails(){}

    public OrderDetails(String itemName, String quantity, String price, String cname, Integer phoneNumber, String address, String date, String payment, String message) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.cname = cname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.date = date;
        this.payment = payment;
        this.message = message;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
