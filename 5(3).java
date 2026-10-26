import java.util.Scanner;
interface Payment {
void makePayment(double amount);
}
class UPI implements Payment {
public void makePayment(double amount) {
System.out.println("Payment of " + amount + " made using UPI");
}
}
class CreditCard implements Payment {
public void makePayment(double amount) {
System.out.println("Payment of " + amount + " made using Credit
Card");
}
}

class NetBanking implements Payment {
public void makePayment(double amount) {
System.out.println("Payment of " + amount + " made using Net
Banking");
}
}
public class Main {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.println("1.UPI");
System.out.println("2.Credit Card");
System.out.println("3.Net Banking");
System.out.print("Enter Choice: ");
int ch = sc.nextInt();
System.out.print("Enter Amount: ");
double amount = sc.nextDouble();
Payment p;
if(ch==1)
p=new UPI();
else if(ch==2)
p=new CreditCard();
else
p=new NetBanking();
p.makePayment(amount);
}
}