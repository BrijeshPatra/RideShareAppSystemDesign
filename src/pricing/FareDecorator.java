package pricing;

import model.Ride;

public abstract class FareDecorator implements FareCalculator{
    protected FareCalculator fareCalculator;

    public FareDecorator(FareCalculator fareCalculator){
        this.fareCalculator=fareCalculator;
    }

    @Override
    public double calcFare(Ride ride) {
        return fareCalculator.calcFare(ride);
    }
}
