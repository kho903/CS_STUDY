package com.company.functional.C06StreamAdvanced;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.company.functional.C06StreamAdvanced.model.Order;
import com.company.functional.C06StreamAdvanced.model.User;

public class C02AllAnyMatch {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
		boolean allPositive = numbers.stream()
			.allMatch(num -> num > 0);
		System.out.println("Are all numbers positive : " + allPositive);

		boolean anyNegative = numbers.stream()
			.anyMatch(num -> num < 0);
		System.out.println("Is any number negative : " + anyNegative);

		User user1 = new User()
			.setId(101)
			.setName("Alice")
			.setVerified(true)
			.setEmailAddress("alice@naver.com");
		User user2 = new User()
			.setId(102)
			.setName("Bob")
			.setVerified(false)
			.setEmailAddress("bob@naver.com");
		User user3 = new User()
			.setId(103)
			.setName("Charlie")
			.setVerified(false)
			.setEmailAddress("charlie@naver.com");

		List<User> users = Arrays.asList(user1, user2, user3);

		boolean areAllUserVerified = users.stream()
			.allMatch(User::isVerified);
		System.out.println(areAllUserVerified);

		Order order1 = new Order()
			.setId(1001L)
			.setAmount(BigDecimal.valueOf(2000))
			.setStatus(Order.OrderStatus.CREATED);
		Order order2 = new Order()
			.setId(1002L)
			.setAmount(BigDecimal.valueOf(4000))
			.setStatus(Order.OrderStatus.ERROR);
		Order order3 = new Order()
			.setId(1003L)
			.setAmount(BigDecimal.valueOf(3000))
			.setStatus(Order.OrderStatus.PROCESSED);
		Order order4 = new Order()
			.setId(1004L)
			.setAmount(BigDecimal.valueOf(7000))
			.setStatus(Order.OrderStatus.ERROR);
		Order order5 = new Order()
			.setId(1005L)
			.setAmount(BigDecimal.valueOf(5000))
			.setStatus(Order.OrderStatus.IN_PROGRESS);
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

		// TODO: check if any of orders is in ERROR status
		boolean isAnyErrorStatus = orders.stream()
			.anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
		System.out.println(isAnyErrorStatus);
	}
}
