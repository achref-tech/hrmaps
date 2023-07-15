package hrmaps.spring.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.Commentaire;
import hrmaps.spring.entites.Conge;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Membre;
import hrmaps.spring.entites.UploadImageDemandeClient;
import hrmaps.spring.repositories.CommentaireRepository;
import hrmaps.spring.repositories.DemandeClientTypeRepository;
import hrmaps.spring.repositories.UploadImageDemandeClientRepository;
import hrmaps.spring.repositories.VoteRepository;
import hrmaps.spring.services.CommentaireService;
import hrmaps.spring.services.DemandeClientTypeService;
import hrmaps.spring.services.EmployeeService;
import hrmaps.spring.servicesImp.MembreServiceImp;
import hrmaps.spring.validator.DuplicateCommentException;


@RestController
@RequestMapping("/demandeclient")
@CrossOrigin(origins="*")
public class DemandeClientControlleur {

	@Autowired
	private DemandeClientTypeService demandeclientService;
	
	@Autowired
	 UploadImageDemandeClientRepository imageRep;
	@Autowired
    DemandeClientTypeRepository demandeRepo ;
	@Autowired
	 EmployeeService employeeservice;
	@Autowired
	   CommentaireService commentaireservice ;
	@Autowired
    private CommentaireRepository commentaireRepository;
	@Autowired
	private MembreServiceImp membreService;



	@GetMapping(value="/retrieve-all-demandeclient",produces="application/json")
    @ResponseBody
    public List<DemandeClientType> getAllDemandeClients() {
        return demandeclientService.getListDemandeClientType();
    }
	@GetMapping(value = "/find/{id}", produces = "application/json")
	public DemandeClientType findDemandeClientTypeById(@PathVariable int id) {
		return demandeclientService.findDemandeClientTypeById(id);
	} 
	@PutMapping(value = "/put", produces = "application/json")
	public void updateDemandeClientType( @RequestBody DemandeClientType demandeclientType) {
		demandeclientService.updateDemandeClientType(demandeclientType);
	}
	/*@DeleteMapping(value = "/delete/{s}", produces = "application/json")
	public void findById(@PathVariable Integer s) {
		demandeclientService.deleteById(s);
	}*/
	/*@DeleteMapping(value = "/delete/{demandeClientTypeId}", produces = "application/json")
    public void deleteDemandeClientTypeId(@PathVariable Integer demandeClientTypeId) {
        demandeclientService.deleteCommentairesByDemandeClientTypeId(demandeClientTypeId);
       demandeclientService.deleteById(demandeClientTypeId);
    }*/
	@DeleteMapping(value = "/delete/{demandeClientTypeId}", produces = "application/json")
	public void deleteDemandeClientType(@PathVariable("demandeClientTypeId") Integer demandeClientTypeId) {
	    //demandeclientService.deleteCommentairesByDemandeClientTypeId(demandeClientTypeId);
	    demandeclientService.deleteById(demandeClientTypeId);
	}
	/*@DeleteMapping(value = "/delete/{demandeClientTypeId}", produces = "application/json")
	public void deleteDemandeClientType(@PathVariable("demandeClientTypeId") Integer demandeClientTypeId) {
	   // demandeclientService.deleteCommentairesByDemandeClientTypeId(demandeClientTypeId);
	    DemandeClientType demandeClientType = demandeclientService.findDemandeClientTypeById(demandeClientTypeId);
	    if (demandeClientType != null) {
	        demandeClientType.setCommentaires(null); // Supprimer la référence aux commentaires
	        demandeclientService.save(demandeClientType); // Enregistrer la demandeClientType mise à jour sans commentaires
	        demandeclientService.deleteById(demandeClientTypeId); // Supprimer la demandeClientType
	    }
	}*/
	
	@PostMapping(value="/add/{membreId}", produces = "application/json")
	public void addCentre(
			@RequestParam("image") MultipartFile file,
			@RequestParam("demandeclientTypeNom") String demandeclientTypeNom,
			@RequestParam("demandeclientTypePrenom") String demandeclientTypePrenom,
			@RequestParam("demandeclientTypeVersion") Double demandeclientTypeVersion,
			@PathVariable("membreId") int membreId
			
             ) throws IOException {
		Membre membree = membreService.findMembreById(membreId);
		DemandeClientType demandeclientType = new DemandeClientType();
		
		demandeclientType.setDemandeclientDateDebutDemande(new Date());
		demandeclientType.setDemandeclientDateFinDemande(new Date());
		demandeclientType.setDemandeclientTypeNom(demandeclientTypeNom);
		demandeclientType.setDemandeclientTypePrenom(demandeclientTypePrenom);
		demandeclientType.setDemandeclientTypeVersion(demandeclientTypeVersion);
		demandeclientType.setMembreId(membree);
		
		
		UploadImageDemandeClient img = new UploadImageDemandeClient();
        img.setData(file.getBytes());
        UploadImageDemandeClient savedImg = this.imageRep.save(img);
        demandeclientType.setImage(savedImg);
		
			
		demandeclientService.save(demandeclientType);
	}
	
