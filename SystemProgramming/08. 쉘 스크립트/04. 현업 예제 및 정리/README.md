## 백업하기
```sh
#!/bin/bash

if [ -z $1 ]||[ -z $2 ]; then
    echo usage: $0 sourcedir targetdir
else
    SRCDIR=$1
    DSTDIR=$2
    BACKUPFILE=backup.$(date +%y%m%d%H%M%S).tar.gz
    if [ -d $DSTDIR ]; then
        tar -cvzf $DSTDIR/$BACKUPFILE $SRCDIR
    else
        mkdir $DSTDIR
        tar -cvzf $DSTDIR/$BACKUPFILE %SRCDIR
    fi
fi
```

## 참고 : 압축 명령 tar
- 주요 옵션
```
x : 묶음을 해제
c : 파일을 묶음
v : 묶음 / 해제 과정을 화면에 표시
z : gunzip을 사용
f : 파일 이름을 지정
```
- 압축시 주로 사용하는 옵션
`tar -cvzf [압축된 파일 이름] [압축할 파일이나 폴더명]`
- 압축을 풀을 때 주로 사용하는 옵션
`tar -xvzf [압축 해제할 압축 아카이브 이름]`

# 2
- 로그파일 정리하기
```sh
find . -type f -name '파일명검색어' -exec bash -c "명령어1; 명령어2; 명령어3;" \;
# -type f: 파일 타입 지정해서 검색 (f는 일반 파일)
```
```sh
#!/bin/bash

LOGDIR=/var/log
GZIPDAY=1
DELDAY=2
cd $LOGDIR
echo "cd $LOGDIR"

sudo find . -type f -name '*log.?' -mtime +$GZIPDAY -exec bash -c "gzip {}" \; 2> dev/null
sudo find . -type f -name '*.gz' -mtime +$DELDAY -exec bash -c "rm -f {}" \; 2> /dev/null
```