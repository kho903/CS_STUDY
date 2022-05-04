package designpattern.structural.bridge.list;

import designpattern.structural.bridge.impl.AbstractList;

public abstract class List<T> {
	AbstractList<T> impl;

	public List(AbstractList<T> impl) {
		this.impl = impl;
	}

	public void add(T obj) {
		impl.addElement(obj);
	}

	public T remove(int i) {
		return impl.deleteElement(i);
	}

	public T get(int i) {
		return impl.getElement(i);
	}

	public int getSize() {
		return impl.getElementSize();
	}

	public String toString() {
		return impl.toString();
	}
}
