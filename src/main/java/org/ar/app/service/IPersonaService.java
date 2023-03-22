package org.ar.app.service;

import java.util.List;

import org.ar.app.model.Persona;

public interface IPersonaService {	
	
	public List<Persona> getAllPersonas();
	public Persona getPersonaById(Long id);
	public Persona createPersona(Persona persona);
	public Persona updatePersona(Long id,Persona persona);
	public Persona deletePersona(Long id);
	
}
