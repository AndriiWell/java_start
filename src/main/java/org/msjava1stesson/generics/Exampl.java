package org.msjava1stesson.generics;

import org.msjava1stesson.service.Vehicle;

public class Exampl<X> {

    public void some(Object obj) {

        // possible only to Cast obj to X, X x = (X) new Object();

X newX = (X)obj;
System.out.println(newX);
    }

    public static void main(String[] args) {

        Object o = new Object();
        Exampl<Object> e = new Exampl<>();
        e.some(new Object());

    }
}
class Test {
    public static void main(String[] args) {

        // any interface .... Vehicle
        // enum
        // wildcard `?` with extends and super keywords
        // any class name
        // we can omit X mention and class will be not parametrizred

        Exampl<Vehicle> es = new Exampl<>();

    }
}