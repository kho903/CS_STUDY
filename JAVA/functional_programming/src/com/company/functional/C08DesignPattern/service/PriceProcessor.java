package com.company.functional.C08DesignPattern.service;

import com.company.functional.C08DesignPattern.model.Price;

@FunctionalInterface
public interface PriceProcessor {
	Price process(Price price);

	default PriceProcessor andThen(PriceProcessor next) {
		return price -> next.process(process(price));
	}
}
