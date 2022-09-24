package com.example.getfoodie.models;

import java.io.Serializable;

public class Popular implements Serializable {
    private String title;
    private String image;
    private String description;
    private Double fee;
    private int numberInCart;


    public Popular(String title, String image, String description, Double fee ) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.fee = fee;
        ;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart(int numberInCart) {
        return this.numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
