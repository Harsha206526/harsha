import java.sql.*;
import java.util.Scanner;
public class BookManagement {
public static void main(String[] args) {
String url = "jdbc:mysql://localhost:3306/librarydb";
String user = "root";
String password = "your_password";
try (Connection con =
DriverManager.getConnection(url, user, password);
Scanner sc = new Scanner(System.in)) {
while (true) {
System.out.println("\n1. Insert Book");
System.out.println("2. Search Book");
System.out.println("3. Display Available Books");
System.out.println("4. Issue Book");
System.out.println("5. Exit");
System.out.print("Enter choice: ");
int ch = sc.nextInt();
sc.nextLine();
if (ch == 1) {
System.out.print("Book ID: ");
int id = sc.nextInt();
sc.nextLine();

System.out.print("Title: ");
String title = sc.nextLine();
System.out.print("Author: ");
String author = sc.nextLine();
System.out.print("Price: ");
double price = sc.nextDouble();
sc.nextLine();

String sql = "INSERT INTO Book VALUES(?,?,?,?,?)";

try (PreparedStatement ps =

con.prepareStatement(sql)) {
ps.setInt(1, id);
ps.setString(2, title);
ps.setString(3, author);
ps.setDouble(4, price);
ps.setString(5, "Available");
ps.executeUpdate();
System.out.println("Book inserted.");

}
} else if (ch == 2) {
System.out.print("Enter Book ID: ");

int id = sc.nextInt();

String sql = "SELECT * FROM Book WHERE BookID=?";

try (PreparedStatement ps =

con.prepareStatement(sql)) {
ps.setInt(1, id);

try (ResultSet rs = ps.executeQuery()) {

if (rs.next()) {
System.out.println(
rs.getInt("BookID") + " " +
rs.getString("Title") + " " +
rs.getString("Author") + " " +
rs.getDouble("Price") + " " +
rs.getString("Availability"));

} else {
System.out.println("Book not found.");
}
}
}
} else if (ch == 3) {
String sql =
"SELECT * FROM Book WHERE Availability=?";
try (PreparedStatement ps =
con.prepareStatement(sql)) {
ps.setString(1, "Available");

try (ResultSet rs = ps.executeQuery()) {

while (rs.next()) {
System.out.println(
rs.getInt("BookID") + " " +
rs.getString("Title") + " " +
rs.getString("Author") + " " +
rs.getDouble("Price"));

}
}
}
} else if (ch == 4) {
System.out.print("Enter Book ID to issue: ");

int id = sc.nextInt();

String sql = "UPDATE Book SET Availability=? " +
"WHERE BookID=? AND Availability=?";
try (PreparedStatement ps =
con.prepareStatement(sql)) {
ps.setString(1, "Issued");

ps.setInt(2, id);

ps.setString(3, "Available");
int rows = ps.executeUpdate();
System.out.println(rows > 0 ?

"Book issued." :

"Book not found or already issued.");

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