import javax.swing.*;
import java.awt.*;
class ServiceModel {
int calculate(boolean general, boolean oil,
boolean brake, boolean battery) {
int total = 0;
if (general) total += 1000;
if (oil) total += 800;
if (brake) total += 1200;
if (battery) total += 500;
return total;
}
}
class ServiceView extends JFrame {
JTextField reg = new JTextField();
JComboBox<String> type =
new JComboBox<>(new String[]{"Two Wheeler", "Car"});
JCheckBox general = new JCheckBox("General Service - Rs.1000");
JCheckBox oil = new JCheckBox("Oil Change - Rs.800");
JCheckBox brake = new JCheckBox("Brake Service - Rs.1200");
JCheckBox battery = new JCheckBox("Battery Check - Rs.500");
JButton calculate = new JButton("Calculate Cost");
ServiceView() {
setTitle("Vehicle Service Estimator");
setLayout(new GridLayout(7, 2, 5, 5));

add(new JLabel("Registration Number"));
add(reg);
add(new JLabel("Vehicle Type"));
add(type);
add(general);
add(oil);
add(brake);
add(battery);
add(calculate);
setSize(450, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class ServiceController {
ServiceController(ServiceModel model, ServiceView view) {
view.calculate.addActionListener(e -> {
String registration = view.reg.getText().trim();
if (registration.isEmpty()) {
JOptionPane.showMessageDialog(view,
"Enter registration number.");
return;
}
int total = model.calculate(
view.general.isSelected(),
view.oil.isSelected(),
view.brake.isSelected(),
view.battery.isSelected()
);
JOptionPane.showMessageDialog(view,
"Registration: " + registration +
"\nVehicle Type: " + view.type.getSelectedItem() +
"\nTotal Service Cost: Rs." + total);
});
}
}
public class VehicleService {
public static void main(String[] args) {
ServiceModel model = new ServiceModel();
ServiceView view = new ServiceView();
new ServiceController(model, view);
}
}