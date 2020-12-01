import Interfaces.ISeller;
import Services.Seller;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;

public class SellerProxy implements ISeller {
    private Seller real;

    public void setReal(Seller real) {
        this.real = real;
    }


    @Override
    public int setNewPerformence(String nameOfPerformence,
                                 String description,
                                 String hallName,
                                 LocalDate date,
                                 String location,
                                 LocalDate lastDateToPurchase,
                                 int price) {
        if (real == null) return -1;
        else
            return real.setNewPerformence(nameOfPerformence, description, hallName, date, location, lastDateToPurchase, price);
    }

    @Override
    public boolean setHour(int orderNumber, Time newHour) {
        if (real == null) return false;
        else return real.setHour(orderNumber, newHour);
    }
}
