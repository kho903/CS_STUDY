# 리눅스 파일 시스템 탐색
## 파일과 inode
- 리눅스 파일 탐색 : 예 - /home/ubuntu/link.txt
    1. 각 디렉토리 엔트리(dentry)를 탐색
        - 각 엔트리는 해당 디렉토리 파일 / 디렉토리 정보를 가지고 있음
    2. '/'dentry 에서 'home' 을 찾고, 'home' 에서 'ubuntu' 를 찾고, 'ubuntu' 에서 link.txt 파일이름에 해당하는 inode를 얻음

## 리눅스 파일 구조
- /bin/, /sbin/ : '쉘명령어 실행파일', 'PATH'
- /boot/ : 부팅
- /dev/ : 'device'
- /etc/ : 설정
- /home/ : 로그인
- /media/, /mnt/ : floppy, (추가적인) SSD (저장매체)
- /var/log/ : 로그파일 기록
