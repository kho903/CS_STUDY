# 탐색 알고리즘 : 이진 탐색(Binary Search)
## 이진 탐색 (Binary Search) 이란?
- 탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법

## 분할 정복 알고리즘과 이진 탐색
- 분할 정복 알고리즘 (Divide and Conquer)
    - Divide : 문제를 하나 또는 둘 이상으로 나눈다.
    - Conquer : 나눠진 문제가 충분히 작고, 해결이 가능하다면 해결하고, 그렇지 않다면 다시 나눈다.
- 이진 탐색
    - Divide : 리스트를 두 개의 서브 리스트로 나눈다.
    - Conquer
        - 검색할 숫자 (search) > 중간값이면, 뒷 부분의 서브 리스트에서 검색할 숫자를 찾는다.
        - 검색할 숫자 (search) < 중간값이면, 앞 부분의 서브 리스트에서 검색할 숫자를 찾는다.

## 어떻게 코드로 만들까?
- 이진 탐색은 데이터가 정렬되 있는 상태에서 진행
- 데이터가 {2, 3, 8, 12, 20} 일 때
    - searchFunc(data_list, find_data) 함수를 만들고
        - searchItem 찾는 숫자
        - dataList는 데이터 배열
        - dataList의 중간에 위치한 값을 searchItem 비교해서
            - searchItem < dataList 중간값이라면
                - 맨 앞부터 dataList의 중간까지에서 다시 searchItem 찾기
            - dataList의 중간값 < searchItem 이라면
                - dataList의 중간부터 맨 끝까지에서 다시 searchItem 찾기
            - 그렇지 않다면, dataList의 중간값은 searchItem인 경우로, return dataList 중간위치

## 알고리즘 분석
- n개의 리스트를 매번 2로 나누어 1이 될 때까지 비교연산을 k회 진행
- n * 1/2 * 1/2 * .... = 1
- n * (1/2)<sup>k</sup> = 1
- n = 2<sup>k</sup> = log<sub>2</sub>n = log<sub>2</sub>2<sup>k</sup>
- log<sub>2</sub>n = k
- 빅 오 표기법으로는 k + 1이 결국 최종 시간 복잡도임 (1이 되었을 때도, 비교연산을 한 번 수행)
    - 결굴 O(log<sub>2</sub> n + 1)이고, 2와 1, 상수는 삭제되므로 O(log n)