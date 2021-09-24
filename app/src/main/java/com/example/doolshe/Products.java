package com.example.doolshe;

public class Products {
    private String itemNo, itemName, price, details;

    public Products(){}

    public Products(String itemNo, String itemName, String price, String details) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.price = price;
        this.details = details;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
