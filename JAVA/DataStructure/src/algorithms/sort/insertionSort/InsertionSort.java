package algorithms.sort.insertionSort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++) {
            for (int index2 = index + 1; index2 > 0; index2--) {
                if (dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }
            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            arrayList.add((int)(Math.random() * 100));
        }
        sort(arrayList);
        System.out.println(arrayList);
    }
}
