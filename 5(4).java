import java.util.Scanner;
abstract class Product {
int id;
String name;
double price;
Product(int id,String name,double price){
this.id=id;
this.name=name;
this.price=price;
}
abstract double calculateDiscount();
}

class Electronics extends Product{
Electronics(int id,String name,double price){
super(id,name,price);
}
double calculateDiscount(){
return price*0.10;
}
}
class Clothing extends Product{
Clothing(int id,String name,double price){
super(id,name,price);
}
double calculateDiscount(){
return price*0.20;
}
}
class Books extends Product{
Books(int id,String name,double price){
super(id,name,price);
}
double calculateDiscount(){
return price*0.05;
}
}
public class Main{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("1.Electronics");
System.out.println("2.Clothing");
System.out.println("3.Books");
int ch=sc.nextInt();
System.out.print("Enter Product ID: ");
int id=sc.nextInt();
sc.nextLine();
System.out.print("Enter Product Name: ");
String name=sc.nextLine();
System.out.print("Enter Price: ");
double price=sc.nextDouble();
Product p;

if(ch==1)
p=new Electronics(id,name,price);
else if(ch==2)
p=new Clothing(id,name,price);
else
p=new Books(id,name,price);
double discount=p.calculateDiscount();
System.out.println("Discount = "+discount);
System.out.println("Final Price = "+(price-discount));
}
}