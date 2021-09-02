package algorithms.sort.mergeSort;

import java.util.ArrayList;

public class Split {
    public static void splitFunc(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1)
            return;
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftArr = new ArrayList<Integer>();
        ArrayList<Integer> rightArr = new ArrayList<Integer>();

        leftArr = new ArrayList<Integer>(dataList.subList(0, medium)); // 0 부터 medium - 1 인덱스 번호까지 해당 배열 아이템을 서브 배열로 추출
        rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));

        System.out.println(leftArr);
        System.out.println(rightArr);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add((int)(Math.random()* 100));
        }
        System.out.println(arrayList);
        splitFunc(arrayList);
    }
}
