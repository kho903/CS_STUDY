# Swagger 란
- Swagger 란 개발한 REST API를 편리하게 문서화 해주고, 이를 통해서 관리 및 제 3의 사용자가
편리하게 API를 호출해보고 테스트할 수 있는 프로젝트이다.
- Spring Boot 에서는 간단하게 springfox-boot-starter 를 gradle dependencies에
추가해서 사용할 수 있다.
- 다만, 주의할 점은 운영환경과 같은 외부에 노출되면 안되는 곳에서 사용할 땐 주의해야 한다.

## Swagger Annotation
- @Api : 클래스를 스웨거의 리소스로 표시
- @ApiOperation : 특정 경로의 오퍼레이션 HTTP 메소드 설명
- @ApiParam : 오퍼레이션 파라미터에 메타 데이터 설명
- @ApiResponse : 오퍼레이션의 응답 지정
- @ApiModelProperty : 모델의 속성 데이터를 설명
- @ApiImplicitParam : 메소드 단위의 오퍼레이션 파라미터를 설명
- @ApiImplicitParams