	@PostMapping("/file")
    @ResponseBody
    @Transactional
    public Object  uploadImg (@RequestParam("file") @Nullable MultipartFile file,@RequestParam(value="identifier",required=false)int id) {
		
        DemandeClientType client=demandeclientService.findDemandeClientTypeById(id);
        if(client==null)
        {
            Map<String, String> errorDetails= new HashMap<>();
            errorDetails.put("message", "client non definit");
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
        if(file!=null) {
            UploadImageDemandeClient image =client.getImage();

            if(image==null)
            {
                image= new UploadImageDemandeClient();
                image.setDemandeclient(client);
                client.setImage(image);
            }

            try {
                image.setData(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setName(file.getOriginalFilename());

            demandeclientService.saveImage(image);

            demandeclientService.updateDemandeClientType( client);
        }


        return client;
    }
	/*@PutMapping(value = "/accepte", produces = "application/json")
	public void affecterClientAccepte( @RequestBody  DemandeClientType client) {
				
				System.out.println("##### DemandeClientType == " + client.toString());
				demandeclientService.affecterClientAccepte(client);
	}*/
	 @PutMapping("/accepte/{demandeClientTypeId}")
	    public void accepterDemandeClient(@PathVariable int demandeClientTypeId) {
	        demandeclientService.affecterClientAccepte(demandeClientTypeId);
	    }
	@PutMapping( "/refuse/{demandeClientTypeId}")
	public void affecterVersionClient(@PathVariable int demandeClientTypeId) {
				demandeclientService.affecterClientRefuse( demandeClientTypeId);
	}
	@PutMapping("/like-pub/{demandeClientTypeId}")
    public void like(@PathVariable("demandeClientTypeId")int demandeClientTypeId) {
    	DemandeClientType demande = demandeRepo.findById(demandeClientTypeId).orElse(null);
        if (demande != null) {
            Integer note = demande.getNote();
            int updatedNote = Objects.requireNonNullElse(note, 0) + 1;
            demande.setNote(updatedNote);
            demandeRepo.save(demande);
        }

    }

	    
	/*@PutMapping("/like-pub/{demandeClientTypeId}")
	public void like(@PathVariable("demandeClientTypeId") int demandeClientTypeId, @RequestBody Employee employee) {
	    DemandeClientType demande = demandeRepo.findById(demandeClientTypeId).orElse(null);
	    if (demande != null && !hasVoted(demande, employee.getEmployeeId())) {
	        Integer note = demande.getNote();
	        int updatedNote = Objects.requireNonNullElse(note, 0) + 1;
	        demande.setNote(updatedNote);
	        addVotedEmployee(demande, employee.getEmployeeId());
	        demandeRepo.save(demande);
	    }
	}*/

	
	    @PutMapping("/dislike-pub/{demandeClientTypeId}")
	    public void dislike(@PathVariable("demandeClientTypeId")int demandeClientTypeId) {
	    	DemandeClientType demande = demandeRepo.findById(demandeClientTypeId).get();
	    	if(demande.getNote()>0) {
	    		demande.setNote(demande.getNote()-1);
	        	demandeRepo.save(demande);
	    	}
	    }
	    @GetMapping("/get-comments/{demandeClientTypeId}")
	    public List<Commentaire> retrieveCommentsOfPub(@PathVariable("demandeClientTypeId")int demandeClientTypeId){
	    	DemandeClientType d = demandeRepo.findById(demandeClientTypeId).get();
	    	List<Commentaire> comments = new ArrayList<Commentaire>();
	    	for (Commentaire commentaire : d.getCommentaires()) {
				comments.add(commentaire);
			}
	    	return comments;
	    }
	    @PostMapping("/add-comment-properly/{employeeId}/{demandeClientTypeId}")
	    public void addCommentProperly(@RequestBody Commentaire c, @PathVariable("demandeClientTypeId") int demandeClientTypeId, @PathVariable("employeeId") int employeeId) {
	    	
	    	Employee user = employeeservice.findEmployeeById(employeeId);
    	    DemandeClientType demande = demandeclientService.findDemandeClientTypeById(demandeClientTypeId);
    	    
    	    c.setDemandeClientTypeId(demande);
    	    c.setEmployeeId(user);
    	    
    	    Commentaire comm = commentaireservice.addComment(c);
    	    demande.getCommentaires().add(comm);
    	    
    	    demandeclientService.save(demande);

        // Remove the following line as it's no longer needed
        //demandeRepo.save(demande);
	    	
	    }
	    @GetMapping("/membre/{membreId}")
	    public List<DemandeClientType> getDemandeClientTypesByMembreId(@PathVariable("membreId") int membreId) {
	    	Membre membre = membreService.findMembreById(membreId);
			return  demandeclientService.getDemandeClientTypeByMembre(membre);
	    }
	    @PutMapping(value = "/employeee/{employeeId}", produces = "application/json")
		public void affecterVersionClient(@PathVariable int employeeId,  @RequestBody DemandeClientType demandeclientType) {
					System.out.println("##### employeeId == " + employeeId);
					System.out.println("##### demandeclientType == " + demandeclientType.toString());
					demandeclientService.affecteremployeedemande(employeeId, demandeclientType);
		}
	    
}

