package by.itstep.bar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itstep.bar.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
