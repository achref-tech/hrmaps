package hrmaps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import hrmaps.spring.entites.ClientType;
import hrmaps.spring.services.ClientTypeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "ClientType")
public class ClientTypeControlleur {
	
	@Autowired
	private ClientTypeService clientTypeService;
 

	@GetMapping(value = "/clientTypes", produces = "application/json")
	public List<ClientType> getAllClientTypes() {
		return clientTypeService.findAllClientTypes();
	}
	
	@PostMapping(value = "/saveClientType", produces = "application/json")
	public void saveClientTypes(@RequestBody ClientType clientType) {
		clientTypeService.saveClientTypes(clientType);
	}
	
	@PutMapping(value = "/editClientType", produces = "application/json")
	public void editClientType(@RequestBody ClientType clientType) {
		clientTypeService.saveClientTypes(clientType);
	}
	
	@DeleteMapping(value = "/deleteClientType", produces = "application/json")
	public void deleteClientType(@RequestBody ClientType clientType) {
		clientTypeService.saveClientTypes(clientType);
	}
	

}

