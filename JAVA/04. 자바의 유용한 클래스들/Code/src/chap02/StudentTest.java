package chap02;

public class StudentTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student std1 = new Student(100, "Lee");
        Student std2 = new Student(100, "Lee");
        Student std3 = std1;

        System.out.println(std1 == std2); // false
        System.out.println(std1.equals(std2)); // false
        // override 후 true

        System.out.println(std1 == std3); // true
        System.out.println(std1.equals(std3)); // true

        System.out.println(std1.hashCode()); // override 후 rkxdms rkqt
        System.out.println(std2.hashCode());

        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.equals(str2)); // true

        System.out.println(str1.hashCode()); // 같은 값
        System.out.println(str2.hashCode());

        Integer i = 100;
        System.out.println(i.hashCode()); // 정수값 100

        System.out.println(System.identityHashCode(std1)); // 다른 값
        System.out.println(System.identityHashCode(std2));

        // clone
        Student copyStudent = (Student) std1.clone();
        System.out.println(copyStudent);
        //Student 클래스에 implements Cloneable 안할 시 오류

        std1.setStudentName("KIM");
        Student copyStudent2 = (Student) std1.clone();
        System.out.println(copyStudent2); // KIM
    }
}
