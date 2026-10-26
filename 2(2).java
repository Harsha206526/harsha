class Book {
String title;
String author;
double price;

public static void main(String[] args) {
Book b = new Book();

b.title = "Java Programming";
b.author = "James Gosling";
b.price = 450.50;

System.out.println("Book Title: " + b.title);
System.out.println("Author: " + b.author);
System.out.println("Price: " + b.price);
}
}