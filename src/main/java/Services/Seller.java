package Services;

import Interfaces.ISeller;

import java.sql.Time;
import java.time.LocalDate;


public class Seller implements ISeller {

    @Override
    public int setNewPerformence(String nameOfPerformence,
                                 String description,
                                 String hallName,
                                 LocalDate date,
                                 String location,
                                 LocalDate lastDateToPurchase,
                                 int price) {
        if(
                date.isBefore(LocalDate.now())||
                        lastDateToPurchase.isBefore(LocalDate.now()))return -1;
        return (int)(Math.random() * Integer.MAX_VALUE);
    }

    public boolean setHour(int orderNumber, Time newHour) {
        return true;
    }
}
