package lessonthree.streamapi;

import java.util.List;

public class Student {

    /**
     * Name of the student.
     */
    private String name;

    /**
     * Age of the student.
     */
    private int age;

    /**
     * The name of the school the student attends.
     */
    private String school;

    /**
     * List of Grade objects, each representing the score in a subject.
     */
    private List<Grade> grades;

    /**
     * A nested field with information about the student’s address.
     */
    private Address address;

    public Student(String name, int age, String school, List<Grade> grades, Address address) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.grades = grades;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }
}
