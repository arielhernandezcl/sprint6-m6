package cl.equipo1.sprint6.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import cl.equipo1.sprint6.dto.UserRegisteredDTO;
import cl.equipo1.sprint6.model.User;



public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);
	
}
