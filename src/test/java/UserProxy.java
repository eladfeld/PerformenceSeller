import Interfaces.IUser;
import Services.User;

import java.util.List;

public class UserProxy implements IUser {
    private User real;

    public void setReal(User real) {
        this.real = real;
    }

    @Override
    public int makeOrder(String name, String PhoneNUmber, List<String> seats) {
        if(real == null)return -1;
        return real.makeOrder(name, PhoneNUmber, seats);
    }

    @Override
    public boolean cancelOrder(int orderNumber) {
        if(real == null)return false;
        return real.cancelOrder(orderNumber);
    }

    @Override
    public boolean approveOrder(int orderNumber, int confirmationNumber) {
        if(real == null)return false;
        return real.approveOrder(orderNumber, confirmationNumber);
    }
}
