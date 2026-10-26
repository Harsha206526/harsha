import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Student Marks: ");
int marks = sc.nextInt();

if (marks >= 50)
System.out.println("Pass");
else
System.out.println("Fail");

sc.close();
}

}