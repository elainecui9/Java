import java.util.ArrayList;
public class Taxonomy {
    public static void main(String[] args) {
        ArrayList<Animalia> animals = new ArrayList<Animalia>();
        Animalia a1 = new Animalia();
        Animalia a2 = new Reptilia();
        Animalia a3 = new Mammalia();
        Animalia a4 = new Platypus();
        Animalia a5 = new Human();
        animals.add(a1);
        animals.add(a2);
        animals.add(a3);
        animals.add(a4);
        animals.add(a5);
        for (Animalia animal : animals){
            System.out.println("Name: " + animal.getClass().getName());
            System.out.println("Thermoregulation: " + animal.thermoRegulationType());
            System.out.println("Type of Food Production: " + animal.foodProduction());
            System.out.println("Method of Transportation: " + animal.methodOfTransportation());
            if (animal instanceof Human){
                Human human = (Human) animal;
                System.out.println("I can do math! " + human.canDoCalculus());
            }
            System.out.println();
        }
    }
}