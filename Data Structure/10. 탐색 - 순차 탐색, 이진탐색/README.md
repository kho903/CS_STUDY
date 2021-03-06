# 순차 탐색과 이진 탐색
## 순차 탐색 (Sequential Search)
- 순차 탐색은 특정한 원소를 찾기 위해 원소를 순차적으로 하나씩 탐색하는 방법이다.
- 순차 탐색은 데이터 정렬 유무에 관계 없이 가장 앞에 있는 원소부터 하나씩 확인해야 한다는 점에서 O(N)의 시간 복잡도를 가진다.

## 이진 탐색 (Binary Search)
- 이진 탐색은 배열 내부 데이터가 이미 정렬 되어 있는 상황에서 사용 가능한 알고리즘이다. 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 특징이 있다.
- MID위치에 있는 원소와 반복적으로 비교
- 이진 탐색은 한 번 확인할 때마다 보아야 하는 원소의 개수가 절반씩 줄어든다는 점에서 탐색 시간에서 O(log N)의 시간 복잡도를 가진다.
