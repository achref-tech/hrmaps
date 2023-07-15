package hrmaps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.Conge;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.services.CongeService;
import hrmaps.spring.servicesImp.EmployeeServiceImpl;





@RestController
@RequestMapping(path = "/conge")
@CrossOrigin(origins="http://localhost:4200")
public class CongeControlleur {

	@Autowired
	private CongeService congeService;
	@Autowired
	EmployeeServiceImpl empll;
	
	
	
	@GetMapping(path = "/listeconge")
	public List<Conge> getListeConge() {
		 List<Conge> listeconge=congeService.getListConge();
		 return listeconge;
	}
	
	
	/*@PostMapping(path =  "/ajoutconge")
	public ResponseEntity<Conge> save(@RequestBody Conge conge) {	
		 //Employee user = empll.findEmployeeById(employeeId);
		 
		
		Conge congeAjoute=congeService.save(conge);
			
		return new ResponseEntity<>(congeAjoute,HttpStatus.CREATED);
	}
	*/
	@PostMapping(path = "/ajoutconge/{employeeId}")
	public ResponseEntity<Conge> save(@PathVariable("employeeId") int employeeId, @RequestBody Conge conge) {
	    Employee employee = empll.findEmployeeById(employeeId);
	    conge.setEmployeeId(employee);
	    Conge congeAjoute = congeService.save(conge);
	    return new ResponseEntity<>(congeAjoute, HttpStatus.CREATED);
	}
	  
	  
	
	@PutMapping(path = "/modifconge")
	public ResponseEntity<Conge> updateConge(@RequestBody Conge conge) {		
		Conge congeModifee=congeService.update(conge);
		return new ResponseEntity<>(congeModifee,HttpStatus.OK);
	}
	
	
	@GetMapping(path = "findconge/{idV}")
	public ResponseEntity<Conge> findCongeByID(@PathVariable(name = "idV") Long id) {
		Conge congeType=congeService.findCongeById(id);
		return  new ResponseEntity<>(congeType,HttpStatus.OK);
	}
	 @PutMapping("/accepte/{id}")
	    public void accepterDemandeConge(@PathVariable Long id) {
		 congeService.affecterCongeAccepte(id);
	    }
	@PutMapping( "/refuse/{id}")
	public void refuserDemandeConge(@PathVariable Long id) {
		congeService.affecterCongeRefuse(id);
	}
	@GetMapping("/employee/{employeeId}")
    public List<Conge> getCongesByEmployeeId(@PathVariable("employeeId") int employeeId) {
		Employee employee = empll.findEmployeeById(employeeId);
		return  congeService.getCongeByEmployee(employee);
    }
}


