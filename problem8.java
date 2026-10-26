import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Basic Salary: ");
double basic = sc.nextDouble();

System.out.print("Enter Allowance: ");
double allowance = sc.nextDouble();

double totalSalary = basic + allowance;

System.out.println("\n------ EMPLOYEE SALARY ------");
System.out.println("Total Salary = " + totalSalary);

sc.close();

}
}