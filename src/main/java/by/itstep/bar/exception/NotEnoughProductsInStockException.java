
package by.itstep.bar.exception;

import by.itstep.bar.model.Drink;

public class NotEnoughProductsInStockException extends Exception {

	private static final String DEFAULT_MESSAGE = "Not enough products in stock";

	public NotEnoughProductsInStockException() {
		super(DEFAULT_MESSAGE);
	}

	public NotEnoughProductsInStockException(Drink drink) {
		super(String.format("Not enough %s products in stock. Only %d left", drink.getName()));
	}

}
