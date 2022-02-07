package com.company.functional.C07FuncImpl;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C02LazyEvaluation {

	public static void main(String[] args) {
		/*if (true || returnFalse()) {
			System.out.println("true");
		}
		if (returnTrue() || returnFalse()) {
			System.out.println("true");
		}*/

		// if (or(returnTrue(), returnFalse())) {
		// 	System.out.println("true");
		// }

		// if (lazyOr(() -> returnTrue(), () -> returnFalse())) {
		// 	System.out.println("true");
		// }

		Stream<Integer> integerStream = Stream.of(3, -2, 5, 8, -3, 10)
			.filter(x -> x > 0)
			.peek(x -> System.out.println("peeking " + x))
			.filter(x -> x % 2 == 0);
		System.out.println("before collect");

		List<Integer> integers = integerStream.collect(Collectors.toList());
		// Collect가 일어나기 전까지 모든 계산을 미룬다.
		System.out.println("After collect: " + integers);
	}

	public static boolean or(boolean x, boolean y) {
		return x || y;
	}

	public static boolean lazyOr(Supplier<Boolean> x, Supplier<Boolean> y) {
		return x.get() || y.get();
	}

	public static boolean returnTrue() {
		System.out.println("Returning true");
		return true;
	}

	public static boolean returnFalse() {
		System.out.println("Returning false");
		return false;
	}
}
