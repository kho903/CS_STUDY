## 파일 처리 성능 개선 기법 - 메모리에 파일 매핑
`int msync(void *start, size_t length, int flags)`
- start : mmap()를 통해 리턴 받은 메모리 맵의 시작 주소
- length : 동기화를 할 길이. 시작 주소로부터 길이를 지정하면 된다.
- flags
    - MS_ASYNC : 비동기 방식, 동기화(MEMORY->FILE)하라는 명령만 내리고 결과에 관계 없이 다음 코드 실행(따라서, 동기화가 완료 안 된 상태로 다음 코드 실행 가능)
    - MS_SYNC : 동기 방식, 동기화(MEMORY->FILE)가 될 때까지 블럭 상태로 대기
    - MS_INVALIDATE : 현재 메모리 맵을 무효화하고 파일의 데이터로 갱신. 즉 FILE->MEMORY