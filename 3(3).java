class Employee {
int employeeId;
String employeeName;
double salary;
Employee(int id, String name, double sal) {
employeeId = id;
employeeName = name;
salary = sal;
}
void display() {
System.out.println("Employee ID : " + employeeId);
System.out.println("Employee Name : " + employeeName);
System.out.println("Salary : " + salary);
}
}
class EmployeeDemo {
public static void main(String[] args) {
Employee e = new Employee(101, "Rahul", 45000);
e.display();
}
}