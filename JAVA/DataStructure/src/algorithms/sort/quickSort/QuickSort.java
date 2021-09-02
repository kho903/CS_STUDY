package algorithms.sort.quickSort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int pivot = dataList.get(0);
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) > pivot) {
                rightArr.add(dataList.get(i));
            } else
                leftArr.add(dataList.get(i));
        }

        ArrayList<Integer> mergedArr = new ArrayList<>();
        mergedArr.addAll(sort(leftArr));
        mergedArr.addAll(Arrays.asList(pivot));
        mergedArr.addAll(sort(rightArr));
        return mergedArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testData.add((int) (Math.random() * 100));
        }
        System.out.println(testData);
        System.out.println(sort(testData));
    }
}
