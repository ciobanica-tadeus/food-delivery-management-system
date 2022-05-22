package DataLayer;

import BussinesLayer.DeliveryService;
import java.io.*;

public class Serializator implements Serializable {


    public Serializator(){

    }

    /**
     * Metoda care face serializarea datelor in fisierul cu numele primit ca si parametru
     * @param deliveryService
     * @param name
     */
    public void serializare(DeliveryService deliveryService, String name){
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutput write = new ObjectOutputStream(file);

            write.writeObject(deliveryService);
            write.close();
            file.close();
            System.out.println("Object has been serialized");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metoda care face deserializarea datelor din fisierul primit ca si parametru
     * @param name
     * @return
     */
    public DeliveryService deserializare(String name ){
        DeliveryService newDeliveryService = null;
        try {
            FileInputStream file = new FileInputStream(name);
            if(file.getChannel().size() != 0){
                ObjectInputStream read = new ObjectInputStream(file);
                newDeliveryService = (DeliveryService) read.readObject();
                read.close();
                file.close();
                System.out.println("Object has been deserialized");
            }else{
                newDeliveryService = new DeliveryService();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newDeliveryService;
    }
}
