package hrmaps.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.Commentaire;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.repositories.DemandeClientTypeRepository;
import hrmaps.spring.services.CommentaireService;
import hrmaps.spring.services.DemandeClientTypeService;
import hrmaps.spring.services.EmployeeService;
import hrmaps.spring.servicesImp.MapValidationErrorService;
import hrmaps.spring.validator.CommentaireValidator;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/commentaire")
public class CommentaireControlleur {
	
	
	@Autowired
   CommentaireService commentaireservice ;

    
    
    EmployeeService employeeservice;
    @Autowired
    DemandeClientTypeService demandeservice ;
    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    CommentaireValidator commentValidator ;
    
    @Autowired
    DemandeClientTypeRepository demanderepo;
    
    @GetMapping("/retrieve-all-comment/{demandeClientTypeId}/{employeeId}")
    @ResponseBody
    public List<Commentaire> getAllCommentaires(@PathVariable("demandeClientTypeId")  int demandeClientTypeId , @PathVariable("employeeId")  int employeeId) {
        return commentaireservice.retrieveAllCommentBydemandeClientTypeId(employeeId, demandeClientTypeId);
    }

    @PostMapping("/add-comment/{employeeId}/{demandeClientTypeId}")
    @ResponseBody
    public ResponseEntity<?> addComment(@Valid @RequestBody Commentaire c , BindingResult result , @PathVariable("demandeClientTypeId")  int demandeClientTypeId , @PathVariable("employeeId")  int employeeId) {
        commentValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        c.setDemandeClientTypeId(demandeservice.findDemandeClientTypeById(demandeClientTypeId));
        c.setEmployeeId(employeeservice.findEmployeeById(employeeId));
        Commentaire comm = commentaireservice.addComment(c);
        return new ResponseEntity<Commentaire>( comm, HttpStatus.CREATED);
    }
    
    @GetMapping("/get-comments/{demandeClientTypeId}")
    public List<Commentaire> retrieveCommentsOfPub(@PathVariable("demandeClientTypeId")int demandeClientTypeId){
    	DemandeClientType d = demanderepo.findById(demandeClientTypeId).get();
    	List<Commentaire> comments = new ArrayList<Commentaire>();
    	for (Commentaire commentaire : d.getCommentaires()) {
			comments.add(commentaire);
		}
    	return comments;
    }

    @DeleteMapping("/remove-comment/{idComm}")
    @ResponseBody
    public void removecomment(@PathVariable("idComm")  Integer commentid) {
        commentaireservice.removeComment(commentid);

    }

    @PutMapping("/modify-comment")
    @ResponseBody
    public Commentaire modifycomment(@RequestBody Commentaire c) {
        return commentaireservice.updateComment(c);
    }
    @PostMapping("/add-comment-properly/{employeeId}/{demandeClientTypeId}")
    public void addCommentProperly(@RequestBody Commentaire c, @PathVariable("demandeClientTypeId")  int demandeClientTypeId , @PathVariable("employeeId")  int employeeId) {
    	Employee userr = employeeservice.findEmployeeById(employeeId);
    	DemandeClientType demande = demandeservice.findDemandeClientTypeById(demandeClientTypeId);
    	c.setDemandeClientTypeId(demande);
    	c.setEmployeeId(userr);
    	Commentaire comm = commentaireservice.addComment(c);
    	DemandeClientType p = demandeservice.findDemandeClientTypeById(demandeClientTypeId);
    	p.getCommentaires().add(comm);
    	demanderepo.save(p);
    }


    @GetMapping("/retrieve-comment/{ idComm}")
    @ResponseBody
    public Commentaire retrievecomment(@PathVariable(" idComm") Integer commentId) {
        return commentaireservice.findCommentById(commentId);  }
    
    
    @DeleteMapping("/comments/{demandeClientTypeId}")
    public ResponseEntity<?> deleteCommentsByDemandeClientTypeId(@PathVariable("demandeClientTypeId") Integer demandeClientTypeId) {
    	commentaireservice.deleteCommentairesByDemandeClientTypeId(demandeClientTypeId);
        return ResponseEntity.ok().build();
    }




}
