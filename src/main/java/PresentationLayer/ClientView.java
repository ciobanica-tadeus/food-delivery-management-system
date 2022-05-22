package PresentationLayer;

import BussinesLayer.DeliveryService;
import BussinesLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientView extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel menuLabel = new JLabel("Menu");
    private JButton viewProductsBtn = new JButton("View Products");
    private JLabel titleLabel = new JLabel("Title");
    private JLabel ratingLabel = new JLabel("Rating");
    private JLabel caloriesLabel = new JLabel("Calories");
    private JLabel proteinLabel = new JLabel("Proteins");
    private JLabel fatLabel = new JLabel("Fat");
    private JLabel sodiumLabel = new JLabel("Sodium");
    private JLabel priceLabel = new JLabel("Price");
    private JTextField title = new JTextField();
    private JTextField minRating = new JTextField();
    private JTextField maxRating = new JTextField();
    private JTextField minCalories = new JTextField();
    private JTextField maxCalories = new JTextField();
    private JTextField minProtein = new JTextField();
    private JTextField maxProtein = new JTextField();
    private JTextField minFat = new JTextField();
    private JTextField maxFat = new JTextField();
    private JTextField minSodium = new JTextField();
    private JTextField maxSodium = new JTextField();
    private JTextField minPrice = new JTextField();
    private JTextField maxPrice = new JTextField();
    private JButton titleSearch = new JButton("Search by title");
    private JButton ratingSearch = new JButton("Search by Rating");
    private JButton caloriesSearch = new JButton("Search by Calories");
    private JButton proteinSearch = new JButton("Search by Protein");
    private JButton fatSearch = new JButton("Search by Fat");
    private JButton sodiumSearch = new JButton("Search by Sodium");
    private JButton priceSearch = new JButton("Search by Price");
    private JButton resetSearch = new JButton("Reset Search");
    private JButton submitOrder = new JButton("Submit Order");

    private DeliveryService deliveryService;
    private List<MenuItem> menu = new ArrayList<>();
    private DefaultListModel<String> productsModel = new DefaultListModel<>();
    private JList<String> jList = new JList<>(productsModel);
    private JScrollPane jScrollPane = new JScrollPane(jList);

    public ClientView (DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        showJList(deliveryService.getMenuItems());
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        titleLabel.setBounds(10,20,80,30);
        title.setBounds(90 ,20,200,30);
        menuLabel.setBounds(500,20,200,30);
        titleSearch.setBounds(90,50,200,30);
        ratingLabel.setBounds(10,100,80,30);
        minRating.setBounds(90,100,200,30);
        maxRating.setBounds(90,130,200,30);
        ratingSearch.setBounds(90,160,200,30);
        caloriesLabel.setBounds(10,210,80,30);
        minCalories.setBounds(90,210,200,30);
        maxCalories.setBounds(90,240,200,30);
        caloriesSearch.setBounds(90,270,200,30);
        proteinLabel.setBounds(10,320,80,30);
        minProtein.setBounds(90,320,200,30);
        maxProtein.setBounds(90,350,200,30);
        proteinSearch.setBounds(90,380,200,30);
        fatLabel.setBounds(10,430,80,30);
        minFat.setBounds(90,430,200,30);
        maxFat.setBounds(90,460,200,30);
        fatSearch.setBounds(90,490,200,30);
        sodiumLabel.setBounds(10,540,80,30);
        minSodium.setBounds(90,540,200,30);
        maxSodium.setBounds(90,570,200,30);
        sodiumSearch.setBounds(90,600,200,30);
        priceLabel.setBounds(10,650,80,30);
        minPrice.setBounds(90,650,200,30);
        maxPrice.setBounds(90,680,200,30);
        priceSearch.setBounds(90,710,200,30);
        resetSearch.setBounds(10,770,200,30);
        jScrollPane.setBounds(350, 40, 1100, 700);
        submitOrder.setBounds(350,770,300,30);
        setDefaultTextFields();
        setInvisibleButtons();
        setPanelContent();
        panel.add(jScrollPane);
        panel.setLayout(null);
        panel.setBackground(new Color(204, 255, 255));
        this.setContentPane(panel);
        this.setSize(1500,1000);
        this.setTitle("Client View");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void showJList(List<MenuItem> products){
        productsModel.removeAllElements();
        //setter pt lista de menuItem
        menu.clear();
        menu.addAll(products);
        //afisare JListee
        for( MenuItem i: menu){
            String string = i.getTitle() + "Rating: " + i.getRating() + " Calories: " + i.getCalories()
                    + " Proteins: " + i.getProtein() + " Fats: " + i.getFat() + " Sodium: " + i.getSodium() + " Price: " + i.computePrice();
            //System.out.println(string);
            this.productsModel.addElement(string);
        }

    }

    public List<MenuItem> getSelectedProducts(){
        List<MenuItem > ordered = new ArrayList<>();
        List<String> selectedItems = jList.getSelectedValuesList();

        for( String s: selectedItems){
            String []title = s.split("Rating");
            for(MenuItem m: menu){
                if(m.getTitle().equals(title[0])){
                    ordered.add(m);
                }
            }
        }
        return  ordered;
    }

    private void setDefaultTextFields() {
        title.setText("Title");
        minRating.setText("Min rating");
        maxRating.setText("Max rating");
        minCalories.setText("Min Calories");
        maxCalories.setText("Max Calories");
        minProtein.setText("Min protein");
        maxProtein.setText("Max protein");
        minFat.setText("Min fat");
        maxFat.setText("Max fat");
        minSodium.setText("Min sodium");
        maxSodium.setText("Max sodium");
        minPrice.setText("Min price");
        maxPrice.setText("Max price");
    }

    private void setPanelContent() {
        panel.add(resetSearch);
        panel.add(titleLabel);
        panel.add(title);
        panel.add(ratingLabel);
        panel.add(minRating);
        panel.add(maxRating);
        panel.add(caloriesLabel);
        panel.add(minCalories);
        panel.add(maxCalories);
        panel.add(proteinLabel);
        panel.add(minProtein);
        panel.add(maxProtein);
        panel.add(fatLabel);
        panel.add(minFat);
        panel.add(maxFat);
        panel.add(sodiumLabel);
        panel.add(maxSodium);
        panel.add(minSodium);
        panel.add(priceLabel);
        panel.add(minPrice);
        panel.add(maxPrice);
        panel.add(titleSearch);
        panel.add(ratingSearch);
        panel.add(caloriesSearch);
        panel.add(proteinSearch);
        panel.add(fatSearch);
        panel.add(sodiumSearch);
        panel.add(priceSearch);
        panel.add(submitOrder);
    }

    public void setInvisibleButtons(){
        titleSearch.setContentAreaFilled(false);
        titleSearch.setFocusPainted(false);
        ratingSearch.setContentAreaFilled(false);
        ratingSearch.setFocusPainted(false);
        caloriesSearch.setContentAreaFilled(false);
        caloriesSearch.setFocusPainted(false);
        proteinSearch.setContentAreaFilled(false);
        proteinSearch.setFocusPainted(false);
        sodiumSearch.setContentAreaFilled(false);
        sodiumSearch.setFocusPainted(false);
        fatSearch.setContentAreaFilled(false);
        fatSearch.setFocusPainted(false);
        priceSearch.setContentAreaFilled(false);
        priceSearch.setFocusPainted(false);
        viewProductsBtn.setContentAreaFilled(false);
        viewProductsBtn.setFocusPainted(false);
        resetSearch.setContentAreaFilled(false);
        resetSearch.setFocusPainted(false);
        submitOrder.setContentAreaFilled(false);
        submitOrder.setFocusPainted(false);

    }

    public String getTitlee(){
        return title.getText();
    }

    public double getMinRating(){
        return Double.parseDouble(minRating.getText());
    }

    public double getMaxRating(){
        return Double.parseDouble(maxRating.getText());
    }

    public int getMinCalories(){
        return Integer.parseInt(minCalories.getText());
    }

    public int getMaxCalories(){
        return Integer.parseInt(maxCalories.getText());
    }

    public int getMinProteins(){
        return Integer.parseInt(minProtein.getText());
    }

    public int getMaxProteins(){
        return Integer.parseInt(maxProtein.getText());
    }

    public int getMinFat(){
        return Integer.parseInt(minFat.getText());
    }

    public int getMaxFat(){
        return Integer.parseInt(maxFat.getText());
    }

    public int getMinSodium(){
        return Integer.parseInt(minSodium.getText());
    }

    public int getMaxSodium(){
        return Integer.parseInt(maxSodium.getText());
    }

    public int getMinPrice(){
        return Integer.parseInt(minPrice.getText());
    }

    public int getMaxPrice(){
        return Integer.parseInt(maxPrice.getText());
    }

    public List<MenuItem> getItems() {
        return menu;
    }

    public void addSearchByTitleListener(ActionListener actionListener){
        titleSearch.addActionListener(actionListener);
    }

    public void addSearchByRatingListener(ActionListener actionListener){
        ratingSearch.addActionListener(actionListener);
    }

    public void addSearchByCaloriesListener(ActionListener actionListener){
        caloriesSearch.addActionListener(actionListener);
    }

    public void addSearchByProteinsListener(ActionListener actionListener){
        proteinSearch.addActionListener(actionListener);
    }

    public void addSearchByFatListener(ActionListener actionListener){
        fatSearch.addActionListener(actionListener);
    }

    public void addSearchBySodiumListener(ActionListener actionListener){
        sodiumSearch.addActionListener(actionListener);
    }

    public void addSearchByPriceListener(ActionListener actionListener){
        priceSearch.addActionListener(actionListener);
    }

    public void addResetSearchListener(ActionListener actionListener){
        resetSearch.addActionListener(actionListener);
    }

    public void addSubmitOrderListener(ActionListener actionListener){
        submitOrder.addActionListener(actionListener);
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(panel,message);
    }
}
