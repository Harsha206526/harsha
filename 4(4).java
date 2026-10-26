import java.util.Scanner;
class Patient {
String name;
double fee;
Patient(String n, double f) {
name = n;
fee = f;
}
double calculate(double amount) {
if (amount >= 2000)
return amount - amount * 0.10;
else
return amount - amount * 0.05;
}
void display() {
double finalAmount = calculate(fee);
double discount = fee - finalAmount;
System.out.println("Patient Name: " + name);
System.out.println("Fee: " + fee);
System.out.println("Discount: " + discount);
System.out.println("Final Amount: " + finalAmount);
System.out.println();
}
}
public class HospitalBilling {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
Patient p[] = new Patient[5];
for (int i = 0; i < 5; i++) {
System.out.print("Patient Name: ");

String name = sc.nextLine();
System.out.print("Consultation Fee: ");
double fee = sc.nextDouble();
sc.nextLine();
p[i] = new Patient(name, fee);
}
for (int i = 0; i < 5; i++)
p[i].display();
}
}