package Interfaces;

import java.util.List;

public interface IUser {
    int makeOrder(String name, String PhoneNUmber, List<String> seats);

    boolean cancelOrder(int orderNumber);

    boolean approveOrder(int orderNumber, int confirmationNumber);

}
