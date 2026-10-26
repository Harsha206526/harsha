import java.sql.*;
import java.util.Scanner;
public class BookManagement {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/librarydb",
"root", "your_password");
while (true) {
System.out.println("\n1.Insert Book");
System.out.println("2.Search Book");
System.out.println("3.Display Available Books");

System.out.println("4.Issue Book");
System.out.println("5.Exit");
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
PreparedStatement ps = con.prepareStatement(sql);
ps.setInt(1, id);
ps.setString(2, title);
ps.setString(3, author);
ps.setDouble(4, price);
ps.setString(5, "Available");
ps.executeUpdate();
System.out.println("Book Inserted");
ps.close();
} else if (ch == 2) {
System.out.print("Enter Book ID: ");
int id = sc.nextInt();
PreparedStatement ps = con.prepareStatement(
"SELECT * FROM Book WHERE BookID=?");
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
System.out.println("Title: " + rs.getString("Title"));
System.out.println("Author: " + rs.getString("Author"));
System.out.println("Price: " + rs.getDouble("Price"));
System.out.println("Availability: " +
rs.getString("Availability"));
} else {
System.out.println("Book Not Found");
}
rs.close();
ps.close();

} else if (ch == 3) {
PreparedStatement ps = con.prepareStatement(
"SELECT * FROM Book WHERE Availability='Available'");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
System.out.println(
rs.getInt("BookID") + " " +
rs.getString("Title") + " " +
rs.getString("Author") + " " +
rs.getDouble("Price"));

}
rs.close();
ps.close();
} else if (ch == 4) {
System.out.print("Enter Book ID to issue: ");
int id = sc.nextInt();
PreparedStatement ps = con.prepareStatement(
"UPDATE Book SET Availability='Issued' " +
"WHERE BookID=? AND Availability='Available'");

ps.setInt(1, id);
int rows = ps.executeUpdate();
if (rows > 0)
System.out.println("Book Issued Successfully");
else
System.out.println("Book Not Found or Already Issued");
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