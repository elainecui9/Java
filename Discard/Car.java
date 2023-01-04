public class Car extends Vehicle{
    private double mpg;
    public Car(double m){
        mpg = m;
        super.nVehicles = super.nVehicles + 1;
    }
    public Car(){
        mpg = 30.0;
        super.nVehicles = super.nVehicles + 1;
    }
    public void movingForward(){
        System.out.println("Car moving forward.");
    }
    public void movingBackward(){
        System.out.println("Car moving backwards.");
    }
    public double getMPG(){
        return mpg;
    }
    public String toString(){
        return "Car: " + mpg;
    }
}
