# 스레드 디태치
- 해당 스레드가 종료될 경우, 즉시 관련 리소스를 해제(free)한다.
    - pthread_join을 기다리지 않고, 종료 즉시 리소스를 해제한다.
```C
// thread : detach 할 스레드 식별자
int pthread_detach(pthread_t thread); 
```
# Pthread 뮤텍스 - 상호 배제 기법
- 뮤텍스 선언과 초기화
```C
pthread_mutext_t mutext_lock = PTHREAD_MUTEX_INITIALIZER;
```
- 뮤텍스 락 걸기 / 풀기
```C
int pthread_mutex_lock(pthread_mutex_t *mutex);
int pthread_mutex_unlock(pthread_mutex_t *mutex);
```

