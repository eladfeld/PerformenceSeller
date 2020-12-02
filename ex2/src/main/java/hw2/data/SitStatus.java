package hw2.data;

import java.time.LocalTime;

public class SitStatus {

    private Status status;
    private LocalTime reserveTime;

    public SitStatus(){
        status = Status.FREE;
        reserveTime = null;
    }

    public boolean isFree(){
         if(status == Status.FREE)return true;
         if(this.status == Status.RESERVED && reserveTime.isBefore(LocalTime.now().minusHours(1))){
             this.status = Status.FREE;
             this.reserveTime = null;
             return true;
         }
         return false;
    }
    public boolean isReseved(){
        return status == Status.RESERVED;
    }

    public boolean ReserveSit(){
        if(this.status == Status.TAKEN)return false;
        if(this.status == Status.RESERVED && reserveTime.isAfter(LocalTime.now().minusHours(1)))
            return false;
        reserveTime = LocalTime.now();
        return true;
    }

    public boolean TakeSit(){
        if(this.status != Status.TAKEN){
            status = Status.TAKEN;
            return true;
        }
        return false;
    }


}
