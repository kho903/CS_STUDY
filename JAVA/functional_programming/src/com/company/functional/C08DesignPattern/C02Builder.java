package com.company.functional.C08DesignPattern;

import java.time.LocalDateTime;

import com.company.functional.C08DesignPattern.model.User;

public class C02Builder {
	public static void main(String[] args) {
		// User user = User.builder(1, "Alice")
		// 	.withEmailAddress("alice@naver.com")
		// 	.withVerified(true)
		// 	.withCreatedAt(LocalDateTime.now())
		// 	.build();

		User user = User.builder(1, "Alice")
			.with(builder -> {
				builder.emailAddress = "alice@naver.com";
				builder.isVerified = true;
				builder.createdAt = LocalDateTime.now();
			}).build();
		System.out.println(user);
	}
}
