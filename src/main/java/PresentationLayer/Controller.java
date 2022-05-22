package PresentationLayer;

import BussinesLayer.DeliveryService;
import DataLayer.Role;
import DataLayer.Serializator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller {
    private Welcome welcomePage;
    private DeliveryService deliveryService;

    public Controller(Welcome welcome) {
        welcomePage = welcome;
        Serializator serialization = new Serializator();
        deliveryService = serialization.deserializare("dataSerialization.txt");
        welcomePage.addRegisterListener(new RegisterListener());
        welcomePage.addLogInListener(new LogInButtonListener());
        welcomePage.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                serialization.serializare(deliveryService, "dataSerialization.txt");
            }
        });
    }

    class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RegisterController(new Register(),deliveryService);
        }

    }

    class LogInButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new LogInController(new LogIn(),deliveryService);
        }

    }
}
