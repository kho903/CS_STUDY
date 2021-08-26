package dataStructure.hash;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap();
        map1.put(1, "사과");
        map1.put(2, "포도");
        map1.put(3, "바나나");
        System.out.println(map1.get(1));

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("kim", "01011112222");
        map2.put("kkm", "01022223333");
        map2.put("kkk", "01033334444");
        System.out.println(map2.get("kim"));
    }
}
