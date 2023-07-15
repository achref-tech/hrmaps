package hrmaps.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmaps.spring.entites.Commentaire;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;


public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	
	List<Commentaire> findCommentaireByDemandeClientTypeIdAndEmployeeId(DemandeClientType demandeClientTypeId,Employee employeeId );

	 boolean existsByDemandeClientTypeIdAndEmployeeId(int demandeClientTypeId, int employeeId);
	 //List<Commentaire> findByDemandeClientTypeId(Integer demandeclientTypeId);

	    List<Commentaire> findByDemandeClientTypeId(Integer demandeClientTypeId);

	   // void deleteByDemandeClientType(DemandeClientType demandeClientTypeId);

	    void deleteByDemandeClientTypeId(Integer demandeclientTypeId);
	    //List<Commentaire> findByDemandeId(Integer demandeId);
}
