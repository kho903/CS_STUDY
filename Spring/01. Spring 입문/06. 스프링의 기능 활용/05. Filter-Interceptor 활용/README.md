# Filter Interceptor 활용
## Filter
- Filter란 Web Application에서 관리되는 영역으로써 Spring Boot Framework에서 Client로 부터
오는 요청 / 응답에 대해서 최초 / 최종 단계의 위치에 존재하며, 이를 통해서 요청 / 응답의 정보를 변경하거나,
Spring에 의해서 데이턱 변환되기 전의 순수한 Client의 요청 / 응답 값을 확인할 수 있다.
- 유일하게 ServletRequest, ServletResponse의 객체를 변환할 수 있다.
- 주로 Spring Framework 에서는 request / response의 Logging 용도로 활용하거나,
인증과 관련된 Logic들을 해당 Filter에서 처리한다.
- 이를 선 / 후 처리 함으로써, Service business logic과 분리 시킨다.
