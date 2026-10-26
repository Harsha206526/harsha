import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Price of Product 1: ");
int price1 = sc.nextInt();

System.out.print("Enter Price of Product 2: ");
int price2 = sc.nextInt();

System.out.println("\n-------- ARITHMETIC OPERATIONS --------");
System.out.println("Addition : " + (price1 + price2));
System.out.println("Subtraction : " + (price1 - price2));
System.out.println("Multiplication : " + (price1 * price2));
System.out.println("Division : " + (price1 / price2));
System.out.println("Remainder : " + (price1 % price2));

sc.close();
}
}