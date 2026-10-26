import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Seat Number: ");
int seat = sc.nextInt();

if (seat % 2 == 0)
System.out.println("Seat Number is Even");
else
System.out.println("Seat Number is Odd");

sc.close();
}
}