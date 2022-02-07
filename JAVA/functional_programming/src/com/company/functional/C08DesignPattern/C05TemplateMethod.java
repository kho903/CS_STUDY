package com.company.functional.C08DesignPattern;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.company.functional.C08DesignPattern.model.User;
import com.company.functional.C08DesignPattern.service.InternalUserService;
import com.company.functional.C08DesignPattern.service.UserService;
import com.company.functional.C08DesignPattern.service.UserServiceInFunctionalWay;

public class C05TemplateMethod {
	public static void main(String[] args) {
		User alice = User.builder(1, "Alice")
			.with(builder -> {
				builder.emailAddress = "alice@naver.com";
				builder.isVerified = false;
				builder.createdAt = LocalDateTime.now();
				builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
			}).build();

		UserService userService = new UserService();
		InternalUserService internalUserService = new InternalUserService();

		userService.createUser(alice);
		internalUserService.createUser(alice);

		UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
			user -> {
				System.out.println("Validating user " + user.getName());
				return user.getName() != null && user.getEmailAddress().isPresent();
			},
			user -> {
				System.out.println("Writing user " + user.getName() + " to DB");
			}
		);
		userServiceInFunctionalWay.createUser(alice);
	}
}
