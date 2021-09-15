# 세마포어
## 동기화(Synchronization) 이슈
- 동기화 : 작업들 사이에 실행 시기를 맞추는 것
- 여러 스레드가 동일한 자원(데이터) 접근시 동기화 이슈 발생
    - 동일 자원을 여러 스레드가 동시 수정시, 각 스레드 결과에 영향을 줌

## 동기화 이슈 해결 방안
- Mutual exclusion (상호 배제)
- 쓰레드는 프로세스 모든 데이터를 접근할 수 있으므로,
    - 여러 쓰레드가 변경하는 공유 변수에 대해 Exclusive Access 필요
    - 어느 한 쓰레드가 공유 변수를 갱신하는 동안 다른 쓰레드가 동시 접근하지 못하도록 막아라

## Mutual exclusion (상호 배제)
- 임계 자원 (critical resource)
- 임계 영역 (critical section)
```python
lock.acquire()
for i in range(100000):
    g_count += 1
lock.release()
```

## Mutex와 세마포어 (Semaphore)
- Critical Section(임계구역)에 대한 접근을 막기 위해 LOCKING 매커니즘이 필요
    - Mutex(binary semaphore)
        - 임계구역에 하나의 쓰레드만 들어갈 수 있음
    - Semaphore
        - 임계구역에 여러 쓰레드가 들어갈 수 있음
        - counter를 두어서 동시에 리소스에 접근할 수 있는 허용 가능한 쓰레드 수를 제어

## 세마포어 (Semaphore)
- P : 검사 (임계 영역에 들어갈 때) - lock.acquire()
    - S 값이 1 이상이면, 임계 영역 진입 후, S값 1 차감 (S값이 0이면 대기)
- V : 증가 (임계 영역에서 나올 때) - lock.release()
    - S 값을 1 더하고, 임계 영역을 나옴
- S : 세마포어 값 (초기 값만큼 여러 프로세스가 동시에 임계 영역 접근 가능)
```
P(S): wait(S) {
            while S <= 0 // 대기
            ;
        S--;    // 다른 프로세스 접근 제한
      }
```
```
V(S): signal(S) {
        S++;    // 다른 프로세스 접근 허용
      }
```

## 세마포어 (Semaphore) - 바쁜 대기
- wait()은 S가 0이라면, 임계영역에 들어가기 위해, 반복문 수행
    - 바쁜 대기, busy waiting
```
P(S): wait(S) {
            while S <= 0 // 바쁜 대기
            ;
        S--;    // 다른 프로세스 접근 제한
      }
```

## 참고
- 프로그래밍은 근본적으로는 중단이 없음. 끊임없이 코드 실행
    - 중단은 대부분 loop로 표현
    - loop는 CPU에 부하를 걸리게 함

## 세마포어 (Semaphore) - 대기큐
> 운영체제 기술로 보완 - 대기큐
- S가 음수일 경우, 바쁜 대기 대신, 대기큐에 넣는다.
```
wait(S) {
    S->count--;
    if (S->count < 0) {
        add this process to S->queue;
        block()
    }
}
```
- wakeup() 함수를 통해 대기큐에 있는 프로세스 재실행
```
signal(S) {
        S->count++;
    if (S->count <= 0) {
        remove a process P from S->queue;
        wakeup(P);
    }
}
```

## 참고 : 주요 세마포어 함수 (POSIX 세마포어)
- sem_open() : 세마포어를 생성
- sem_wait() : 임계영역 접근 전, 세마포어를 잠그고, 세마포어가 잠겨 있다면, 풀릴 때까지 대기
- sem_post() : 공유자원에 대한 접근이 끝났을 때 세마포어 잠금을 해제한다.
