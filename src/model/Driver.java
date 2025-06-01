package model;

public class Driver extends User{

    private Vehicle vehicle;
    private String currentLocation;
    private double rating;
    private boolean available;
    public Driver(String id, String name, String phone,Vehicle vehicle,String location,double rating) {
        super(id, name, phone);
        this.phone=phone;
        this.vehicle=vehicle;
        this.currentLocation=location;
        this.rating=rating;
        this.available=true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
