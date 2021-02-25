
package by.itstep.bar.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import by.itstep.bar.exception.NotEnoughProductsInStockException;
import by.itstep.bar.model.Drink;
import by.itstep.bar.model.Order;

@Service
public interface OrderProcessService {

	void save(Order order);
	
	List<Order> findAll();

	void removeOrder(Order order);

	void addProduct(Drink drink);
	
	void removeDrink(Drink drink);
	
	void checkout() throws NotEnoughProductsInStockException;

	BigDecimal getTotal();

}
