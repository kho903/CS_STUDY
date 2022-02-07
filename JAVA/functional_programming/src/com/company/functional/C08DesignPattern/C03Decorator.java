package com.company.functional.C08DesignPattern;

import com.company.functional.C08DesignPattern.model.Price;
import com.company.functional.C08DesignPattern.service.BasicPriceProcessor;
import com.company.functional.C08DesignPattern.service.DiscountPriceProcessor;
import com.company.functional.C08DesignPattern.service.PriceProcessor;
import com.company.functional.C08DesignPattern.service.TaxPriceProcessor;

public class C03Decorator {
	public static void main(String[] args) {
		Price unprocessedPrice = new Price("Original Price");

		PriceProcessor basicPriceProcessor = new BasicPriceProcessor();
		PriceProcessor discountPriceProcessor = new DiscountPriceProcessor();
		PriceProcessor taxPriceProcessor = new TaxPriceProcessor();

		PriceProcessor decoratedPriceProcessor = basicPriceProcessor
			.andThen(discountPriceProcessor)
			.andThen(taxPriceProcessor);
		Price processedPrice = decoratedPriceProcessor.process(unprocessedPrice);
		System.out.println(processedPrice.getPrice());

		PriceProcessor decoratedPriceProcessor2 = basicPriceProcessor
			.andThen(taxPriceProcessor)
			.andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
		Price processedPrice2 = decoratedPriceProcessor2.process(unprocessedPrice);
		System.out.println(processedPrice2.getPrice());
	}
}
