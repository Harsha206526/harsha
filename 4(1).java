import java.util.Scanner;
class Product {
int id;
String name;
double price;
int quantity;
double total, discount, finalPrice;
}
public class ProductBilling {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Product p[] = new Product[5];
for (int i = 0; i < 5; i++) {
p[i] = new Product();
System.out.println("Enter Product " + (i + 1));
System.out.print("ID: ");
p[i].id = sc.nextInt();
sc.nextLine();
System.out.print("Name: ");
p[i].name = sc.nextLine();
System.out.print("Price: ");
p[i].price = sc.nextDouble();
System.out.print("Quantity: ");
p[i].quantity = sc.nextInt();
p[i].total = p[i].price * p[i].quantity;
if (p[i].total >= 5000)
p[i].discount = p[i].total * 0.10;

else
p[i].discount = p[i].total * 0.05;
p[i].finalPrice = p[i].total - p[i].discount;
}
System.out.println("\nProduct Details");
for (int i = 0; i < 5; i++) {
System.out.println("Product ID: " + p[i].id);
System.out.println("Name: " + p[i].name);
System.out.println("Total Price: " + p[i].total);
System.out.println("Discount: " + p[i].discount);
System.out.println("Final Price: " + p[i].finalPrice);
System.out.println();
}
}
}