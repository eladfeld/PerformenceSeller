import Interfaces.ISeller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.sql.Time;
import java.time.LocalDate;


public class SellerTest {
    ISeller seller;

    @Before
    public void setSeller() {
        seller = Driver.getSeller();
    }

    @Test
    public void setNewPerformenceTest1(){
        Assert.assertTrue(seller.setNewPerformence("you", "drama", "atarbut",
                LocalDate.now().plusDays(14), "haifa", LocalDate.now().plusDays(7) ,100 ) > 0);
    }
    @Test
    public void setNewPerformenceTest2(){
        Assert.assertTrue(seller.setNewPerformence("you", "drama", "atarbut",
                LocalDate.now().minusDays(14), "haifa", LocalDate.now().plusDays(7), 100  ) > 0);
    }

    @Before
    public void addPerformnce(){
        seller.setNewPerformence("zoe101", "kids", "abima",
                LocalDate.now().plusDays(4), "afula", LocalDate.now().plusDays(1), 100);
    }

    @Test
    public void DoublePerformence(){
        Assert.assertTrue(seller.setNewPerformence("artur", "drama", "abima",
                LocalDate.now().plusDays(4), "afula", LocalDate.now().plusDays(1), 100) > 0);
    }

    @Test
    public void purchaseDateTest(){
        Assert.assertFalse(seller.setNewPerformence("artur", "drama", "abima",
                LocalDate.now().plusDays(4), "afula", LocalDate.now().minusDays(1), 100) < 0);
    }

    @Test
    public void changeHour(){
        Assert.assertTrue(seller.setHour(1123, Time.valueOf("13:22")));
    }



}
