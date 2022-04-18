package designpattern.creational.abstract_factory.domain.userinfo.dao.mysql;

import designpattern.creational.abstract_factory.domain.userinfo.UserInfo;
import designpattern.creational.abstract_factory.domain.userinfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao {
	@Override
	public void insertUser(UserInfo userInfo) {
		System.out.println("insert into MySQL DB userId = " + userInfo.getUserId());
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		System.out.println("update into MySQL DB userId = " + userInfo.getUserId());
	}

	@Override
	public void deleteUser(UserInfo userInfo) {
		System.out.println("delete from MySQL DB userId = " + userInfo.getUserId());
	}
}
