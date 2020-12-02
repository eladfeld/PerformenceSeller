package hw2.data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Bridge implements hw2.bridge.Bridge {

    private HashMap<String, List<Hall>> cities;
    private List<User> admins;
    private HashMap<Integer, Show> shows;
    private HashMap<Integer, List<OrderInfo>> waitings;
    private int lastShowId;
    private int lastOrderId;

    public Bridge() {
        lastShowId = 1;
        lastOrderId = 1;
        cities = new HashMap<>();
        admins = new LinkedList<>();
        shows = new HashMap<>();
        waitings = new HashMap<>();
    }

    @Override
    public void addCity(String city) {
        if (city != null)
            cities.put(city, new LinkedList<>());
    }

    @Override
    public void addHall(String city, String hall, int sits) {
        if (city == null | hall == null) return;
        Hall hallToAdd = new Hall(city, hall, sits);
        List<Hall> halls = cities.get(city);
        if (halls == null) return;
        halls.add(hallToAdd);
    }

    @Override
    public void addAdmin(String city, String user, String pass) {
        if (city == null | user == null | pass == null) return;
        User adminToAdd = new User(city, user, pass);
        admins.add(adminToAdd);
    }

    @Override
    public int addNewShow(String user, String pass, ShowInfo showInfo) {
        if (user == null | pass == null | showInfo.city == null | showInfo.hall == null | showInfo.description == null | showInfo.name == null |
                showInfo.showTime == null | showInfo.userstoinform == null)
            for (User admin : admins) {
                if (admin.isUser(user, pass)) {
                    List<Hall> halls = cities.get(admin.getCity());
                    if (halls == null) return 0;
                    for (Hall hall : halls) {
                        if (hall.getName().equals(showInfo.hall)
                                & hall.getCity().equals(showInfo.city)
                                & showInfo.lastOrderDate < showInfo.showDate) {
                            shows.put(lastShowId, new Show(lastShowId, admin, hall, showInfo));
                            return lastShowId++;
                        }
                    }
                }
            }
        return 0;
    }

    @Override
    public void reserveMemberChairs(int showID, int from, int to) {
        Show show = shows.get(showID);
        if (show == null) return;
        if (show.areSitsAvailable(from, to)) {
            show.reserveSits(from, to);
        }
    }


    @Override
    public int newOrder(OrderInfo order) {
        if (order.name == null ||
                order.memberId == null ||
                order.chairsIds == null ||
                order.phone == null ||
                order.chairsIds.length == 0 |
                        order.name.equals("") ||
                order.phone.equals("") ||
                !shows.containsKey(order.showId)
        ) return 0;
        Show show = shows.get(order.showId);
        if (show == null ||
                Instant.ofEpochMilli(show.getShowInfo().lastOrderDate).atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now())
        ) return 0;
        show.takeSits(order.chairsIds);
        List<OrderInfo> orders = waitings.get(order.showId);
        if (orders == null) waitings.put(order.showId, new LinkedList<>());
        if (!isUserWaiting(order.name, waitings.get(order.showId))) waitings.get(order.showId).add(order);
        return lastOrderId++;
    }

    private boolean isUserWaiting(String user, List<OrderInfo> orders) {
        for (OrderInfo order : orders)
            if (order.name.equals(user)) return true;
        return false;
    }

    @Override
    public List<OrderInfo> getWaitings(int showId) {
        return waitings.get(showId);
    }
}
