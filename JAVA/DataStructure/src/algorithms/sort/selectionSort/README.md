# 대표적인 정렬 : 선택 정렬 (selection sort)
## 선택 정렬 (selection sort) 란?
- 다음과 같은 순서를 반복하며 정렬하는 알고리즘
1. 주어진 데이터 중, 최솟값을 찾음
2. 해당 최솟 값을 데이터 맨 앞에 위치한 값과 교체함
3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함

## 어떻게 코드로 만들까?
> 간단히 로직에 집중해서, 각각 데이터가 저장되어 있는 배열이 있다고 가정한다면
- 데이터가 두 개 일때
    - 예) dataList = {9, 1}
        - dataList[0] > dataList[1] 이르모 dataList[0] 값과 dataList[1] 값을 교환
  - 데이터가 세 개 일때
    - 예) dataList = {9, 1, 7}
        - 처음 한 번 실행하면 {1, 9, 7}
        - 두 번째 실행하면 {1, 7, 9}
  - 데이터가 네 개 일떄
    - 예) dataList = {9, 3, 2, 1}
        - 처음 한 번 실행하면 {1, 3, 2, 9}
        - 두 번째 실행하면 {1, 2, 3, 9}
        - 세 번째 실행하면 변화 없음

# 알고리즘 구현
1. for (int stand = 0; stand < dataList.size() - 1; stand++) 로 반복
2. lowest = stand 로 놓고
3. for (int index = strand + 1; index < dataList.size(); index++)로 stand 이후부터 반복
    - 내부 반복문 안에서 dataList[lowest] > dataList[index] 이면,
        - lowest = num
4. dataList[lowest] 와 dataList[index] 스왑

- 반복문이 두 개 O(n<sup>2</sup>)
    - 실제로 상세하게 계산하면, n * (n - 1) / 2
