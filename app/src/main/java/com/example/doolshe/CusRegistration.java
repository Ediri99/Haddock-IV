package com.example.doolshe;

public class CusRegistration {

    private String customerName;
    private String customerPhone;
    private String customerLocation;
    private String customerPwd;

    public CusRegistration() {
    }

    public CusRegistration(String customerName, String customerPhone, String customerLocation, String customerPwd) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerLocation = customerLocation;
        this.customerPwd = customerPwd;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public String getCustomerPwd() {
        return customerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        this.customerPwd = customerPwd;
    }
}

