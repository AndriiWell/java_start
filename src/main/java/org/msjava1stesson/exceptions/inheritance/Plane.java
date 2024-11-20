package org.msjava1stesson.exceptions.inheritance;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Plane {

    public void fly() throws IOException {

    }
}


class Airplane extends Plane {

    public void fly(){

    }
}

class Helicopter extends Plane {
    public void fly() throws FileNotFoundException {
    }
}