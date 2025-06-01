import model.Driver;
import model.Rider;
import model.Vehicle;
import service.DriverPool;
import service.RiderManager;
import service.UserManager;
import strategy.BestRatedDriverStrategy;
import strategy.NearestDriverStrategy;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        DriverPool driverPool = DriverPool.getInstance();
        RiderManager rideManager = RiderManager.getInstance();

        //register driver
        Driver d1 = new Driver("d1", "Ravi", "999", new Vehicle("Sedan", 4, 12.0), "A", 4.5);
        Driver d2 = new Driver("d2", "Amit", "888", new Vehicle("Bike", 1, 8.0), "B", 4.8);

        userManager.registerDriver(d1);
        userManager.registerDriver(d2);

        driverPool.addDriver(d1);
        driverPool.addDriver(d2);

        //register rider
        Rider r1=new Rider("r1","Rahul","9999","BBSR");
        userManager.registerRider(r1);

        //set matching strategy
        rideManager.setMatchingStrategy(new NearestDriverStrategy());
        rideManager.requestRide(r1, "BBSR", "C", 5);

        System.out.println("\nNow switching to best-rated strategy...\n");
        rideManager.setMatchingStrategy(new BestRatedDriverStrategy());
        rideManager.requestRide(r1, "B", "D", 10); // 10 km ride
    }
}
