package BussinesLayer;

import java.io.Serializable;

public class BaseProduct implements MenuItem, Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String title;
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int nrTimesOrdered;

    /**
     * Instantiaza un obiect de tipul BaseProduct cu variabilele instanta corespunzatoare
     *
     * @param title
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     */
    public BaseProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
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
        return rating;
    }

    @Override
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public int getFat() {
        return fat;
    }

    @Override
    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public int getSodium() {
        return sodium;
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
    public int getProtein() {
        return protein;
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
        return price;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        BaseProduct baseProduct = (BaseProduct) obj;
        return !baseProduct.getTitle().equals(this.title);
    }
}
