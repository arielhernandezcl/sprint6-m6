package cl.equipo1.sprint6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import cl.equipo1.sprint6.entity.Usuario;
import cl.equipo1.sprint6.service.UsuarioServiceImpl;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/listar")
    public String listarUsuarios(Model model) {
		List<Usuario> listausuarios = usuarioService.getAll();
		
        model.addAttribute("titulo", "Listado de Usuarios");
        model.addAttribute("usuarios", listausuarios);
        return "usuarios/listar";
    }
	@GetMapping("/crear")
    public String crearUsuarios(Model model) {
        model.addAttribute("titulo", "Formulario de Usuarios");
        model.addAttribute("usuario", new Usuario());
        return "usuarios/crear";
    }
	@PostMapping("/crear")
    public String crearUsuarios(@ModelAttribute Usuario usuario) {
		usuarioService.createUsuario(usuario);
        return "redirect:/usuarios/listar";
    }
	@GetMapping("/editar/{id}")
	public String mostrarEditarUsuario(@PathVariable("id") Long id, Model model) {
		Usuario usuario = usuarioService.findById(id);
		model.addAttribute("titulo", "Editar Usuario");
		model.addAttribute("usuario", usuario);
		return "usuarios/editar";
	}
    @PostMapping("/editar")
	public String editarCapacitacion(@ModelAttribute Usuario usuario) {
    	usuarioService.update(usuario);
		return "redirect:/usuarios/listar";
	}
    @GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable Long id) {
    	usuarioService.deleteUsuarioById(id);
		return "redirect:/usuarios/listar";
	}
}

