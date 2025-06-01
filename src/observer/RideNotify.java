package observer;

import model.Rider;

public class RideNotify implements Observer{
    private Rider rider;

    public RideNotify(Rider rider){
        this.rider=rider;
    }
    @Override
    public void update(String message) {
        System.out.println("Notification to rider " + rider.getName() + ":" + message);
    }
}
