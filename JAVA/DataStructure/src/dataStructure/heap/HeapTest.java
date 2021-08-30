package dataStructure.heap;

import java.util.ArrayList;
import java.util.Collections;

public class HeapTest {
    public static void main(String[] args) {
        Heap heapTest = new Heap(1);
        heapTest.insert(2);
        heapTest.insert(3);
        heapTest.insert(4);
        heapTest.insert(5);
        System.out.println(heapTest.heapArray);

        ArrayList<Integer> heapArray = new ArrayList<Integer>();
        heapArray.add(1);
        heapArray.add(2);
        System.out.println(heapArray);

        Collections.swap(heapArray, 0, 1);
        System.out.println(heapArray);

        Heap heapTest2 = new Heap(15);
        heapTest2.insert(10);
        heapTest2.insert(8);
        heapTest2.insert(5);
        heapTest2.insert(4);
        heapTest2.insert(20);

        System.out.println(heapTest2.heapArray);

    }
}
