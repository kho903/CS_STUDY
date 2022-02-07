package com.company.functional.C08DesignPattern;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.company.functional.C08DesignPattern.model.User;
import com.company.functional.C08DesignPattern.service.EmailProvider;
import com.company.functional.C08DesignPattern.service.EmailSender;
import com.company.functional.C08DesignPattern.service.MakeMoreFriendsEmailProvider;
import com.company.functional.C08DesignPattern.service.VerifiedYourEmailAddressEmailProvider;

public class C04Strategy {
	public static void main(String[] args) {
		User user1 = User.builder(1, "Alice")
			.with(builder -> {
				builder.emailAddress = "alice@naver.com";
				builder.isVerified = false;
				builder.createdAt = LocalDateTime.now();
				builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
			}).build();

		User user2 = User.builder(2, "Bob")
			.with(builder -> {
				builder.emailAddress = "bob@naver.com";
				builder.isVerified = true;
				builder.createdAt = LocalDateTime.now();
				builder.friendUserIds = Arrays.asList(211, 212, 214);
			}).build();

		User user3 = User.builder(3, "Charlie")
			.with(builder -> {
				builder.emailAddress = "charlie@naver.com";
				builder.isVerified = true;
				builder.createdAt = LocalDateTime.now();
				builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212);
			}).build();

		List<User> users = Arrays.asList(user1, user2, user3);

		EmailSender emailSender = new EmailSender();
		EmailProvider verifyYourEmailAddressEmailProvider = new VerifiedYourEmailAddressEmailProvider();
		EmailProvider makeMoreFriendsEmailProvider = new MakeMoreFriendsEmailProvider();

		emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);
		users.stream()
			.filter(user -> !user.isVerified())
			.forEach(emailSender::sendEmail);

		emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
		users.stream()
			.filter(User::isVerified)
			.filter(user -> user.getFriendUserIds().size() <= 5)
			.forEach(emailSender::sendEmail);

		emailSender.setEmailProvider(user -> "'Play with Friends' email for " + user.getName());
		users.stream()
			.filter(User::isVerified)
			.filter(user -> user.getFriendUserIds().size() > 5)
			.forEach(emailSender::sendEmail);
	}
}
