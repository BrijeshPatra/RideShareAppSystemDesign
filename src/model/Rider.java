package model;

public class Rider extends User{

    private String currentLocation;

    public Rider(String id, String name, String phone,String currentLocation) {
        super(id, name, phone);
        this.currentLocation=currentLocation;
    }
    public String getCurrentLocation(){
        return currentLocation;
    }
}
