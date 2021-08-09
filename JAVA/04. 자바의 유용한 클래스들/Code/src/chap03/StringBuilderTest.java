package chap03;

public class StringBuilderTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        StringBuilder buffer = new StringBuilder(java);
        System.out.println(System.identityHashCode(buffer));
        buffer.append(android);
        System.out.println(System.identityHashCode(buffer));
        // append 전 후 hashCode 값 동일

        String test = buffer.toString();
        System.out.println(test);
    }
}
