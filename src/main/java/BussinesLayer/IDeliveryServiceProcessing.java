package BussinesLayer;

import DataLayer.User;

import java.util.ArrayList;
import java.util.List;

public interface IDeliveryServiceProcessing {

    /**
     * ADMIN OPERATIONS
     */
    void importProducts();
    Boolean addProduct(String name, double rating, int calories, int protein, int fat, int sodium , int price);
    Boolean modifyProduct(String name, double rating, int calories,int protein,int fat, int sodium,int price);
    Boolean deleteProduct(String name);
    Boolean createComposite(String name, ArrayList<BaseProduct> baseProductList);
    List<Order> generateReport1(int startHour, int endHour);
    List<MenuItem> generateReport2(int nrTimesOrdered);
    List<User> generateReport3(int nrTimesOrdered, int amount);
    List<MenuItem> generateReport4(int day);
    /**
     * CLIENT OPERATIONS
     */
    List<MenuItem> searchProductsByTitle(List<MenuItem> menu,String title);
    List<MenuItem> searchProductsByRating(List<MenuItem>menu,double minRating, double maxRating);
    List<MenuItem> searchProductsByCalories(List<MenuItem> menu,int minCalories, int maxCalories);
    List<MenuItem> searchProductsByProteins(List<MenuItem> menu,int minProtein, int maxProtein);
    List<MenuItem> searchProductsByFat(List<MenuItem> menu,int minFat, int maxFat);
    List<MenuItem> searchProductsBySodium(List<MenuItem> menu,int minSodium, int maxSodium);
    List<MenuItem> searchProductsByPrice(List<MenuItem> menu,int minPrice, int maxPrice);
    void createOrder(String user,List<MenuItem> productsList);

}
