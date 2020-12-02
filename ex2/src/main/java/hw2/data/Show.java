package hw2.data;

import java.util.HashMap;
import java.util.Map;

public class Show {

    private int showID;
    private User adminCreator;
    private Hall hall;
    private ShowInfo showInfo;
    private HashMap<Integer, SitStatus> sits;

    public Show(int showID, User adminCreator, Hall hall, ShowInfo showInfo){
        this.showID = showID;
        this.adminCreator =adminCreator;
        this.hall = hall;
        this.showInfo = showInfo;
        this.sits = new HashMap<>();
        initSits(this.hall.getNumberOfSits());
    }

    public ShowInfo getShowInfo(){
        return showInfo;
    }

    private void initSits(int numberOfSits){
        for(int i = 1; i <= numberOfSits; i++)
            sits.put(i, new SitStatus());
    }

    public boolean areSitsAvailable(int from, int to){
        boolean result = true;
        for(Integer i = from; result & i <= to; i++){
            result = sits.get(i).isFree();
        }
        return result;
    }

    public boolean reserveSits(int from, int to){
        boolean result = true;
        for(Integer i = from; result & i <= to; i++){
            result = sits.get(i).ReserveSit();
        }
        return result;
    }

    public boolean takeSits(int[] sits) {
        boolean result = true;
        for (int i = 0; result & i < sits.length; i++)
            result = this.sits.get(sits[i]).TakeSit();
        return result;
    }
}
