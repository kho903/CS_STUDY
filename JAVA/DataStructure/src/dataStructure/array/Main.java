package dataStructure.array;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 1치원 배열
        System.out.println("======= 1차원 배열 ========");
        ArrayList<Integer> list1 = new ArrayList<Integer>(); // int 형 데이터를 담을 수 있는 가변 길이의 배열 선언
        list1.add(1); // 배열에 아이템 추가 시 add(아이템) 메서드 사용
        list1.add(2);
        System.out.println(list1.get(0)); // 배열에 특정 아이템을 읽을 시 get(인덱스번호) 메서드 사용(

        list1.set(0, 5); // 특정 인덱스에 해당하는 아이템 변경 시, set(인덱스 번호, 변경할 값) 메서드 사용
        System.out.println(list1.get(0));

        list1.remove(0); // 특정 인덱스에 해당하는 아이템 삭제 시, remove(인덱스번호) 메서드 사용
        System.out.println(list1.get(0));
        System.out.println(list1.size()); // 배열 길이 확

        // 2차원 배열
        System.out.println("======= 2차원 배열 ========");
        Integer[][] data_list2 = {{1, 2, 3}, {4, 5, 6}};
        // 데이터 2 인덱스로 지정해서 출력해보기
        System.out.println(data_list2[0][1]);
        // 데이터 5 인덱스로 지정해서 출력해보기
        System.out.println(data_list2[1][1]);

        // 3차원 배열
        System.out.println("======= 1차원 배열 ========");
        Integer[][][] data_list3 = {
                {
                        {1, 2, 3},
                        {4, 5, 6}
                },
                {
                        {7, 8, 9},
                        {10, 11, 12}
                }
        };
        // 데이터 5 인덱스로 지정해서 출력해보기
        System.out.println(data_list3[0][1][1]);
        // 데이터 12 인덱스로 지정해서 출력해보기
        System.out.println(data_list3[1][1][2]);
        // 3차원 배열에서 8, 10, 2를 순서대로 각각의 라인에 출력해보기
        System.out.println("=======3차원 배열에서 8, 10, 2를 순서대로 각각의 라인에 출력해보기========");
        System.out.println(data_list3[1][0][1]);
        System.out.println(data_list3[1][1][0]);
        System.out.println(data_list3[0][0][1]);
        System.out.println("=========================");
        String[] dataset = {
                "BasdadM",
                "dsklfmsdlf",
                "dsjkfndsfM",
                "dsfsfM",
                "sdkfsdfM",
                "fdskfs",
                "dskflds",
                "dsjfknasdjf",
                "dsjfksdnfM",
                "dskfoldsmnfM",
                "dsjifknsdM",
                "dsfsdf"
        };
        int count = 0;
        for (int i = 0; i < dataset.length; i++) {
            if (dataset[i].contains("M"))
                count++;
        }
        System.out.println(count);
    }
}