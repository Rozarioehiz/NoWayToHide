package com.lastma.data.models;

import java.time.Year;

public class Vehicle {
    private String brand;
    private String model;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public ViolationType getType() {
        return Type;
    }

    public void setType(ViolationType type) {
        Type = type;
    }

    private Year year;
    private ViolationType Type;



}
