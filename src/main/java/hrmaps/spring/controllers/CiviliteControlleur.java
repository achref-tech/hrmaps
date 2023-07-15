package hrmaps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.Civilite;
import hrmaps.spring.services.CiviliteService;


@RestController
public class CiviliteControlleur {
	
	@Autowired
	private CiviliteService civiliteService;
	
	@GetMapping(value="/civilites",  produces = "application/json")
	public Iterable<Civilite> getAllCivilite(){
		return civiliteService.findAll();
	}
	
	@PostMapping(value="/civilite")
	public void saveCivilite(@RequestBody Civilite civilite){
		civiliteService.save(civilite);
	}
	
	@DeleteMapping(value="/civilite/{id}")
	public void deleteCivilite(@PathVariable int id) {
		civiliteService.deleteById(id);
	}
	

}

