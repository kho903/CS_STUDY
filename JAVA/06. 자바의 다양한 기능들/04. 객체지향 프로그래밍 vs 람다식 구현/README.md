# 객체지향 프로그래밍 vs 람다식 구현
## 객체 지향 프로그래밍과 람다식 비교
- 문자열 두 개를 연결하여 출력하는 예제를 두 가지 방식으로 구현해 보자
- 인터페이스 선언
```java
public interface StringConcat {
    public void makeString(String s1, String s2);
}
```
- 객체 지향 프로그래밍으로 구현하기

인터페이스를 구현한 클래스 만들기
```java
public class StringConcatImpl implements StringConcat {
    @Override
    public void makeString(String s1, String s2) {
        System.out.println(s1 + ", " + s2);
    }
}
```
클래스를 생성하고 메서드 호출하기
```java
public class TestStringConcat {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";
        StringConcatImpl concat1 = new StringConcatImpl();
        concat1.makeString(s1, s2);
    }
}
```
- 람다식으로 구현하기
```java
StringConcat concat2 = (s, v) -> System.out.println(s + ", " + v);
concat2.makeString(s1, s2);
```

## 익명 객체를 생성하는 람다식
- 자바에서는 객체 없이 메서드가 호출될 수 없음
- 람다식을 구현하면 익명 내부 클래스가 만들어지고, 이를 통해 익명 객체가 생성됨
```java
StringConcat concat3 = new StringConcat() {
    
    @Override
    public void makeString(String s1, String s2) {
        System.out.println(s1 + ", " + s2);
    }
};
concat3.makeString(s1, s2);
```
- 익명 내부 클래스에서와 마찬가지로 람다식 내부에서도 외부에 있는 지역 변수의 값을 변경하면 오류가 발생함

## 함수를 변수처럼 사용하는 람다식
변수는...
> 특정 자료형으로 변수를 선언한 후 값을 대입함 int a = 10; <br>
> 매개변수로 전달하여 사용함 int add(int x, int y); <br>
> 메서드의 반환 값으로 반환하기 return num;
- 인터페이스형 변수에 람다식 대입하기

함수형 인터페이스
```java
interface PrintString {
    void showString(String str){}
}
```
```java
PrintStirng lambdaStr = s-> System.out.println();
lambdaStr.showString("hello lambda_1");
```
- 매개변수로 전달하는 람다식
```java
showMyString(lambdaStr);
public static void showMyString(PrintString p){
    p.showString("hello lambda_2");
}
```
- 반환 값으로 쓰이는 람다식
```java
public static PrintString returnString() {
    // 반환값으로 사용
    return s->System.out.println(s + "world");
}

PrintString reStr = returnString();
reStr.showString("hello ");
```