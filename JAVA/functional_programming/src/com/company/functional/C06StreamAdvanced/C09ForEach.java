package com.company.functional.C06StreamAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.company.functional.C06StreamAdvanced.model.User;
import com.company.functional.C06StreamAdvanced.service.EmailService;

public class C09ForEach {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
		// numbers.stream().forEach(number -> System.out.println("The Number is " + number));
		numbers.forEach(number -> System.out.println("The Number is " + number));

		User user1 = new User()
			.setId(101)
			.setName("Alice")
			.setEmailAddress("Alice@naver.com")
			.setVerified(true);
		User user2 = new User()
			.setId(102)
			.setName("Bob")
			.setEmailAddress("Bob@naver.com")
			.setVerified(false);
		User user3 = new User()
			.setId(103)
			.setName("Charlie")
			.setEmailAddress("Charlie@naver.com")
			.setVerified(false);
		List<User> users = Arrays.asList(user1, user2, user3);

		EmailService emailService = new EmailService();

		users.stream()
			.filter(user -> !user.isVerified())
			.forEach(emailService::sendVerifyYourEmailEmail);

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			System.out.println("Do an operation on user " + user.getName() + " at index " + i);
		}
		IntStream.range(0, users.size()).forEach(i -> {
			User user = users.get(i);
			System.out.println("Do an operation on user " + user.getName() + " at index " + i);
		});
	}
}
