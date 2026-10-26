import javax.swing.*;
import java.awt.*;
class StudentModel {
String name;
int m1, m2, m3;
int total;
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

JLabel result = new JLabel("Result will appear here");
StudentView() {
setTitle("Student Grade Calculator");
setLayout(new GridLayout(6, 2, 5, 5));
add(new JLabel("Student Name"));
add(name);
add(new JLabel("Subject 1 Marks"));
add(m1);
add(new JLabel("Subject 2 Marks"));
add(m2);
add(new JLabel("Subject 3 Marks"));
add(m3);
add(calculate);
add(result);
setSize(450, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class StudentController {
StudentModel model;
StudentView view;
StudentController(StudentModel m, StudentView v) {
model = m;
view = v;
view.calculate.addActionListener(e -> {
try {
String name = view.name.getText().trim();
int a = Integer.parseInt(view.m1.getText());
int b = Integer.parseInt(view.m2.getText());
int c = Integer.parseInt(view.m3.getText());
if (name.isEmpty() || a < 0 || a > 100 ||
b < 0 || b > 100 || c < 0 || c > 100) {
throw new IllegalArgumentException();

}
model.calculate(name, a, b, c);
view.result.setText(
"Total: " + model.total +

" Average: " + String.format("%.2f", model.average) +
" Grade: " + model.grade

);
} catch (Exception ex) {
JOptionPane.showMessageDialog(view,
"Enter a name and marks between 0 and 100.");
}
});
}
}

public class StudentGradeCalculator {
public static void main(String[] args) {
SwingUtilities.invokeLater(() ->
new StudentController(new StudentModel(), new StudentView())
);
}
}