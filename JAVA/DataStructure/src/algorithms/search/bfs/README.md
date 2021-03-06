# 너비 우선 탐색 (Bread-First-Search)
## BFS 와 DFS 란?
- 대표적인 그래프 탐색 알고리즘
    - 너비 우선 탐색 (Breadth First Search) : 정점들과 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 탐색하는 방식
    - 깊이 우선 탐색 (Depth First Search) : 정점의 자식들을 먼저 탐색하는 방식

### BFS / DFS 방식 이해를 위한 예제
```
          A
       /      \
      B        C
    /        / | \
   D        G  H  I
 /   \            |
E     F           J
```
- BFS 방식 : A - B - C - D - G - H - I - E - F - J
  - 한 단계씩 내려가면서, 해당 노드와 같은 레벨에 있는 노드들 (형제 노드들)을 먼저 순회함
- DFS 방식 : A - B - D - E - F - C - G - H - I - J
  - 한 노드의 자식을 타고 끝까지 순회한 후, 다시 돌아와서 다른 형제들의 자식을 타고 내려가며 순회함

## JAVA로 그래프를 표현하는 방법
- Java Collection Framework 에서 제공하는 HashMap과 ArrayList를 활용해서 그래프를 표현할 수 있음

### 참고: HashMap
- HashMap은 '키'와 '값'을 저장하는 자료구조로, 내부에서 해쉬 함수를 통해, '키'에 대한 '값'을 빠르게 검색할 수 있음
> 데이터를 다루는 기능은 항상 C(생성/선언), R(읽기), U(수정하기), D(삭제하기) 즉, CRUD 순으로 사용법을 익히면 빠르게 사용할 수 있다.

## BFS 알고리즘 구현
- 자료구조 큐를 활용함
  - needVisit 큐와 visited 큐, 두 개의 큐를 생성
- 큐의 구현은 간단히 ArrayList 클래스를 활용

## 시간 복잡도
- 일반적인 BFS 시간 복잡도
  - 노드 수 : V
  - 간선 수 : E
    - BFS 코드에서 while needVisit은 V + E번 만큼 수행함
  - 시간 복잡도 : O(V + E)
