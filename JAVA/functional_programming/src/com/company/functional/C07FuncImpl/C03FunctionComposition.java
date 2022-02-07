package com.company.functional.C07FuncImpl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.company.functional.C07FuncImpl.model.Order;
import com.company.functional.C07FuncImpl.model.OrderLine;
import com.company.functional.C07FuncImpl.priceprocessor.OrderLineAggregationPriceProcessor;
import com.company.functional.C07FuncImpl.priceprocessor.TaxPriceProcessor;

public class C03FunctionComposition {
	public static void main(String[] args) {
		Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
		Function<Integer, Integer> addTen = x -> x + 10;

		Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen);
		// System.out.println(composedFunction.apply(3));

		Order unprocessedOrder = new Order()
			.setId(1001L)
			.setOrderLines(Arrays.asList(
				new OrderLine().setAmount(BigDecimal.valueOf(1000)),
				new OrderLine().setAmount(BigDecimal.valueOf(2000))
			));

		List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);

		Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
			.reduce(Function.identity(), Function::andThen);

		Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
		System.out.println(processedOrder);
	}

	public static List<Function<Order, Order>> getPriceProcessors(Order order) {
		return Arrays.asList(new OrderLineAggregationPriceProcessor(),
			new TaxPriceProcessor(new BigDecimal("9.375")));
	}
}