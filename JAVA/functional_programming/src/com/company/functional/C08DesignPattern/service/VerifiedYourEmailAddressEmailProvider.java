package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.User;

public class VerifiedYourEmailAddressEmailProvider implements EmailProvider {
	@Override
	public String getEmail(User user) {
		return "'Verify Your Email Address' email for " + user.getName();
	}
}
