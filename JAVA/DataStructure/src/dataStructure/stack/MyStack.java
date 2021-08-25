package dataStructure.stack;

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();

    public T push(T item) {
        stack.add(item);
        return item;
    }

    public T pop() {
        if(stack.isEmpty())
            return null;
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<Integer> stack_int = new MyStack<>();
        System.out.println(stack_int.push(1));
        System.out.println(stack_int.push(2));
        System.out.println(stack_int.push(3));
        System.out.println(stack_int.isEmpty());

        System.out.println(stack_int.pop());
        System.out.println(stack_int.pop());
        System.out.println(stack_int.pop());
        System.out.println(stack_int.isEmpty());
    }
}
