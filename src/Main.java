import java.util.ArrayList;
import java.util.List;


interface Manageable {
    void displayInfo();
}


abstract class Person implements Manageable {
    private String name;
    private String id;

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}


class Student extends Person {
    private List<Course> enrolledCourses;

    public Student(String name, String id) {
        super(name, id);
        this.enrolledCourses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(getName() + " has enrolled in " + course.getCourseName());
    }

    public void displayCourses() {
        System.out.println("Courses for " + getName() + ":");
        for (Course course : enrolledCourses) {
            System.out.println(course.getCourseName());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Name: " + getName() + ", ID: " + getId());
    }
}


class Instructor extends Person {
    private String department;

    public Instructor(String name, String id, String department) {
        super(name, id);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void displayInfo() {
        System.out.println("Instructor Name: " + getName() + ", ID: " + getId() + ", Department: " + department);
    }
}


class Staff extends Person {
    private String position;

    public Staff(String name, String id, String position) {
        super(name, id);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void displayInfo() {
        System.out.println("Staff Name: " + getName() + ", ID: " + getId() + ", Position: " + position);
    }
}


class Course implements Manageable {
    private String courseName;
    private Instructor instructor;

    public Course(String courseName, Instructor instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @Override
    public void displayInfo() {
        System.out.println("Course Name: " + courseName + ", Instructor: " + instructor.getName());
    }
}


class Department implements Manageable {
    private String departmentName;
    private List<Course> courses;
    private List<Instructor> instructors;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    @Override
    public void displayInfo() {
        System.out.println("Department: " + departmentName);
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseName() + " - Instructor: " + course.getInstructor().getName());
        }
        System.out.println("Instructors:");
        for (Instructor instructor : instructors) {
            System.out.println(instructor.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Instructor instructor1 = new Instructor("Prof.Dr. h turkas", "INS001", "ML");
        Instructor instructor2 = new Instructor("Dr. hilal trks", "INS002", "DL");

        Course course1 = new Course("YBS", instructor1);
        Course course2 = new Course("AI", instructor2);

        Student student1 = new Student("Hilal Türkaslann", "STU35");


        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);

        student1.displayInfo();
        student1.displayCourses();


        Department department1 = new Department("AI Department");
        department1.addCourse(course1);
        department1.addInstructor(instructor1);


        department1.displayInfo();
    }
}
