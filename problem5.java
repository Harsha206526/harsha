import java.util.Scanner;

class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Score of Student 1: ");
int s1 = sc.nextInt();

System.out.print("Enter Score of Student 2: ");
int s2 = sc.nextInt();

System.out.print("Enter Score of Student 3: ");
int s3 = sc.nextInt();

if (s1 >= s2 && s1 >= s3)
System.out.println("\nHighest Score = " + s1);
else if (s2 >= s1 && s2 >= s3)
System.out.println("\nHighest Score = " + s2);
else
System.out.println("\nHighest Score = " + s3);

sc.close();
}
}