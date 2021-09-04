package algorithms.search.dfs;

import java.util.ArrayList;

public class Stack {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("A");
        aList.add("B");
        String node = aList.remove(aList.size() - 1);
        System.out.println(aList);
        System.out.println(node);
    }
}
