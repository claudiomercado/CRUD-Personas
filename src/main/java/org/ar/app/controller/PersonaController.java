package org.ar.app.controller;

import java.util.List;

import org.ar.app.apiresponseutil.ApiResponseUtil;
import org.ar.app.apiresponseutil.BaseApiResponse;
import org.ar.app.model.Persona;
import org.ar.app.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1")
public class PersonaController extends BaseApiResponse {

	@Autowired
	private IPersonaService service;
	
	@GetMapping("/getPersonas")
	public List<Persona> getAllPersonas(){
		return service.getAllPersonas();
	}
		
	@GetMapping("/getPersonaById")
	public Persona getPersonaById(@RequestParam(name = "id") Long id){
		return service.getPersonaById(id);
	}
	
	@PostMapping("/createPersona")
	public Persona createPersona(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer edad, @RequestParam String dni){
		return service.createPersona(service.createEntityPersona(nombre, apellido, edad, dni));
	}
	
	@PatchMapping("/updatePersona")
	public Persona updatePersona(@RequestParam(name = "id") Long id, @RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer edad, @RequestParam String dni){
		return service.updatePersona(id,service.createEntityPersona(nombre, apellido, edad, dni));
	}
	
	@DeleteMapping("/deletePersona")
	public Persona deletePersona(@RequestParam(name = "id") Long id){
		return service.deletePersona(id);
	}
	
//Metodos que redireccionan a las diferentes vistas 
	
	@GetMapping("/index")
	public ModelAndView templateIndex() {
		ModelAndView mav = new ModelAndView("index");
	  return mav;
	}
	
	@GetMapping("/buttonTemplateCreate")
	public ModelAndView templateCreatePersona() {
		ModelAndView mav = new ModelAndView("createPersona");
	  return mav;
	}
	
	@GetMapping("/buttonTemplateList")
	public ModelAndView templateListPersonas() {
		List<Persona> personas = getAllPersonas();
		ModelAndView mav = new ModelAndView("listPersona");
		mav.addObject("personas", personas);
	  return mav;
	}
	
	@GetMapping("/buttonTemplateEdit/{id}")
	public ModelAndView templateEditPersona(@PathVariable("id")Long id) {
		Persona persona = getPersonaById(id);
		ModelAndView mav = new ModelAndView("editPersona");
		mav.addObject("persona", persona);
	  return mav;
	}
	
	@GetMapping("/buttonDelete/{id}")
	public ModelAndView buttonDeletePersona(@PathVariable("id")Long id) {
		this.deletePersona(id);
		return this.templateListPersonas();
	}
	
	@PostMapping("/templateCreate")
	public ModelAndView templateCreate(@RequestParam String nombre,@RequestParam String apellido,@RequestParam Integer edad,@RequestParam String dni){
		this.createPersona(nombre,apellido,edad,dni);
		return this.templateIndex();
	}
	
	@PostMapping("/templateEdit")
	public ModelAndView templateEdit(Long id, String nombre, String apellido, Integer edad, String dni){
		this.updatePersona(id, nombre, apellido, edad, dni);
		return this.templateIndex();
	}

}


/*@PostMapping("/createPersona")
public ApiResponseUtil<?> createPersona(@RequestBody Persona persona){
	return created(service.createPersona(persona));
}

@GetMapping("/getPersonas")
public ApiResponseUtil<?> getAllPersonas(){
	return success(service.getAllPersonas());
}

@GetMapping("/getPersonaById")
public ApiResponseUtil<?> getPersonasById(@RequestParam(name = "id") Long id){
	return success(service.getPersonaById(id)) ;
}

@PatchMapping("/updatePersona")
public ApiResponseUtil<?> updatePersona(@RequestParam(name = "id") Long id, @RequestBody Persona persona){
	return success(service.updatePersona(id,persona));
}

@DeleteMapping("/deletePersona")
public ApiResponseUtil<?> deletePersona(@RequestParam(name = "id") Long id){
	return noContent(service.deletePersona(id));
}

@GetMapping("/botonListarPersonas")
public String mostrarEjemplo(Model model) {
	List<Persona> personas = getAllPersonasEntity();
	model.addAttribute("personas", personas); 
	return "listarPersona";
}

@GetMapping("/index")
public String mostrarIndex() {
	return "index";
}

@GetMapping("/getPersonas")
public String getPersonas(Model model){
	List<Persona> personas = service.getAllPersonas();
	model.addAttribute("personas",personas);
	return "index";
}


@GetMapping("/getPersonas")
public List<Persona> getAllPersonas(){
	return service.getAllPersonas();
}*/

