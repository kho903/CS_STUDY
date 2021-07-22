package Chap06;

public class StudentTest {
    public static void main(String[] args) {
        Student studentLee = new Student();
        System.out.println(studentLee.showStudentInfo());

        Student studentKIM = new Student(1,"KIM", 3);
        System.out.println(studentKIM.showStudentInfo());
    }
}
