# 대표적인 정렬 : 병합 정렬 (merge sort)
## 병합 정렬 (merge sort)
- 재귀 용법을 활용한 정렬 알고리즘
1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
2. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
3. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.

## 알고리즘 이해
- 데이터가 네 개 일때
- 두 단계로 분리해서 이해할 수 있음
    - 1단계 : 정렬되지 않은 배열을 끝까지 분리하는 단계
    - 2단계 : 분리한 데이터를 단계별로 합치는 단계
- 예: dataList = [1, 9, 3, 2]
    - 먼저 [1, 9], [3, 2]로 나누고
    - 다시 앞 부분은 [1],[9]로 나누고 (여기까지 1단계)
    - 다시 정렬해서 합친다. [1, 9] (이 부분부터 2단계)
    - 다음 [3, 2]는 [3], [2]로 나누고
    - 다시 정렬해서 합친다 [2, 3]
    - 이제 [1, 9]와 [2, 3]을 합친다.
        - 두 배열의 맨 앞에 위치한 데이터부터, 각각 비교하며, 정렬된 합쳐진 배열을 작성한다.
            - 1 < 2 이니 [1]
            - 9 > 2 이니 [1, 2]
            - 9 > 3 이니 [1, 2, 3]
            - 9밖에 없으니 [1, 2, 3, 9]

## mergeSplitFunc 메서드 틀 만들기 (재귀용법 틀 만들기)
- 만약 배열 갯수가 한 개이면 해당 값 리턴
- 그렇지 않으면, 배열을 앞 뒤, 두 개로 나누기
- leftArr = mergeSplitFunc(앞)
- rightArr = mergeSplitFunc(뒤)
- return mergeFunc(leftArr, rightArr) 라는 아직 정의되지 않은 메서드 호출하여 리턴하기
    > mergeFunc() 메서드가 leftArr과 rightArr을 합쳐서 정렬한 배열을 리턴한다고 가정하면
      leftArr과 rightArr은 이미 정렬된 배열임을 알 수 있음

## mergeFunc 메서드 만들기
- 목표 : leftList와 rightList의 배열 데이터를 정렬하며 합쳐서, mergedList라는 이름으로 return 하기
- leftList와 rightList는 이미 정렬된 상태 또는 데이터가 하나임
- ArrayList 만들기
- leftPoint, rightPoint = 0
- CASE1 : leftList, rightList 둘 다 있을때
    - while (leftList.size() > leftPoint && rightList.size() > rightPoint)
        - 만약 leftPoint나 rightPoint가 이미 leftList 또는 rightList 배열을 다 순회했다면, 그 반대쪽 데이터를 그대로 넣고, 해당 인덳그 1 증가
        - if (leftList.get(leftPoint) > rightList.get(rightPoint))
            - mergedList.add(rightList.get(rightPoint));
            - rightPoint += 1;
        - else
            - mergedList.add(leftList.get(leftPoint));
            - leftPoint += 1;
- CASE2 : RightList만 없을 때 : 나머지 leftList에 있는 데이터 그대로 mergedList 뒤에 넣음
- CASE3 : LeftList만 없을 때 : 나머지 rightList에 있는 그대로 mergedList 뒤에 넣음

## 알고리즘 분석
- 몇 단계 깊이까지 만들어지는 지를 depth라고 하고 i로 놓자. 맨 위 단계는 0으로 놓자.
    - 각 단계에 있는 하나의 노드 안의 배열 길이는 n / 2<sup>i</sup>이된다.
    - 각 단계에는 2<sup>i</sup> 개의 노드가 있다.
- 각 단계의 각 노드 안의 배열 데이터는 한 번씩은 체크되므로, 각 단계는 각각 2<sup>i</sup> * n / 2<sup>i</sup> = O(n) 시간복잡도를 가짐
- 단계는 항상 log<sub>2</sub>n개 만큼 만들어짐. 시간 복잡도는 결국 O(log n), 2는 역시 상수이므로 삭제
- 따라서, 단계별 시간 복잡도 O(n) * O(log n) = O(n log n)
