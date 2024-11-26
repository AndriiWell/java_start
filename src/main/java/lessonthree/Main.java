package lessonthree;

import lessonthree.streamapi.Address;
import lessonthree.streamapi.Grade;
import lessonthree.streamapi.Student;
import lessonthree.streamapi.StudentGrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(String[] args) {
        List<Student> students = prefillStudentsData();

        int topAmount = 3;
        int ageFilter = 15;
        String cityNameFilter = "New York";

        System.out.printf("Top %d grades:%n", topAmount);

        students.stream().filter(// flatMap method returns list of StudentGrade
            student -> student.getAge() > ageFilter && student.getAddress() != null && student.getAddress().getCity() == cityNameFilter
        )
        .flatMap(filteredStudent -> filteredStudent.getGrades().stream()
            .map(grade -> new StudentGrade(
                filteredStudent.getName(),
                filteredStudent.getSchool(),
                grade.getSubject(),
                grade.getSource()
            ))
        )
        .sorted(Comparator.comparingDouble(StudentGrade::score).reversed()) // Ascending sort order for score field.
        .limit(topAmount) // Output the top 3 grades.
        .forEach(filteredStudent -> System.out.printf(
            "%s, %s, %s, %.1f%n",
            filteredStudent.studentName(),
            filteredStudent.school(),
            filteredStudent.subject(),
            filteredStudent.score()
        ));
    }

    private static List<Student> prefillStudentsData() {
        // Create a list of Student objects with varied data for testing
        List<Student> students = new ArrayList<>();
        students.add(new Student("Boris", 100, "Borchagivska middle school", Arrays.asList(
            new Grade("Algebrais", 5.5),
            new Grade("Geyofgrafis", 5),
            new Grade("Litracha", 4.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.5),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "Borchagifka",
            "pr. Ze Lenskogo 1")
        ));
        students.add(new Student("Nadias", 100, "Borchagivska middle school", Arrays.asList(
            new Grade("Algebrais", 5.5),
            new Grade("Geyofgrafis", 5),
            new Grade("Litracha", 4.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.5),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "Borchagifka",
            "pr. Ze Yenina 13")
        ));
        students.add(new Student("Verus", 19, "Borchagivska middle school", Arrays.asList(
            new Grade("Algebrais", 5),
            new Grade("Geyofgrafis", 3),
            new Grade("Litracha", 4.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.5),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "New York",
            "pr. Ze Yenina 13")
        ));
        students.add(new Student("Loves", 1, "Borchagivska middle school", Arrays.asList(
            new Grade("Algebrais", 5),
            new Grade("Geyofgrafis", 1),
            new Grade("Litracha", 2.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.5),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "New York",
            "pr. Ze Yenina 13")
        ));

        students.add(new Student("Potoff", 11, "2nd best one", Arrays.asList(
            new Grade("Algebrais", 1.5),
            new Grade("Geyofgrafis", 5),
            new Grade("Litracha", 4.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "New York",
            "pr. Ze Zoo 1")
        ));

        students.add(new Student("Mbabva", 21, "Almost the best school", Arrays.asList(
            new Grade("Algebrais", 5.5),
            new Grade("Geyofgrafis", 5.5),
            new Grade("Litracha", 4.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "New York",
            "pr. Ze Zoo 1")
        ));

        students.add(new Student("Joj", 26, "-", Arrays.asList(
            new Grade("Algebrais", 5.5),
            new Grade("Geyofgrafis", 0),
            new Grade("Litracha", 4.5),
            new Grade("Painting", 4),
            new Grade("Dancing", 4),
            new Grade("Fighting", 3.),
            new Grade("Geometrice", 3.),
            new Grade("Straching", 2)
        ), new Address(
            "New York",
            "pr. Ze Zoo 1")
        ));
        return students;
    }
}
