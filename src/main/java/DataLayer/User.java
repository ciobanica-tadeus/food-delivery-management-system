package DataLayer;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private int userId;
    private String username;
    private String password;
    private String name;
    private String address;
    private Role role;
    private int nrTimesOrdered;

    /**
     * Contructor cu informatiile despre user
     *
     * @param userId
     * @param username
     * @param password
     * @param name
     * @param address
     * @param role
     */
    public User(int userId, String username, String password, String name, String address, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.role = role;
    }

    public Object getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getNrTimesOrdered() {
        return nrTimesOrdered;
    }

    public void setNrTimesOrdered(int nrTimesOrdered) {
        this.nrTimesOrdered = nrTimesOrdered;
    }

    public String getUserId() {
        return Integer.toString(userId);
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
