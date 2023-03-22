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
	public ApiResponseUtil<?> getAllPersonas(){
		return success(service.getAllPersonas());
	}
	
	@GetMapping("/getPersonasEntity")
	public List<Persona> getAllPersonasEntity(){
		return service.getAllPersonas();
	}
	
	@GetMapping("/getPersonaById")
	public ApiResponseUtil<?> getPersonasById(@RequestParam(name = "id") Long id){
		return success(service.getPersonaById(id)) ;
	}
	
	@PostMapping("/createPersona")
	public ApiResponseUtil<?> createPersona(@RequestBody Persona persona){
		return created(service.createPersona(persona));
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
	public ModelAndView mostrarEjemplo() {
		List<Persona> personas = getAllPersonasEntity();
		ModelAndView mav = new ModelAndView("listarPersona");
		mav.addObject("personas", personas);
	  return mav;
	}
	
	@GetMapping("/index")
	public ModelAndView mostrarIndex() {
		ModelAndView mav = new ModelAndView("index");
	  return mav;
	}
	
//	@GetMapping("/botonListarPersonas")
//	public String mostrarEjemplo(Model model) {
//		List<Persona> personas = getAllPersonasEntity();
//		model.addAttribute("personas", personas); 
//		return "listarPersona";
//	}

//	@GetMapping("/index")
//	public String mostrarIndex() {
//		return "index";
//	}
//	
}



//@GetMapping("/getPersonas")
//public String getPersonas(Model model){
//	List<Persona> personas = service.getAllPersonas();
//	model.addAttribute("personas",personas);
//	return "index";
//}


//@GetMapping("/getPersonas")
//public List<Persona> getAllPersonas(){
//	return service.getAllPersonas();
//}



