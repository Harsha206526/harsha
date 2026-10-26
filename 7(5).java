package student;

public class Student
{
    String name;
    int id;

    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    public void display()
    {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
    }
}
package course;

public class Course
{
    String courseName;
    int courseId;

    public Course(String courseName, int courseId)
    {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public void display()
    {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course ID: " + courseId);
    }
}
import student.Student;
import course.Course;

public class Main
{
    public static void main(String args[])
    {
        Student s = new Student("Harsha",101);
        Course c = new Course("Java",501);

        s.display();
        c.display();
    }
}