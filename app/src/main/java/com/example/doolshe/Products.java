package com.example.doolshe;

public class Products {
    private String itemNo, itemName, price, quantity, details;

    public Products(){}

    public Products(String itemNo, String itemName, String price, String quantity,String details) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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


