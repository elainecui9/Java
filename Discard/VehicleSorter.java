import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VehicleSorter {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car(50));
        vehicles.add(new Car());
        vehicles.add(new Train());
        vehicles.add(new Train(400));
        vehicles.add(new Train(2));
        vehicles.add(new Helicopter());
        vehicles.add(new Helicopter(500));
        vehicles.add(new Helicopter(1));
        Collections.sort(vehicles);
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}