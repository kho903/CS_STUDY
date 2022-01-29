package com.company.functional.C03MethodReference.model;

public class Suv extends Car {

    public Suv(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving a suv " + name + " from " + brand);
    }
}
