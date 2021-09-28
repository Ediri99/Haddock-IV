package com.example.doolshe;
    public class ShopRegistration {

        private String shopOwnerID;
        private int mobileNumber;
        private String shopName;
        private String location;
        private String ownerName;
        private String password;
        public ShopRegistration(){}

        public ShopRegistration(int mobileNumber, String shopName, String location, String ownerName, String password){

            this.mobileNumber = mobileNumber;
            this.ownerName = ownerName;
            this.shopName = shopName;
            this.location = location;
            this.password = password;
        }

        public String getShopOwnerID() {
            return shopOwnerID;
        }

        public void setShopOwnerID(String shopOwnerID) {
            this.shopOwnerID = shopOwnerID;
        }

        public int getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(int mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }


        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
