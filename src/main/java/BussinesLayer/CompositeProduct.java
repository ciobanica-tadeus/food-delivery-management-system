package BussinesLayer;

import java.io.Serializable;
import java.util.ArrayList;

public class CompositeProduct implements MenuItem, Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String title;
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int nrTimesOrdered;
    private ArrayList<BaseProduct> baseProductsList;

    /**
     * Constructor Composite product cu parametrii corespunzatori: titlu si lista de baseProducts
     *
     * @param title
     * @param productList
     */
    public CompositeProduct(String title, ArrayList<BaseProduct> productList) {
        this.title = title;
        this.baseProductsList = productList;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public double getRating() {
        double aux = 0;
        for (BaseProduct base : baseProductsList) {
            aux += base.getRating();
        }
        return aux / (double) baseProductsList.size();
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int getCalories() {
        int aux = 0;
        for (BaseProduct base : baseProductsList) {
            aux += base.getCalories();
        }
        return aux;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public int getProtein() {
        int aux = 0;
        for (BaseProduct base : baseProductsList) {
            aux += base.getProtein();
        }
        return aux;
    }

    @Override
    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public int getFat() {
        int aux = 0;
        for (BaseProduct base : baseProductsList) {
            aux += base.getFat();
        }
        return aux;
    }

    @Override
    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public int getSodium() {
        int aux = 0;
        for (BaseProduct base : baseProductsList) {
            aux += base.getSodium();
        }
        return aux;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getNrTimesOrdered() {
        return nrTimesOrdered;
    }

    @Override
    public void setNrTimesOrdered(int nrTimesOrdered) {
        this.nrTimesOrdered = nrTimesOrdered;
    }

    @Override
    public int computePrice() {
        for (BaseProduct baseProduct : baseProductsList) {
            price += baseProduct.computePrice();
        }
        return price;
    }

    public ArrayList<BaseProduct> getBaseProductsList() {
        return baseProductsList;
    }

    public void setBaseProductsList(ArrayList<BaseProduct> baseProductsList) {
        this.baseProductsList = baseProductsList;
    }
}
