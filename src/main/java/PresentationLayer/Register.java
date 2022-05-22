package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Register extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Register");
    private JLabel nameLabel = new JLabel("Name: ");
    private JTextField nameField = new JTextField();
    private JLabel addressLabel = new JLabel("Address: ");
    private JTextField addressField = new JTextField();
    private JLabel usernameLabel = new JLabel("Username: ");
    private JTextField usernameField = new JTextField();
    private JLabel passwordLabel = new JLabel("Password: ");
    private JPasswordField passwordField = new JPasswordField();
    private JButton registerBtn = new JButton("Register");
    private JButton backBtn = new JButton("Back");

    public Register (){
        label.setFont(new Font("Georgian",Font.CENTER_BASELINE,20));
        label.setBounds(200,10,200,30);
        backBtn.setBounds(10,10,80,30);
        nameLabel.setFont(new Font("Georgian",Font.CENTER_BASELINE,14));
        nameLabel.setBounds(20,70,100,30);
        nameField.setBounds(120,70,300,30);
        addressLabel.setBounds(20,110,100,30);
        addressField.setBounds(120,110,300,30);
        usernameLabel.setBounds(20,150,100,30);
        usernameField.setBounds(120,150,300,30);
        passwordLabel.setBounds(20,190,100,30);
        passwordField.setBounds(120,190,300,30);
        registerBtn.setBounds(180,250,150,30);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        registerBtn.setContentAreaFilled(false);
        registerBtn.setFocusPainted(false);
        panel.add(label);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerBtn);
        panel.add(backBtn);
        panel.setBackground(new Color(204,255,255));
        panel.setLayout(null);
        setContentPane(panel);
        setTitle("Register");
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public String getName(){
        return  nameField.getText();
    }

    public String getAddress(){
        return addressField.getText();
    }

    public String getUsername(){
        return usernameField.getText();
    }

    public String getPassword(){
        return passwordField.getText();
    }

    public void setNameField(String name) {
        nameField.setText(name);
    }

    public void setAddressField(String address) {
        addressField.setText(address);
    }

    public void setUsernameField(String username) {
        usernameField.setText(username);
    }

    public void setPasswordField(String password) {
        passwordField.setText(password);
    }

    public void addBackListener(ActionListener actionListener){
        backBtn.addActionListener(actionListener);
    }

    public void addRegisterListener(ActionListener actionListener){registerBtn.addActionListener(actionListener);}

    public void showMessage(String message ){
        JOptionPane.showMessageDialog(registerBtn,message);
    }

    public static void main(String[] args) {
        Register register = new Register();
        register.setVisible(true);
    }
}
