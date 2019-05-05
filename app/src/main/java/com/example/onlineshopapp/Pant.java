package com.example.onlineshopapp;

public class Pant {
    private String itemName,itemPrice,itemDescription;
    private int itemImage;

    public Pant(String itemName, String itemPrice, String itemDescription, int itemImage) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}