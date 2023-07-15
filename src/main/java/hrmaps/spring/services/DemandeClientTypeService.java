package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.Commentaire;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Membre;
import hrmaps.spring.entites.UploadImageDemandeClient;


public interface DemandeClientTypeService {

	public List<DemandeClientType> getListDemandeClientType();

	public DemandeClientType save(DemandeClientType  demandeclientType);

	void updateDemandeClientType(DemandeClientType demandeclientType);
	//void updateDemandeClientTypeId(Integer demandeclientTypeId);
	public void deleteById(Integer demandeclientTypeId);

	public DemandeClientType findDemandeClientTypeById(int id);	
	UploadImageDemandeClient saveImage(UploadImageDemandeClient p);
	//void affecterClientAccepte( DemandeClientType client);
	void affecterClientAccepte( int demandeClientTypeId);
	void affecterClientRefuse(  int demandeClientTypeId);
	List<DemandeClientType> getDemandeClientTypeByMembre(Membre membre);
	void deleteCommentairesByDemandeClientTypeId(Integer demandeClientTypeId);
	void deleteCommentaire(Integer commentaireId);
	 public List<Commentaire> getCommentairesByDemandeId(Integer demandeclientTypeId);
	 void affecteremployeedemande(int employeeId, DemandeClientType demandeclientType);

}
