# HTTP Protocol
- HTTP (Hyper Text Transfer Protocol)로 RFC 2616에서 규정된 Web에서 데이터를 주고 받는 프로토콜
- 이름에는 하이퍼텍스트 전송용 프로토콜로 정의되어 있지만 실제로는 HTML, XML, JSON, Image, Voice, Video, Javascript, PDF 등 다양한 컴퓨터에서 다룰 수 있는 것은 모두 전송할 수 있다.
- HTTP는 TCP를 기반으로 한 REST의 특징을 모두 구현하고 있는 Web 기반의 프로토콜

## HTTP
- HTTP는 메시지를 주고(Request) 받는(Response) 형태의 통신 방법이다.

## HTTP 요청을 특정하는 Method는 8가지가 있다.
- REST를 구현하기 위한 인터페이스이니 알아둬야 한다.

|-|의미|CRUD|멱등성|안정성|Path Variable|Query Parameter|DataBody|
|:---:|:-----:|:---:|:---:|:---:|:---:|:---:|:---:|
|GET|리소스 취득|R|O|O|O|O|X|
|POST|리소스 생성, 추가|C|X|X|O|세모|O|
|PUT|리소스 갱신, 생성|C/U|O|X|O|세모|O|
|DELETE|리소스 삭제|D|O|X|O|O|X|
|HEAD|헤더 데이터 취득|-|O|O|-|-|-|
|OPTIONS|지원하는 메소드 취득|-|O|-|-|-|-|
|TRACE|요청 메시지 반환|-|O|-|-|-|-|
|CONNECT|프록시 동작의 터널 접속으로 변경|-|X|-|-|-|-|

## HTTP Status Code
- 응답의 상태를 나타내는 코드

|-|의미|내용|
|:---:|:---:|:-----------|
|1xx|처리중|처리가 계속 되고 있는 상태. 클라이언트는 요청을 계속 하거나 서버의 지시에 따라서 재요청|
|2xx|성공|요청의 성공|
|3xx|리다이렉트|다른 리소스로 리다이렉트. 해당 코드를 받았을 때는 Response의 새로운 주소로 다시 요청|
|4xx|클라이언트 에러|클라이언트의 요청에 에러가 있는 상태. 재전송하여도 에러가 해결되지 않는다.|
|5xx|서버 에러|서버 처리 중 에러가 발생한 상태. 재전송 시 에러가 해결되었을 수도 있다.|

## 자주 사용되는 코드
- 200 : 성공
- 201 : 성공. 리소스를 생성 성공
- 301 : 리다이렉트, 리소스가 다른 장소로 변경됨을 알림
- 303 : 리다이렉트, Client에서 자동으로 새로운 리소스로 요청 처리
- 400 : 요청 오류, 파라미터 에러
- 401 : 권한 없음 (인증실패)
- 404 : 리소스 없음 (페이지를 찾을 수 없음)
- 500 : 서버 내부 에러 (서버 동작 처리 에러)
- 503 : 서비스 정지 (점검 등등)
