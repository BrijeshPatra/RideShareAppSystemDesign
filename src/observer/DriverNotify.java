package observer;

import model.Driver;

public class DriverNotify implements Observer{
    private Driver driver;

    public DriverNotify(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to Driver " + driver.getName() + ": " + message);
    }
}
