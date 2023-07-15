package hrmaps.spring.servicesImp;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Commentaire;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.repositories.CommentaireRepository;
import hrmaps.spring.services.CommentaireService;
import hrmaps.spring.services.DemandeClientTypeService;
import hrmaps.spring.services.EmployeeService;

@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService{
	
	
	@Autowired
    CommentaireRepository commentaireRep ;

    @Autowired
    DemandeClientTypeService demandeservice ;
    @Autowired
    EmployeeService employeeservice ;
    
    
    
    @Override
    public Commentaire addComment(Commentaire c) {
    	
    	// if (c.getIdComm() != null && commentaireRep.existsById(c.getIdComm())) {
    	 //}
    	
    	//c.setIdComm(null); // Assurez-vous que la clé primaire est nulle
        //Commentaire newComment = commentaireRep.save(c); // Enregistrer le nouveau commentaire avec la clé primaire générée
        //return newComment;
    	    return commentaireRep.save(c); // Enre
    	 
        //return commentaireRep.save(c);
    }
    @Override
    public void deleteCommentairesByDemandeClientTypeId(Integer demandeId) {
        List<Commentaire> comments = commentaireRep.findByDemandeClientTypeId(demandeId);
        commentaireRep.deleteAll(comments);
    }

    @Override
   
    	public void removeComment( Integer commentId) {
    	commentaireRep.deleteById(commentId);
    }

    @Override
    public Commentaire updateComment(Commentaire c) {
        return commentaireRep.save(c);
    }

    @Override
    public List<Commentaire> retrieveAllCommentBydemandeClientTypeId(int employeeId , int demandeClientTypeId) {

        Employee e = employeeservice.findEmployeeById(employeeId);
        DemandeClientType d = demandeservice.findDemandeClientTypeById(demandeClientTypeId);
        List<Commentaire> cmts=(List<Commentaire>)commentaireRep.findCommentaireByDemandeClientTypeIdAndEmployeeId(d,e);
        return cmts;
    }

    @Override
    public Commentaire findCommentById(Integer id) {
        return commentaireRep.findById(id).get();
    }
    /*@Override
    public void deleteCommentairesByDemandeClientTypeId(Integer demandeClientTypeId) {
    	commentaireRep.deleteByDemandeClientTypeId(demandeClientTypeId);
    }*/
	

}
