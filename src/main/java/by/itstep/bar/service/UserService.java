package by.itstep.bar.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import by.itstep.bar.model.User;

@Service
public interface UserService extends UserDetailsService{

	public void save(User user);
}
