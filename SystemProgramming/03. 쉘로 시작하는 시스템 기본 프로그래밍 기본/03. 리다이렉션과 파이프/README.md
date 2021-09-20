# 쉘 사용법 정리 - 리눅스 리다이렉션 (redirection) 과 파이프 (pipe)
## Standard Stream (표준 입출력)
- command로 실행되는 프로세스는 세 가지 스트림을 가지고 있다.
    - 표준 입력 스트림 (Standard Input Stream) - stdin
    - 표준 출력 스트림 (Standard Output Stream) - stdout
    - 오류 출력 스트림 (Standard Error Stream) - stderr
- 모든 스트림은 일반적인 plain text 로 console 에 출력하도록 되어 있음

## 리다이렉션 (redirection)
- 표준 스트림 흐름을 바꿔줄 수 있다.
    - (>) , (<) 을 사용함
    - 주로 명령어 표준 출력을 화면이 아닌 파일에 쓸 때
- 예
    1. ls > files.txt 
    - ls로 출력되는 표준 출력 스트림의 방향을 files.txt 로 바꿔줌<br>
      (files.txt 에 ls 로 출력되는 결과가 저장됨)
    2. head < files.txt
    - files.txt의 파일 내용이 head라는 파일의 처음부터 10라인까지 출력해주는 명령으로 넣어짐<br>
      (files.txt의 앞 10라인이 출력됨)
    3. head < files.txt > files2.txt
    - files.txt의 파일 내용이 head로 들어가서, files.txt의 앞 10라인을 출력
    - head 의 출력 스트림은 다시 files2.txt로 들어감
    - head 는 files.txt 내용을 출력하지 않고, 해당 출력 내용이 다시 files2.txt에 저장됨<br>
      (결과적으로 files.txt의 앞 10라인이 files2.txt에 저장됨)
    4. 기존 파일에 추가는 >> 또는 << 사용
    - ls >> files.txt
    - 기존에 있는 files.txt 파일 끝에, ls 출력 결과를 추가해줌

## 파이프 (pipe)
- 두 프로세스 사이에서 한 프로세스의 출력 스트림을 또다른 프로세스의 입력 스트림으로 사용할 때 사용됨

## 파이프 (pipe) 예
1. ls | grep files.txt
    - ls 명령을 통한 출력 내용이 grep 명령의 입력 스트림으로 들어감
    - grep files.txt는 grep 명령의 입력 스트림을 검색해서 files.txt 가 들어 있는 입력 내용만 출력해줌
    - 따라서, ls 명령으로 해당 디렉토리 / 파일 중에 files.txt 파일이 있는지를 출력해줌

## 참고 : grep 명령어
- grep : 검색 명령
- grep [-option] [pattern] [file or directory name]
```text
<option>
    - i : 영문의 대소문자를 구별하지 않는다.
    - v : pattern을 포함하지 않는 라인을 출력한다.
    - n : 검색 결과의 각 행의 선두에 행 번호를 넣는다 (first line)
    - l : 파일명만 출력한다.
    - c : 패턴과 일치하는 라인의 개수만 출력한다.
    - r : 하위 디렉토리까지 검색한다.
```
- 사용 예
    - grep python files.txt -> files.txt 라는 파일에서 python 이라는 문구가 들어간 모든 행을 출력
    - grep -n python files.txt -> files.txt 라는 파일에서 python 이라는 문구가 들어간 모든 행을 출력
    - grep -r python foldername -> foldername 라는 폴더내의 모든 파일 중 python 이라는 문구가 들어간 모든 행을 출력
    - grep -i python files.txt -> files.txt 라는 파일에서 python 이라는 문구를 대,소문자 구분 없이 검색해서 출력
    - grep -E "go|java|python" files.txt -> files.txt 라는 파일에서 go, java, 또는 python 이 있는 모든 행을 출력 

## 정리
- Standard Stream
    - stdin, stdout, stderr
- redirection
    - 주로 명령어 표준 출력을 화면이 아닌 파일에 쓸 때
- pipe
    - 두 프로세스 사이에서 앞에 있는 프로세스의 출력 스트림을 뒤에 있는 프로세스의 입력 스트림으로 사용될 때
