package com.company.functional.C07FuncImpl.priceprocessor;

import java.math.BigDecimal;
import java.util.function.Function;

import com.company.functional.C07FuncImpl.model.Order;
import com.company.functional.C07FuncImpl.model.OrderLine;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

	@Override
	public Order apply(Order order) {
		return order.setAmount(order.getOrderLines().stream()
			.map(OrderLine::getAmount)
			.reduce(BigDecimal.ZERO, BigDecimal::add)
		);
	}
}
