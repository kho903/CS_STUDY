package introducenullobject.after;

public class Label {
	private String label;

	public Label(String label) {
		this.label = label;
	}

	public void display() {
		System.out.println("display : " + label);
	}

	public boolean isNull() {
		return false;
	}

	@Override
	public String toString() {
		return "\"" + label + "\"";
	}
}
