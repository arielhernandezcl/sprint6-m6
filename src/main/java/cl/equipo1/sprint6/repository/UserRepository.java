package cl.equipo1.sprint6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.equipo1.sprint6.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String emailId);
}
