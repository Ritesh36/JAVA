package OOPSinJAVA;

public class StudentClass {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Alice";
        student1.age = 20;
        student1.rollNumber = 101;

        Student student2 = new Student();
        student2.name = "Bob";
        student2.age = 22;
        student2.rollNumber = 102;

        System.out.println("Student 1: " + student1.name + ", Age: " + student1.age + ", Roll Number: " + student1.rollNumber);
        System.out.println("Student 2: " + student2.name + ", Age: " + student2.age + ", Roll Number: " + student2.rollNumber);
    }
}
