package designpattern.creational.abstract_factory.domain.userinfo.dao;

import designpattern.creational.abstract_factory.domain.userinfo.UserInfo;

public interface UserInfoDao {
	void insertUser(UserInfo userInfo);
	void updateUser(UserInfo userInfo);
	void deleteUser(UserInfo userInfo);
}
