package designpattern.creational.prototype;

import java.util.ArrayList;

public class BookShelf implements Cloneable {
	private ArrayList<Book> shelf;

	public BookShelf() {
		shelf = new ArrayList<Book>();
	}

	public void addBook(Book book) {
		shelf.add(book);
	}

	public ArrayList<Book> getShelf() {
		return shelf;
	}

	public void setShelf(ArrayList<Book> shelf) {
		this.shelf = shelf;
	}

	@Override
	public String toString() {
		return shelf.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 얕은 복사 (주소를 복사해 주었기 때문에 같이 변형됨)
		// return super.clone();

		// 깊은 복사
		BookShelf another = new BookShelf();
		for (Book book : shelf) {
			another.addBook(new Book(book.getAuthor(), book.getTitle()));
		}

		return another;
	}
}
