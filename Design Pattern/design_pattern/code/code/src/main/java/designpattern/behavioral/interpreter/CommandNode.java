package designpattern.behavioral.interpreter;

public class CommandNode extends Node {
	private Node node;
	public void parse(Context context) throws ParseException, java.text.ParseException {
		if (context.currentToken().equals("repeat")) {
			node = new RepeatCommandNode();
			node.parse(context);
		} else {
			node = new PrimitiveCommandNode();
			node.parse(context);
		}
	}
	public String toString() {
		return node.toString();
	}
}
