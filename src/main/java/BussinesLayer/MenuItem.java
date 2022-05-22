package BussinesLayer;

public interface MenuItem {

    int computePrice();

    String toString();

    double getRating();

    int getCalories();

    int getProtein();

    int getSodium();

    int getFat();

    public int getNrTimesOrdered();

    public void setNrTimesOrdered(int nrTimesOrdered);

    String getTitle();

    public void setTitle(String title);

    public void setRating(double rating);

    public void setCalories(int calories);

    public void setProtein(int protein);

    public void setFat(int fat);

    public void setSodium(int sodium);

    public void setPrice(int price);

}
