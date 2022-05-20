package designpattern.behavioral.iterator;

public class IteratorFactory extends Factory {
	private static IteratorFactory ifactory = new IteratorFactory();

	private IteratorFactory() {

	}

	public static IteratorFactory getInstance() {
		return ifactory;
	}

	@Override
	public Iterator createProduct(Aggregate list, int type) {
		if (type == Constant.FORWARD) {
			return new ForwardShelfIterator(list);
		} else if (type == Constant.REVERSE) {
			return new ReverseShelfIterator(list);
		}
		return null;
	}
}
