package algorithms.sort.mergeSort;

import java.util.ArrayList;

public class MergeSort {
    public static ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;
        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        leftArr = mergeSplitFunc(new ArrayList<>(dataList.subList(0, medium)));
        rightArr = mergeSplitFunc(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return mergeFunc(leftArr, rightArr);
    }

    public static ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        // CASE1 : left / right 둘 다 있을 때
        while (leftList.size() > leftPoint && rightList.size() > rightPoint) {
            if (leftList.get(leftPoint) > rightList.get(rightPoint)) {
                mergedList.add(rightList.get(rightPoint));
                rightPoint++;
            } else {
                mergedList.add(leftList.get(leftPoint));
                leftPoint++;
            }
        }

        // CASE2 : right 데이터가 없을 때
        while (leftList.size() > leftPoint) {
            mergedList.add(leftList.get(leftPoint));
            leftPoint++;
        }

        // CASE3 : left 데이터가 없을 때
        while (rightList.size() > rightPoint) {
            mergedList.add(rightList.get(rightPoint));
            rightPoint++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            arrayList.add((int) (Math.random() * 100));
        }
        System.out.println(mergeSplitFunc(arrayList));
    }
}
