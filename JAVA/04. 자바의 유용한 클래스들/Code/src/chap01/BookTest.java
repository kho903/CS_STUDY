package chap01;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + ", " + author;
    }
}

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("데미안", "헤르만 헤세");
        System.out.println(book); // toString 오버라이드 전 : 패키지 이름 @ 가상 메모리값
        // toString 오버라이드 후 : 데미안, 헤르만 헤세

        String str = new String("test");
        System.out.println(str); // test
        System.out.println(str.toString()); // test

    }
}
