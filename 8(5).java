import java.sql.*;
import java.util.Scanner;
public class ProductManagement {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/storedb",
"root", "your_password");
while (true) {
System.out.println("\n1.Insert Product");
System.out.println("2.Search Product");
System.out.println("3.Update Quantity");
System.out.println("4.Low Stock Products");
System.out.println("5.Exit");
System.out.print("Enter choice: ");
int ch = sc.nextInt();
sc.nextLine();
if (ch == 1) {
System.out.print("Product ID: ");
int id = sc.nextInt();
sc.nextLine();

System.out.print("Product Name: ");
String name = sc.nextLine();
System.out.print("Price: ");
double price = sc.nextDouble();
System.out.print("Quantity: ");
int qty = sc.nextInt();
PreparedStatement ps = con.prepareStatement(
"INSERT INTO Product VALUES(?,?,?,?)");
ps.setInt(1, id);
ps.setString(2, name);
ps.setDouble(3, price);
ps.setInt(4, qty);
ps.executeUpdate();
System.out.println("Product Inserted");
ps.close();
} else if (ch == 2) {
System.out.print("Enter Product ID: ");
int id = sc.nextInt();
PreparedStatement ps = con.prepareStatement(
"SELECT * FROM Product WHERE ProductID=?");
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
System.out.println("Name: " +
rs.getString("ProductName"));
System.out.println("Price: " +
rs.getDouble("Price"));
System.out.println("Quantity: " +
rs.getInt("Quantity"));
} else {
System.out.println("Product Not Found");
}
rs.close();
ps.close();
} else if (ch == 3) {
System.out.print("Product ID: ");
int id = sc.nextInt();
System.out.print("New Quantity: ");
int qty = sc.nextInt();
PreparedStatement ps = con.prepareStatement(
"UPDATE Product SET Quantity=? WHERE ProductID=?");
ps.setInt(1, qty);
ps.setInt(2, id);

int rows = ps.executeUpdate();
if (rows > 0)
System.out.println("Quantity Updated");
else
System.out.println("Product Not Found");
ps.close();
} else if (ch == 4) {
PreparedStatement ps = con.prepareStatement(
"SELECT * FROM Product WHERE Quantity < 10");
ResultSet rs = ps.executeQuery();
boolean found = false;
while (rs.next()) {
found = true;
System.out.println(

rs.getInt("ProductID") + " " +
rs.getString("ProductName") + " " +
rs.getDouble("Price") + " " +
rs.getInt("Quantity"));

}
if (!found)
System.out.println("No Low Stock Products");
rs.close();
ps.close();
} else if (ch == 5) {
break;
} else {
System.out.println("Invalid Choice");
}
}
con.close();
sc.close();
}
}