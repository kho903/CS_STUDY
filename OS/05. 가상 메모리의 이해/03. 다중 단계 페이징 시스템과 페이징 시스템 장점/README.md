# 다중 단계 페이징 시스템
- 32bit 시스템에서 4KB 페이지를 위한 페이징 시스템은
    - 하위 12bit는 오프셋
    - 상위 20bit가 페이징 번호이므로, 2의 20승(1048576)개의 페이지 정보가 필요함
- 페이징 정보를 단계를 나누어 생성
    - 필요없는 페이지는 생성하지 않으면, 공간 절약 가능
- 페이지 번호를 나타내는 bit를 구분해서, 단계를 나눔 (리눅스는 3단계, 최근 4단계)

## MMU와 TLB(컴퓨터 구조)
- MMU가 물리 주소를 확인하기 위해 메모리를 갔다와야 함
1. Virtual address 요청 (CPU -> MMU)
2. CR3(base address) (MMU -> Memory(Process A's table))
3. Physical address 요청 (Memory(Process A's table) -> MMU)
4. Physical address 접근 (MMU -> Memory(Process A's page #5))
5. Data 전달 (Memory(Process A's page #5) -> CPU)

- TLB (Translation Lookaside Buffer) : 페이지 정보 캐쉬
1. Virtual address 요청 (CPU -> MMU)
    - Physical address 전달 & 캐쉬 (MMU <-> TLB)
2. CR3(base address) (MMU -> Memory(Process A's page table))
3. Physical address 전달 (Memory(Process A's page table) -> MMU)
4. Physical address 접근 (MMU -> Memory(Process A's page #5))
5. Data 전달 (Memory(Process A's page #5) -> CPU)

## 페이징 시스템과 공유 메모리
- 프로세스간 동일한 물리 주소를 가리킬 수 있음 (공간 절약, 메모리 할당 시간 절약)
- 물리 주소 데이터 변경시
    - 물리 주소에 데이터 수정 시도시, 물리 주소를 복사할 수 있음 (copy-on-write)

