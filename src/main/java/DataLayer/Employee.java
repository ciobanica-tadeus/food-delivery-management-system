package DataLayer;

import DataLayer.Role;

public class Employee extends User {
    public Employee(int userId,String username, String password, String name, String address) {
        super(userId,username, password, name, address,Role.EMPLOYEE);
    }
}
