package com.example.doolshe;

public class Reviews {

    private String cName;
    private String cPhone;
    private String comment;
    private String rating;

    public Reviews() {
    }

    public Reviews(String cName, String cPhone, String comment, String rating) {
        this.cName = cName;
        this.cPhone = cPhone;
        this.comment = comment;
        this.rating = rating;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}