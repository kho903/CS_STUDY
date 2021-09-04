package algorithms.basicSearch.binarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public static boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        if (dataList.size() == 1 && searchItem.equals(dataList.get(0)))
            return true;
        else if (dataList.size() == 1 && !searchItem.equals(dataList.get(0)))
            return false;
        else if (dataList.size() == 0)
            return false;

        int medium = dataList.size() / 2;
        if (searchItem.equals(dataList.get(medium)))
            return true;
        else {
            if (searchItem < dataList.get(medium))
                return searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            else
                return searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < 100 ; i ++)
            testData.add((int) (Math.random() * 100));
        Collections.sort(testData);
        System.out.println(testData);
        System.out.println(searchFunc(testData, 2));
    }
}
