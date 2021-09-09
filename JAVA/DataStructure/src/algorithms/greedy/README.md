# 탐욕 알고리즘의 이해
## 탐욕 알고리즘이란?
- Greedy algorithm 또는 탐욕 알고리즘이라고 불리움
- 최적의 해에 가까운 값을 구하기 위해 사용됨
- 여러 경우 중 하나를 결정해야 할 때마다, 매 순간 최적이라고 생각되는 경우를 선택하는 방식으로 진행해서, 최종적인 값을 구하는 방식

## 탐욕 알고리즘 예
### 동전 문제
- 지불해야 하는 값이 4720원 일때, 1, 50, 100, 500원 동전으로 동전의 수가 가장 적게 지불.
    - 가장 큰 동전부터 최대한 지불해야 하는 값을 채우는 방식으로 구현 가능
    - 탐욕 알고림즘으로 매 순간 최적이라고 생각되는 경우를 선택하면 됨

### 부분 배낭 문제 (Fractional Knapsack Problem)
- 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
  - 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
  - 물건은 쪼갤 수 있으므로 물건의 일부분이 배낭에 넣어질 수 있음., 그래서 Fractional Knapsack Problem 으로 부름
    - Fractional Knapsack Problem 의 반대로 물건을 쪼개서 넣을 수 없는 배낭 문제도 존재함 (0/1 Knapsack Problem 으로 부름)

### 참고 : 정렬 기준 정의하기
- 정렬을 위해서는 정렬 기준이 있어야 함
- 객체간 정렬을 위해서는 정렬 기준을 먼저 정의해줘야 함

```java
import java.util.Arrays;

public class Edge {
    public Integer distance;
    public String vertex;
  
    public Edge(Integer distance, String vertex) {
      this.distance = distance;
      this.vertex = vertex;
    }
  
    Edge edge1 = new Edge(10, "A");
    Edge edge2 = new Edge(12, "A");
    Edge edge3 = new Edge(13, "A");
    Edge[] edges = new Edge[]{edge1, edge2, edge3};
    Arrays.sort(edges);
}
```

### Comparable과 Comparator 인터페이스
- Comparable과 Comparator는 둘 다 인터페이스로, 정렬 기준을 구현하기 위해 사용됨
  - Comparable 인터페이스는 compareTo() 메서드를 override해서 구현
    - 일반저긍로는 정렬할 객체에 implements로 Comparable 인터페이스를 추가하여 구현
  - Comparator 인터페이스는 compare() 메서드를 override 해서 구현
    - 일반적으로는 별도 클래스를 정의해서 구현하며, 따라서, 동일 객체에 다양한 정렬 기준을 가진 클래스를 작성 가능

## Arrays.sort() 와 Comparator
- 다음 예와 같이 Arrays.sort() 메서드는 인자를 두 개 받아서, 두 번째 인자에 Comparator 클래스를 넣어줄 수도 있음
  - Edge 객체에 Comparable 인터페이스가 정의되어 있다 하더라도, Comparator 클래스의 정렬 기준으로 정렬이 됨

## 탐욕 알고리즘의 한계
- 탐욕 알고리즘은 근사치 추정에 활용
- 반드시 최적의 해에 가까운 값을 구하는 방법 중에 하나임

예)
```
        시작
        / \
       7  10
      / \ /\
    12 15 5 7
```
- '시작'노드에서 시작해서 가장 작은 값을 찾아 leaf node까지 가는 경로를 찾을 시에
  - Greedy 알고리즘 적용시 : 7 -> 12 : 19
  - 실제 가장 작은 값 : 10 -> 5 : 15
