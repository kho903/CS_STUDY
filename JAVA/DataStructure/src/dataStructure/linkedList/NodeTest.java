package dataStructure.linkedList;

public class NodeTest {
    public static void main(String[] args) {
        // Node와 Node 연결하기 : Node 인스턴스간 연결
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);

        node1.next = node2;
        Node head = node1;

        // SingleLinkedList
        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
        MyLinkedList.addNode(1);
        System.out.println(MyLinkedList.head.data);
        MyLinkedList.addNode(2);
        System.out.println(MyLinkedList.head.next.data);
        System.out.println();
        MyLinkedList.printAll();
        System.out.println();

        System.out.println("===링크드 리스트 생성하고, 1, 2, 3 데이터 넣기===");
        SingleLinkedList<Integer> MyLinkedList2 = new SingleLinkedList<Integer>();
        MyLinkedList2.addNode(1);
        MyLinkedList2.addNode(2);
        MyLinkedList2.addNode(3);
        MyLinkedList2.printAll();

        System.out.println("===1 데이터 뒤에 5 넣어 보기===");
        MyLinkedList2.addNodeInside(5, 1);
        MyLinkedList2.printAll();

        System.out.println("===3 데이터 뒤에 6 넣어 보기===");
        MyLinkedList2.addNodeInside(6, 3);
        MyLinkedList2.printAll();

        System.out.println("===없는 데이터를 찾도록 해서, 맨 마지막에 데이터 넣기===");
        MyLinkedList2.addNodeInside(7, 20);
        MyLinkedList2.printAll();


        System.out.println("====테스트 : 5개의 노드 생성====");
        SingleLinkedList<Integer> MyLinkedList3 = new SingleLinkedList<Integer>();
        MyLinkedList3.addNode(1);
        MyLinkedList3.addNode(2);
        MyLinkedList3.addNode(3);
        MyLinkedList3.addNode(4);
        MyLinkedList3.addNode(5);
        MyLinkedList3.printAll();

        System.out.println(MyLinkedList3.delNode(3));
        MyLinkedList3.printAll();

        System.out.println(MyLinkedList3.delNode(1));
        MyLinkedList3.printAll();

        System.out.println(MyLinkedList3.delNode(5));
        MyLinkedList3.printAll();

        System.out.println(MyLinkedList3.delNode(20));
        MyLinkedList3.printAll();

    }
}
