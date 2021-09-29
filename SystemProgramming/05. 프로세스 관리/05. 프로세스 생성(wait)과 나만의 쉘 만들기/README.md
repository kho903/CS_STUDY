# 프로세스 생성(wait)과 나만의 쉘 만들기
## fork() 와 exec()
- 리눅스 프로세스 실행
    1. 부모 프로세스로부터 새로운 프로세스 공간을 만들고 부모 프로세스 데이터 복사 (fork)
    2. 새로운 프로세스를 위한 바이너리를 새로운 프로세스 공간에 덮어 씌움 (exec)

## wait() 시스템 콜
- wait() 함수를 이용하면, fork() 함수 호출 시, 자식 프로세스가 종료할 때까지, 부모 프로세스가 기다림
- 자식 프로세스와 부모 프로세스의 동기화, 부모 프로세스가 자식 프로세스보다 먼저 죽는 경우를 막기 위해 사용 (고아 프로세스, 좀비 프로세스)

## fork(), execl(), wait() 시스템 콜
```C
int main() {
    int pid;
    int child_pid;
    int status;
    pid = fork(); // 새로운 프로세스 공간 (based on 부모 프로세스)
    switch(pid) {
        case -1:
            perror("fork is failed\n");
        case 0: // 자식 프로세스
            execl("/bin/ls", "ls", "-al", NULL);
            perror("execl is failed\n");
        default: // 부모 프로세스
            child_pid = wait(NULL);
            printf("ls is complete\n");
            printf("Parent PID (%d), Child PID (%d)\n", getpid(), child_pid);
            exit(0);
    }
}
```
- execl()만 사용하면, 부모 프로세스가 사라짐
- 이를 유지하기 위해, fork()로 새로운 프로세스 공간 복사 후, execl() 사용
- wait() 함수를 사용해서 부모 프로세스가 자식 프로세스가 끝날 때까지 기다릴 수 있음
> 쉘 프로그램은 fork(), exec() 계열, wait() 함수를 기반으로 작성 가능

### myShell
```C
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/types.h>
#define MAXLINE 64

int main(int argc, char **argv) {
    char buf[MAXLINE];
    int proc_status;
    pid_t pid;
    printf("MyShell ver 0.01\n");
    while (1)
    {
        memset(buf, 0x00, MAXLINE);
        fgets(buf, MAXLINE - 1, stdin);
        // char *fgets(char *string, int n, FILE *stream);
        if (strcmp(buf, "exit\n", 5) == 0) {
            break;
        }
        buf[strlen(buf) - 1] = 0x00;

        pid = fork();
        if (pid == 0) {
            // if (execl(buf, buf, NULL) == -1)
            if (execlp(buf, buf, NULL) == -1) {
                printf("command execution is failed\n");
                exit(0);
            }
        }
        if (pid > 0) {
            wait(NULL);
        }
    }
}
```