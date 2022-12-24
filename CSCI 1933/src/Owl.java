public class Owl {
    private String name;
    private int age;
    private double weight;

    public Owl(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setage(int age){
        this.age = age;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public boolean equals(Owl other){
        if (name.equals(other.name) && age == other.age && weight == other.weight){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Owl owl1 = new Owl("Bob", 10, 25.6);
        Owl owl2 = new Owl("Sally", 10, 34);
        Owl owl3 = new Owl("Bob", 10, 25.6);
        System.out.println(owl1.equals(owl2));
        System.out.println(owl1.equals(owl3));

    }

}
