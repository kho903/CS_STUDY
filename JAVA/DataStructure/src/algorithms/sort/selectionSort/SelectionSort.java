package algorithms.sort.selectionSort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        int lowest;
        for (int stand = 0; stand < dataList.size() - 1; stand++) {
            lowest = stand;
            for (int index = stand + 1; index < dataList.size(); index++) {
                if (dataList.get(lowest) > dataList.get(index)) {
                    lowest = index;
                }
            }
            Collections.swap(dataList, lowest, stand);
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0 ; i<100; i++) {
            arrayList.add((int)(Math.random() * 100));
        }
        sort(arrayList);
        System.out.println(arrayList);
    }
}
