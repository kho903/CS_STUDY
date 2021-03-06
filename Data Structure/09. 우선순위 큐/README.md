# 우선순위 큐
## 우선순위 큐의 필요성
- 우선순위 큐는 '우선 순위'를 가진 데이터들을 저장하는 큐를 의미한다.
- 데이터를 꺼낼 때 우선 순위가 높은 데이터가 가장 먼저 나온다는 특징이 있어 많이 활용된다.
- 우선순위 큐는 운영체제의 작업 스케쥴링, 정렬, 네트워크 관리 등의 다양한 기술에 적용되고 있다.

## 우선순위 큐와 큐의 차이점
- 일반적인 형태의 큐는 선형적인 형태를 가지고 있지만 우선순위 큐는 트리(Tree) 구조로 보는 것이 합리적이다. 일반적으로 우선순위 큐는 최대 힙을 이용해 구현한다.

## 최대 힙(Max Heap)
- 최대 힙은 부모 노드가 자식 노드보다 값이 큰 완전 이진 트리를 의미한다.
- 최대 힙의 루트 노드는 전체 트리에서 가장 큰 값을 가진다는 특징이 있다.
- 우리는 항상 전체 트리가 최대 힙 구조를 유지하도록 자료구조를 만들 수 있다.
- PUSH : 우선순위 큐에 데이터를 삽입한다.
- POP : 우선순위 큐에서 데이터를 추출한다.

## 우선순위 큐의 삽입
- 삽입할 원소는 완전 이진 트리를 유지하는 형태로 순차적으로 삽입된다.
- 삽입 이후에는 루트 노드까지 거슬러 올라가면서 최대 힙을 구성한다. [상향식]

## 우선순위 큐의 삭제
- 삭제를 할 때는 루트 노드를 삭제하고, 가장 마지막 원소를 루트 노드의 위치로 옮겨준다.
- 삭제 이후에는 리프 노드까지 내려가면서 최대 힙을 구성한다.

## 정리
1. 우선순위 큐는 완전 이진 트리 형태의 힙을 이용해 구현할 수 있다.
2. 우선순위 큐의 삽입과 삭제는 O(log N)의 시간 복잡도를 가진다.
3. 따라서 우선순위 큐를 이용한 정렬은 O(N log N)의 시간 복잡도를 가진다.