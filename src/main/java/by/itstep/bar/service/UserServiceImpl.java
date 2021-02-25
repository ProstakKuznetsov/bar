package by.itstep.bar.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import by.itstep.bar.dao.RoleRepository;
import by.itstep.bar.dao.UserRepository;
import by.itstep.bar.model.Role;
import by.itstep.bar.model.User;

@Service
@Order(1)
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UserRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public void save(User user) {
		List<Role> roles = (List<Role>) user.getRoles();
		if (roles.get(0) != null && roles.get(0).getId() == null) {
			Role role = roleRepository.findByName(roles.get(0).getName());
			roles.set(0, role);
		}
		user.setPassword(encoder.encode(user.getPassword()));
		repository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User optionalUser = repository.findByLogin(username);
		if (optionalUser != null) {

			List<String> roleList = new ArrayList<String>();
			for (Role role : optionalUser.getRoles()) {
				roleList.add(role.getName());
			}

			return org.springframework.security.core.userdetails.User.builder().username(optionalUser.getLogin())
					.password(optionalUser.getPassword()).roles(roleList.toArray(new String[0])).build();
		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}
	}

}
