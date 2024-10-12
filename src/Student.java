import java.util.ArrayList;
import java.util.List;

public class Student {
    private int rating;
    private String name;

    // Static list to hold all students
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Create 3 Student objects and input information about them
        Student student1 = new Student("Andrii", 85);
        Student student2 = new Student("Vasyl", 90);
        Student student3 = new Student("Leonid", 75);

        // Add students to the list
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Display the average rating of all students
        System.out.println("Average rating: " + getAvgRating());

        // Change the rating of any student
        student2.changeRating(95);

        // Display the new average rating after the change
        System.out.println("New average rating: " + getAvgRating());

        // Output each student's information
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
    }

    // Default constructor
    public Student() {
        this.name = "";
        this.rating = 0;
        addStudentToList();
    }

    // Constructor with name only, rating will default to 0
    public Student(String name) {
        this.name = name;
        this.rating = 0; // Default rating
        addStudentToList();
    }

    // Constructor with parameters
    public Student(String name, int rating) {
        this.name = name;
        this.rating = rating;
        addStudentToList();
    }

    // Method to add this student to the static list
    private void addStudentToList() {
        students.add(this);
    }

    // Method to calculate average rating
    public static double getAvgRating() {
        if (students.isEmpty()) return 0.0; // Return 0 if no students
        int totalRating = 0;
        for (Student student : students) {
            totalRating += student.getRating();
        }
        return (double) totalRating / students.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean betterStudent(Student student) {
        return this.rating > student.rating;
    }

    public void changeRating(int rating) {
        setRating(rating);
    }

    public static void removeStudent(Student student) {
        students.remove(student);
    }

    public static void removeAllStudents() {
        students.clear();
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', rating=%d}", name, rating);
    }
}
