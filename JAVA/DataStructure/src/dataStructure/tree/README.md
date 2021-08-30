# 대표적인 데이터 구조 : 트리
## 트리(Tree) 구조
- 트리 : Node와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
- 실제 사용 예)
    - 트리 중 이진 트리(Binary Tree) 형태의 구조로, 탐색(검색) 알고리즘 구현을 위해 
      많이 사용됨

## 용어
- Node : 트리에서 데이터를 저장하는 기본 요소 (데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
- Root Node : 트리 맨 위에 있는 노드
- Level : 최상위 노드를 Level 0으로 하였을 때, 하위 Branch로 연결된 노드의 깊이를 나타냄
- Parent Node : 어떤 노드의 다음 레벨에 연결된 노드
- Child Node : 어떤 노드의 상위 레벨에 연결된 노드
- Leaf Node (Terminal Node) : Child Node가 하나도 없는 노드
- Sibling (Brother Node) : 동일한 Parent Node를 가진 노드
- Depth : 트리에서 Node가 가질 수 있는 최대 Level

## 이진 트리와 이진 탐색 트리 (Binary Search Tree)
- 이진 트리 : 노드의 최대 Branch가 2인 트리
- 이진 탐색 트리(Binary Search Tree, BST) : 이진 트리에 다음과 같은 추가적인 조건이 있는 트리
    - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음

## 이진 탐색 트리의 장점과 주요 용도
- 주요 용도 : 데이터 검색(탐색)
- 장점 : 탐색 속도를 개선할 수 있다.

## 이진 탐색 트리 삭제
### Leaf Node 삭제
- Leaf Node : Child Node가 없는 Node
- 삭제할 Node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다.

### Child Node가 하나인 Node 삭제
- 삭제할 Node의 Parent Node가 삭제할 Node의 Child Node를 가리키도록 한다.

## Child Node가 두 개인 Node 삭제
1. 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
2. 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent가 가리키도록 한다.
### 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키게 할 경우
- 삭제할 Node의 오른쪽 자식 선택
- 오른쪽 자식의 가장 왼쪽에 있는 Node를 선택
- 해당 Node를 삭제할 Node의 Parent Node의 왼쪽 Branch가 가리키게 함
- 해당 Node의 왼쪽 Branch가 삭제할 Node의 왼쪽 Child를 가리키게 함
- 해당 Node의 오른쪽 Branch가 삭제할 Node의 오른쪽 Child Node를 가리키게 함
- 만약 해당 Node가 오른쪽 Child Node를 가지고 잇었을 경우에는, 
  해당 Node가 본래 Parent Node의 왼쪽 Branch가 해당 오른쪽 Child Node를 가리키게 함

# 이진 탐색 트리 삭제 코드 구현과 분석
## 삭제할 Node 탐색
- 삭제할 Node가 없는 경우도 처리해야 함
    - 이를 위해 삭제할 Node가 없는 경우는 false를 리턴하고, 함수를 종료시킴

## 삭제할 Node가 Child Node를 두 개 가지고 있을 경우 (삭제할 Node가 Parent Node 왼 쪽에 있을 때)
- 기본 사용 가능 전략
    1. 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
    2. 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
- 기본 사용 가능 전략중, 1번 전략을 사용하여 코드를 구현.
    - 경우의 수가 또다시 두가지가 있음
        1. 삭제할 Node가 Parent Node의 왼쪽에 있고, 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 Child Node가 없을 때,
        2. 삭제할 Node가 Parent Node의 왼쪽에 있고, 삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 가진 Node의 오른쪽에 Child Node가 있을 때
            - 가장 작은 값을 가진 Node의 Child Node가 왼쪽에 있을 경우는 없음. 왜냐하면 왼쪽 Node가 있다는 것은 해당 Node보다 더 작은 값을 가진 Node가 있다는 뜻이기 때문

## 이진 탐색 트리의 단점
- 평균 시간 복잡도는 O(log n)이지만
    - 이는 트리의 균형잡혀 있을 때의 평균 시간 복잡도이며,
- 다음 예와 같이 구성되어 있을 경우, 최악의 경우는 링크드 리스트 등과 동일한 성능을 보여줌(O(n))
    - 1 - 2 - 3 - 4 - 5 (1이 루트 노드)