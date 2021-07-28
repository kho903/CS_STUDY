package Chap20;

public class CharArrTest {
    public static void main(String[] args) {
        char[] alph = new char[26];
        char ch = 'A';

        for (int i = 0; i < alph.length; i++) {
            alph[i] = ch++;
        }
        for (char a : alph ) {
            System.out.println(a + "," + (int)a);
        }
    }
}
