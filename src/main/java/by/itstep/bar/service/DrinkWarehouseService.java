package by.itstep.bar.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import by.itstep.bar.model.Drink;

@Service
public interface DrinkWarehouseService {

	void save(Drink drink);

	List<Drink> findAll();
	
	Drink findById(Long id);
	
	Page<Drink> findAllProductsPageable(Pageable pageable);
}
