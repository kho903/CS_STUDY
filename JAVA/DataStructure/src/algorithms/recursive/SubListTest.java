package algorithms.recursive;

import java.util.ArrayList;

public class SubListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i<10;i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        System.out.println(arrayList.subList(1, arrayList.size()));
        System.out.println(arrayList.subList(1, arrayList.size() - 1));
    }
}
