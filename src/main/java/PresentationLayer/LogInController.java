package PresentationLayer;

import BussinesLayer.DeliveryService;
import DataLayer.Employee;
import DataLayer.Role;
import DataLayer.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController {
    private LogIn logInView;
    private DeliveryService deliveryService;

    public LogInController(LogIn logInView, DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        this.logInView = logInView;
        logInView.addBackListener(new BackFromLogInToWelcomePage());
        logInView.addLogInListener(new LogInListener());
        logInView.setVisible(true);
    }

    class LogInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = logInView.getUsername();
            String password = logInView.getPassword();
            if (!username.equals("") && !password.equals("")) {
                if (!deliveryService.findUser(username, password)) {
                    logInView.showMessage("User inexistent");
                } else {
                    Role role = deliveryService.findUserRole(username, password);
                    logInView.setUsernameField(null);
                    logInView.setPasswordField(null);
                    logInView.setVisible(false);
                    if (role == Role.ADMINISTRATOR) {
                        new AdminController(new AdminView(deliveryService), deliveryService);

                    } else if (role == Role.CLIENT) {
                            new ClientController(new ClientView(deliveryService), deliveryService, username);
                        }
                        else if(role == Role.EMPLOYEE){
                            deliveryService.addObserver(new EmployeeController(new EmployeeView()));
                    }
                }
            } else {
                logInView.showMessage("Completati campurile pentru logare");
            }
        }
    }

    class BackFromLogInToWelcomePage implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logInView.setVisible(false);
        }

    }
}
