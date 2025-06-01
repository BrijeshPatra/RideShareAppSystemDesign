package pricing;

import model.Ride;

public interface FareCalculator {
    double calcFare(Ride ride);
}
