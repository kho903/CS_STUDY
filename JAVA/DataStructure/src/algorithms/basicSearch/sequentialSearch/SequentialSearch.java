package algorithms.basicSearch.sequentialSearch;

import java.util.ArrayList;

public class SequentialSearch {
    public static int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).equals(searchItem)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData =  new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            testData.add((int)(Math.random() * 100));
        }
        System.out.println(testData);
        System.out.println(searchFunc(testData, 3));
    }
}
