package typecodewithclass.before;

public class Main {

	public static void main(String[] args) {
		Item bookItem = new Item(Item.TYPECODE_BOOK, "토지", 10000);
		Item dvdItem = new Item(Item.TYPECODE_DVD, "바람과 함께 사라지다", 20000);
		Item softwareItem = new Item(Item.TYPECODE_SOFTWARE, "Windows", 30000);

		System.out.println(bookItem);
		System.out.println(dvdItem);
		System.out.println(softwareItem);
	}
}
