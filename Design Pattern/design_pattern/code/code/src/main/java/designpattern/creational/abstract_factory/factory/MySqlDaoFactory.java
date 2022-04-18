package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.domain.product.dao.ProductDao;
import designpattern.creational.abstract_factory.domain.product.dao.mysql.ProductMySqlDao;
import designpattern.creational.abstract_factory.domain.userinfo.dao.UserInfoDao;
import designpattern.creational.abstract_factory.domain.userinfo.dao.mysql.UserInfoMySqlDao;

public class MySqlDaoFactory implements DaoFactory {
	@Override
	public UserInfoDao createUserInfoDao() {
		return new UserInfoMySqlDao();
	}

	@Override
	public ProductDao createProductDao() {
		return new ProductMySqlDao();
	}
}
