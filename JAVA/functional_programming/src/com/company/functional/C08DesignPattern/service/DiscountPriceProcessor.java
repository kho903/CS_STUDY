package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.Price;

public class DiscountPriceProcessor implements PriceProcessor {
	@Override
	public Price process(Price price) {
		return new Price(price.getPrice() + ", then applied discount");
	}
}
