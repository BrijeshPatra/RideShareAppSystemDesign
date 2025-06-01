package model;

public class Vehicle{
    private String type;
    private int capacity;
    private double farePerKm;

    public Vehicle(String type,int capacity,double farePerKm){
        this.type=type;
        this.capacity=capacity;
        this.farePerKm=farePerKm;
    }
    public String getType(){return type;}

    public int getCapacity() {
        return capacity;
    }

    public double getFarePerKm() {
        return farePerKm;
    }
}
