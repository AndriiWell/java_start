package org.msjava1stesson.service;

public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike started");
    }
    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
