# 이진 탐색 트리 (Binary Search Tree)
- 이진 탐색 트리에서는 항상 부모 노드가 왼쪽 자식보다는 크고, 오른쪽 자식보다는 작다.
- 이진 탐색 트리에서는 한 번 확인할때마다 보아야 하는 원소의 개수가 절반씩 줄어든다는 점에서 '완전 이진 트리'인 경우 탐색 시간에 O(log N)의 시간 복잡도를 가진다.
- 이진 탐색 트리에서 탐색을 할 때는 찾고자 하는 값이 부모 노드보다 클 경우 오른쪽 자식으로 이어 나가면서 방문한다.
- 이진 탐색 트리의 성능을 최대로 끌어내기 위해서는 이진 탐색 트리가 완전 이진 트리에 가까워 질 수 있도록 설계해야 한다.

## 완전 이진 트리(Complete Binary Tree)
- 데이터기 루트(Root) 노드부터 시작해서 자식 노드가 왼쪽 자식 노드, 오른쪽 자식 노드로 차례대로 들어가는 구조의 이진 트리이다.

## 트리의 효율성
- 트리(Trre)를 사용하면 데이터를 처리함에 있어서 효율적이다.
- 트리에서 데이터의 개수가 N개일 때, 배열과 마찬가지로 O(N)의 공간만이 소요되며 삽입 및 삭제에 있어서 일반적인 경우 기존의 배열(Array)를 이용하는 방식보다 효율적이다.
- 따라서 데이터베이스 등 대용량 저장 및 검색 자료구조로 많이 활용된다.

## 정리1
- 정상적으로 설계된 완전 이진 트리(Complete Binary Tree)에서는 어떠한 원소라도 탐색함에 있어서 O(log N)의 시간이 소요된다.
- 반면에 한쪽으로 치우친 편향 이진 트리(Skewed Binary Tree)의 경우 탐색에 있어 O(N)의 시간 복잡도가 형성되므로 기존의 배열(Array)을 사용하는 것보다 오히려 많은 공간과 시간이 낭비된다.
- 따라서 이진 트리(Binary Tree)를 만들 때는 트리의 균형이 맞도록 설정하는 것이 중요하다.

## 정리2
1. 편향 이진 트리(Skewed Binary Tree)의 경우 탐색에 있어 O(N)의 시간 복잡도를 가진다.
2. 따라서 이진 탐색 트리를 최대한 완전 이진 트리의 형태를 유지할 수 있도록 해야 한다.