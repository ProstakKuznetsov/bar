package by.itstep.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import by.itstep.bar.dao.DrinkRepository;
import by.itstep.bar.model.Drink;
import by.itstep.bar.model.Order;
import by.itstep.bar.service.DrinkWarehouseService;
import by.itstep.bar.service.OrderProcessService;

@Controller
public class WaiterController {

	@Autowired
	private OrderProcessService orderProcessService;
	
	@Autowired
	private DrinkWarehouseService drinkWarehouseService; 
	
	@PostMapping("/createOrder")
	public String createOrder(Model model) {
		model.addAttribute("order", new Order());
		model.addAttribute("drinks", drinkWarehouseService.findAll());
		return "createOrder";
	}
	
	@PostMapping("/addDrinkInOrder/{count}")
	public String addDrinkInOrder(@PathVariable("count") Integer count, Drink drink) {
		
		return "newOrder";
	}
}
