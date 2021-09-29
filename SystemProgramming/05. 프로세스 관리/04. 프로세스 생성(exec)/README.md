# 프로세스 생성 (exec)
## exec() 시스템 콜
- exec() 시스템 콜을 호출한 현재 프로세스 공간의 TEXT, DATA, BSS 영역을 새로운 프로세스의 이미지로 덮어 씌움
    - 별도의 프로세스 공간을 만들지 않음

## exec() 시스템 콜 family
```
헤더 파일 : <unistd.h>
함수 원형 :
int execl(const char *path, const char *arg, ...);
int execlp(const char *file, const char *arg, ...);
int execle(const char *path, const char *arg, ..., char *const envp[]);
int execlv(const char *path, const *char *arg[]);
int execlvp(const char *file, const *char *arg[]); 
int execlvpe(const char *file, const *char *arg[], char *const envp[]);
```

## execl() 시스템 콜 예
```C
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("execute ls\n");
    execl("/bin/ls", "ls", "-l", NULL);
    perror("execl is failed\n");
    exit(1);
}
```

## execl()와 execlp() 시스템 콜 사용법
`execl("디렉토리와 파일 이름이 합친 전체 이름", "명령어 인수 리스트", "끝은 NULL로 끝나야 함");`
```
// 파일 이름을 해당 프로세스를 실행한 프로세스의 환경변수(path)를 검색함
execp("파일 이름", "명령어 인수 리스트", "끝은 NUL로 끝나야 함");
```
- 명령어 인수 리스트
    - argv[0] = "ls"
    - argv[1] = "-al"
`$ ls -al`
`execl("/bin/ls", "ls", "-al", NULL);`
`execlp("ls", "ls", "-al", NULL);`

## execle() 시스템 콜 사용법
```C
// 환경 변수를 지정하고자 할 때,
char *envp[] = {"USER=kim", "PATH=/bin", (char *)0};
execle("ls", "ls", "-al", NULL, envp);
```

## execv(), execvp(), execve() 시스템 콜 사용법
```C
// 인수 리스트를 내용으로 하는 문자열 배열
char *arg[] = {"ls", "-al", NULL};
execv("/bin/ls", arg);
```

```C
// 파일 이름을 해당 프로세스를 실행한 프로세스의 환경변수(path)를 검색함
// 인수 리스트를 내용으로 하는 문자열 배열
char *arg[] = {"ls", "-al", NULL};
execvp("ls", arg);
```

```C
// 환경 변수를 지정하고자 할 때
char *envp[] = { "USER=KIM", "PATH=/bin", (char *)0 };
// 인수 리스트를 내용으로 하는 문자열 배열
char *arg[] = {"ls", "-al", NULL};
execve("ls", arg, envp);
```

- execlp() -> argv 생성 -> execvp()
    - 파일 이름만 넘겨주면 프로세스 환경변수(path)에서 파일명(실행파일) 검색
- execl() -> argv 생성 -> execv()
    - 파일명을 전체경로 포함 넘겨줌
- execle() -> argv 생성 -> execv()
    - 환경변수(PATH 포함 가능)를 별도로 정의해서 넘겨주어야 함.

## execl() 시스템 콜 예
- execl() 시스템 콜을 실행시킨 프로세스 공간에 새로운 프로세스 이미지를 덮어 씌우고, 새로운 프로세스를 실행
- perror() 함수가 호출된다는 의미는 새로운 프로세스 이미지로 덮어씌우는 작업이 실행되지 못했다는 의미
    - 즉, execl() 시스템 콜 실행 실패
