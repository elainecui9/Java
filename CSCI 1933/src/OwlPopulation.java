import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
public class OwlPopulation {
    private String fileName;
    private Owl[] data;

    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner scanner = new Scanner(f);
        int numLines = 0;
        while(scanner.hasNextLine()){
            numLines++;
            String s = scanner.nextLine();
        }
        data = new Owl[numLines];
        File hi = new File(fileName);
        Scanner scanner2 = new Scanner(hi);
        for (int x = 0 ; x < data.length; x++){
            String y = scanner2.nextLine();
            String[] tempa = y.split(",");
            data[x] = new Owl(tempa[0], Integer.parseInt(tempa[1]), Double.parseDouble(tempa[2]));
        }
        scanner.close();
        return data.length;
    }

    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        populateData();
    }
    public double averageAge(){
        double sum = 0.0;
        for (int x = 0; x< data.length; x++){
            sum = data[x].getAge() + sum;
        }
        return sum / data.length;
    }
    public Owl getYoungest(){
        double youngest = 100;
        int temp = 0;
        for (int x = 0; x < data.length; x++){
            if (youngest >= data[x].getAge()){
                youngest = data[x].getAge();
                temp = x;
            }
        }
        if (data.length > 0) {
            return data[temp];
        } else {
            return null;
        }
    }
    public Owl getHeaviest(){
        double max = 0.0;
        int temp = 0;
        for (int x = 0; x < data.length; x++){
            if (max <= data[x].getWeight()){
                max = data[x].getWeight();
                temp = x;
            }
        }
        if (data.length > 0) {
            return data[temp];
        } else {
            return null;
        }
    }
    public String toString(){
        return "The youngest owl is: " + getYoungest().getName() + ", " + " which is " + getYoungest().getAge() + " years old.\n" + "The heaviest owl is " + getHeaviest().getName() + ", which weighs " + getHeaviest().getWeight() + " pounds.\n" + "The average age of the population is " + averageAge() + ".";
    }
    public boolean containsOwl(Owl other){
        for (int x = 0; x < data.length; x++){
            if (data[x].equals(other)){
            return true;
            }
        }
        return false;
    }

    public void merge(OwlPopulation other){
        int index = 0;
        for (int x = 0 ; x < other.data.length; x++){
            if (!containsOwl(other.data[x])){
                index++;
        }
            Owl[] mdata = new Owl[index + data.length];
            int index2 = 0;
            for (int i = 0; i < data.length; i++){
                mdata[index2] = data[i];
                index2++;
            }
            for (int y = 0 ; y < other.data.length; y++){
                if (!containsOwl(other.data[y])){
                    mdata[index2] = other.data[y];
                    index2++;
                }
        }
        this.data = mdata;

        }
        //1) determine (and store) the distinct owls in the other population.
        //2) make a new data array to hold the correct number of owls for the merged population
        //3) copy over the distinct owls from each population to the data array
        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)

    /*public int popSize(){
        return data.length;
    }
   public static void main(String[] args){
        try {
            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            System.out.println(pop1);
            System.out.println(pop1.popSize());
            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");
            System.out.println(pop2);
            System.out.println(pop2.popSize());
            pop1.merge(pop2);
            System.out.println(pop1);
            System.out.println(pop1.popSize());
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }*/
    }
}
