package algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class GreedyCoin {
    public static void coinFunc(Integer price, ArrayList<Integer> coinList) {
        Integer totalCoinCount = 0;
        Integer coinNum = 0;
        ArrayList<Integer> details = new ArrayList<Integer>();

        for (int i = 0; i < coinList.size(); i++) {
            coinNum = price / coinList.get(i);
            totalCoinCount += coinNum;
            price -= coinNum * coinList.get(i);
            System.out.println(coinList.get(i) + "원: " + coinNum + "개");
        }
        System.out.println("총 동전 갯수 : " + totalCoinCount);
    }

    public static void main(String[] args) {
        ArrayList<Integer> coinList = new ArrayList<Integer>(Arrays.asList(500, 100, 50, 1));
        coinFunc(4720, coinList);
    }
}
