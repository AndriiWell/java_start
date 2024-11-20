package org.msjava1stesson;

public class CarA {
    private CarA(String model, int year, boolean isNew) {
        this.model = model;
        this.year = year;
        this.isNew = isNew;
    }

    private String getModel() {
        return model;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private String model;

    private int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    int year;
    boolean isNew = false;

    private CarA() {

    }

    private CarA(String model, int year) {

        this(model, year, true);
//        this.model = model;
//        this.year = year;
    }

    private String  getInfo() {
        //String model="a";
        return model + ", " + this.year + ", isNew: " + this.isNew + "";
    }
}
