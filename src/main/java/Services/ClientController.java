package Services;

import java.util.List;

public class ClientController {
    private PerformancesController ctrl_performance;
    private HallController ctrl_hall;


    public void ClientController()
    {
        this.ctrl_hall=new HallController();
        this.ctrl_performance=new PerformancesController();
    }


    public boolean makeOrder(String name, String phoneNUmber, List<String> seats) {

    }
}
