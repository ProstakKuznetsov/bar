package by.itstep.bar.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.bar.dao.DrinkRepository;
import by.itstep.bar.dao.OrderRepository;
import by.itstep.bar.exception.NotEnoughProductsInStockException;
import by.itstep.bar.model.Drink;
import by.itstep.bar.model.Order;

@Service
public class OrderProcessServiceImpl implements OrderProcessService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private final DrinkRepository drinkRepository;

	private Map<Drink, Integer> drinks = new HashMap<>();

	@Autowired
	public OrderProcessServiceImpl(DrinkRepository drinkRepository) {
		this.drinkRepository = drinkRepository;
	}

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}

	@Override
	public List<Order> findAll() {
		orderRepository.findAll();
		return null;
	}
	
	@Override
	public void removeOrder(Order order) {
		orderRepository.delete(order);
	}

	@Override
	public void addProduct(Drink drink) {
		if (drinks.containsKey(drink)) {
			drinks.replace(drink, drinks.get(drink) + 1);
		} else {
			drinks.put(drink, 1);
		}
	}

	@Override
	public void removeDrink(Drink drink) {
		if (drinks.containsKey(drink)) {
			if (drinks.get(drink) > 1)
				drinks.replace(drink, drinks.get(drink) - 1);
			else if (drinks.get(drink) == 1) {
				drinks.remove(drink);
			}
		}
	}

	@Override
	public void checkout() throws NotEnoughProductsInStockException {
		Drink drink;
		for (Map.Entry<Drink, Integer> entry : drinks.entrySet()) {
			// Refresh quantity for every product before checking
			drink = drinkRepository.getOne(entry.getKey().getId());
			if (drink.getQuantityInWarehouse() < entry.getValue())
				throw new NotEnoughProductsInStockException(drink);
			entry.getKey().setQuantityInWarehouse(drink.getQuantityInWarehouse() - entry.getValue());
		}
		drinkRepository.save((Drink) drinks.keySet());
		drinkRepository.flush();
		drinks.clear();
	}

	@Override
	public BigDecimal getTotal() {
		return drinks.entrySet().stream()
				.map(entry -> entry.getKey().getPricePerServing().multiply(BigDecimal.valueOf(entry.getValue())))
				.reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

}
