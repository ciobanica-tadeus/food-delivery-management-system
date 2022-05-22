package PresentationLayer;

import BussinesLayer.BaseProduct;
import BussinesLayer.DeliveryService;
import BussinesLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompositeProductView extends JFrame {
    private ArrayList<BaseProduct> composite = new ArrayList<>();
    private int nrCompositeProducts;
    private JPanel mainPanel = new JPanel();
    private JLabel nameLabel = new JLabel("Name");
    private JTextField nameField = new JTextField();
    private JLabel labelNrProducts = new JLabel("Number products: " + nrCompositeProducts);
    private JButton addBtn = new JButton("Add");
    private JButton submitBtn = new JButton("Submit");
    private String finalName;

    public CompositeProductView(DeliveryService deliveryService) {
        nameLabel.setBounds(20, 15, 100, 30);
        nameField.setBounds(120, 15, 200, 30);

        JComboBox comboBox = new JComboBox();
        List<MenuItem> list = deliveryService.getMenuItems();
        for (MenuItem i : list)
            comboBox.addItem(i.getTitle());

        comboBox.setBounds(20, 70, 400, 80);
        addBtn.setBounds(20,160,100,30);
        labelNrProducts.setBounds(130,160,200,30);
        submitBtn.setBounds(120,200,200,30);
        addBtn.setFocusPainted(false);
        addBtn.setContentAreaFilled(false);
        submitBtn.setContentAreaFilled(false);
        submitBtn.setContentAreaFilled(false);

        addBtn.addActionListener(e1 -> {
            nrCompositeProducts++;
            labelNrProducts.setText("Nr. products: " + nrCompositeProducts);
            this.setVisible(true);
            composite.add((BaseProduct) deliveryService.getProduct((String) comboBox.getSelectedItem()));
        });

        submitBtn.addActionListener(e12 -> {
            this.dispose();
            finalName = nameField.getText();
            deliveryService.createComposite(finalName, composite);
            nrCompositeProducts = 0;
            labelNrProducts.setText("Nr. products: " + nrCompositeProducts);
        });

        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(comboBox);
        mainPanel.add(addBtn);
        mainPanel.add(labelNrProducts);
        mainPanel.add(submitBtn);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(204, 255, 255));
        setTitle("Composite Product");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);

    }

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        AdminView adminView = new AdminView(deliveryService);
        CompositeProductView compositeProductView = new CompositeProductView( deliveryService);
        compositeProductView.setVisible(true);
    }
}
