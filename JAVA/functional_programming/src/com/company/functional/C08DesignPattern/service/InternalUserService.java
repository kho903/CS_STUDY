package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.User;

public class InternalUserService extends AbstractUserService {
	@Override
	protected boolean validateUser(User user) {
		System.out.println("Validating internal user " + user.getName());
		return true;
	}

	@Override
	protected void writeToDB(User user) {
		System.out.println("Writing user " + user.getName() + " to internal DB");
	}
}
