# 스케쥴링 알고리즘
- 프로세스 상태와 스케쥴링

## 멀티 프로그래밍과 Wait
- 멀티 프로그래밍 : CPU 활용도를 극대화하는 스케쥴링 알고리즘
- Wait : 간단히 저장매체로부터 파일 읽기를 기다리는 시간으로 가정

## 프로세스 상태
- 프로세스 생성(new) -> 실행 가능(ready) <=> 실행중(running) -> 종료(exit)
    - 실행중 -> 대기 (blocked) -> 실행가능

- running state : 현재 CPU에서 실행 상태
- ready state : CPU에서 실행 가능 상태 (실행 대기 상태)
- block state : 특정 이벤트 발생 대기 상태 (예: 프린팅이 다 되었다.) 

## 프로세스 상태간 관계
- ready, running, block states
1. Running -> Block : Process blocks for input (특정 이벤트 대기)
2. Block -> Ready : Process becomes available
3. Ready -> Running : Scheduler picks another process (Ready 상태의 프로세스를 선택)
4. Running -> Ready : Scheduler picks this process

