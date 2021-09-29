# 프로세스 생성 (fork)
## 프로세스 기본 구조
- TEXT, DATA, BSS, HEAP, STACK
- TEXT
    - CPU에서 직접 수행되는 명령어를 가진다. Code 영역이라고도 한다. 코드 자체를 구성하는 메모리 영역으로 Hex 파일이나 Bin 파일 메모리
- DATA
    - 전역변수가 속함. 그 외에 프로그램이 실행될 때 생성되고 프로그램이 종료되면 시스템에 반환되며 정적변수, 배열, 구조체 등이 저장되는 곳. 이 때 초기화 된 데이터에는 data 영역에 저장되고, 초기화되지 않은 데이터는 BSS(Block Stated Symbol) 영역에 저장된다.
- HEAP
    - 동적으로 할당받은 내용을 가진다. 동적 데이터 영역이라고도 부른다. 메모리 주소 값에 의해서만 참조되고 사용되는 영역
- STACK
    - 지역변수와 인자, 그리고 함수의 리턴 주소를 가진다. 함수를 호출 시에 생성이 되고, 함수가 끝나면 반환이 된다.


## 프로세스 생성
- 기본 프로세스 생성 과정
    1. TEXT, DATA, BSS, HEAP, STACK의 공간을 생성
    2. 프로세스 이미지를 해당 공간에 업로드하고, 실행 시작
- 프로세스 계층 : 다른 프로세스는 또다른 프로세스로부터 생성
    - 부모 프로세스, 자식 프로세스

## fork()와 exec() 시스템 콜
- fork() 시스템 콜 (복사)
    - 새로운 프로세스 공간을 별도로 만들고, fork() 시스템을 호출한 프로세스(부모 프로세스) 공간을 모두 복사
        - 별도의 프로세스 공간을 만들고, 부모 프로세스 공간의 데이터를 그대로 복사
- exec() 시스템 콜 (덮어씌움)
    - exec() 시스템 콜을 호출한 현재 프로세스 공간의 TEXT, DATA, BSS 영역을 새로운 프로세스의 이미지로 덮어씌움
        - 별도의 프로세스 공간을 만들지 않음

## fork() 시스템콜
- 헤더 파일 : <unistd.h>
- 함수 원형 : pid_t fork(void);
```C
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main()
{
    pid_t pid;
    printf("Before fork() call\n");
    pid = fork();

    if (pid == 0)
        printf("This is Child process. PID is %d\n", pid);
    else if (pid > 0)
        printf("This is Parent process. PID is %d\n", pid);
    else
        printf("fork() is failed\n");
    return 0;
}
```

## fork() 시스템 콜 정리
- pid = fork()가 실행되면 부모 프로세스와 동일한 프로세스가 별도 메모리 공간에 생성
- 자식 프로세스는 pid가 0으로 리턴, 부모 프로세스는 실제 pid 리턴
- 두 프로세스의 변수 및 PC(Program Count) 값은 동일
- 새로운 프로세스 공간을 별도로 만들고, fork() 시스템 콜을 호출한 프로세스 (부모 프로세스) 공간을 모두 복사한 후, fork() 시스템 콜을 호출한 프로세스(부모 프로세스) 공간을 모두 복사한 후, fork() 시스템 콜 이후 코드부터 실행
