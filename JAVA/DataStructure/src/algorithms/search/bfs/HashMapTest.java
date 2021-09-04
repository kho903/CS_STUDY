package algorithms.search.bfs;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        // 기본 선언 HashMap<키타입, 값타입> 변수 = new HashMap<>();
        // C : 생성 / 선언
        HashMap<String, Integer> mapData1 = new HashMap<String, Integer>();
        HashMap<String, Integer> mapData2 = new HashMap<String, Integer>(mapData1);
        HashMap<String, Integer> mapData3 = new HashMap<String, Integer>(10);
        HashMap<String, ArrayList<String>> mapData4 = new HashMap<String, ArrayList<String>>();
        // HashMap 데이터 추가
        mapData1.put("A", 1);
        mapData1.put("B", 2);

        // R : HashMap 데이터 읽기
        System.out.println(mapData1);
        System.out.println(mapData1.get("A"));

        // U : HashMap 데이터 수정
        mapData1.put("B", 3);
        System.out.println(mapData1);

        // D : HashMap 데이터 삭제
        mapData1.remove("A");
        System.out.println(mapData1);
    }
}
