public class Student implements Person {
    public Student() {}
    public Student(String name, int id) {
        this.name = name;
        studentID = id;
    }
    public String getName() {
        return "Student Name is: " + name;
    }
    public int getID() {
        return studentID;
    }
    public String toString() {
        return "Student " + name + " " + studentID;
    }
    protected String name;
    private int studentID;
}
