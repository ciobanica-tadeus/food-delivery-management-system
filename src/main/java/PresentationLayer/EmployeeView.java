package PresentationLayer;

import DataLayer.Employee;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JLabel pendingLabel = new JLabel("Pending orders: ");
    private JLabel ordersLabel = new JLabel("------------------------");

    public EmployeeView() {
        pendingLabel.setBounds(10, 10, 100, 20);
        ordersLabel.setBounds(10, 20, 200, 200);
        mainPanel.setLayout(null);
        mainPanel.add(pendingLabel);
        mainPanel.add(ordersLabel);
        mainPanel.setBackground(new Color(204, 255, 255));
        this.setContentPane(mainPanel);
        this.setTitle("Employee View");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public void setTextLabel(String string) {
        ordersLabel.setText(string);
    }

    public void addWaitingOrders(String order) {
        String string = "<html>" + ordersLabel.getText() + "<br>" + order + "<br>-------------------<html>";
        //System.out.println(string);
        //ordersLabel = new JLabel(string);
        this.setTextLabel(string);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EmployeeView employeeView = new EmployeeView();
        employeeView.setVisible(true);
    }
}
