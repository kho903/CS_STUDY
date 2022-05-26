package typecodewithclass.after;

public class Item {

	public static final int TYPECODE_BOOK = ItemType.BOOK.getTypeCode();
	public static final int TYPECODE_DVD = ItemType.DVD.getTypeCode();
	public static final int TYPECODE_SOFTWARE = ItemType.SOFTWARE.getTypeCode();

	private int typeCode;
	private String title;
	private int price;

	public Item(int typeCode, String title, int price) {
		this.typeCode = typeCode;
		this.title = title;
		this.price = price;
	}

	public int getTypeCode() {
		return typeCode;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return getTypeCode() + ", " + getTitle() + ", " + getPrice();
	}
}
