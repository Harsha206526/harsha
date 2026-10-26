class Area {
void calculateArea(int side) {
System.out.println("Area of Square : " + (side * side));
}
void calculateArea(int length, int breadth) {

System.out.println("Area of Rectangle : " + (length * breadth));
}
void calculateArea(double radius) {
System.out.println("Area of Circle : " + (3.14 * radius * radius));
}
}
class AreaDemo {
public static void main(String[] args) {
Area a = new Area();
a.calculateArea(5);
a.calculateArea(10, 5);
a.calculateArea(7.0);
}
}