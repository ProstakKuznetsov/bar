package by.itstep.bar.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itstep.bar.model.Drink;
import by.itstep.bar.service.DrinkWarehouseService;
import by.itstep.bar.util.Pager;

@Controller
public class AdminController {

	private static final int INITIAL_PAGE = 0;
	
	@Autowired
	private DrinkWarehouseService drinkWarehouseService;

	@GetMapping("/user")
	public String showUsers() {
		return "user";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/warehouse")
	public String warehouse(Model model) {
		model.addAttribute("drink", new Drink());
		model.addAttribute("drinks", drinkWarehouseService.findAll());
		return "warehouse";
	}

	@PostMapping("/changeQuantityMinus/{id}")
	public String increaseQuantityByWarehouse(@PathVariable("id") String id,
			@RequestParam(value = "newQuantityMinus") String newQuantity, Model model) {
		Long thisId = Long.valueOf(id);
		Long thisNewQuantity = Long.valueOf(newQuantity);
		Drink drinks = drinkWarehouseService.findById(thisId);
		drinks.setQuantityInWarehouse(drinks.getQuantityInWarehouse() - thisNewQuantity);
		drinkWarehouseService.save(drinks);
		model.addAttribute("drink", new Drink());
		model.addAttribute("drinks", drinkWarehouseService.findAll());
		return "warehouse";
	}

	@PostMapping("/changeQuantityPlus/{id}")
	public String reduceQuantityByWarehouse(@PathVariable("id") String id,
			@RequestParam(value = "newQuantityPlus") String newQuantity, Model model) {
		Long thisId = Long.valueOf(id);
		Long thisNewQuantity = Long.valueOf(newQuantity);
		Drink drinks = drinkWarehouseService.findById(thisId);
		drinks.setQuantityInWarehouse(drinks.getQuantityInWarehouse() + thisNewQuantity);
		drinkWarehouseService.save(drinks);
		model.addAttribute("drink", new Drink());
		model.addAttribute("drinks", drinkWarehouseService.findAll());
		return "warehouse";
	}

	@PostMapping("/warehouse")
	public ModelAndView getAllDrinksAfterAdd(@RequestParam("page") Optional<Integer> page, Drink drink, Model model) {
		Boolean isSaved = false;
		if (drink.getName()!=null) {
			List<Drink> allDrinks = drinkWarehouseService.findAll();
			for (Drink newDrink : allDrinks) {
				if (newDrink.getName().equalsIgnoreCase(drink.getName())){
					Drink changedDrink = drinkWarehouseService.findById(newDrink.getId());
					Long quantity = changedDrink.getQuantityInWarehouse();
					changedDrink.setQuantityInWarehouse(quantity + drink.getQuantityInWarehouse());
					drinkWarehouseService.save(changedDrink);
					isSaved = true;
					break;
				} else {
					continue;
				}
			} if(!isSaved) drinkWarehouseService.save(drink);
		}
		 
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		Page<Drink> drinks = drinkWarehouseService.findAllProductsPageable(PageRequest.of(evalPage, 10));
		Pager pager = new Pager(drinks);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("drinks", drinks);
		modelAndView.addObject("pager", pager);
		modelAndView.setViewName("/warehouse");
		return modelAndView;
	}
}