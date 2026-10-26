import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Roll Number 1: ");
int a = sc.nextInt();

System.out.print("Enter Roll Number 2: ");
int b = sc.nextInt();

int temp = a;
a = b;
b = temp;

System.out.println("\n------ AFTER SWAPPING ------");
System.out.println("Roll Number 1 = " + a);
System.out.println("Roll Number 2 = " + b);

sc.close();
}
}