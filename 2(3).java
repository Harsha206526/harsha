class Student {
String name;
int rollNo;

void display() {
System.out.println("Student Name: " + name);
System.out.println("Roll Number: " + rollNo);

}

public static void main(String[] args) {
Student s = new Student();

s.name = "Harsha";
s.rollNo = 102;

s.display();
}
}