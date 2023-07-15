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

import hrmaps.spring.entites.Version;
import hrmaps.spring.services.VersionService;




@RestController
@RequestMapping(path = "/Version")
@CrossOrigin(origins="http://localhost:4200")
public class VersionControlleur {

	@Autowired
	private VersionService versionService;
	
	
	
	@GetMapping(path = "/listeversion")
	public List<Version> getListeVersion() {
		 List<Version> listeVersion=versionService.getListVersion();
		 return listeVersion;
	}
	
	
	@PostMapping(path =  "/ajoutversion")
	public ResponseEntity<Version> save(@RequestBody Version version) {		
		
		Version versionAjoute=versionService.save(version);
			
		return new ResponseEntity<>(versionAjoute,HttpStatus.CREATED);
	}
	
	
	@PutMapping(path = "modifversion")
	public ResponseEntity<Version> updateVersion(@RequestBody Version version) {		
		Version versionModifee=versionService.update(version);
		return new ResponseEntity<>(versionModifee,HttpStatus.OK);
	}
	
	
	@GetMapping(path = "findversion/{idV}")
	public ResponseEntity<Version> findVersionByID(@PathVariable(name = "idV") Integer VersionId) {
		Version versionType=versionService.findVersionById(VersionId);
		return  new ResponseEntity<>(versionType,HttpStatus.OK);
	}
	
}

