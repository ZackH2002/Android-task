package com.example.a6lv2;

public class Item {
    private String text;
    private int imageId;
    public Item(String text,int imageId){
        this.text=text;
        this.imageId=imageId;
    }

    public String getText() {
        return text;
    }

    public int getImageId() {
        return imageId;
    }
}
