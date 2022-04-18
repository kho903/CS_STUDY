package designpattern.creational.abstract_factory.factory;

import designpattern.creational.abstract_factory.domain.product.dao.ProductDao;
import designpattern.creational.abstract_factory.domain.userinfo.dao.UserInfoDao;

public interface DaoFactory {

	public UserInfoDao createUserInfoDao();
	public ProductDao createProductDao();
}
