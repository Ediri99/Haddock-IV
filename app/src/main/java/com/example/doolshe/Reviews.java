package com.example.doolshe;

public class Reviews {
    private String cName;
    private int rating;
    private String comment;

    Reviews(){

    }


    public Reviews(String cName, int rating, String comment) {
        this.cName = cName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
