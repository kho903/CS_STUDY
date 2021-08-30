package dataStructure.tree;

class Node {
    Node left;
    Node right;
    int value;

    public Node(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class NodeMgmt {
    Node head = null;


    public boolean insertNode(int data) {
        if (this.head == null)
            // CASE1 : Node가 하나도 없을 때
            this.head = new Node(data);
        else {
            // CASE2 : Node가 하나 이상 들어가 있을 때,
            Node findNode = this.head;
            while (true) {
                // CASE2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때
                if (data < findNode.value) { // CASE2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                } else { // CASE2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    // 이진 트리 탐색
    public Node search(int data) {
        // CASE1 : Node 가 하나도 없을 때
        if (this.head == null)
            return null;
        else { // CASE2 : Node 가 하나 이상 있을 때
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data)
                    return findNode;
                else if (data < findNode.value)
                    findNode = findNode.left;
                else
                    findNode = findNode.right;
            }
            return null;
        }
    }

    // 이진 트리 삭제
    public boolean delete(int value) {
        boolean searched = false;

        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스1 : Node가 하나도 없을 떄
        if (this.head == null)
            return false;
            // 코너 케이스2 : Node가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
        else {
            // 코너 케이스2 : Node가 단지 하나만 있고, 해당 Node가 삭제할 Node일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }

            if (searched == false) {
                return false;
            }
        }
        // 여기까지 실행되면
        // currNode에는 해당 데이터를 가지고 있는 Node,
        // currParentNode에는 해당 데이터를 가지고 있는 Node의 부모 Node

        // Case 1: 삭제할 Node가 Leaf Node인 경우
        if (currNode.left == null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = null;
                currNode = null;
            } else {
                currParentNode.right = null;
                currNode = null;
            }
            return true;
        }
        // Case 2-1: 삭제할 Node를 한 개 가지고 있을 경우(왼쪽에 Child Node가 있을 경우)
        else if (currNode.left != null && currNode.right == null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.left;
                currNode = null;
            } else {
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        }
        // Case 2-1: 삭제할 Node를 한 개 가지고 있을 경우(왼쪽에 Child Node가 있을 경우)
        else if (currNode.left == null && currNode.right != null) {
            if (value < currParentNode.value) {
                currParentNode.left = currNode.right;
                currNode = null;
            } else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        } else {
            // Case 3-1: 삭제할 Node가 Child Node를 두 개 가지고 있고, (삭제할 Node가 부모 Node의 왼쪽에 있을 때,)
            // 삭제할 Node가 부모 Node의 왼쪽에 있을 때
            if (value < currParentNode.value) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음
                if (changeNode.right != null) {
                    // Case 3-1-2: ChangeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-1-1: ChangeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // currParentNode의 왼쪽 Child Node에, 삭제할 Node의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode를 연결
                currParentNode.left = changeNode;

                // parentNode의 왼쪽 Child Node가 현재, changeNode이고,
                // changeNode의 왼쪽/오른쪽 Child Node를 모두, 삭제할 currNode의
                // 기존 왼쪽/오른쪽 Node로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;
                currNode = null;
            } else {
                // Case 3-2: 삭제할 Node가 Child Node를 두 개 가지고 있고, (삭제할 Node가 부모 Node의 오른쪽에 있을 때,)
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음
                if (changeNode.right != null) {
                    // Case 3-1-2: ChangeNode의 오른쪽 Child Node가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-1-1: ChangeNode의 Child Node가 없을 때
                    changeParentNode.left = null;
                }

                // currParentNode의 오른쪽 Child Node에, 삭제할 Node의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode를 연결
                currParentNode.right = changeNode;

                // parentNode의 왼쪽 Child Node가 현재, changeNode이고,
                // changeNode의 왼쪽/오른쪽 Child Node를 모두, 삭제할 currNode의
                // 기존 왼쪽/오른쪽 Node로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;
                currNode = null;
            }
            return true;
        }
    }
}
