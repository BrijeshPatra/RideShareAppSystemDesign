package pricing;

import model.Ride;

public class SurgeFareDecorator extends FareDecorator{
    private double surgeMultiplier;

    public SurgeFareDecorator(FareCalculator fareCalculator,double surgeMultiplier) {
        super(fareCalculator);
        this.surgeMultiplier=surgeMultiplier;
    }
    public double calculateFare(Ride ride) {
        double baseFare = super.calcFare(ride);
        return baseFare * surgeMultiplier;
    }
}
