package by.itstep.bar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import by.itstep.bar.dao.DrinkRepository;
import by.itstep.bar.model.Drink;

@Service
public class DrinkWarehouseServiceImpl implements DrinkWarehouseService {

	@Autowired
	private DrinkRepository drinkRepository;

	@Override
	public void save(Drink drink) {
		drinkRepository.save(drink);
	}

	@Override
	public List<Drink> findAll() {
		return drinkRepository.findAll();
	}

	@Override
	public Drink findById(Long id) {
		return drinkRepository.findById(id).orElse(null);
	}

	@Override
	public Page<Drink> findAllProductsPageable(Pageable pageable) {
		return drinkRepository.findAll(pageable);
	}
}
