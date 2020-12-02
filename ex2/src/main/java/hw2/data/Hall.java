package hw2.data;

public class Hall {

    private String city;
    private String name;
    private int numberOfSits;

    public Hall(String city, String name, int numberOfSits){
        this.city = city;
        this.name = name;
        this.numberOfSits = numberOfSits;
    }

    public int getNumberOfSits() {
        return numberOfSits;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
