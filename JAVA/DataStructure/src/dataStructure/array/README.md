# 꼭 알아둬야 할 자료 구조 : 배열(Array)
- 데이터를 나열하고 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조

## 1. 배열은 왜 필요할까?
- 같은 종류의 데이터를 효율적으로 관리하기 위해 사용
- 같은 종류의 데이터를 순차적으로 저장
- 장점
    - 빠른 접근 가능
        - 첫 데이터의 위치에서 상대적인 위치로 데이터 접근 (인덱스 번호로 접근)
- 단점
    - 데이터 추가 / 삭제의 어려움
        - 미리 최대 길이를 지정해야 함

## 참고 : Primitive 자료형과 Wrapper 클래스
- JAVA에서는 int와 Integer 같이, Primitive 자료형과 Wrapper 클래스가 있음
- Wrapper 클래스는 null을 용이하게 처리할 수 있고, ArrayList 등 객체만을 핸들링하는 기능을 사용할 수 있다.

## 2. JAVA와 배열
### JAVA에서는 기본 문법으로 배열 지원
- 1차원 배열은 []를 통해 선언할 수 있다.
- 각 아이템은 {} 내에 콤마로 생성
- new 키워드를 사용해서, 배열을 미리 선언하고, 데이터를 넣을 수도 있다.
```java
Integer[] data_list = new Integer[10];
data_list[0] = 1;
```

```java
Integer data_list1[] = {5,4,3,2,1};
Integer[] data_list2 = {1,2,3,4,5};
```

### JAVA에서 배열을 보다 손쉽게 다루기 위한 클래스 등을 제공
- 예 : Arrays 클래스를 활용하여, 전체 데이터 출력하기
```java
import java.util.Arrays;
// 배열의 내용을 출력하려면 Arrays.toString(배열변수) 메서드를 사용하면 됨
System.out.println(Arrays.toString(data_list2));
```

### JAVA에서 배열을 보다 손쉽게 다루기 위한 ArrayList 클래스 예
- ArrayList 클래스는 가변 길이의 배열 자료구조를 다룰 수 있는 기능을 제공함
### 참고 : List와 ArrayList
- 선언
```java
List<Integer> list1 = new ArrayList<Integer>();
ArrayList<Integer> list1 = new ArrayList<Integer>();
```
- List는 인터페이스이고, ArrayList는 클래스임
    - 클래스는 크게 일반 클래스와 클래스 내에 '추상 메서드'가 하나 이상 있거나, abstract로 정의된 추상 클래스로 나뉨
    - 인터페이스는 모든 메서드가 추상 메서드인 경우를 의미하며, 인터페이스를 상속받는 클래스는 인터페이스에서 정의된 추상메서드를 모두 구현해야 함
      (따라서 다양한 클래스를 상속받는 특정 인터페이스는 결국 동일한 메서드를 제공함)
    - ArrayList가 아니라, List로 선언된 변수는 다음과 같이 필요에 따라 다른 리스트 클래스를 쓸 수 있는 구현상의 유연성을 제공함
    ```java
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
    ```
    - 다만 굳이 동일 변수에 다양한 리스트 클래스를 쓸 필요는 없으므로, 최대한 동일한 클래스로 선언
    ```java
        ArrayList<Integer> list1 = new ArrayList<Integer>();
    ```
    - 이외에 jdk1.7 이상부터 인스턴스 생성 시 타입을 추정할 수 있는 경우에는 타입을 생략할 수 있으므로, 다음과 같이 작성할 수 있다.
    ```java
        ArrayList<Integer> list1 = new ArrayList<>();
    ```
