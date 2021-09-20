# 쉘 사용법 정리 - 파일 및 권한 관련 명령어
## sudo 명령어 : root 권한으로 실행하기
- /etc/sudoers 설정 파일에서 다음과 같으 설정을 변경할 수 있음
    - visudo가 설치되어 있다면, 해당 명령을 통해 설정 파일이 오픈되어 바로 수정 가능
```
1. 특정 사용자가 sudo를 사용할 수 있도록 설정
   userid   ALL=(ALL)   ALL
2. 특정 그룹에 포함된 모든 사용자가 sudo를 사용할 수 있도록 설정
   %group   ALL=(ALL)   ALL
3. 패스워드 생략 설정
   %group   ALL=(ALL)   NOPASSWD: ALL
   userid   ALL=(ALL)   NOPASSWD: ALL
```
- 예 : sudo apt-get update

## pwd
- 현재 디렉토리 위치

## cd
- 디렉토리 이동

## ls
- 파일 목록 출력

## ls와 와일드 카드
- * 는 임의 문자열
- ? 는 문자 하나

## ls와 파일 권한
- 파일마다 소유자, 소유자 그룹, 모든 사용자에 대해
    - 읽고, 쓰고, 실행하는 권한 설정
    - 소유자 접근 권한 정보는 inode에 저장
- -rwxrw-r-x
    - 첫번째 - : 이 데이터가 파일
    - 앞 세자리 : 소유자의 권한
    - 중간 세자리 : 그룹의 권한
    - 끝 세자리 : 기타 사용자의 권한

|권한|대표문자|파일일 때|폴더일 때|
|---|---|---|---|
|읽기|r|읽고 카피|ls 명령어 가능|
|쓰기|w|수정|파일 생성 가능|
|실행|x|실행|cd 접근 가능|

## 파일 권한
- 사용자
    - 소유자 : 소유자에 대한 권한
    - 그룹 : 소유자가 속해 있는 그룹에 대한 권한
    - 공개 : 모든 사용자들에 대한 권한
- 퍼미션 종류, (권한 기호)
    - 읽기 (r) : 읽기 권한
    - 쓰기 (w) : 쓰기 권한
    - 실행 (x) : 실행 권한

## chmod : 파일 권한 변경
- 기호 문자를 사용하는 방법
    - 누구에계 ?
        - u 사용자
        - g 그룹
        - o 기타
        - a 전부
    - 줄까? 뺄까?
        - + 더하기
        - - 빼기
        - = 설정
    - 무슨 권한을?
        - r 읽기
        - w 쓰기
        - x 실행
- chmod g+rx test.c
- chmod u+rw test.c
- chmod ug+rw test.c
- chmod u=rwx,g=rw,o=rx test.c

## chmod : 파일 권한 변경
- 숫자를 사용하는 방법
- r = 4, w = 2, x = 1
- 소유자(u),그룹(g),기타(o)
- 예)
    - rwxrwxrwx = 777
    - r-xr-xr-x = 555
    - r-------- = 400
    - rwx------ = 700
    - chmod 400 test.c
- 주로 사용하는 옵션
    - chmod -R 777 directory

## chown : 소유자 변경
- chown [옵션] [소유자:소유그룹] [파일]
    - chown root:root file
    - chown root: file
    - chown :root file
- 주로 사용하는 옵션
    - chown -R root:root directory
- 참고 : 소유자 그룹 변경
    - chgrp [옵션][그룹][파일]
    - 예 : chgrp -R root directory

## cat: 파일 보기
- 파일 보기

## head/tail
- head는 파일 시작부분, tail은 끝 부분을 보여줌

## more
- 파일 보기 (화면이 넘어갈 경우, 화면이 넘어가기 전까지 보여줌)

## rm : 파일 및 폴더 삭제
- 주로 사용하는 명령어 형태 : rm -rf 디렉토리명
- r 옵션 : 하위 디렉토리를 포함한 모든 파일 삭제
- f 옵션 : 강제로 파일이나 디렉토리 삭제
> 기본적으로 리눅스에는 휴지통이 없다.

## 정리
- 쉘 - Bourne-Again Shell (bash) : GNU 프로젝트의 일환으로 개발됨, 리눅스 거의 디폴트임
- user 관련 명령 : whoami, useradd, passwd, su - 명령
- Directory / file 관련 명령 : pwd, cd, ls, cat, head/tail, more, rm
- Directory / file 권한 관련 명령 : chmod, chown, chgrp
- 관리자 권한으로 실행하기 : sudo
- 다양한 옵션은 man 명령으로 메뉴얼 확인이 가능함
