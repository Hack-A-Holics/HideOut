package com.hackoholics.hideout;

public class Property {

    private int imageResourceId;
    private String name, address, distance;
    private int price;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Property(int imageResourceId, String name, String address, int price, String distance) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.address = address;
        this.price = price;
        this.distance = distance;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return Integer.toString(price);
    }

    public String getDistance() {
        return distance;
    }

    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

}
