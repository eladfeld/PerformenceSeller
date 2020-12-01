package Interfaces;

import Services.Hall;

import java.sql.Time;
import java.time.LocalDate;

public interface ISeller {
    int setNewPerformence(String nameOfPerformence,
                          String description,
                          Hall hall,
                          LocalDate date,
                          String location,
                          LocalDate lastDateToPurchase,
                          int price);

    boolean setHour(int orderNumber, Time newHour);

}
