package by.itstep.bar.util;

import org.springframework.data.domain.Page;

import by.itstep.bar.model.Drink;

public class Pager {

	private final Page<Drink> drinks;

	public Pager(Page<Drink> drinks) {
		this.drinks = drinks;
	}

	public int getPageIndex() {
		return drinks.getNumber() + 1;
	}

	public int getPageSize() {
		return drinks.getSize();
	}

	public boolean hasNext() {
		return drinks.hasNext();
	}

	public boolean hasPrevious() {
		return drinks.hasPrevious();
	}

	public int getTotalPages() {
		return drinks.getTotalPages();
	}

	public long getTotalElements() {
		return drinks.getTotalElements();
	}

	public boolean indexOutOfBounds() {
		return this.getPageIndex() < 0 || this.getPageIndex() > this.getTotalElements();
	}

}