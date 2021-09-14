# 프로세스와 컨텍스트 스위칭
- 다시 PC, SP에 주목
    - PC(Program Counter) + SP(Stack Pointer)

## PCB
> PC, SP는 어디에 저장하나?
- Process Control Block (PCB)에 저장!
    > Process Context Block 이라고도 함
1. Process ID
2. Register 값 (PC, SP 등)
3. Scheduling Info (Process State)
4. Memory Info (메모리 사이즈 limit)
...
> PCB : 프로세스가 실행중인 상태를 캡쳐 / 구조화해서 저장

# 정리
- 프로세스 구조
    - Stack, Heap, Data (BSS, Data), TEXT (Code)
- PCB
    - 프로세스 상태 정보 - PC, SP, 메모리, 스케쥴링 정보 등

