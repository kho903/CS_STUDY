package com.company.functional.C04Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.company.functional.C04Stream.model.Order;
import com.company.functional.C04Stream.model.User;

public class C03Map {
	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(3, 6, -4);
		Stream<Integer> numberStream = numberList.stream();
		Stream<Integer> numberStream2 = numberStream.map(x -> x * 2);
		List<Integer> numberListX2 = numberStream2.collect(Collectors.toList());
		System.out.println(numberListX2);

		List<Integer> numberList2 = Arrays.asList(3, 6, -4);
		List<Integer> numberListX2V2 = numberList.stream()
			.map(x -> x * 2)
			.collect(Collectors.toList());
		System.out.println(numberListX2V2);

		Stream<Integer> numberListStream = numberList.stream();
		Stream<String> stringStream = numberListStream.map(x -> "Number is " + x);
		List<String> stringList = stringStream.collect(Collectors.toList());
		System.out.println(stringList);

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
			.setName("Chalie")
			.setVerified(true)
			.setEmailAddress("charlie@naver.com");

		List<User> users = Arrays.asList(user1, user2, user3);
		Stream<User> userStream = users.stream();
		// Stream<String> userEmailStream = userStream.map(user -> user.getEmailAddress());
		Stream<String> userEmailStream = userStream.map(User::getEmailAddress);
		List<String> emailAddress = userEmailStream.collect(Collectors.toList());
		System.out.println(emailAddress);

		List<String> emailAddressSimple = users.stream()
			.map(User::getEmailAddress)
			.collect(Collectors.toList());
		System.out.println(emailAddressSimple);


		Order order1 = new Order()
			.setId(1001)
			.setStatus(Order.OrderStatus.CREATED)
			.setCreatedByUserId(101);
		Order order2 = new Order()
			.setId(1002)
			.setStatus(Order.OrderStatus.ERROR)
			.setCreatedByUserId(103);
		Order order3 = new Order()
			.setId(1003)
			.setStatus(Order.OrderStatus.PROCESSED)
			.setCreatedByUserId(102);
		Order order4 = new Order()
			.setId(1004)
			.setStatus(Order.OrderStatus.ERROR)
			.setCreatedByUserId(104);
		Order order5 = new Order()
			.setId(1005)
			.setStatus(Order.OrderStatus.IN_PROGRESS)
			.setCreatedByUserId(101);

		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		// TODO: userId List

		List<Long> createByUserId = orders.stream()
			.map(Order::getCreatedByUserId)
			.collect(Collectors.toList());
		System.out.println(createByUserId);
	}
}
