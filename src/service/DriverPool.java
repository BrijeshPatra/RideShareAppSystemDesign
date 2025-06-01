package service;


import model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverPool {
    private static DriverPool instance=null;
    private List<Driver>availableDriver;

    private DriverPool(){
        availableDriver=new ArrayList<>();
    }
    public static DriverPool getInstance(){
        if(instance==null){
            instance=new DriverPool();
        }
        return instance;
    }
    public void addDriver(Driver driver){
        if(!availableDriver.contains(driver)) {
            availableDriver.add(driver);
        }
    }
    public void removeDriver(Driver driver){
        availableDriver.remove(driver);
    }
    public List<Driver>getAvailableDriver(){
        return new ArrayList<>(availableDriver);
    }
}
