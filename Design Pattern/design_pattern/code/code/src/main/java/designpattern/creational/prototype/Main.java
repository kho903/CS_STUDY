package designpattern.creational.prototype;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		BookShelf bookShelf = new BookShelf();

		bookShelf.addBook(new Book("조정래", "태백산맥"));
		bookShelf.addBook(new Book("박완서", "나목"));
		bookShelf.addBook(new Book("박경리", "토지"));

		System.out.println(bookShelf);

		BookShelf another = (BookShelf)bookShelf.clone();
		System.out.println(another);

		bookShelf.getShelf().get(0).setAuthor("김지훈");
		bookShelf.getShelf().get(0).setTitle("자바");

		System.out.println(bookShelf);
		System.out.println(another);
	}
}
