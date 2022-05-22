package DataLayer;

import BussinesLayer.MenuItem;
import BussinesLayer.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Bill implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private int nrBill = 0;

    /**
     * Constructorul care creeaza un bill cu datele unei comenzi plasate de catre client
     * @param order
     * @param products
     */
    public Bill(Order order, List<MenuItem> products){
        nrBill++;
        try {
            FileWriter fileWriter = new FileWriter("bill" + nrBill + "_" + order.getOrderID() + ".txt");

            fileWriter.write("Bill nr: " + nrBill + "\n");
            fileWriter.write("OrderID: " + order.getOrderID() + "\n");
            fileWriter.write("Date: " + order.getDate() + "\n");
            fileWriter.write("Client ID: " + order.getUserID() + "\n");
            fileWriter.write("Products ordered: \n");
            for(MenuItem m: products){
                fileWriter.write(" # " + m.getTitle() + " - " + m.computePrice() +" lei\n");
            }
            fileWriter.write("Total price: " + order.getTotalPrice() + " lei\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
