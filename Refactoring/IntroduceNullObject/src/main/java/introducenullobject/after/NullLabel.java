package introducenullobject.after;

public class NullLabel extends Label {
	public NullLabel() {
		super(" (none) ");
	}

	public boolean isNull() {
		return true;
	}

	@Override
	public void display() {
	}
}
