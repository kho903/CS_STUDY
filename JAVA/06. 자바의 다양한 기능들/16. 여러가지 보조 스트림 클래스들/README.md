# 여러가지 보조 스트림 클래스들
## 보조 스트림
- 실제 읽고 쓰는 스트림이 아닌 보조 기능을 제공하는 스트림
- FilterInputStream과 FilterOutputStream이 보조 스트림의 상위 클래스들
- 생성자의 매개변수로 또다른 스트림(기반 스트림이나 다른 보조 스트림)을 가짐
- Decorator Pattern으로 구현됨
- 상위 클래스 생성자
    - protected FilterInputStream(InputStream in) : 생성자의 매개변수로 InputStream을 받는다.
    - public FilterOutputStream(OutputStream out) : 생성자의 매개변수로 OutputStream을 받는다.
- 바이트 단위 파일 입력 스트림(기반 스트림) + 문자로 변환 기능 추가(보조 스트림) + 버퍼링 기능 추가(보조 스트림)

### InputStreamReader와 OutputStreamWriter
- 바이트 단위로 읽거나 쓰는 자료를 문자로 변환해주는 보조 스트림
- FileInputStream으로 읽은 자료를 문자로 변환해 주는 예
```java
public class InputStreamReaderTest {
    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"))) {
            int i;
            while((i = isr.read()) != -1) { // 보조 스트림으로 읽는다.
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### BufferedInputStream과 BufferedOutputStream
- 약 8k의 배열이 제공되어 입출력이 빠르게 하는 기능이 제공되는 보조 스트림
- BufferedReader와 BufferedWriter는 문자용 입출력 보조 스트림
- BufferedInputStream과 BufferedOutputStream을 이용하여 파일 복사하는 예
```java
public class BufferedStreamTest {
  public static void main(String[] args) {

    long millisecond = 0;
    try(FileInputStream fis = new FileInputStream("a.zip");
        FileOutputStream fos = new FileOutputStream("copy.zip");
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos)){

      millisecond = System.currentTimeMillis();

      int i;
      while( ( i = bis.read()) != -1){
        bos.write(i);
      }

      millisecond = System.currentTimeMillis() - millisecond;
    }catch(IOException e) {
      e.printStackTrace();
    }

    System.out.println("파일 복사 하는 데 " + millisecond + " milliseconds 소요되었습니다.");
  }
}
```