import java.util.Scanner;
class Student {
int roll;
String name;
int marks[] = new int[3];
double attendance;
int total;
double average;
}
public class StudentPerformance {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
Student s[] = new Student[5];
double highest = 0;
String topper = "";
for (int i = 0; i < 5; i++) {
s[i] = new Student();
System.out.println("Enter Student " + (i + 1));
System.out.print("Roll No: ");
s[i].roll = sc.nextInt();
sc.nextLine();
System.out.print("Name: ");

s[i].name = sc.nextLine();
s[i].total = 0;
for (int j = 0; j < 3; j++) {
System.out.print("Marks " + (j + 1) + ": ");
s[i].marks[j] = sc.nextInt();
s[i].total += s[i].marks[j];
}
System.out.print("Attendance: ");
s[i].attendance = sc.nextDouble();
s[i].average = s[i].total / 3.0;
if (s[i].average > highest) {
highest = s[i].average;
topper = s[i].name;
}
}
System.out.println("\nStudent Details");
for (int i = 0; i < 5; i++) {
System.out.println("Roll No: " + s[i].roll);
System.out.println("Name: " + s[i].name);
System.out.println("Total: " + s[i].total);
System.out.println("Average: " + s[i].average);
System.out.println("Result: " + (s[i].average >= 50 ? "Pass" :
"Fail"));
System.out.println("Scholarship: " +
(s[i].average >= 75 && s[i].attendance >= 80 ? "Eligible"
: "Not Eligible"));
System.out.println("Performance: " +
(s[i].average >= 85 ? "Excellent" : "Good"));
System.out.println();
}
System.out.println("Topper: " + topper);
System.out.println("Highest Average: " + highest);
}
}