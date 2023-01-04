public class Train extends Vehicle{
    private double mpg;
    public Train(double m){
        mpg = m;
        super.nVehicles = super.nVehicles + 1;
    }
    public Train(){
        mpg = 470.0;
        super.nVehicles = super.nVehicles + 1;
    }
    public void movingForward(){
        System.out.println("Train moving forward.");
    }
    public void movingBackward(){
        System.out.println("Train moving backwards.");
    }
    public double getMPG(){
        return mpg;
    }
    public void enteringStation(){
        System.out.println("Train entering station.");
    }
    public void leavingStation(){
        System.out.println("Train leaving station.");
    }
    public String toString(){
        return "Train: " + mpg;
    }
}

