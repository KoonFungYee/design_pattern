package com.example.dockertest1.abstractFactory;

public class BigBike extends Vehicle {
    int cc;

    public BigBike() {
        this.cc = 1500;
    }

    @Override
    public int getCc() {
        return this.cc;
    }
}
