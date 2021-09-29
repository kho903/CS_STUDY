# 프로세스 ID 시스템 콜
## 프로세스 관리 관련 시스템 콜
- 사전 작업 : 우분투 리눅스에 gcc 설치 (+ vi 에디터/한글 설정)
```
sudo apt-get install gcc
gcc --version
gcc -o test.c test
```

## 부모 프로세스와 자식 프로세스
- bash 프로세스가 실행 파일의 부모 프로세스인 예
```
# ./pidinfo
pid=1202
ppid=1076
```
```
# ps
  PID   TTY         TIME    CMD
  1076  tty1    00:00:00    bash
  1204  tty1    00:00:00    ps
```
