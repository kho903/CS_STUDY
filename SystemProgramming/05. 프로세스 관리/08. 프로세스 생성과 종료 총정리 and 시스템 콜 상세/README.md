# 프로세스 생성과 종료
## wait() 시스템 콜
- wait() 함수를 사용하면, fork() 함수 호출 시, 자식 프로세스가 종료할 때까지, 부모 프로세스가 기다림
- 자식 프로세스가 종료되면, 좀비 프로세스가 되어, 해당 프로세스 조사를 위한 최소 정보만 가지고 있는 상태가 됨
- 완전히 끝나면, 해당 정보도 삭제되고, 부모 프로세스에 SIGCHLD 시그널이 보내짐

- wait() 리턴 값
    - 에러가 발생한 경우
```C
#include <sys/wait.h>
pid_t wait(int *status)
// 리턴 값은 종료된 자식 프로세스의 pid
```
- status 정보를 통해 기본적인 자식 프로세스 관련 정보를 확인할 수 있음
- 예
```C
int WIFEXITED(status);
// 자식 프로세스가 정상 종료 시 리턴 값은 0이 아닌 값이 됨
```

```C
int main() {
    int pid;
    int child_pid;
    int status;
    pid = fork();
    switch(pid) {
        case -1:
            perror("fork is failed\n");
        case 0:
            execl("/bin/ls", "ls", "-al", NULL);
            perror("execl is failed\n");
            break;
        default:
            child_pid = wait(&status);
            if (WIFEXITED(status)) {
                printf("Child process is normally terminated\n");
            }
            exit(0);
    }
}
```