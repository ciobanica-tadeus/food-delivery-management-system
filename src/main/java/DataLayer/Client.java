package DataLayer;

import DataLayer.Role;

public class Client extends User {
    public Client( int userId, String username, String password, String name, String address) {
        super(userId,username, password, name, address,Role.CLIENT);
    }
}
