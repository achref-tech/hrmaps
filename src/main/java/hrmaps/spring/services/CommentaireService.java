package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.Commentaire;

public interface CommentaireService {
	
	
	Commentaire addComment(Commentaire c);
	Commentaire updateComment(Commentaire c);
	 //String DeleteComment(Long corrId);
	void removeComment( Integer commentId);
	 Commentaire findCommentById(Integer id);
	 List<Commentaire> retrieveAllCommentBydemandeClientTypeId(int employeeId , int demandeClientTypeId);
	 void deleteCommentairesByDemandeClientTypeId(Integer demandeClientTypeId);
	 //void deleteCommentsByDemandeClientTypeId(Integer demandeId);
}
