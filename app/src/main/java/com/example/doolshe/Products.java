package com.example.doolshe;

public class Products {
    private String details, itemName, itemNo, price, quantity;

    public Products(){}

/*    public Products(String curl, String itemNo, String itemName, String price, String quantity,String details) {
        this.curl =  curl;
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.details = details;
    }*/

    public Products(String itemNo, String itemName, String price, String quantity, String details) {
        this.details = details;
        this.itemName = itemName;
        this.itemNo = itemNo;
        this.price = price;
        this.quantity = quantity;

    }

 /*   public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl;
    }*/

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}


