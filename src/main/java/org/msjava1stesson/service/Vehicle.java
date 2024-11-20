package org.msjava1stesson.service;

public interface Vehicle {
    void start();
    void stop();

    default String getInfo() {

        return "Vehicle default";
    }
    default boolean isRunning(){
        throw new UnsupportedOperationException();
    }
}
