package pricing;

import model.Ride;

public class DiscountFare extends FareDecorator{
    private double discountAmount;

    public DiscountFare(FareCalculator fareCalculator, double discountAmount) {
        super(fareCalculator);
        this.discountAmount = discountAmount;
    }
    public double calculateFare(Ride ride) {
        double baseFare = super.calcFare(ride);
        return Math.max(baseFare - discountAmount, 0); // avoid negative fare
    }
}
