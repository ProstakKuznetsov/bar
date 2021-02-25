package by.itstep.bar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itstep.bar.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findByLogin(String login);
}