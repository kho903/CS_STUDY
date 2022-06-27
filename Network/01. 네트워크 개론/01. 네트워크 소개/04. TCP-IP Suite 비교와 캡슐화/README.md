# TCP / IP 모델 비교와 캡슐화
## TCP/IP란?
- 정의
    - 네트워크 프로토콜의 모음으로 패킷 통신 방식의 IP와 전송 조절 프로토콜인 TCP로 이루어져 있다.
- 역사
    - 1960년대 말 방위고등연구계획국(DARPA)이 연구
    - 1990년대 네트워크 표준이 ISO 모델과 TCP/IP 모델로 좁혀짐
    - 1990년대 말 TCP/IP 모델이 자주 쓰이면서 가장 일반적인 모델이 됨

## TCP/IP 모델
- Application       : 응용 프로그램간 표준화된 데이터 교환
- Transport         : TCP / UDP
- Network           : 패킷을 처리하고 다른 네트워크로 연결
- Network Interface : 물리 계층으로 네트워크 노드들을 상호 연결

## TCP/IP 와 OSI 7 Layer 비교
### TCP/IP : Service & Protocol
- Application       : HTTP, SMTP, DNS
- Transport         : TCP, UDP
- Network           : IP, ICMP, OSPF
- Network Interface : Ethernet

### OSI 7 Layer : Service & Protocol
- Application, Presentation, Session   : HTTP, SMTP, DNS
- Transport     : TCP,UDP
- Network       : IP, ICMP, OSPF
- Data Link, Physical     : Ethernet

## 캡슐화
### 인캡슐레이션 
- Application, Presentation   : HOST Data
- Session       : Data
- Transport  (Segment)   : TCP header, Data
- Network    (Packet)   : IP header, Data
- Data Link  (Frame)   : MAC LLC header, Data, FCS
- Physical   (bit)   : Signal 111010..............

### 디캡슐레이션
- Application, Presentation   : HOST Data
- Session       : Data
- Transport   (Segment)  : TCP header, Data
- Network     (Packet)  : IP header, Data
- Data Link   (Frame)  : MAC LLC header, Data, FCS
- Physical    (bit)  : Signal 111010..............

### 정리
- TCP/IP 모델은 패킷 통신 방식의 IP와 전송 조절 프로토콜인 TCP로 이루어져 있다.
- 1960년대 말 개발되어 1990년대 말 네트워크 통신의 일반적인 모델이 됨
- 캡슐화를 통해서 네트워크는 통신한다.
