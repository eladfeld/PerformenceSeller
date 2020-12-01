import Interfaces.IUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class UserTest {
    IUser user;

    @Before
    public void setup(){
        user = Driver.getUser();
    }

    @Test
    public void orderSeetsTest(){
        LinkedList lst = new LinkedList();
        lst.add("23J");
        lst.add("24J");
        lst.add("25J");
        Assert.assertTrue(user.makeOrder("Ido shwarz", "0501112223", lst) > 0);
    }

    @Test
    public void orderSeetsWhenSeetsAreTakenTest(){
        LinkedList lst = new LinkedList();
        lst.add("23J");
        lst.add("24J");
        lst.add("25J");
        Assert.assertFalse(user.makeOrder("Ido shwarz", "0501112223", lst) > 0);
    }

    @Test
    public void orderMadeMoreThenTest(){
        LinkedList lst = new LinkedList();
        lst.add("23J");
        lst.add("24J");
        lst.add("25J");
        user.makeOrder("Ido shwarz", "0501112223", lst);
//        try {
//            wait(60);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Assert.assertFalse(user.approveOrder(123, 123));
    }

    @Test
    public void cancelTest(){
        Assert.assertTrue(user.cancelOrder(123));
    }

}
