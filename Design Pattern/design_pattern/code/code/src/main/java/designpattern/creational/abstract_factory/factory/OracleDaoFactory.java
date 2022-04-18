package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.domain.product.dao.ProductDao;
import designpattern.creational.abstract_factory.domain.product.dao.oracle.ProductOracleDao;
import designpattern.creational.abstract_factory.domain.userinfo.dao.UserInfoDao;
import designpattern.creational.abstract_factory.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class OracleDaoFactory implements DaoFactory {
	@Override
	public UserInfoDao createUserInfoDao() {
		return new UserInfoOracleDao();
	}

	@Override
	public ProductDao createProductDao() {
		return new ProductOracleDao();
	}
}
