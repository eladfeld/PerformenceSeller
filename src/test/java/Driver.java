import Interfaces.ISeller;
import Interfaces.IUser;

public class Driver {
    public static IUser getUser(){
        UserProxy proxy = new UserProxy();
        // Uncomment when real application is ready
        // proxy.setReal(new User());
        return proxy;
    }

    public static ISeller getSeller(){
        SellerProxy proxy = new SellerProxy();
        // Uncomment when real application is ready
        // proxy.setReal(new Seller());
        return proxy;
    }
}
