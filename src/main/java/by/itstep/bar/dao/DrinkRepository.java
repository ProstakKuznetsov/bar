package by.itstep.bar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itstep.bar.model.Drink;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}