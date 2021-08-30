package dataStructure.tree;

public class treeTest {
    public static void main(String[] args) {
//        NodeMgmt myTree = new NodeMgmt();
//        myTree.insertNode(2);
//        myTree.insertNode(3);
//        myTree.insertNode(4);
//        myTree.insertNode(6);
//
//        Node testNode = myTree.search(3);
//        System.out.println(testNode.value);
//        System.out.println(testNode.right.value);

        NodeMgmt myTree = new NodeMgmt();
        myTree.insertNode(10);
        myTree.insertNode(15);
        myTree.insertNode(13);
        myTree.insertNode(11);
        myTree.insertNode(14);
        myTree.insertNode(18);
        myTree.insertNode(16);
        myTree.insertNode(19);
        myTree.insertNode(17);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(6);
        System.out.println(myTree.delete(15));
        System.out.println("myTree.head.value = " + myTree.head.value);
        System.out.println("myTree.head.left.value = " + myTree.head.left.value);
        System.out.println("myTree.head.left.left.value = " + myTree.head.left.left.value);
        System.out.println("myTree.head.left.right.value = " + myTree.head.left.right.value);

        System.out.println("myTree.head.right.value = " + myTree.head.right.value);
        System.out.println("myTree.head.right.left.value = " + myTree.head.right.left.value);
        System.out.println("myTree.head.right.right.value = " + myTree.head.right.right.value);

        System.out.println("myTree.head.right.right.left.value = " + myTree.head.right.right.left.value);
        System.out.println("myTree.head.right.right.right.value = " + myTree.head.right.right.right.value);
    }
}
