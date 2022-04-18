package designpattern.creational.abstract_factory.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import designpattern.creational.abstract_factory.domain.product.Product;
import designpattern.creational.abstract_factory.domain.product.dao.ProductDao;
import designpattern.creational.abstract_factory.domain.product.dao.mysql.ProductMySqlDao;
import designpattern.creational.abstract_factory.domain.userinfo.UserInfo;
import designpattern.creational.abstract_factory.domain.userinfo.dao.UserInfoDao;
import designpattern.creational.abstract_factory.factory.DaoFactory;
import designpattern.creational.abstract_factory.factory.MySqlDaoFactory;
import designpattern.creational.abstract_factory.factory.OracleDaoFactory;

public class WebClient {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/kimjihun/dev/CS_STUDY/Design Pattern/design_pattern/code/code/src/main/java/designpattern/creational/abstract_factory/db.properties");

		Properties prop = new Properties();
		prop.load(fis);

		String dbtype = prop.getProperty("DBTYPE");

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		userInfo.setPassword("!@#$%");
		userInfo.setUserName("이순신");

		Product product = new Product();
		product.setProductId("0011AA");
		product.setProductName("TV");

		DaoFactory daoFactory = null;

		if (dbtype.equals("MYSQL")) {
			daoFactory = new MySqlDaoFactory();
		} else if (dbtype.equals("ORACLE")) {
			daoFactory = new OracleDaoFactory();
		} else {
			System.out.println("error");
		}

		UserInfoDao userInfoDao = daoFactory.createUserInfoDao();
		userInfoDao.insertUser(userInfo);
		userInfoDao.updateUser(userInfo);
		userInfoDao.deleteUser(userInfo);

		ProductDao productDao = daoFactory.createProductDao();
		productDao.insertProduct(product);
		productDao.updateProduct(product);
		productDao.deleteProduct(product);
	}
}
