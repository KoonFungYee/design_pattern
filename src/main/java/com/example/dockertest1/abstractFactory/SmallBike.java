package com.example.dockertest1.abstractFactory;

public class SmallBike extends Vehicle {
    int cc;

    public SmallBike() {
        this.cc = 500;
    }

    @Override
    public int getCc() {
        return this.cc;
    }
}

