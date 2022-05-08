package designpattern.structural.composite;

public class CategoryClient {
	public static void main(String[] args) {
		ProductCategory womanCategory = new Category(1234, "Woman", 0);
		ProductCategory manCategory = new Category(5678, "Man", 0);

		ProductCategory clothesCategoryW = new Category(2345, "Clothes", 0);
		ProductCategory bagCategoryW = new Category(3456, "Bag", 0);
		ProductCategory shoesCategoryW = new Category(9876, "Shoes", 0);

		womanCategory.addProductCategory(clothesCategoryW);
		womanCategory.addProductCategory(bagCategoryW);
		womanCategory.addProductCategory(shoesCategoryW);

		ProductCategory clothesCategoryM = new Category(23450, "Clothes", 0);
		ProductCategory bagCategoryM = new Category(34560, "Bag", 0);
		ProductCategory shoesCategoryM = new Category(98760, "Shoes", 0);

		manCategory.addProductCategory(clothesCategoryM);
		manCategory.addProductCategory(bagCategoryM);
		manCategory.addProductCategory(shoesCategoryM);

		Product shoes1 = new Product(121, "Nike", 100000);
		Product shoes2 = new Product(122, "Adidas", 200000);
		Product shoes3 = new Product(123, "Gucci", 300000);
		Product shoes4 = new Product(124, "Balencia", 400000);
		Product shoes5 = new Product(125, "Prada", 500000);
		Product shoes6 = new Product(126, "Bally", 600000);

		shoesCategoryW.addProductCategory(shoes1);
		shoesCategoryW.addProductCategory(shoes2);
		shoesCategoryW.addProductCategory(shoes3);

		shoesCategoryM.addProductCategory(shoes4);
		shoesCategoryM.addProductCategory(shoes5);
		shoesCategoryM.addProductCategory(shoes6);

		Product bag1 = new Product(221, "HERMES", 500000);
		Product bag2 = new Product(222, "LOUIS", 500000);
		Product bag3 = new Product(223, "GUCCI", 500000);
		Product bag4 = new Product(224, "BALENCIA", 500000);
		Product bag5 = new Product(225, "PRADA", 500000);
		Product bag6 = new Product(226, "BURBERRY", 500000);

		bagCategoryW.addProductCategory(bag1);
		bagCategoryW.addProductCategory(bag2);
		bagCategoryW.addProductCategory(bag3);

		bagCategoryM.addProductCategory(bag4);
		bagCategoryM.addProductCategory(bag5);
		bagCategoryM.addProductCategory(bag6);

		System.out.println(womanCategory.getCount());
		System.out.println(womanCategory.getPrice());
		System.out.println(manCategory.getCount());
		System.out.println(manCategory.getPrice());
	}
}
