package model;

import observer.Observer;
import observer.RideSubject;

import java.util.*;

public class Ride implements RideSubject {
    private String id;
    private Rider rider;
    private Driver driver;
    private String pickupLocation;
    private String dropLocation;
    private RideStatus rideStatus;
    private double fare;
    private double distanceKm;

    private List<Observer>observers=new ArrayList<>();
    public Ride(Rider rider, String pickupLocation, String dropLocation, double distanceKm) {
        this.id = UUID.randomUUID().toString();
        this.rider = rider;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.rideStatus=RideStatus.REQUESTED;
        this.distanceKm = distanceKm;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public double getFare() {
        return fare;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        for(Observer observer:observers){
            observer.update(message);
        }
    }
}

