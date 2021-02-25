package by.itstep.bar.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import by.itstep.bar.dao.DrinkRepository;
import by.itstep.bar.model.Drink;
import by.itstep.bar.service.DrinkWarehouseService;
import by.itstep.bar.util.Pager;

@Controller
public class GuestController {

	private static final int INITIAL_PAGE = 0;
	
	@Autowired
	DrinkWarehouseService drinkWarehouseService;

	@RequestMapping("/")
	public String goHomePage() {
		return "homePage";
	}

	@GetMapping("/menu")
	public ModelAndView menu(@RequestParam("page") Optional<Integer> page) {

		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		Page<Drink> drinks = drinkWarehouseService.findAllProductsPageable(PageRequest.of(evalPage, 10));
		Pager pager = new Pager(drinks);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("drinks", drinks);
		modelAndView.addObject("pager", pager);
		modelAndView.setViewName("/menu");
		return modelAndView;
	}
}
