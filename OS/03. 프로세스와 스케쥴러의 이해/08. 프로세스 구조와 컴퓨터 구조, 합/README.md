# 프로세스와 컨텍스트 스위칭
- 프로세스(process)는 일반적으로 어떻게 구성되어 있을까?
    - text(CODE) : 코드
    - data : 변수 / 초기화된 데이터
    - stack : 임시 데이터 (함수 호출, 로컬 변수 등)
    - heap : 코드에서 동적으로 만들어지는 데이터

## 컴퓨터 구조 복습
- PC(Program Counter) + SP(Stack Pointer)

## 프로세스 구조: Stack, HEAP, DATA(BSS, DATA), TEXT(CODE)
> DATA를 BSS와 DATA로 분리
- Stack
- heap
- data
  - BSS : 초기화되지 않은 전역 변수
  - DATA : 초기값이 있는 전역 변수
- code (TEXT)

