package dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue_int = new LinkedList<Integer>(); // Integer형 queue 선언
        Queue<String> queue_str = new LinkedList<String>(); // String형 queue 선언

        // 데이터 추가는 add(value) 또는 offer(value)를 사용함
        queue_int.add(1);
        System.out.println(queue_int.offer(2)); // offer()의 경우 true라고 출력됨.
        // 셀의 맨 마지막에 함수를 넣을 경우, 변수가 변수값에 출력되는 것처럼 함수는 함수 리턴값이 출력되는 것임

        // Queue 인스턴스를 출력하면, 해당 큐에 들어 있는 아이템 리스트가 출력됨
        System.out.println(queue_int);

        // poll()은 큐의 첫 번째 값 반환, 해당 값은 큐에서 삭제
        System.out.println(queue_int.poll());
        System.out.println(queue_int);

        // remove()는 poll()과 마찬가지로, 첫 번째 값을 반환하고 해당 값은 큐에서 삭제
        System.out.println(queue_int.remove());
        System.out.println(queue_int);
    }
}
