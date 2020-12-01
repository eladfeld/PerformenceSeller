package Services;

import Interfaces.ISeller;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Scanner;


public class Seller implements ISeller {

    public int addNewPerformance(){
        Scanner s = new Scanner(System.in);

        String nameOfPerformance,description, locetion;
        System.out.println("please enter name of performance");
        nameOfPerformance = s.nextLine();
        description = s.nextLine();
        locetion = s.nextLine();

        return setNewPerformence(nameOfPerformance, description, hall, date, locetion, lastDateToPurchase, priec);
    }

    @Override
    public int setNewPerformence(String nameOfPerformence,
                                 String description,
                                 Hall hall,
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
