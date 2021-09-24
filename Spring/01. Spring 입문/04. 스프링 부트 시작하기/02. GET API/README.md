|-|의미|CRUD|멱등성|안정성|Path Variable|Query Parameter|DataBody|
|---|---|---|---|---|---|---|---|
|GET|리소스 취득|R|O|O|O|O|X|
|POST|리소스 생성, 추가|C|X|X|O|세모|O|
|PUT|리소스 갱신, 생성|C/U|O|X|O|세모|O|
|DELETE|리소스 삭제|D|O|X|O|O|X|
|HEAD|헤더 데이터 취득|-|O|O|-|-|-|
|OPTIONS|지원하는 메소드 취득|-|O|-|-|-|-|
|TRACE|요청메시지 반환|-|O|-|-|-|-|
|CONNECT|프록시 동작의 터널 접속으로 변경|-|X|-|-|-|-|


