package com.company.functional.C06StreamAdvanced.service;

import com.company.functional.C06StreamAdvanced.model.User;

public class EmailService {
	public void sendPlayWithFriendsEmail(User user) {
		user.getEmailAddress().ifPresent(email ->
			System.out.println("Sending 'Play with Friends' email to " + email));
	}

	public void sendMakeMoreFriendsEmail(User user) {
		user.getEmailAddress().ifPresent(email ->
			System.out.println("Sending 'Make More Friends' email to " + email));
	}
}
