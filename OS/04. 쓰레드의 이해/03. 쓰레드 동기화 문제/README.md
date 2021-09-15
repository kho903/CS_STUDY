# 동기화 (synchronization)
## 동기화 이슈 예제(example.py)
### 반복문 횟수를 100000 이상 증가할 경우, 전체 계산값(g_count)이 비정상적으로 출력되는 이유
- 반복문 횟수를 100000 이상 증가할 경우, Thread가 온전히 100000 반복하지 않고, 다른 Thread로 Context Switching)
- 이 때 어느 부분을 실행하다가 Context Switching 할지는 알 수 없다.
- Context Switching 시 register의 값들은 모두 실행중단 직전의 값으로 모두 복원된다.
- Thread1은 Register1의 값을 g_count에 쓰기 전에 실행중단되었으므로, Thread2에서 g_count 값을 읽으면, 1이 증가된 값이 아니라, Thread1 때와 동일하게 0을 읽어들임
- Thread2도 Register1의 값을 g_count에 쓰기 전 중단되고, 다시 Thread1이 실행된다면, Thread1에서는 기존 register 값을 복원해서, Register1에 있는 1을 g_count에 저장한다.
- 마찬가지로 이후에 다시 바로 Thread2로 Context switching이 된다면, Thread2가 실행중단되었던 당시의 Register 값이 복원되어, Register1에 1이 복원되고,
이를 g_count에 저장하는 명령부터 실행할 차례이므로, 해당 값을 g_count에 저장한다.
- 결과적으로 Thread1에서 g_count를 1 증가시키고, Thread2에서 g_count를 다시 증가시키면, g_count는 2가 되어야 하지만, 위와 같이 Thread 간 Context Switching이 얽힐 경우,
일부 1을 더하는 동작이 제대로 동작하지 않는 것처럼 보이게 된다.



