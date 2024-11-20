package org.msjava1stesson.model;

public class Car {

    //private final String as;
    public Car(String model, int year, boolean isNew) {
        this.model = model;
        this.year = year;
        this.isNew = isNew;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String model;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    int year;
    boolean isNew = false;

    public Car() {

    }

    public Car(String model, int year) {

        this(model, year, true);
//        this.model = model;
//        this.year = year;
    }

    public String  getInfo() {
        //String model="a";
        return model + ", " + this.year + ", isNew: " + this.isNew + "";
    }
}
