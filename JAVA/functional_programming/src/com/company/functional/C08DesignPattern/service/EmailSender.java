package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.User;

public class EmailSender {
	private EmailProvider emailProvider;

	public EmailSender setEmailProvider(EmailProvider emailProvider) {
		this.emailProvider = emailProvider;
		return this;
	}

	public void sendEmail(User user) {
		String email = emailProvider.getEmail(user);
		System.out.println("Sending " + email);
	}
}
