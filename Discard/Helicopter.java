public class Helicopter extends Vehicle{
    private double mpg;
    public Helicopter(double m){
        mpg = m;
        super.nVehicles = super.nVehicles + 1;
    }
    public Helicopter(){
        mpg = 0.3;
        super.nVehicles = super.nVehicles + 1;
    }
    public void movingForward(){
        System.out.println("Helicopter moving forward.");
    }
    public void movingBackward(){
        System.out.println("Helicopter moving backwards.");
    }
    public double getMPG(){
        return mpg;
    }
    public void movingUp(){
        System.out.println("Helicopter moving up.");
    }
    public void movingDown(){
        System.out.println("Helicopter moving down.");
    }
    public String toString(){
        return "Helicopter: " + mpg;
    }
}

