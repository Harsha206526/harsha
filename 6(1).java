package student;
public class Student
{
int studentId;
String studentName;
String department;
public Student(int studentId, String studentName, String department)
{
this.studentId = studentId;
this.studentName = studentName;
this.department = department;
}
public void displayStudent()
{
System.out.println("Student ID : " + studentId);
System.out.println("Student Name : " + studentName);
System.out.println("Department : " + department);
}
}
package course;
public class Course
{
int courseId;
String courseName;
int credits;
public Course(int courseId, String courseName, int credits)
{
this.courseId = courseId;
this.courseName = courseName;
this.credits = credits;
}
public void displayCourse()
{
System.out.println("Course ID : " + courseId);
System.out.println("Course Name : " + courseName);
System.out.println("Credits : " + credits);
}
}
import student.Student;
import course.Course;
public class Main
{
public static void main(String args[])
{
Student s = new Student(101, "Harsha", "Cyber Security");
Course c = new Course(501, "Java Programming", 4);
System.out.println("******** STUDENT DETAILS ********");
s.displayStudent();
System.out.println();
System.out.println("******** COURSE DETAILS ********");
c.displayCourse();
}
}