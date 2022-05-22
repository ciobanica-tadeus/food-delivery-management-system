package PresentationLayer;

import DataLayer.Employee;

import java.util.Observable;
import java.util.Observer;

public class EmployeeController implements Observer {
    private EmployeeView employeeView;

    public EmployeeController(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    @Override
    public void update(Observable o, Object arg) {
        String order = (String) arg;
        employeeView.addWaitingOrders(order);
    }
}
