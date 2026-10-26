import java.util.Scanner;
class BankAccount {
private int accountNumber;
private String accountHolder;
private double balance;
BankAccount(int accountNumber, String accountHolder, double balance) {
this.accountNumber = accountNumber;
this.accountHolder = accountHolder;
this.balance = balance;
}
void deposit(double amount) {
balance += amount;
System.out.println("Amount Deposited: " + amount);
}
void withdraw(double amount) {
if (amount <= balance) {
balance -= amount;
System.out.println("Amount Withdrawn: " + amount);
} else {
System.out.println("Insufficient Balance");
}
}
void display() {
System.out.println("Account Number : " + accountNumber);
System.out.println("Account Holder : " + accountHolder);
System.out.println("Balance : " + balance);
}
}
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Account Number: ");
int accNo = sc.nextInt();
sc.nextLine();
System.out.print("Enter Account Holder Name: ");
String name = sc.nextLine();
System.out.print("Enter Initial Balance: ");
double balance = sc.nextDouble();
BankAccount b = new BankAccount(accNo, name, balance);
System.out.print("Enter Deposit Amount: ");
b.deposit(sc.nextDouble());
System.out.print("Enter Withdraw Amount: ");
b.withdraw(sc.nextDouble());
b.display();
}
}