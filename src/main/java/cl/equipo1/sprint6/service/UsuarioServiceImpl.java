package cl.equipo1.sprint6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.equipo1.sprint6.entity.Usuario;
import cl.equipo1.sprint6.repository.UsuarioRepository;
@Service
public class UsuarioServiceImpl {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	public Usuario createUsuario(Usuario u) {
		return usuarioRepository.save(u);
	}
	public Usuario findById(Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}
	public void deleteUsuarioById(Long id) {
		
		usuarioRepository.deleteById(id);
	}
	public void update(Usuario u) {
		usuarioRepository.save(u);
		
	}

	

}
