package DataLayer;

public class Administrator extends User {
    public Administrator(int userId,String username, String password, String name, String address) {
        super(userId,username, password, name, address,Role.ADMINISTRATOR);
    }
}
