import java.util.Scanner;
class Employee {

int id;
String name;
double salary;
void display() {
System.out.println("Employee ID: " + id);
System.out.println("Name: " + name);
System.out.println("Monthly Salary: " + salary);
}
void annualSalary() {
System.out.println("Annual Salary: " + salary * 12);
}
void bonus() {
double annual = salary * 12;
if (salary >= 30000) {
System.out.println("Bonus: " + annual * 0.10);
System.out.println("Eligible");
} else {
System.out.println("Bonus: 0");
System.out.println("Not Eligible");
}
}
}
public class EmployeeManagement {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
Employee e[] = new Employee[5];
for (int i = 0; i < 5; i++) {
e[i] = new Employee();
System.out.print("Employee ID: ");
e[i].id = sc.nextInt();
sc.nextLine();
System.out.print("Name: ");
e[i].name = sc.nextLine();
System.out.print("Monthly Salary: ");
e[i].salary = sc.nextDouble();
}
System.out.println("\nEmployee Details");
for (int i = 0; i < 5; i++) {
e[i].display();

e[i].annualSalary();
e[i].bonus();
System.out.println();
}
}
}