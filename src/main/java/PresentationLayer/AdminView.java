package PresentationLayer;

import BussinesLayer.DeliveryService;
import BussinesLayer.MenuItem;
import BussinesLayer.Order;
import DataLayer.Role;
import DataLayer.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class AdminView extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JLabel productsLabel = new JLabel("List of products");
    private JLabel startHourLabel = new JLabel("Start hour");
    private JLabel endHourLabel = new JLabel("End hour");
    private JLabel numberTimes1Label = new JLabel("Number times");
    private JLabel numberTimes2Label = new JLabel("Number times");
    private JLabel amountLabel = new JLabel("Amount");
    private JLabel dayLabel = new JLabel("Day");
    private JTextField startHour = new JTextField();
    private JTextField endHour = new JTextField();
    private JTextField numberTimes1 = new JTextField();
    private JTextField numberTimes2 = new JTextField();
    private JTextField amount = new JTextField();
    private JTextField day = new JTextField();

    private JLabel titleLabel = new JLabel("Title");
    private JLabel ratingLabel = new JLabel("Rating");
    private JLabel caloriesLabel = new JLabel("Calories");
    private JLabel proteinLabel = new JLabel("Protein");
    private JLabel fatLabel = new JLabel("Fat");
    private JLabel sodiumLabel = new JLabel("Sodium");
    private JLabel priceLabel = new JLabel("Price");

    private JTextField title = new JTextField();
    private JTextField rating = new JTextField();
    private JTextField calories = new JTextField();
    private JTextField protein = new JTextField();
    private JTextField fat = new JTextField();
    private JTextField sodium = new JTextField();
    private JTextField price = new JTextField();

    private JButton importProductsBtn = new JButton("Import Products");
    private JButton addProductsBtn = new JButton("Add Product");
    private JButton deleteProductsBtn = new JButton("Delete Product");
    private JButton modifyProductBtn = new JButton("Modify product");
    private JButton createComposeProductsBtn = new JButton("Create Composite Product");
    private JButton generateRepBtn = new JButton("Generate Reports");
    private JButton viewProductsBtn = new JButton("View Products");
    private JButton timeReportBtn = new JButton("Time interval report");
    private JButton numberReportBtn = new JButton("Number times report");
    private JButton numberAndAmountReportBtn = new JButton("Time and amount report");
    private JButton dayReportBtn = new JButton("Day report");
    private JTable table;
    private DefaultTableModel model;
    private DeliveryService deliveryService;
    private String columns[] = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
    private String columnsNrTimesOrdered[] = {"NrTimesOrdered", "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
    private String columnsOrder[] = {"OrderID", "UserID", "Date", "Price"};
    private String columnsUsers[] = {"UserId", "Username", "Name", "Address", "Role"};


    public AdminView(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        importProductsBtn.setBounds(30, 40, 200, 30);
        viewProductsBtn.setBounds(30, 80, 200, 30);
        createComposeProductsBtn.setBounds(30, 120, 200, 30);

        startHourLabel.setBounds(30, 280, 200, 30);
        startHour.setBounds(30, 310, 200, 30);
        endHourLabel.setBounds(30, 340, 200, 30);
        endHour.setBounds(30, 370, 200, 30);
        timeReportBtn.setBounds(30, 400, 200, 30);
        numberTimes1Label.setBounds(30, 440, 200, 30);
        numberTimes1.setBounds(30, 470, 200, 30);
        numberReportBtn.setBounds(30, 500, 200, 30);
        numberTimes2Label.setBounds(30, 540, 200, 30);
        numberTimes2.setBounds(30, 570, 200, 30);
        amountLabel.setBounds(30, 600, 200, 30);
        amount.setBounds(30, 630, 200, 30);
        numberAndAmountReportBtn.setBounds(30, 660, 200, 30);
        dayLabel.setBounds(30, 700, 200, 30);
        day.setBounds(30, 730, 200, 30);
        dayReportBtn.setBounds(30, 760, 200, 30);
        setInvisibleButtons();
        table = new JTable(new DefaultTableModel(columns, 0));
        resizeColumnWidth(table);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(300, 40, 1150, 500);
        mainPanel.add(scrollPane);
        productsLabel.setBounds(800, 5, 250, 30);
        productsLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 20));
        titleLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 14));
        ratingLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 13));
        caloriesLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 13));
        proteinLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 13));
        fatLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 13));
        sodiumLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 13));
        priceLabel.setFont(new Font("Georgian", Font.CENTER_BASELINE, 13));
        titleLabel.setBounds(700, 550, 80, 30);
        title.setBounds(780, 550, 200, 30);
        ratingLabel.setBounds(700, 580, 80, 30);
        rating.setBounds(780, 580, 200, 30);
        caloriesLabel.setBounds(700, 610, 80, 30);
        calories.setBounds(780, 610, 200, 30);
        proteinLabel.setBounds(700, 640, 80, 30);
        protein.setBounds(780, 640, 200, 30);
        fatLabel.setBounds(700, 670, 80, 30);
        fat.setBounds(780, 670, 200, 30);
        sodiumLabel.setBounds(700, 700, 80, 30);
        sodium.setBounds(780, 700, 200, 30);
        priceLabel.setBounds(700, 730, 80, 30);
        price.setBounds(780, 730, 200, 30);
        addProductsBtn.setBounds(1000, 600, 200, 30);
        modifyProductBtn.setBounds(1000, 640, 200, 30);
        deleteProductsBtn.setBounds(1000, 680, 200, 30);
        mainPanel.add(titleLabel);
        mainPanel.add(title);
        mainPanel.add(ratingLabel);
        mainPanel.add(rating);
        mainPanel.add(caloriesLabel);
        mainPanel.add(calories);
        mainPanel.add(proteinLabel);
        mainPanel.add(protein);
        mainPanel.add(fatLabel);
        mainPanel.add(fat);
        mainPanel.add(sodiumLabel);
        mainPanel.add(sodium);
        mainPanel.add(priceLabel);
        mainPanel.add(price);
        mainPanel.add(productsLabel);
        mainPanel.add(importProductsBtn);
        mainPanel.add(viewProductsBtn);
        mainPanel.add(addProductsBtn);
        mainPanel.add(deleteProductsBtn);
        mainPanel.add(modifyProductBtn);
        mainPanel.add(createComposeProductsBtn);
        mainPanel.add(viewProductsBtn);
        mainPanel.add(timeReportBtn);
        mainPanel.add(numberReportBtn);
        mainPanel.add(numberAndAmountReportBtn);
        mainPanel.add(dayReportBtn);
        mainPanel.add(startHour);
        mainPanel.add(startHourLabel);
        mainPanel.add(numberTimes1);
        mainPanel.add(numberTimes1Label);
        mainPanel.add(numberTimes2);
        mainPanel.add(numberTimes2Label);
        mainPanel.add(endHourLabel);
        mainPanel.add(endHour);
        mainPanel.add(amountLabel);
        mainPanel.add(amount);
        mainPanel.add(dayLabel);
        mainPanel.add(day);
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(204, 255, 255));
        this.setContentPane(mainPanel);
        this.setTitle("Admin Page");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(1500, 1200);

    }

    public void setStartHour(String name) {
        startHour.setText(name);
    }

    public void setEndHour(String name) {
        endHour.setText(name);
    }

    public void setNumberTimes1(String name) {
        numberTimes1.setText(name);
    }

    public void setNumberTimes2(String name) {
        numberTimes2.setText(name);
    }

    public void setAmount(String name) {
        amount.setText(name);
    }

    public void setDay(String name) {
        day.setText(name);
    }

    public void setTitlee(String name) {
        title.setText(name);
    }

    public void setRating(String name) {
        rating.setText(name);
    }

    public void setCalories(String name) {
        calories.setText(name);
    }

    public void setProtein(String name) {
        this.protein.setText(name);
    }

    public void setFat(String name) {
        this.fat.setText(name);
    }

    public void setSodium(String name) {
        this.sodium.setText(name);
    }

    public void setPrice(String name) {
        this.price.setText(name);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getRating() {
        return rating.getText();
    }

    public String getCalories() {
        return calories.getText();
    }

    public String getProtein() {
        return protein.getText();
    }

    public String getFat() {
        return fat.getText();
    }

    public String getSodium() {
        return sodium.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getStartHour() {
        return startHour.getText();
    }

    public String getEndHour() {
        return endHour.getText();
    }

    public String getNumberTimes1() {
        return numberTimes1.getText();
    }

    public String getNumberTimes2() {
        return numberTimes2.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getDay() {
        return day.getText();
    }

    public void makeJTable() {
        model = new DefaultTableModel(columns, 0);
        List<MenuItem> productsList = deliveryService.getMenuItems();

        for (int i = 0; i < productsList.size(); i++) {
            String title = productsList.get(i).getTitle();
            double rating = productsList.get(i).getRating();
            int calories = productsList.get(i).getCalories();
            int protein = productsList.get(i).getProtein();
            int fat = productsList.get(i).getFat();
            int sodium = productsList.get(i).getSodium();
            int price = productsList.get(i).computePrice();
            Object[] data = {title, rating, calories, protein, fat, sodium, price};
            model.addRow(data);
        }
        table.setModel(model);
        resizeColumnWidth(table);
    }

    public void makeFirstReportJTable(List<Order> orderList) {
        model = new DefaultTableModel(columnsOrder, 0);

        for (int i = 0; i < orderList.size(); i++) {
            int orderID = orderList.get(i).getOrderID();
            String userID = orderList.get(i).getUserID();
            Date date = orderList.get(i).getDate();
            int price = orderList.get(i).getTotalPrice();
            Object[] data = {orderID, userID, date, price};
            model.addRow(data);
        }
        table.setModel(model);
        resizeColumnWidth(table);
    }

    public void makeSecondReportJTable(List<MenuItem> menuItemsList) {
        model = new DefaultTableModel(columnsNrTimesOrdered, 0);
        for (int i = 0; i < menuItemsList.size(); i++) {
            int nrTimesOrdered = menuItemsList.get(i).getNrTimesOrdered();
            String title = menuItemsList.get(i).getTitle();
            double rating = menuItemsList.get(i).getRating();
            int calories = menuItemsList.get(i).getCalories();
            int protein = menuItemsList.get(i).getProtein();
            int fat = menuItemsList.get(i).getFat();
            int sodium = menuItemsList.get(i).getSodium();
            int price = menuItemsList.get(i).computePrice();
            Object[] data = {nrTimesOrdered, title, rating, calories, protein, fat, sodium, price};
            model.addRow(data);
        }
        table.setModel(model);
        resizeColumnWidth(table);
    }

    public void makeThirdReportJTable(List<User> userList) {
        model = new DefaultTableModel(columnsUsers, 0);
        for (int i = 0; i < userList.size(); i++) {
            int userID = Integer.parseInt(userList.get(i).getUserId());
            String username = (String) userList.get(i).getUsername();
            String name = userList.get(i).getName();
            String address = userList.get(i).getAddress();
            Role role = userList.get(i).getRole();
            Object[] data = {userID,username,name,address,role};
            model.addRow(data);
        }
        table.setModel(model);
        resizeColumnWidth(table);
    }

    private void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void setInvisibleButtons() {
        importProductsBtn.setContentAreaFilled(false);
        importProductsBtn.setFocusPainted(false);
        viewProductsBtn.setContentAreaFilled(false);
        viewProductsBtn.setFocusPainted(false);
        addProductsBtn.setContentAreaFilled(false);
        addProductsBtn.setFocusPainted(false);
        deleteProductsBtn.setContentAreaFilled(false);
        deleteProductsBtn.setFocusPainted(false);
        modifyProductBtn.setContentAreaFilled(false);
        modifyProductBtn.setFocusPainted(false);
        createComposeProductsBtn.setContentAreaFilled(false);
        createComposeProductsBtn.setFocusPainted(false);
        timeReportBtn.setContentAreaFilled(false);
        timeReportBtn.setFocusPainted(false);
        dayReportBtn.setContentAreaFilled(false);
        dayReportBtn.setFocusPainted(false);
        numberAndAmountReportBtn.setContentAreaFilled(false);
        numberAndAmountReportBtn.setFocusPainted(false);
        numberReportBtn.setContentAreaFilled(false);
        numberReportBtn.setFocusPainted(false);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(mainPanel, message);
    }

    public void addImportProductsListener(ActionListener actionListener) {
        importProductsBtn.addActionListener(actionListener);
    }

    public void addViewProductsListener(ActionListener actionListener) {
        viewProductsBtn.addActionListener(actionListener);
    }

    public void addAddNewProductListener(ActionListener actionListener) {
        addProductsBtn.addActionListener(actionListener);
    }

    public void addModifyProductListener(ActionListener actionListener) {
        modifyProductBtn.addActionListener(actionListener);
    }

    public void addDeleteProductListener(ActionListener actionListener) {
        deleteProductsBtn.addActionListener(actionListener);
    }

    public void addCompositeListener(ActionListener actionListener) {
        createComposeProductsBtn.addActionListener(actionListener);
    }

    public void addFirstReportListener(ActionListener actionListener) {
        timeReportBtn.addActionListener(actionListener);
    }

    public void addSecondReportListener(ActionListener actionListener) {
        numberReportBtn.addActionListener(actionListener);
    }

    public void addThirdReportListener(ActionListener actionListener) {
        numberAndAmountReportBtn.addActionListener(actionListener);
    }

    public void addFourthReportListener(ActionListener actionListener) {
        dayReportBtn.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        AdminView adminView = new AdminView(deliveryService);
        adminView.setVisible(true);
    }
}
