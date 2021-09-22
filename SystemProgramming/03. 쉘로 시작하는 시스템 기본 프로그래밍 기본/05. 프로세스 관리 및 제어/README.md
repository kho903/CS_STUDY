# 프로세스 관리 및 제어
## foreground process 제어하기
- [ctrl] + z : foreground 프로세스를 실행 중지 상태 (suspend 모드)로 변경
- 맨 마지막 [ctrl] + z 로 중지된 프로세스는 bg 명령으로 background 프로세스로 실행될 수 있음
- jobs 명령어 : 백그라운드로 진행 또는 중지된 상태로 있는 프로세스를 보여줌
```shell
find / -name '*.txt'
[1]- Stopped              find / -name '*.txt'
find / -name '*.py'
[2]- Stopped              find / -name '*.py'
# jobs
[1]- Stopped              find / -name '*.txt'
[2]- Stopped              find / -name '*.py'
# bg
[2]+ find / -name '*.py' &
```
- [ctrl] + c : 프로세스 작업 취소 (해당 프로세스는 완전히 종료된다.)
> 운영체제 소프트웨어가 인터럽트가 해당 프로세스에 보내짐 - 그래서 프로세스 제어가 가능함

## 프로세스 상태 확인 - ps 명령어
- 사용법 : ps[option(s)]
- option(s)
```text
-a : 시스템을 사용하는 모든 사용자의 프로세스 출력
    (보통 aux)와 같이 u, x 옵션과 함께 사용
-u : 프로세스 소유자에 대한 상세 정보 출력
-l : 프로세스 관련 상세 정보 출력
-x : 터미널에 로그인한 후 실행한 프로세스가 아닌 프로세스들도 출력함.
    주로 데몬 프로세스 (daemon process)까지 확인하기 위해 사용.
    본래 ps 명령을 현재 쉘(shell)에서 실행한 프로세스들만 
    보여주기 때문에 이 옵션을 사용하는 경우가 많음.
-e : 해당 프로세스외 관련된 환경 변수 정보도 함께 출력
-f : 프로세스 간 관계 정보도 출력
```
- 데몬 프로세스(daemon process) : daemon은 악마를 의미함. 사용자 모르게 시스템 관리를 위해
    실행되는 프로세스로 보통 시스템이 부팅될 떄 자동 실행 (예: ftpd, inetd 등)
- 주요 ps 출력 정보 항목
```text
USER : 프로세스를 실행시킨 사용자 ID
PID : 프로세스 ID
%CPU : 마지막 1분 동안 프로세스가 사용한 CPU 시간의 백분율
%MEM : 마지막 1분 동안 프로세스가 사용한 메모리 백분율
VSZ : 프로세스가 사용하는 가상 메모리 크기
RSS : 프로세스에서 사용하는 실제 메모리 크기
STAT : 프로세스 상태
START : 프로세스가 시작된 시간
TIME : 현재까지 CPU 시간 (분 : 초)
COMMAND : 명령어
```

## 프로세스 중지시키기
- kill 명령어
    - 사용법
        - kill %작업번호 (job number)
        - kill 프로세스 ID (pid)
        - 작업 강제 종료 옵션 -9
    - 예
```text
# find / -name '*py' > list.txt &
# kill -9 57
```