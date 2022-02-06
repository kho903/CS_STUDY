package com.company.functional.C06StreamAdvanced;

import java.util.Optional;
import java.util.stream.Stream;

public class C03FindFirstAny {

	public static void main(String[] args) {
		Optional<Integer> anyNegativeInteger = Stream.of(3, 2, -5, 6)
			.filter(x -> x < 0)
			.findAny();
		System.out.println(anyNegativeInteger.get());

		Optional<Integer> firstPositiveInt = Stream.of(3, 2, -5, 6)
			.filter(x -> x > 0)
			.findFirst();

		System.out.println(firstPositiveInt.get());

	}
}
