package typecodewithclass.after2;

public class Item {

	public static final int TYPECODE_BOOK = ItemType.BOOK.getTypeCode();
	public static final int TYPECODE_DVD = ItemType.DVD.getTypeCode();
	public static final int TYPECODE_SOFTWARE = ItemType.SOFTWARE.getTypeCode();

	private ItemType itemType;
	private String title;
	private int price;

	public Item(ItemType itemType, String title, int price) {
		this.itemType = itemType ;
		this.title = title;
		this.price = price;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return itemType.getTypeCode() + ", " + getTitle() + ", " + getPrice();
	}
}
