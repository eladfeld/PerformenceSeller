package Services;

import Interfaces.IUser;

import java.util.List;
import java.util.Map;

public class User implements IUser{

    private ClientController myClientController;

    public User(ClientController clientController)
    {
        this.myClientController=clientController;
    }

    public int makeOrder(String name, String PhoneNUmber, List<String> seats) {
        boolean ans=myClientController.makeOrder(name,PhoneNUmber,seats);
        System.out.println("yofi yofi");
        return (int)(Math.random() * Integer.MAX_VALUE);
    }

    public boolean cancelOrder(int orderNumber) {
        return true;
    }

    public boolean approveOrder(int orderNumber, int confirmationNumber) {
        return true;
    }
}
