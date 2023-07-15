package hrmaps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.Membre;
import hrmaps.spring.servicesImp.MembreServiceImp;


@RestController
@RequestMapping("/membre")
@CrossOrigin(origins="*")

public class MembreControlleur {
	
	@Autowired
	private MembreServiceImp membreService;
	
	@GetMapping(value = "/membres", produces = "application/json")
	public List <Membre> getAllMembres() {
		return membreService.findAll();
	}
	@GetMapping(value = "/membre/{id}", produces = "application/json")
	public Membre getMembreById(@PathVariable int id) {
		return membreService.findMembreById(id);
	} 
	@PostMapping(value = "/registreMembre", produces = "application/json")
	public Membre registreMembre(@RequestBody Membre membre) throws Exception {
		String membreAdresseMail=membre.getMembreAdresseMail();
		if (membreAdresseMail!=null && !"" .equals(membreAdresseMail)) {
			
			Membre MembreObj = membreService.FetchMembreByEmail(membreAdresseMail);
			if (MembreObj != null) {
				throw new Exception("Membre with "+membreAdresseMail+" is already exist");
				
			}
			
		}

		Membre membreObj = null;
		membreObj = membreService.saveMembre(membre);
		return membreObj;
	}
	
	@PostMapping(value = "/login", produces = "application/json")
	public Membre loginMembre(@RequestBody Membre membre) throws Exception {
		String membreAdresseMail = membre.getMembreAdresseMail();
		String membreCell = membre.getMembreCell();
		Membre MembreObj = null;
		if (membreAdresseMail !=null && membreCell != null) {
			MembreObj= membreService.FetchMembreByEmailandPassword(membreAdresseMail, membreCell);
		}
		if (MembreObj == null) {
			throw new Exception("Bad credentials");
			
		}
		return MembreObj;
	}
	

}
