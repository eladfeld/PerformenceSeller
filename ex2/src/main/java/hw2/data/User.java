package hw2.data;

public class User {
    private String city;
    private String name;
    private String pass;

    public User(String city, String name, String pass) {
        this.city = city;
        this.name = name;
        this.pass = pass;
    }

    public boolean isUser(String name, String pass){
        return(this.name.equals(name) & this.pass.equals(pass));
    }

    public String getCity() {
        return city;
    }
}
