import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class Employee {
String id, name, department;
Employee(String id, String name, String department) {
this.id = id;
this.name = name;
this.department = department;
}
public String toString() {
return id + " - " + name + " - " + department;
}
}
class PortalModel {
String username = "admin";
String password = "admin123";
ArrayList<Employee> employees = new ArrayList<>();
boolean login(String u, String p) {
return username.equals(u) && password.equals(p);
}
boolean changePassword(String oldP, String newP, String confirmP) {
if (password.equals(oldP) && !newP.isEmpty()
&& newP.equals(confirmP)) {
password = newP;
return true;
}
return false;
}
}

class PortalView extends JFrame {
JTextField username = new JTextField();
JPasswordField password = new JPasswordField();
JButton login = new JButton("Login");
PortalView() {
setTitle("Employee Login");
setLayout(new GridLayout(3, 2, 5, 5));
add(new JLabel("Username"));
add(username);
add(new JLabel("Password"));
add(password);
add(new JLabel(""));
add(login);
setSize(350, 180);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}
}
class PortalController {
PortalModel model;
PortalView view;
PortalController(PortalModel m, PortalView v) {
model = m;
view = v;
view.login.addActionListener(e -> {
String u = view.username.getText();
String p = new String(view.password.getPassword());
if (model.login(u, p)) {
JOptionPane.showMessageDialog(view, "Login Successful");
view.dispose();
showMainWindow();
} else {
JOptionPane.showMessageDialog(view, "Invalid Credentials");
}
});
}
void showMainWindow() {
JFrame frame = new JFrame("Employee Management Portal");
JMenuBar bar = new JMenuBar();
JMenu employee = new JMenu("Employee");
JMenu tools = new JMenu("Tools");
JMenu exit = new JMenu("Exit");
JMenuItem add = new JMenuItem("Add Employee");
JMenuItem show = new JMenuItem("View Employee");
JMenuItem change = new JMenuItem("Change Password");

JMenuItem logout = new JMenuItem("Logout");
JMenuItem quit = new JMenuItem("Exit Application");
employee.add(add);
employee.add(show);
tools.add(change);
exit.add(logout);
exit.add(quit);
bar.add(employee);
bar.add(tools);
bar.add(exit);
frame.setJMenuBar(bar);
frame.add(new JLabel("Welcome to Employee Management Portal",
SwingConstants.CENTER));
frame.setSize(550, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);
frame.setVisible(true);
add.addActionListener(e -> {
JTextField id = new JTextField();
JTextField name = new JTextField();
JTextField dept = new JTextField();
Object[] fields = {
"Employee ID:", id,
"Employee Name:", name,
"Department:", dept
};
int option = JOptionPane.showConfirmDialog(frame, fields,
"Add Employee", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
if (id.getText().trim().isEmpty() ||
name.getText().trim().isEmpty() ||
dept.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(frame,
"All fields are required");
return;
}
model.employees.add(new Employee(
id.getText(), name.getText(), dept.getText()));
JOptionPane.showMessageDialog(frame,
"Employee Added Successfully");
}
});
show.addActionListener(e -> {
StringBuilder s = new StringBuilder();
for (Employee emp : model.employees) {

s.append(emp).append("\n");
}
if (s.length() == 0)
s.append("No employees found");
JOptionPane.showMessageDialog(frame, s.toString());
});
change.addActionListener(e -> {
JPasswordField oldP = new JPasswordField();
JPasswordField newP = new JPasswordField();
JPasswordField confirmP = new JPasswordField();
Object[] fields = {
"Old Password:", oldP,
"New Password:", newP,
"Confirm Password:", confirmP
};
int option = JOptionPane.showConfirmDialog(frame, fields,
"Change Password", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
boolean ok = model.changePassword(
new String(oldP.getPassword()),
new String(newP.getPassword()),
new String(confirmP.getPassword()));
JOptionPane.showMessageDialog(frame,
ok ? "Password Changed Successfully"
: "Invalid old password or passwords do not match");
}
});
logout.addActionListener(e -> {
frame.dispose();
new PortalController(new PortalModel(), new PortalView());
});
quit.addActionListener(e -> System.exit(0));
}
}
public class EmployeePortal {
public static void main(String[] args) {
SwingUtilities.invokeLater(() ->
new PortalController(new PortalModel(), new PortalView())
);
}
}