# 페이지 교체 정책 (page replacement policy)
- 운영체제가 특정 페이지를 물리 메모리에 올리려 하는데, 물리 메모리가 다 차있다면?
    - 기존 페이지 중 하나의 물리 메모리에서 저장 매체로 내리고 (저장)
    - 새로운 페이지를 해당 물리 메모리 공간에 올린다.
> 어떤 페이지를 물리 메모리에서, 저장 매체로 내릴 것인가?<br>
> -> Page Replacement(Swapping) Algorithm

## 페이지 교체 알고리즘 (FIFO)
- FIFO Page Replacement Algorithm
    - 가장 먼저 들어온 페이지를 내리자

## 페이지 교체 알고리즘 (OPT)
- 최적 페이지 교체 알고리즘 (OPTimal Replacement Algorithm)
    - 앞으로 가장 오랫동안 사용하지 않을 페이지를 내리자
    - 일반 OS 에서는 구현 불가
  
## 페이지 교체 알고리즘 (LRU)
- LRU(Least Recently Used) Page Replacement Algorithm
    - 가장 오래 전에 사용된 페이지를 교체
    - OPT 교체 알고리즘이 구현이 불가하므로, 과거 기록을 기반으로 시도
  
## 페이지 교체 알고리즘 (LFU)
- LFU(Least Frequently Used) Page Replacement Algorithm
    - 가장 적게 사용된 페이지를 내리자

## 페이지 교체 알고리즘 (NUR)
- NUR(Not Used Recently) Page Replacement Algorithm
    - LRU와 마찬가지로 최근에 사용하지 않은 페이지부터 교체하는 기법
    - 각 페이지마다 참조 비트 (R), 수정 비트 (M)을 둠 (R, M)
      - (0, 0), (0, 1), (1, 0), (1, 1) 순으로 페이지 교체

## 스레싱 (Thrashing)
- 반복적으로 페이지 폴트가 발생해서, 과도하게 페이지 교체 작업이 일어나, 실제로는 아무일도 하지 못하는 상황

