package strategy;

import model.Driver;
import model.Ride;

import java.util.List;

public class BestRatedDriverStrategy implements DriverMatchingStrategy{

    @Override
    public Driver matchDriver(Ride ride, List<Driver> availableDriver) {
        Driver bestDriver=null;
        double bestRating=-1;
        for(Driver driver:availableDriver){
            if(driver.isAvailable() && driver.getRating()>bestRating){
                bestRating=driver.getRating();
                bestDriver=driver;
            }
        }
        return bestDriver;
    }
}
