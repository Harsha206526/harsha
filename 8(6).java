import java.sql.*;
import java.util.Scanner;
public class CourseRegistration {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/collegedb",
"root", "your_password");
System.out.print("Enter Course Code: ");
String code = sc.nextLine();
PreparedStatement ps = con.prepareStatement(
"SELECT * FROM CourseRegistration WHERE CourseCode=?");
ps.setString(1, code);
ResultSet rs = ps.executeQuery();
boolean found = false;
while (rs.next()) {
found = true;

System.out.println("Student ID: " +
rs.getInt("StudentID"));
System.out.println("Student Name: " +
rs.getString("StudentName"));
System.out.println("Course Code: " +
rs.getString("CourseCode"));
System.out.println("Course Name: " +
rs.getString("CourseName"));
System.out.println("Semester: " +
rs.getInt("Semester"));
System.out.println("--------------------");
}
if (!found) {
System.out.println(
"No students registered for this course code.");
}
rs.close();
ps.close();
con.close();
sc.close();
}
}