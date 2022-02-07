package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.Price;

public class BasicPriceProcessor implements PriceProcessor {
	@Override
	public Price process(Price price) {
		return price;
	}
}
