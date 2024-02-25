package com.example.reportGenerator.models;

public class Products{
    private String name;
    private int quantity;
    private double price;

    public Products(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String toString(){
        return "Name: " + this.name + ", Quantity: " + this.quantity + ", Price: " + this.price;
    }
}
