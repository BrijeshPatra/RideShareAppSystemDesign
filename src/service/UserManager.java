package service;

import model.Driver;
import model.Rider;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private static UserManager instance=null;
    private Map<String, Rider>riders;
    private Map<String, Driver>drivers;

    private UserManager(){
        riders=new HashMap<>();
        drivers=new HashMap<>();
    }
    public static UserManager getInstance(){
        if(instance==null){
            instance=new UserManager();
        }
        return instance;
    }
    public void registerRider(Rider rider){
        riders.put(rider.getId(),rider);
    }
    public void registerDriver(Driver driver){
        drivers.put(driver.getId(),driver);
    }
    public Rider getRiderById(String id) {
        return riders.get(id);
    }

    public Driver getDriverById(String id) {
        return drivers.get(id);
    }
}
