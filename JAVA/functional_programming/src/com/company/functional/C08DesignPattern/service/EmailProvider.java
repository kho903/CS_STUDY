package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.User;

public interface EmailProvider {
	String getEmail(User user);
}
