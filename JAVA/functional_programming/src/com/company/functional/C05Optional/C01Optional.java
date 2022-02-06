package com.company.functional.C05Optional;

import java.util.Optional;

import com.company.functional.C05Optional.model.User;

public class C01Optional {
	public static void main(String[] args) {
		User user1 = new User()
			.setId(1001)
			.setName("Alice")
			.setVerified(false);

		User user2 = new User()
			.setId(1001)
			.setName("Alice")
			.setEmailAddress("alice@naver.com")
			.setVerified(false);

		System.out.println("Same? : " + userEquals(user2, user1));
		// System.out.println("Same? : " + userEquals(user1, user2)); // NullPointerException

		String someEmail = "some@email.com";
		String nullEmail = null;

		Optional<String> maybeEmail = Optional.of(someEmail);
		Optional<String> maybeEmail2 = Optional.empty();
		Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
		Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

		String email = maybeEmail.get();
		System.out.println(email);

		// String email2 = maybeEmail2.get(); // NullPointerException
		// System.out.println(email2);

		if (maybeEmail2.isPresent()) {
			System.out.println(maybeEmail2.get());
		}

		String defaultEmail = "default@email.com";
		String email3 = maybeEmail2.orElse(defaultEmail);
		System.out.println(email3);

		String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
		System.out.println(email4);

		String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));
	}

	public static boolean userEquals(User u1, User u2) {
		return u1.getId() == u2.getId()
			&& u1.getName().equals(u2.getName())
			&& u1.getEmailAddress().equals(u2.getEmailAddress())
			&& u1.isVerified() == u2.isVerified();
	}
}
