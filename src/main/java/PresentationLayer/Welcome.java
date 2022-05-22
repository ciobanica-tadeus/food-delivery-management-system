package PresentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Welcome {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("WELCOME !");
    private JButton registerBtn = new JButton("Register");
    private JButton logBtn = new JButton("Log in");

    public Welcome(){
        label.setFont(new Font("Georgian",Font.CENTER_BASELINE,20));
        label.setBounds(150,10,300,30);
        registerBtn.setBounds(50,50,300,30);
        logBtn.setBounds(50,90,300,30);
        registerBtn.setContentAreaFilled(false);
        logBtn.setContentAreaFilled(false);
        registerBtn.setFocusPainted(false);
        logBtn.setFocusPainted(false);
        panel.add(label);
        panel.add(registerBtn);
        panel.add(logBtn);
        panel.setBackground(new Color(204,255,255));
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setSize(400,200);
        frame.setTitle("Welcome");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void addRegisterListener(ActionListener actionListener){
        registerBtn.addActionListener(actionListener);
    }

    public void addLogInListener(ActionListener actionListener){
        logBtn.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        Welcome welcome = new Welcome();

    }
}
