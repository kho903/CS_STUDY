package designpattern.behavioral.visitor;

import java.util.Iterator;

public class ListVisitor extends Visitor {

	private String currentDir = "";

	@Override
	public void visitFile(File file) {
		System.out.println(currentDir + "/" + file);
	}

	@Override
	public void visitDirectory(Directory directory) {
		System.out.println(currentDir + "/" + directory);
		String saveDir = currentDir;
		currentDir = currentDir + "/" + directory.getName();
		Iterator<Entry> it = directory.iterator();
		while (it.hasNext()) {
			Entry entry = (Entry) it.next();

			entry.accept(this);
		}
		currentDir = saveDir;
	}
}
