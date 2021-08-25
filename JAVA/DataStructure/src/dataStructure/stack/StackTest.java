package dataStructure.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        // 자료형 매개변수를 넣어서, 스택에 들어갈 데이터의 타입을 지정해야 함.
        Stack<Integer> stack_int = new Stack<Integer>(); // Integer형 스택 선언

        System.out.println(stack_int.push(1));
        System.out.println(stack_int.push(2));
        System.out.println(stack_int.push(3));
        // push 성공 시 해당 아이템을 리턴해준다.

        System.out.println(stack_int.pop()); // Stack에서 데이터 추출 (마지막에 넣은 3이 출력)
    }
}
