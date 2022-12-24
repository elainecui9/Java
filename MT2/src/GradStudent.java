public class GradStudent extends Student {
    public GradStudent(String name, int id, String degree) {
        this.name = name;
        this.id = id;
        this.degree = degree;
    }
    public int getID() {
        return id + 1000;
    }
    public String getDegree() {
        return degree;
    }
    public String toString() {
        return "Grad " + name + " " + degree;
    }
    private int id;
    private String degree;
    public static void main(String[] args) {
        Student s = new Student( "MyTA", 1);
        Student gs = new GradStudent("Smart Person", 2, "PhD");
        System.out.println("line 1: " + s.toString());
        System.out.println("line 2: " + gs.toString());
        System.out.println("line 3: " + s.getID());
        System.out.println("line 4: " + gs.getID());
        System.out.println("line 5: " + s.getName());
        System.out.println("line 6: " + gs.getName());
        Person p = new GradStudent("Hi", 6, "Masters");
        Object o = new Student("hi", 8);
        System.out.println(p.toString());
        Student t = (Student) o;
        System.out.println(t.toString());
    }
}