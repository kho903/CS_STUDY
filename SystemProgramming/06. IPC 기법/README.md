# 다양한 IPC 기법
- IPC : InterProcess Communication
1. file 사용
2. Message Queue
3. Shared Memory
4. Pipe
5. Signal
6. Semaphore
7. Socket<br>
...

## 파이프(pipe)
- 기본 파이프는 단방향 통신
- fork()로 자식 프로세스 만들었을 때, 부모와 자식간의 통신

## 메시지 큐(message queue)
- 큐니까, 기본은 FIFO 정책으로 데이터 전송

### 메시지 큐 코드 예제
`msgid = msgget(key, msgflg); // key는 1234, msgflg는 옵션`
- msgflg 설정
    - IPC_CREAT : 새로운 키면 식별자를 새로 생성, IPC_CREAT|접근권한
    - 예: IPC_CREAT|0644 -> rw-r--r--
`msgsnd(msqid, &sbuf, buf_length, IPC_NOWAIT);`
- msgflg 설정 : 블록 모드(O) / 비블록 모드 (IPC_NOWAIT)

### 메시지큐 전송 프로그램 일부 코드 예
```C
msgid = msgget(1234, IPC_CREAT|0644); // keysms 1234, msgflg는 옵션
msgsnd(msqid, &sbuf, buf_length, IPC_NOWAIT);
```

### 메시지 큐 코드 예제
```C
ssize_t msgrcv(int msqid, void *msgp, size_t msgsz, long msgtyp, int msgflg);
msgrcv(msqid, &rbuf, MSGSZ, 1, 0) // msgrcv 예
```
- msgtyp 설정 : 0이면 첫 번째 메세지, 양수이면 타입이 일치하는 첫번째 메세지
- msgflg 설정 : 블록 모드(0) / 비블록 모드(IPC_NOWAIT)

### 메시지 큐 수신 프로그램 일부 코드 예
```C
msqid = msgget(1234, IPC_CREAT|0644) // key는 동일하게 1234로 해야 해당 큐의 msgid를 얻을 수 있다.
msgrcv(msqid, &rbuf, MSGSZ, 1, 0)
```

## 참고 : ftok()
- ftok() : 키 생성을 위한 함수
    - path 경로명의 inode 값과 숫자값(id)를 기반으로 키 생성
    - 경로 삭제 후 재생성시 inode 값이 달라지므로, 이전과는 다른 키 값이 리턴

```C
#include <sys/ipc.h>

key_t ftok(const char *path, int id);

// 예)
key = ftok("keyfile", 1);
id = msgget(key, IPC_CREAT|0640);
```