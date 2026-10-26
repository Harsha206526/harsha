import javax.swing.*;
import java.awt.*;
class StudentModel {
String name;
int m1, m2, m3, total;
double average;
String grade;
void calculate(String n, int a, int b, int c) {
name = n;
m1 = a;
m2 = b;
m3 = c;
total = m1 + m2 + m3;
average = total / 3.0;
if (average >= 90)
grade = "A";
else if (average >= 75)
grade = "B";
else if (average >= 60)
grade = "C";
else if (average >= 50)
grade = "D";
else
grade = "F";
}
}
class StudentView extends JFrame {
JTextField name = new JTextField();
JTextField m1 = new JTextField();
JTextField m2 = new JTextField();
JTextField m3 = new JTextField();
JButton calculate = new JButton("Calculate Result");
StudentView() {
setTitle("Student Grade Calculator");
setLayout(new GridLayout(5, 2, 5, 5));
add(new JLabel("Student Name"));

add(name);
add(new JLabel("Subject 1 Marks"));
add(m1);
add(new JLabel("Subject 2 Marks"));
add(m2);
add(new JLabel("Subject 3 Marks"));
add(m3);
add(calculate);
setSize(350, 250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class StudentController {
StudentController(StudentModel model, StudentView view) {
view.calculate.addActionListener(e -> {
try {
String name = view.name.getText();
int a = Integer.parseInt(view.m1.getText());
int b = Integer.parseInt(view.m2.getText());
int c = Integer.parseInt(view.m3.getText());
if (name.trim().isEmpty() ||
a < 0 || a > 100 ||
b < 0 || b > 100 ||
c < 0 || c > 100) {
JOptionPane.showMessageDialog(view,

"Enter a name and marks from 0 to 100.");
return;
}
model.calculate(name, a, b, c);
JOptionPane.showMessageDialog(view,
"Student: " + model.name +
"\nTotal: " + model.total +
"\nAverage: " + model.average +
"\nGrade: " + model.grade);
} catch (NumberFormatException ex) {
JOptionPane.showMessageDialog(view,
"Enter valid marks.");
}
});
}
}
public class StudentGradeCalculator {
public static void main(String[] args) {
StudentModel model = new StudentModel();
StudentView view = new StudentView();
new StudentController(model, view);
}
}