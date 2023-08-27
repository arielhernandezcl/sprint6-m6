package cl.equipo1.sprint6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.equipo1.sprint6.entity.Capacitacion;
import cl.equipo1.sprint6.repository.CapacitacionRepository;

@Service
public class CapacitacionServiceImpl {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    public List<Capacitacion> getAll() {
        return (List<Capacitacion>) capacitacionRepository.findAll();
    }
    
    
    public Capacitacion crearCapacitacion(Capacitacion capacitacion) {
    	
    	capacitacionRepository.save(capacitacion);
    	
    	return capacitacion;
    }
    
    
}