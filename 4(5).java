class Ride {
int number;
String name;
Ride(int number, String name) {
this.number = number;
this.name = name;
}
}
public class RidePattern {
public static void main(String args[]) {
Ride r[] = {
new Ride(1, "Roller Coaster"),
new Ride(2, "Ferris Wheel"),
new Ride(3, "Bumper Cars"),
new Ride(4, "Water Ride"),
new Ride(5, "Haunted House")
};
for (int i = 0; i < r.length; i++) {
System.out.print(r[i].name + " : ");
for (int j = 1; j <= r[i].number; j++) {
System.out.print("*");
}
System.out.println();
}
}
}