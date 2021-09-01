package algorithms.recursive;

public class Example {
    public static int solution(int data) {
        if (data == 1)
            return 1;
        else if (data == 2)
            return 2;
        else if (data == 3)
            return 4;
        return solution(data - 1) + solution(data - 2) + solution(data - 3);
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }
}
