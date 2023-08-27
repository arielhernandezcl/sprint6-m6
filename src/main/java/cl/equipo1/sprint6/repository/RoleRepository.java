package cl.equipo1.sprint6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.equipo1.sprint6.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByRole(String name);
}
