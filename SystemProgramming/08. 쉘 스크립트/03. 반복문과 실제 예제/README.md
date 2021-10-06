## 파일 검사
```text
-e 파일명       # 파일이 존재하면 참
-d 파일명       # 파일이 디렉토리면 참
-h 파일명       # 심볼릭 링크파일
-f 파일명       # 파일이 일반파일이면 참
-r 파일명       # 파일이 읽기 가능이면 참
-s 파일명       # 파일 크기가 0이 아니면 참
-u 파일명       # 파일이 set-user-id가 설정되면 참
-w 파일명       # 파일이 쓰기 가능 상태이면 참
-x 파일명       # 파일이 실행 가능 상태이면 참
```

## 논리 연산 (참고)
```text
조건1 -a 조건2      # AND
조건1 -o 조건2      # OR
조건1 && 조건2      # 양쪽 다 성립
조건1 || 조건2      # 한쪽 또는 양쪽 다 성립
!조건              # 조건이 성립하지 않음
true              # 조건이 언제나 성립
false             # 조건이 언제나 성립하지 않음
```

## 조건문 문법
- 기본 if / else 구문
```
if  [ 조건 ]
then
    명령문
else
    명령문
fi
```

## 쉘 스크립트 해석하기
- 명령 해석
    - ping -c 1 192.168.0.1 1> /dev/null
        - 0:표준입력, 1:표준출력, 2:표준에러
    - 1> /dev/null : 표준 출력 내용은 버려라 (출력하지 말아라)
    - -c 1 은 1번만 체크해봐라

## 조건문 한 줄에 작성하기 (참고)
- if 구문 (한 라인에 작성하는 방법)
`if [ 조건 ]; than 명령문; fi`
```sh
예)
if [ -z $1 ]; then echo "Insert args"; fi
```
- if [뒤와,]앞에는 반드시 공백이 있어야 함
- [] 에서 &&, ||, <, > 연산자들이 에러가 나는 경우는 [[]] 를 사용하면 정상 작동하는 경우가 있음

## 반복문 문법
- 기본 for 구문
```sh
for 변수 in 변수값1 변수값2 ...
do
    명령문
done
```
- 현재 디렉토리 출력
```sh
#!/bin/bash
for database in $(ls)
do
    echo $database
done
```

```sh
#!/bin/bash
for database in $(ls); do
    echo $database
done
```

```sh
#!/bin/bash
for database in $(ls); do echo $database; done
```
- 기본 while 구문
```sh
while [ 조건문 ]
do
    명령문
done
```
- 현재 디렉토리에 있는 파일과 디렉토리 출력 (while)
```sh
#!/bin/bash
lists=$(ls)
num=${#lists[@]}
index=0
while [ $num -ge 0 ]
do
    echo ${lists[$index]}
    index=`expr $index + 1`
    num=`expr $num - 1`
done
```
