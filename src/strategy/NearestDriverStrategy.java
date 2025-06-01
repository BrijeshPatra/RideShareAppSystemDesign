package strategy;

import model.Driver;
import model.Ride;

import java.util.List;

public class NearestDriverStrategy implements DriverMatchingStrategy{

    @Override
    public Driver matchDriver(Ride ride, List<Driver> availableDriver) {
        for (Driver driver:availableDriver){
            if(driver.isAvailable() && driver.getCurrentLocation().equals(ride.getPickupLocation())){
                return driver;
            }
        }
        return null;
    }
}
