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
    }
}
