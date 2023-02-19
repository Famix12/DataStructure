
public class Student {

    protected String name; 
    protected double gpa;
    protected int id;

    public Student(int id) {
        this.id = id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    
    public boolean equals(Object opj){
        Student opj1 = (Student) opj;
        return id == opj1.id;
    }
    
    public String toString(){
     return id + "\t" + name + "\t" + gpa;
    }
    
    
}
