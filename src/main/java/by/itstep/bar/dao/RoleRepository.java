package by.itstep.bar.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.itstep.bar.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByName(String name);
}
