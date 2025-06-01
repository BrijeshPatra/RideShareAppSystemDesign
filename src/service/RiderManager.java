package service;

import model.*;
import observer.DriverNotify;
import observer.RideNotify;
import pricing.BaseFareCalculator;
import pricing.DiscountFare;
import pricing.FareCalculator;
import pricing.SurgeFareDecorator;
import strategy.DriverMatchingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RiderManager {
    private static RiderManager instance=null;

    private Map<String, Ride> ongoingRides;
    private List<Ride>completedRides;
    private DriverMatchingStrategy driverMatchingStrategy;

    private RiderManager(){
        this.ongoingRides=new HashMap<>();
        this.completedRides=new ArrayList<>();
    }
    public static RiderManager getInstance(){
        if(instance==null){
            instance=new RiderManager();
        }
        return instance;
    }
    public void setMatchingStrategy(DriverMatchingStrategy strategy) {
        this.driverMatchingStrategy = strategy;
    }
    public Ride requestRide(Rider rider,String pickup,String drop,double distanceKm){
        Ride ride=new Ride(rider,pickup,drop,distanceKm);

        List<Driver>availableDrivers=DriverPool.getInstance().getAvailableDriver();
        Driver matchedDriver=driverMatchingStrategy.matchDriver(ride,availableDrivers);

        if(matchedDriver==null){
            System.out.println("No drivers available"+rider.getName());
            return null;
        }
        //assign driver to ride
        ride.setDriver(matchedDriver);
        matchedDriver.setAvailable(false);
        ongoingRides.put(ride.getId(), ride);
        DriverPool.getInstance().removeDriver(matchedDriver);

        //updated ride manager to send notification
        ride.addObserver(new RideNotify(rider));
        ride.addObserver(new DriverNotify(matchedDriver));

        ride.notifyObserver("Driver assigned " + ride.getId());
        System.out.println(matchedDriver.getName() + " " + rider.getName());

        stimulateRideProgress(ride);
        return ride;


    }
    private void stimulateRideProgress(Ride ride){
        System.out.println(ride.getId() + "starting");
        ride.setRideStatus(RideStatus.EN_ROUTE);
        System.out.println("Driver en route to pickup...");

        ride.setRideStatus(RideStatus.IN_PROGRESS);
        System.out.println("Passenger onboard, ride in progress...");

        ride.setRideStatus(RideStatus.COMPLETED);
        ride.setFare(calculateFare(ride));

        System.out.println("Ride completed. Fare: ₹" + ride.getFare());

        //updated ride manager to send notification
        ride.setRideStatus(RideStatus.EN_ROUTE);
        ride.notifyObserver("Driver is en route to pickup location.");

        ride.setRideStatus(RideStatus.IN_PROGRESS);
        ride.notifyObserver("Ride has started. Enjoy your trip!");

        ride.setRideStatus(RideStatus.COMPLETED);
        ride.notifyObserver("Ride completed. Total Fare: ₹" + ride.getFare());

        ride.getDriver().setAvailable(true);
        DriverPool.getInstance().addDriver(ride.getDriver());

        ongoingRides.remove(ride.getId());
        completedRides.add(ride);
    }
    private double calculateFare(Ride ride) {
        FareCalculator baseCalculator = new BaseFareCalculator();

        // Apply decorators
        FareCalculator withSurge = new SurgeFareDecorator(baseCalculator, 1.5); // 1.5x
        FareCalculator finalCalculator = new DiscountFare(withSurge, 20); // ₹20 off

        return finalCalculator.calcFare(ride);
    }
}
