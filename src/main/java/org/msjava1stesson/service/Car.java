package org.msjava1stesson.service;

public class Car implements Vehicle{
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
