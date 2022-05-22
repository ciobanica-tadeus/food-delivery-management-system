package PresentationLayer;

import BussinesLayer.DeliveryService;
import DataLayer.Role;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private Register registerPage;
    private DeliveryService deliveryService;

    public RegisterController(Register registerView, DeliveryService deliveryService){
        this.registerPage = registerView;
        this.deliveryService = deliveryService;
        registerPage.addBackListener(new BackFromRegisterToWelcomePage());
        registerPage.addRegisterListener(new CreateAccountListener());
        registerView.setVisible(true);
    }

    class BackFromRegisterToWelcomePage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerPage.setVisible(false);
        }
    }

    class CreateAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = registerPage.getName();
            String address = registerPage.getAddress();
            String username = registerPage.getUsername();
            String password = registerPage.getPassword();
            if (name.length() > 0 && address.length() > 0 && username.length() > 0 && password.length() > 0) {
                deliveryService.addUser(username, password, name, address, Role.CLIENT);
                //deliveryService.addUser("admin","parola","Tadeus","Ciobanica", Role.ADMINISTRATOR);
                //deliveryService.addUser("angajator","parola","Tudor","Strisca", Role.EMPLOYEE);
                //client1: client parola
                //client2: client2 parola
                deliveryService.setNrClients(deliveryService.getNrClients() + 1);
                registerPage.showMessage("Contul a fost creat cu succes! ");
                registerPage.setNameField(null);
                registerPage.setAddressField(null);
                registerPage.setUsernameField(null);
                registerPage.setPasswordField(null);
            } else {
                registerPage.showMessage("Toate campurile trebuie completate");

            }
        }
    }

}
