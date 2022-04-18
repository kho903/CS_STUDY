package designpattern.creational.abstract_factory.domain.product.dao;

import designpattern.creational.abstract_factory.domain.product.Product;

public interface ProductDao {

	void insertProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);

}
