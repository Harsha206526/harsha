import java.util.Scanner;
abstract class Shape{
abstract void calculateArea();
}
class Circle extends Shape{
double r;
Circle(double r){
this.r=r;
}
void calculateArea(){
System.out.println("Area = "+(3.14*r*r));
}
}
class Rectangle extends Shape{
double l,b;
Rectangle(double l,double b){
this.l=l;
this.b=b;
}
void calculateArea(){
System.out.println("Area = "+(l*b));
}
}
class Triangle extends Shape{
double base,height;
Triangle(double base,double height){
this.base=base;
this.height=height;

}
void calculateArea(){
System.out.println("Area = "+(0.5*base*height));
}
}
public class Main{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("1.Circle");
System.out.println("2.Rectangle");
System.out.println("3.Triangle");
int ch=sc.nextInt();
Shape s;
if(ch==1){
System.out.print("Enter Radius: ");
s=new Circle(sc.nextDouble());
}
else if(ch==2){
System.out.print("Enter Length: ");
double l=sc.nextDouble();
System.out.print("Enter Breadth: ");
double b=sc.nextDouble();
s=new Rectangle(l,b);
}
else{
System.out.print("Enter Base: ");
double base=sc.nextDouble();
System.out.print("Enter Height: ");
double h=sc.nextDouble();
s=new Triangle(base,h);
}
s.calculateArea();
}
}