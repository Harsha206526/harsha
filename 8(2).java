import javax.swing.*;
import java.awt.*;
class ServiceModel {
int calculate(boolean general, boolean oil,
boolean brake, boolean battery) {
int cost = 0;
if (general) cost += 1000;
if (oil) cost += 800;
if (brake) cost += 1200;
if (battery) cost += 500;
return cost;
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
JLabel result = new JLabel("Total Cost: Rs.0");
ServiceView() {
setTitle("Vehicle Service Cost Estimator");
setLayout(new GridLayout(8, 2, 5, 5));
add(new JLabel("Registration Number"));
add(reg);
add(new JLabel("Vehicle Type"));
add(type);
add(general);
add(oil);
add(brake);
add(battery);
add(calculate);
add(result);
setSize(450, 350);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
class ServiceController {
ServiceController(ServiceModel model, ServiceView view) {
view.calculate.addActionListener(e -> {
if (view.reg.getText().trim().isEmpty()) {
JOptionPane.showMessageDialog(view,
"Enter vehicle registration number");
return;
}
int cost = model.calculate(
view.general.isSelected(),
view.oil.isSelected(),
view.brake.isSelected(),
view.battery.isSelected()
);
view.result.setText("Total Cost: Rs." + cost);
});
}
}
public class VehicleService {
public static void main(String[] args) {
SwingUtilities.invokeLater(() ->
new ServiceController(new ServiceModel(), new ServiceView())
);
}
}