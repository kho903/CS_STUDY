package chap02;

public class AddTest {
    public static void main(String[] args) {
//        Add addL = (x, y) -> {return x + y;}; // O
//        Add addL = (x, y) -> return x + y; // X
        Add addL = (x, y) ->  x + y; // O
        System.out.println(addL.add(2, 3));
    }
}
