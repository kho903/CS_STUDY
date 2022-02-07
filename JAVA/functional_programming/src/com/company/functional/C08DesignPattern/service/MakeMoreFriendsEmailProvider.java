package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.User;

public class MakeMoreFriendsEmailProvider implements EmailProvider{
	@Override
	public String getEmail(User user) {
		return "'Make more Friends' email for " + user.getName();
	}
}
