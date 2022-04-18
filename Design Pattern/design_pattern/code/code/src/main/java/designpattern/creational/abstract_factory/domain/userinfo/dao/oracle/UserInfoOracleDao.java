package designpattern.creational.abstract_factory.domain.userinfo.dao.oracle;

import designpattern.creational.abstract_factory.domain.userinfo.UserInfo;
import designpattern.creational.abstract_factory.domain.userinfo.dao.UserInfoDao;

public class UserInfoOracleDao implements UserInfoDao {
	@Override
	public void insertUser(UserInfo userInfo) {
		System.out.println("insert into Oracle DB userId" + userInfo.getUserId());
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		System.out.println("update into Oracle DB userId" + userInfo.getUserId());
	}

	@Override
	public void deleteUser(UserInfo userInfo) {
		System.out.println("delete from Oracle DB userId" + userInfo.getUserId());
	}
}
