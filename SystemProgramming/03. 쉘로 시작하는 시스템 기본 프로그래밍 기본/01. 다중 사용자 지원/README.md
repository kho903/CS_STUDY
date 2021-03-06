# 쉘 사용법 정리 - 다중 사용자 지원 관련 명령어
## 쉘 종류
- 쉘 (shell) : 사용자와 컴퓨터 하드웨어 또는 운영체제간 인터페이스
    - 사용자의 명령을 해석해서, 커널에 명령을 요청해주는 역할
    - 관련된 시스템콜을 사용해서 프로그래밍이 작성되어 있다.

## 쉘 종류
- Bourne-Again Shell (bash) : GNU 프로젝트의 일환으로 개발됨, 리눅스 거의 디폴트임
- Bourne Shell (sh)
- C Shell (csh)
- Korn Shell (ksh) : 유닉스에서 가장 많이 사용됨

## 리눅스 기본 명령어 정리
- 리눅스 명령어는 결국 쉘이 제공하는 명령어
- 리눅스 기본 쉘이 bash 이므로, bash에서 제공하는 기본 명령어를 배우는 것

## UNIX는 다중 사용자를 지원하는 시스템
- 다중 사용자 관련 명령어 알아보기

## whoami
- 로그인한 사용자 ID를 알려줌
```shell
~$ whoami
jihun
```
## passwd
- 로그인한 사용자 ID의 암호 변경
- password 축약어

## useradd와 adduser
- useradd는 사용자 기본 설정 자동으로 하지 않음
- adduser는 사용자 기본 설정을 자동으로 수행함

## sudo 명령어 : root 권한으로 실행하기
- root 계정으로 로그인하지 않은 상태에서 root 권한이 필요한 명령을 실행할 수 있도록 하는 프로그램
- 기본 사용법
    - sudo 명령어
    - 사용 예
        - sudo apt-get update

## su : 사용자 변경
- 보통 su - 와 함께 사용
    - su root : 현재 사용자의 환경설정 기반, root로 변경
    - su - root : 변경되는 사용자의 환경설정을 기반으로, root로 전환

