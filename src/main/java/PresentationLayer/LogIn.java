package PresentationLayer;

import DataLayer.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel title = new JLabel("Log In");
    private JLabel usernameLabel = new JLabel("Username: ");
    private JTextField usernameField = new JTextField();
    private JLabel passwordLabel = new JLabel("Password: ");
    private JPasswordField passwordField = new JPasswordField();
    private JButton logBtn = new JButton("Log in");
    private JButton backBtn = new JButton("Back");
    private JRadioButton admin = new JRadioButton("Admin");
    private JRadioButton client = new JRadioButton("Client");
    public LogIn (){
        title.setFont(new Font("Georgian",Font.CENTER_BASELINE,20));
        title.setBounds(160,20,100,30);
        usernameLabel.setBounds(10,70,100,30);
        usernameField.setBounds(110,70,200,30);
        passwordLabel.setBounds(10,110,100,30);
        passwordField.setBounds(110,110,200,30);
        logBtn.setBounds(150,160,100,30);
        backBtn.setBounds(10,10,80,20);
        panel.add(title);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        logBtn.setFocusPainted(false);
        logBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.setContentAreaFilled(false);
        panel.add(backBtn);
        panel.add(logBtn);
        panel.setLayout(null);
        panel.setBackground(new Color(204,255,255));
        this.setContentPane(panel);
        this.setTitle("Log in");
        this.setSize(400,250);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public String getUsername(){
        return usernameField.getText().toString();
    }

    public String getPassword(){
        return passwordField.getText().toString();
    }

    public void setUsernameField(String name){
        usernameField.setText(name);
    }

    public void setPasswordField(String password){
        passwordField.setText(password);
    }

    public void showMessage( String message){
        JOptionPane.showMessageDialog(logBtn,message);
    }

    public void addBackListener (ActionListener actionListener){
        backBtn.addActionListener(actionListener);
    }

    public void addLogInListener(ActionListener actionListener){logBtn.addActionListener(actionListener);}

    public static void main(String[] args) {
        LogIn logIn = new LogIn();
        logIn.setVisible(true);
    }
}
