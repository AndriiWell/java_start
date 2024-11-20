package org.msjava1stesson.model;

public class User {
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age = 11;

    public User(int age) {
        this.age = age;
    }
}
