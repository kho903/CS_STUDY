# 소프트 링크 및 특수 파일
## 소프트(심볼릭) 링크 : ln -s A B
- Windows OS 의 바로가기와 동일
- ls -al 하면, 소프트링크 확인 가능<br>
  `lrwxr-xr-x      link3.txt -> link2.txt`
- rm A로 A를 삭제 하면? B는 해당 파일 접근 불가

## 특수 파일
- 디바이스
  - 블록 디바이스 (Block Device)
    - HDD, CD / DVD 와 같이 블록 또는 섹터 등 정해진 단위로 데이터 전송, IO 송수신 속도가 높음
  - 캐릭터 디바이스 (Character Device)
    - 키보드, 마우스 등 byte 단위 데이터 전송, IO 송수신 속도가 낮음
  - cd /dev, cat tty
  ```text
  brw-r-----              disk0
  crw-rw-rw-              tty
  ```

### 정리
- 파일 추상화 인터페이스를 활용 다양한 데이터 / 디바이스 접근
- 파일 네임스페이스는 전역 네임스페이스 활용 (/media/floppy/dave.jpg)
- '파일이름:inode'로 매칭, 파일 시스템은 inode 기반 접근
- 하드 링크 : 동일 inode 가리키는 파일 이름만 하나 더 만듦 (inode -> link_count 몇개)
- 소프트 링크 : 특정 파일 바로가기 파일을 만듦
- ln 명령 알아두기
- 특수 파일 : 블록 / 캐릭터 디바이스