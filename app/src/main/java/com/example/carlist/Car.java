package com.example.carlist;

import java.io.Serializable;

public class Car implements Serializable {

    private final String name;
    private final String brand;
    private final String color;
    private final Integer year;

    public Car(String name, String brand, String color, Integer year){
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }
}
