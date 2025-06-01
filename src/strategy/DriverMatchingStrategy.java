package strategy;

import model.Driver;
import model.Ride;

import java.util.List;

public interface DriverMatchingStrategy {
    Driver matchDriver(Ride ride, List<Driver>availableDriver);
}
