import java.sql.*;
import java.util.Scanner;

public class ProductManagement {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/storedb";
String user = "root";
String password = "your_password";
try (Connection con =
DriverManager.getConnection(url, user, password);
Scanner sc = new Scanner(System.in)) {
while (true) {
System.out.println("\n1. Insert Product");
System.out.println("2. Search Product");
System.out.println("3. Update Quantity");
System.out.println("4. Low Stock Products");
System.out.println("5. Exit");
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

String sql = "INSERT INTO Product VALUES(?,?,?,?)";

try (PreparedStatement ps =

con.prepareStatement(sql)) {
ps.setInt(1, id);
ps.setString(2, name);
ps.setDouble(3, price);
ps.setInt(4, qty);
ps.executeUpdate();
System.out.println("Product inserted.");

}
} else if (ch == 2) {
System.out.print("Enter Product ID: ");

int id = sc.nextInt();

String sql =
"SELECT * FROM Product WHERE ProductID=?";
try (PreparedStatement ps =
con.prepareStatement(sql)) {
ps.setInt(1, id);

try (ResultSet rs = ps.executeQuery()) {

if (rs.next()) {
System.out.println(
rs.getInt("ProductID") + " " +

rs.getString("ProductName") + " " +
rs.getDouble("Price") + " " +
rs.getInt("Quantity"));

} else {
System.out.println("Product not found.");
}
}
}
} else if (ch == 3) {
System.out.print("Product ID: ");

int id = sc.nextInt();

System.out.print("New Quantity: ");

int qty = sc.nextInt();

String sql =
"UPDATE Product SET Quantity=? WHERE ProductID=?";
try (PreparedStatement ps =
con.prepareStatement(sql)) {
ps.setInt(1, qty);
ps.setInt(2, id);
int rows = ps.executeUpdate();
System.out.println(rows > 0 ?
"Quantity updated." :
"Product not found.");

}
} else if (ch == 4) {
String sql =
"SELECT * FROM Product WHERE Quantity < 10";
try (PreparedStatement ps =
con.prepareStatement(sql);
ResultSet rs = ps.executeQuery()) {
while (rs.next()) {
System.out.println(
rs.getInt("ProductID") + " " +
rs.getString("ProductName") + " " +
rs.getInt("Quantity"));

}
}
} else if (ch == 5) {
break;
} else {
System.out.println("Invalid choice.");
}
}
} catch (SQLException e) {
System.out.println(e.getMessage());
}
}
}