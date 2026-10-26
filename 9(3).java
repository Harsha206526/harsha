import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class EmployeeModel {
String password = "admin123";
ArrayList<String> employees = new ArrayList<>();
boolean login(String user, String pass) {
return user.equals("admin") && pass.equals(password);
}
boolean changePassword(String oldPass, String newPass,
String confirmPass) {
if (!password.equals(oldPass))
return false;
if (newPass.isEmpty() || !newPass.equals(confirmPass))
return false;
password = newPass;
return true;
}
void addEmployee(String id, String name, String dept) {
employees.add(id + " - " + name + " - " + dept);
}
}
class EmployeeView extends JFrame {
JTextField username = new JTextField();
JPasswordField password = new JPasswordField();
JButton login = new JButton("Login");
EmployeeView() {
setTitle("Employee Login");
setLayout(new GridLayout(3, 2, 5, 5));
add(new JLabel("Username"));
add(username);
add(new JLabel("Password"));
add(password);
add(login);

setSize(300, 180);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);
}
}
class EmployeeController {
EmployeeModel model;
EmployeeView view;
EmployeeController(EmployeeModel m, EmployeeView v) {
model = m;
view = v;
view.login.addActionListener(e -> {
String user = view.username.getText();
String pass = new String(view.password.getPassword());
if (model.login(user, pass)) {
JOptionPane.showMessageDialog(view, "Login Successful");
view.dispose();
showMain();
} else {
JOptionPane.showMessageDialog(view, "Invalid Login");
}
});
}
void showMain() {
JFrame f = new JFrame("Employee Management Portal");
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
f.setJMenuBar(bar);
f.add(new JLabel("Welcome to Employee Portal",
SwingConstants.CENTER));
f.setSize(500, 300);

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setLocationRelativeTo(null);
f.setVisible(true);
add.addActionListener(e -> {
JTextField id = new JTextField();
JTextField name = new JTextField();
JTextField dept = new JTextField();
Object[] fields = {
"Employee ID", id,
"Employee Name", name,
"Department", dept
};
int result = JOptionPane.showConfirmDialog(
f, fields, "Add Employee",
JOptionPane.OK_CANCEL_OPTION);
if (result == JOptionPane.OK_OPTION) {
if (id.getText().trim().isEmpty() ||
name.getText().trim().isEmpty() ||
dept.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(f,
"Enter all employee details.");
return;
}
model.addEmployee(id.getText(), name.getText(),
dept.getText());
JOptionPane.showMessageDialog(f,
"Employee Added Successfully");
}
});
show.addActionListener(e -> {
if (model.employees.isEmpty()) {
JOptionPane.showMessageDialog(f, "No employees found.");
} else {
JOptionPane.showMessageDialog(f,
String.join("\n", model.employees));
}
});
change.addActionListener(e -> {
JPasswordField oldPass = new JPasswordField();
JPasswordField newPass = new JPasswordField();
JPasswordField confirmPass = new JPasswordField();
Object[] fields = {
"Old Password", oldPass,
"New Password", newPass,
"Confirm Password", confirmPass
};
int result = JOptionPane.showConfirmDialog(
f, fields, "Change Password",

JOptionPane.OK_CANCEL_OPTION);
if (result == JOptionPane.OK_OPTION) {
boolean success = model.changePassword(
new String(oldPass.getPassword()),
new String(newPass.getPassword()),
new String(confirmPass.getPassword()));

JOptionPane.showMessageDialog(f,
success ? "Password Changed" :

"Invalid old password or passwords do not match");

}
});
logout.addActionListener(e -> {
f.dispose();
new EmployeeController(model, new EmployeeView());
});
quit.addActionListener(e -> System.exit(0));
}
}
public class EmployeePortal {
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
EmployeeModel model = new EmployeeModel();
EmployeeView view = new EmployeeView();
new EmployeeController(model, view);
});
}
}