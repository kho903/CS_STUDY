# 깊이 우선 탐색 (Depth-First-Search)
## DFS 알고리즘 구현
- 자료구조 스택과 큐를 활용함
    - needVisit 스택과 visited 큐, 두 개의 자료 구조를 생성
> BFS 자료구조는 두 개의 큐를 활용하는데 반해, DFS는 스택과 큐를 활용한다는 차이가 있음을 인지해야 함
- 큐와 스택의 구현도 간단히 ArrayList 클래스를 활용

## 시간 복잡도
- 일반적인 DFS 시간 복잡도
  - 노드 수 : V
  - 간선 수 : E
    - DFS 코드에서 while needVisit은 V + E 번 만큼 수행함
  - 시간 복잡도 O(V + E)