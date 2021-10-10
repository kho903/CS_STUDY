# 최단 경로 알고리즘의 이해
## 1. 최단 경로 문제란?
- 최단 경로 문제란 두 노드를 잇는 가장 짧은 경로를 찾는 문제임
- 가중치 그래프 (Weighted Graph) 에서 간선 (Edge)의 가중치 합이 최소가 되도록 하는 경로를 찾는 것이 목적

### 최단 경로 문제 종류
1. 단일 출발 (single-source) 최단 경로 문제
    - 그래프 내의 특정 노드 u에서 출발하여, 그래프 내의 모든 다른 노드에 도착하는 가장 짧은 경로를 찾는 문제
2. 단일 도착 (single-destination) 최단 경로 문제
    - 모든 노드들로부터 출발해서, 그래프 내의 특정 노드 u로 도착하는 가장 짧은 경로를 찾는 문제
3. 단일 쌍 (single-pair) 최단 경로 문제
    - 주어진 노드 u와 v간의 최단 경로를 찾는 문제
4. 전체 쌍(all-pair) 최단 경로 : 그래프 내의 모든 노드 쌍 (u, v) 사이에 대한 최단 경로를 찾는 문제

## 2. 최단 경로 알고리즘 - 다익스트라 알고리즘
- 다익스트라 알고리즘은 위의 최단 경로 문제 종류 중, 1번에 해당
    - 하나의 정점에서 다른 모든 정점에 도착하는 가장 짧은 거리를 구하는 문제

### 다익스트라 알고리즘 로직
- 첫 정점을 기준으로 연결되어 있는 정점들을 추가해 가며, 최단 거리를 갱신하는 기법
- 다익스트라 알고리즘은 너비우선탐색(BFS)와 유사
    - 첫 정점부터 각 노드간의 거리를 저장하는 배열을 만든 후, 첫 정점의 인접 노드 간의 거리부터 먼저 계산하면서, 첫 정점부터
    해당 노드간의 가장 짧은 거리를 해당 배열에 업데이트
    > 다익스트라 알고리즘의 다양한 변형 로직이 있지만, 가장 개선된
    > 우선순위 큐를 사용하는 방식에 집중
- 우선순위 큐를 활용한 다익스트라 알고리즘
    - 우선순위 큐는 MinHeap 방식을 활용해서, 현재 가장 짧은 거리를 가진 노드 정보를 먼저 꺼내게 됨
    1. 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지의 거리를 저장
        - 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장함 (inf 라고 표현함)
        - 우선순위 큐에 (첫 정점, 거리 0)만 먼저 넣음
    2. 우선순위 큐에서 노드를 꺼냄
        - 처음에는 첫 정점만 저장되어 있으므로, 첫 정점이 꺼내짐
        - 첫 정점에 인접한 노드들 각각에 대해, 첫 정점에서 각 노드로 가는 거리와 현제 배열에 저장되어 있는 첫 정점에서
        각 정점까지의 거리를 비교한다.
        - 배열에 저장되어 있는 거리보다, 첫 정점에서 해당 노드로 가는 거리가 더 짧을 경우,
        배열에 해당 노드의 거리를 업데이트 한다.
        - 배열에 해당 노드의 거리가 업데이트된 경우, 우선순위 큐에 넣는다.
            - 결과적으로 너비 우선 탐색 방식과 유사하게, 첫 정점에 인접한 노드들을 순차적으로 방문하게 됨
            - 만약 배열에 기록된 현재까지 발견된 가장 짧은 거리보다, 더 긴 거리(루트)를 가진 (노드, 거리)의 경우에는
            해당 노드와 인접한 노드간의 거리 계산을 하지 않음
    3. 2번의 과정을 우선순위 큐에 꺼낼 노드가 없을 때까지 반복한다.

### 구현을 위해 참고해야하는 JAVA 문법
### 참고 : PriorityQueue와 정렬
- 내부적으로 정렬 기능 수행
- 따라서 PriorityQueue에 넣어지는 특별한 형태의 객체인 경우, 객체간의 정렬을 위한 기준을 정의해야 함
- PriorityQueue에서 내부적으로 정렬 기능을 사용할 때는, 해당 객체의 Comparable 인터페이스의 compareTo() 메서드를 호출하므로,
- 객체간 정렬 기준을 정의하기 위해, Comparable 인터페이스의 compareTo() 메서드를 정의해줘야 함

