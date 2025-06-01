package pricing;

import model.Ride;
import model.Vehicle;

public class BaseFareCalculator implements FareCalculator{

    @Override
    public double calcFare(Ride ride) {
        Vehicle vehicle=ride.getDriver().getVehicle();
        return 50+ride.getDistanceKm()* vehicle.getFarePerKm();
    }
}
