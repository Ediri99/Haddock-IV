package com.example.doolshe;

public class SellerOrder {

    private String Name;
    private int PhoneNumber;
    private String HomeAddress;
    private String Description;
    private String PaymentMethod;

    public SellerOrder(){

    }

    public SellerOrder(String name, int phoneNumber, String homeAddress, String description, String paymentMethod) {
        Name = name;
        PhoneNumber = phoneNumber;
        HomeAddress = homeAddress;
        Description = description;
        PaymentMethod = paymentMethod;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        HomeAddress = homeAddress;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }
}
/*
clearAll();
    dbReference.push().getKey();
    Reviews reviews = new Reviews(customerName,customerRating,customerComment);
    dbReference.child(customerName).setValue(reviews);
    Toast.makeText(AddReview.this, "Feedback Submitted Successfully.", Toast.LENGTH_LONG).show();
});
 */




