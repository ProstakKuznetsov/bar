package by.itstep.bar.exception;

import by.itstep.bar.model.Drink;

public class BadNameDrinkException extends Exception {

	private static final String DEFAULT_MESSAGE = "Not enough products in stock";

	public BadNameDrinkException() {
		super(DEFAULT_MESSAGE);
	}

	public BadNameDrinkException(Drink drink) {
		super(String.format("Name %d is used", drink.getName()));
	}

}
