package chap03;

public class StringTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        System.out.println(System.identityHashCode(java));
        java = java.concat(android);

        System.out.println(java); // javaandroid
        System.out.println(System.identityHashCode(java)); // concat전 java 값과 다른 값
        // 따라서 StringBuilder, StringBuffer 활용할 것
    }
}
