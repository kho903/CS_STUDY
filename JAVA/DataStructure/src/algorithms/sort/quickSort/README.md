# 대표적인 정렬 : 퀵 정렬 (quick sort)
## 퀵 정렬(quick sort) 이란?
- 정렬 알고리즘의 꽃
- 기준점(pivot이라고 부름)을 정해서, 기준점보다 작은 데이터는 왼쪽(left), 큰 데이터는 오른쪽(right)으로 모으는 함수를 작성함
- 각 왼쪽(left), 오른쪽(right)은 재귀용법을 사용해서 다시 동일 함수를 호출하여 위 작업을 반복함
- 함수는 왼쪽(left) + 기준점(pivot) + 오른쪽(right)을 리턴함

### 참고
- 배열은 ArrayList로 변환하기
    - Arrays.asList() 메서드에 넣어주면, ArrayList에서 사용할 수 있음
        - int[] array = {4, 1, 2, 5, 7};
        - ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));

## 알고리즘 분석
- 병합 정렬과 유사, 시간복잡도는 O(n log n)
    - 단, 최악의 경우
        - 이미 정렬된 배열에서 pivot이 가장 크거나, 가장 작으면 가장 큰 시간이 소요됨
        - 모든 데이터를 비교하는 상황이 나옴
        - O(n<sup>2</sup>)