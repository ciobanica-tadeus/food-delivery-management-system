package BussinesLayer;

import DataLayer.Bill;
import DataLayer.Role;
import DataLayer.Serializator;
import DataLayer.User;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Map<Order, ArrayList<MenuItem>> ordersInfo = new HashMap<>();
    private List<MenuItem> menuItems = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Serializator serialiation = new Serializator();
    private int nrClients;
    private int nrProducts;
    private int nrOrders;

    public DeliveryService() {

    }

    public int getNrClients() {
        return nrClients;
    }

    public void setNrClients(int nrClients) {
        this.nrClients = nrClients;
    }

    public int getNrProducts() {
        return nrProducts;
    }

    public void setNrProducts(int nrProducts) {
        this.nrProducts = nrProducts;
    }

    public int getNrOrders() {
        return nrOrders;
    }

    public void setNrOrders(int nrOrders) {
        this.nrOrders = nrOrders;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Metoda care creaza un user din fereastra de register. Se poate inregistra doar ca utilizator "CLIENT"
     * Returneaza true daca s-a inregistrat cu succes,altfel false
     *
     * @param username
     * @param password
     * @param name
     * @param address
     * @param role
     * @precondition Verificare date corecte cu metoda wellFormed si verificarea datelor inserate de catre utilizator
     * @postcondition Verificare date corecte cu metoda wellFormed
     * @return
     */
    public Boolean addUser(String username, String password, String name, String address, Role role) {
        assert wellFormed();
        assert username.equals("") || password.equals("") || name.equals("") || address.equals(""): "Can't add a user without username,password,address and name";
        if (users.stream().anyMatch(e -> e.getUsername().equals(username))) {
            return false;
        }
        nrClients++;
        users.add(new User(nrClients, username, password, name, address, role));
        assert wellFormed();
        return true;
    }

    /**
     * Metoda care cauta daca exista un user cu o parola si un username introdus de catre utilizator
     *
     * @param username
     * @param password
     * @return
     */
    public Boolean findUser(String username, String password) {
        return users.stream().anyMatch(e -> e.getUsername().equals(username) && e.getPassword().equals(password));
    }

    /**
     * Metoda care afla rolul utilizatorului la logarea acestuia
     *
     * @param username
     * @param password
     * @return
     */
    public Role findUserRole(String username, String password) {
        List<User> find = users.stream().filter(e -> e.getUsername().equals(username) && e.getPassword().equals(password)).collect(Collectors.toList());
        if (find.size() > 0) {
            return find.get(0).getRole();
        } else {
            return null;
        }
    }

    /**
     * Metoda care importa produse din fisierul .csv si sunt adaugate in lista de MenuItems
     *
     */
    @Override
    public void importProducts() {
        var filePath = System.getProperty("user.dir") + "\\products.csv";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            List<String> lines;
            lines = bufferedReader.lines().skip(1).collect(Collectors.toList());
            lines = lines.stream().distinct().collect(Collectors.toList());

            for (String it : lines) {
                String[] p = it.split(",");
                List<MenuItem> items = menuItems.stream().filter(e -> e.getTitle().equals(p[0])).collect(Collectors.toList());
                if (items.size() == 0) {
                    MenuItem product = new BaseProduct(p[0],
                            Double.parseDouble(p[1]),
                            Integer.parseInt(p[2]),
                            Integer.parseInt(p[3]),
                            Integer.parseInt(p[4]),
                            Integer.parseInt(p[5]),
                            Integer.parseInt(p[6]));
                    menuItems.add(product);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        menuItems.removeIf(Objects::isNull);
    }

    /**
     * Metoda care adauga un produs de tipul BaseProduct
     *
     * @param name
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @precondition Verificare date cu metoda wellFormed() si verificarea corectitudinii datelor introduse de catre utilizator
     * @postcondition Verificare date cu metoda wellFormed()
     * @return true - produs adaugat cu succes; false - altfel
     */
    @Override
    public Boolean addProduct(String name, double rating, int calories, int protein, int fat, int sodium, int price) {
        assert wellFormed();
        assert name.equals("") || rating < 0 || calories < 0 || protein < 0 || fat < 0 || sodium < 0 || price < 0 : "Can't create product with negative fields";
        List<MenuItem> menu = menuItems.stream().filter(e -> e.getTitle().equals(name)).collect(Collectors.toList());
        if (!(menu.size() == 0)) {
            return false;
        }
        nrProducts++;
        menuItems.add(new BaseProduct(name, rating, calories, protein, fat, sodium, price));
        assert wellFormed();
        return true;
    }

    /**
     * Metoda care modifica un produs de tipul BaseProduct
     *
     * @param name
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @precondition Verificare date cu metoda wellFormed() si verificarea datelor introduse de catre utilizator
     * @postcondition Verificare date cu metoda wellFormed()
     * @return
     */
    @Override
    public Boolean modifyProduct(String name, double rating, int calories, int protein, int fat, int sodium, int price) {
        assert wellFormed();
        assert name.equals("") || rating < 0 || calories < 0 || protein < 0 || fat < 0 || sodium < 0 || price < 0 : "Can't modify product with negative fields";
        List<MenuItem> menu = menuItems.stream().filter(e -> e.getTitle().equals(name)).collect(Collectors.toList());
        if (menu.size() == 0) {
            return false;
        }
        menu.get(0).setTitle(name);
        menu.get(0).setRating(rating);
        menu.get(0).setCalories(calories);
        menu.get(0).setFat(fat);
        menu.get(0).setSodium(sodium);
        menu.get(0).setPrice(price);
        assert wellFormed();
        return true;

    }

    /**
     * Metoda care sterge un produs din lista de MenuItem dupa introducerea numelui
     *
     * @param name
     * @precondition Verificare date cu metoda wellFormed() si verificarea numelui introdus de catre utilizator
     * @postcondition Verificare date cu metoda wellFormed()
     * @return
     */
    @Override
    public Boolean deleteProduct(String name) {
        assert wellFormed();
        assert name.equals("") : "Can't delete product with noName";
        List<MenuItem> menu = menuItems.stream().filter(e -> e.getTitle().equals(name)).collect(Collectors.toList());
        if (menu.size() == 0) {
            return false;
        }
        menuItems.remove(menu.get(0));
        menuItems.removeIf(it -> it.getTitle().equals(menu.get(0).getTitle()));
        assert wellFormed();
        return true;
    }

    /**
     * Metoda care cauta in lista de produse din clientView dupa un substring.
     *
     * @param menu
     * @param title
     * @precondition Verificare numelui introdus de catre utilizator
     * @return O lista de produse care contine string-ul in numele produselui
     */
    @Override
    public List<MenuItem> searchProductsByTitle(List<MenuItem> menu, String title) {
        assert title.equals("") : "Can't searchByTitle without title";
        List<MenuItem> searchList = menu.stream().filter(product -> product.getTitle().contains(title)).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de produse care are ratingul intre cele doua valori introduse de catre utilizator
     *
     * @param menu
     * @param minRating
     * @param maxRating
     * @precondition Verificare ca ratingul introdus de catre utilizator sa fie pozitive si sa fie minRating < maxRating
     * @return
     */
    @Override
    public List<MenuItem> searchProductsByRating(List<MenuItem> menu, double minRating, double maxRating) {
        assert minRating < 0 || maxRating < 0 || minRating > maxRating : "Can't searchByRating with negative values";
        List<MenuItem> searchList = menu.stream().filter(r -> r.getRating() >= minRating).filter(r -> r.getRating() <= maxRating).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de produse care are valoarea caloriilor intre cele doua valori introduse de catre utilizator
     *
     * @param menu
     * @param minCalories
     * @param maxCalories
     * @precondition Verificarea corectitudinii datelor introduse de catre utilizator
     * @return
     */
    @Override
    public List<MenuItem> searchProductsByCalories(List<MenuItem> menu, int minCalories, int maxCalories) {
        assert minCalories < 0 || maxCalories < 0 || minCalories > maxCalories: "Can't searchByCalories with negative values";
        /*List<MenuItem> newList = new ArrayList<>();
        newList.addAll(menu);*/
        List<MenuItem> searchList = menu.stream().filter(r -> r.getCalories() >= minCalories).filter(r -> r.getCalories() <= maxCalories).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de produse care are valoarea proteinelor intre cele doua valori introduse de catre utilizator
     *
     * @param menu
     * @param minProtein
     * @param maxProtein
     * @precondition Verificare corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<MenuItem> searchProductsByProteins(List<MenuItem> menu, int minProtein, int maxProtein) {
        assert minProtein < 0 || maxProtein < 0 || minProtein > maxProtein : "Can't searchByProtein with negative values";
        List<MenuItem> searchList = menu.stream().filter(r -> r.getProtein() >= minProtein).filter(r -> r.getProtein() <= maxProtein).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de produse care are valoarea grasimilor intre cele doua valori introduse de catre utilizator
     * @param menu
     * @param minFat
     * @param maxFat
     * @precondition Verificarea corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<MenuItem> searchProductsByFat(List<MenuItem> menu, int minFat, int maxFat) {
        assert minFat < 0 || maxFat < 0 || minFat > maxFat : "Can't searchByFat with negative values";
        List<MenuItem> searchList = menu.stream().filter(r -> r.getFat() >= minFat).filter(r -> r.getFat() <= maxFat).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de produse care are valoarea de sare intre cele doua valori introduse de catre utilizator
     *
     * @param menu
     * @param minSodium
     * @param maxSodium
     * @precondition Verificarea corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<MenuItem> searchProductsBySodium(List<MenuItem> menu, int minSodium, int maxSodium) {
        assert minSodium < 0 || maxSodium < 0 || minSodium > maxSodium : "Can't searchBySodium with negative values";
        List<MenuItem> searchList = menu.stream().filter(r -> r.getSodium() >= minSodium).filter(r -> r.getSodium() <= maxSodium).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de produse care are pretul intre cele doua valori introduse de catre utilizator
     * @param menu
     * @param minPrice
     * @param maxPrice
     * @precondition Verificarea corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<MenuItem> searchProductsByPrice(List<MenuItem> menu, int minPrice, int maxPrice) {
        assert minPrice < 0 || maxPrice < 0 || minPrice > maxPrice : "Can't searchByPrice with negative values";
        List<MenuItem> searchList = menu.stream().filter(r -> r.computePrice() >= minPrice).filter(r -> r.computePrice() <= maxPrice).collect(Collectors.toList());
        return searchList;
    }

    /**
     * Metoda care returneaza o lista de comenzi care au fost comandate intre cele doua ore introduse de catre utilizator
     * @param startHour
     * @param endHour
     * @precondition Verificarea corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<Order> generateReport1(int startHour, int endHour) {
        assert startHour < 0 || endHour < 0|| startHour > endHour: "Invalid data for generating first report";
        Map<Order, ArrayList<MenuItem>> result = ordersInfo.entrySet().stream().filter(map -> map.getKey().getDate().getHours() >= startHour).
                filter(map -> map.getKey().getDate().getHours() <= endHour).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        List<Order> ordersResult = new ArrayList<>(result.keySet());
        return ordersResult;
    }

    /**
     * Metoda care returneaza o lista de produse care au fost comandate de mai multe ori decat o valoare introdusa de catre utilizator
     * @param nrTimesOrdered
     * @precondition Verificarea corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<MenuItem> generateReport2(int nrTimesOrdered) {
        assert nrTimesOrdered <0 :"Invalid data for generating second report";
        List<MenuItem> result = menuItems.stream().filter(p -> p.getNrTimesOrdered() >= nrTimesOrdered).collect(Collectors.toList());
        return result;
    }

    /**
     * Metoda care returneaza o lista de useri care au comandat de mai multe ori decat valoarea introdusa de catre utilizator
     * si au comandat de o suma mai mare decat cea introdusa de catre utilizator
     *
     * @param nrTimesOrdered
     * @param amount
     * @precondition Verificarea corectitudinii introduse de catre utilizator
     * @return
     */
    @Override
    public List<User> generateReport3(int nrTimesOrdered, int amount) {
        assert nrTimesOrdered < 0 || amount < 0: "Invalid data for generating third search report";
        List<User> result = users.stream().filter(p -> p.getRole() == Role.CLIENT).filter(p -> p.getNrTimesOrdered() >= nrTimesOrdered).collect(Collectors.toList());
        List<User> finalResultList = new ArrayList<>();

        for (User u : result) {
            Map<Order, ArrayList<MenuItem>> search = ordersInfo.entrySet().stream().filter(e -> Objects.equals(e.getKey().getUserID(), u.getUserId())).
                    filter(e -> e.getKey().getTotalPrice() >= amount).collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
            if (search.size() > 0) {
                finalResultList.add(u);

            }
        }
        return finalResultList;
    }

    /**
     * Metoda care returneaza o lista de produse care au fost comandate intr-o zi introdusa de catre utilizator
     * Poate introduce valori intre 0 si 6: 0-Duminica
     *                                      ....6-Sambata
     * @param day
     * @precondition day < 0
     * @return
     */
    @Override
    public List<MenuItem> generateReport4(int day) {
        assert day < 0 : "Invalid data for generating fourth report";
        Map<Order, ArrayList<MenuItem>> resultOrders = ordersInfo.entrySet().stream().filter(e -> e.getKey().getDate().getDay() == day)
                .collect(Collectors.toMap(e-> e.getKey(), e-> e.getValue()));
        List<MenuItem> finalResult = new ArrayList<>();
        for(Order o : resultOrders.keySet()){
            finalResult.addAll(resultOrders.get(o));
        }
        finalResult = finalResult.stream().distinct().collect(Collectors.toList());
        return finalResult;
    }

    /**
     * Metoda care creeaza un produs compus din mai multe produse simple
     * @param name
     * @param baseProductList
     * @precondition wellFormed(), name.equals(""), baseProductList.size() == 0
     * @postcondition wellFormed(), size == menuItems.size() - 1
     * @return
     */
    @Override
    public Boolean createComposite(String name, ArrayList<BaseProduct> baseProductList) {
        assert wellFormed();
        assert name.equals("") : "Can't create a composite product without name";
        assert baseProductList.size() == 0 : "Can't create a composite product without at least 1 base product";
        int size = menuItems.size();
        menuItems.add(new CompositeProduct(name, baseProductList));
        nrProducts++;
        assert wellFormed();
        assert size == menuItems.size() - 1 : "The createComposite method did not performed as expected";
        return true;
    }

    /**
     * Metoda care creaza o comanda
     *
     * @param userName
     * @param productsList
     * @precondition wellFormed(), userName.equals(""), productsList.size() == 0
     * @postcondition wellFormed(), ordersInfo.size() != size
     */
    @Override
    public void createOrder(String userName, List<MenuItem> productsList) {
        assert wellFormed() : "There is data that may be corrupted before createOrder operation";
        assert userName.equals("") : "Can't create an order without a user";
        assert productsList.size() == 0 : "Can't create an order without at least 1 product";
        int size = ordersInfo.size();
        ArrayList<MenuItem> orderedItems = new ArrayList<>(productsList);
        //cautam userul pentru a creste numarul de comenzi plasate
        User toFind = users.stream().filter(u -> u.getUsername().equals(userName)).collect(Collectors.toList()).get(0);
        toFind.setNrTimesOrdered(toFind.getNrTimesOrdered() + 1);
        Order order = new Order(++nrOrders, toFind.getUserId(), Calendar.getInstance().getTime());
        ordersInfo.put(order, orderedItems);
        ///formare string despre produsele comandate
        StringBuilder productsCurrentOrders = new StringBuilder();
        for (MenuItem it : orderedItems) {
            order.setTotalPrice(order.getTotalPrice() + it.computePrice());
            it.setNrTimesOrdered(it.getNrTimesOrdered() + 1);
            productsCurrentOrders.append(" ").append(it.getTitle());
        }
        //notificare employee
        setChanged();
        notifyObservers("\nOrder with ID: " + order.getOrderID() + "\n" + productsCurrentOrders);
        //creare bill
        new Bill(order, orderedItems);
        assert wellFormed() : "There is data that may be corrupted before createOrder operation";
        assert ordersInfo.size() != size : "The createOrder method did not performed as expected";
    }

    /**
     * Metoda care verifica daca datele comenzilor, a produselor si cele ale userilor sunt corecte.
     *
     * @return
     */
    private Boolean wellFormed() {
        for (Order i : ordersInfo.keySet()) {
            if (i.getUserID().equals("") || i.getOrderID() < 0) {
                return false;
            }
        }
        for (MenuItem i : menuItems)
            if (i.computePrice() < 0 || i.getCalories() < 0 || i.getProtein() < 0 || i.getSodium() < 0 || i.getFat() < 0 || i.getRating() < 0) {
                return false;
            }
        for (User i : users) {
            if (i.getName().equals("") || i.getAddress().equals("") || i.getPassword().equals("") || i.getUsername().equals(""))
                return false;
        }
        return true;

    }

    /**
     * Metoda care returneaza un produs dupa numele acestuia
     *
     * @param name
     * @return
     */
    public MenuItem getProduct(String name) {
        return menuItems.stream().filter(e -> e.getTitle().equals(name)).collect(Collectors.toList()).get(0);
    }

}
