import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Student Name: ");
String name = sc.nextLine();

System.out.print("Enter Register Number: ");
String regNo = sc.nextLine();

System.out.print("Enter Department: ");
String department = sc.nextLine();

System.out.print("Enter Year of Study: ");
int year = sc.nextInt();
sc.nextLine(); // Consume newline

System.out.print("Enter College Name: ");

String college = sc.nextLine();

System.out.println("\n----------- STUDENT INFORMATION -----------");
System.out.println("Student Name : " + name);
System.out.println("Register Number : " + regNo);
System.out.println("Department : " + department);
System.out.println("Year of Study : " + year);
System.out.println("College Name : " + college);

sc.close();
}
}