```java
public class Edge implements Comparable<Edge> {
    public int distance;
    public String vertex;

    public Edge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString() {
        return "vertex : " + this.vertex + ", distance : " + this.distance;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.distance - edge.distance;
    }
}
```

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();

        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "A"));
        priorityQueue.offer(new Edge(1, "C"));
        priorityQueue.offer(new Edge(7, "D"));

        System.out.println(priorityQueue);
    }
}

```

### 다익스트라 알고리즘 코드

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
    }
}
```

### 참고 : HashMap에 들어있는 모든 key 가져오기
```java
public class Main {
    public static void main(String[] args) {
        for (String key : graph.keySet()) {
            System.out.println(key);
            System.out.println(graph.get(key));
        }
    }
}
```

### 참고 : HashMap에서 각 키에 해당하는 값, 즉 ArrayList의 모든 Edge 객체 추출하기
```java
public class Main {
    public static void main(String[] args) {
        ArrayList<Edge> nodeList = graph.get("A");
        for (int i = 0; i < nodeList.size(); i++) {
            System.out.println(nodeList.get(i));
        }
    }
}
```

## 1단계 구현 : 초기화
- 첫 정점을 기준으로 배열을 선언하여 첫 정점에서 각 정점까지의 거리를 저장
    - 초기에는 첫 정점의 거리는 0, 나머지는 무한대로 저장함 (inf 라고 표현함)
    - 우선순위 큐에 (첫 정점, 거리 0)만 먼저 넣음

### 2단계 : 우선순위 큐에서 추출한 (A, 0) [노드, 첫 노드와의 거리]를 기반으로 인접한 노드와의 거리 계산
```java
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class DijkstraPath {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(distances.get(start), start));
        
        // 알고리즘 작성
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;
            
            if (distances.get(currentNode) < currentDistance) {
                continue;
            }
            
            nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;
                
                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }
}
```
### 3단계 : 그래프 정의 및 실행
```java
public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
        
        DijkstraPath dObject = new DijkstraPath();
        dObject.dijkstraFunc(graph, "A");
        // {A=0, B=6, C=1, D=2, E=5, F=6}

    }
}
```

## 6. 시간 복잡도
- 위 다익스트라 알고리즘은 크게 다음 두 가지 과정을 거침
    - 과정 1 : 각 노드마다 인접한 간선들을 모두 검사하는 과정
    - 과정 2 : 우선순위 큐에 노드 / 거리 정보를 넣고 삭제(pop)하는 과정
- 각 과정 별 시간 복잡도
    - 과정 1 : 각 노드는 최대 한 번씩 방문하므로 (첫 노드와 해당 노드간의 갈 수 있는 루트가 있는 경우에만 해당),
      그래프의 모든 간선은 최대 한 번 씩 검사 
        - 즉, 각 노드마다 인접한 간선드을 모두 검사하는 과정은 O(E) (E는 간선 Edge의 약자)
    - 과정 2 : 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 경우, 우선순위 큐에 노드 / 거리 정보를 넣고,
      삭제하는 과정이 최악의 시간이 걸림
        - 우선순위 큐에 가장 많은 노드, 거리 정보가 들어가는 시나리오는 그래프의 모든 간선이 검사될 때마다,
          배열의 최단 거리가 갱신되고, 우선순위 큐에 노드 / 거리가 추가되는 것임
        - 이 때 추가는 각 간선마다 최대 한 번 일어날 수 있으므로, 최대 O(E)의 시간이 걸리고,
          O(E) 개의 노드 / 거리 정보에 대해 우선순위 큐를 유지하는 작업은 O(log E)가 걸림
            - 따라서 해당 과정의 시간 복잡도는 O(Elog E)
### 총 시간 복잡도
- 과정 1 + 과정 2 = O(E) + O(ElogE) = O(ElogE)

### 참고 : 힙의 시간 복잡도
- depth(트리의 높이)를 h라고 표기한다면
- n개의 노드를 가지는 heap에 데이터 삽입 또는 삭제 시, 최악의 경우 root 노드에서 leaf노드 까지
비교해야 하므로 h = log2n에 가까우므로, 시간 복잡도는 O(log n)
