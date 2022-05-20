package designpattern.behavioral.iterator;

public class ForwardShelfIterator implements Iterator {

	private BookShelf bookShelf;
	private int index;

	public ForwardShelfIterator(Aggregate list) {
		bookShelf = (BookShelf)list;
		index = 0;
	}

	@Override
	public boolean hasNext() {
		if (index < bookShelf.getLength())
			return true;
		return false;
	}

	@Override
	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}
}
