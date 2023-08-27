package cl.equipo1.sprint6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.equipo1.sprint6.entity.Capacitacion;
import cl.equipo1.sprint6.service.CapacitacionServiceImpl;


@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    @Autowired
    private CapacitacionServiceImpl capacitacionService;

    @GetMapping("/listar")
    public String listarCapacitaciones(Model model) {
        List<Capacitacion> listacapacitaciones = capacitacionService.getAll();

        model.addAttribute("titulo", "Listado Capacitaciones");
        model.addAttribute("capacitaciones", listacapacitaciones);
        return "/capacitaciones/listar";
    }
    
    @GetMapping("/crear")
    public String capacitacionForm() {
    	
    	return "capacitaciones/capacitacionForm";
    }
    
    @PostMapping("/crear")
    public String crearCapacitacion(@RequestParam String rut, @RequestParam String dia, @RequestParam String hora, @RequestParam String lugar, @RequestParam String cantidad ) {
    	
    	Capacitacion capacitacion = new Capacitacion(rut, dia, hora, lugar, cantidad);
    	capacitacionService.crearCapacitacion(capacitacion);
    	
    	return "redirect:/capacitaciones/listar";
    }


}