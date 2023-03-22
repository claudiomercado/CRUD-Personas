package org.ar.app.service;

import java.util.List;

import org.ar.app.model.Persona;
import org.ar.app.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository repository;
	
	@Override
	public List<Persona> getAllPersonas() {
		return repository.findAll();
	}

	@Override
	public Persona getPersonaById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Persona createPersona(Persona persona) {
		return repository.save(persona);
	}

	@Override
	public Persona updatePersona(Long id, Persona persona) {
		Persona p1 = getPersonaById(id);
		
		p1.setId(id);
		p1.setNombre(persona.getNombre());
		p1.setApellido(persona.getApellido());
		p1.setEdad(persona.getEdad());
		p1.setDni(persona.getDni());
		
		repository.save(p1);
		return p1;
	}

	@Override
	public Persona deletePersona(Long id) {
		Persona p1 = getPersonaById(id);
		repository.deleteById(id);
		return p1;
	}

	
	
}
