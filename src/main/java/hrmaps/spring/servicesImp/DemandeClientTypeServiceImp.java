package hrmaps.spring.servicesImp;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.Commentaire;
import hrmaps.spring.entites.Conge;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Etat;
import hrmaps.spring.entites.Membre;
import hrmaps.spring.entites.UploadImageClient;
import hrmaps.spring.entites.UploadImageDemandeClient;
import hrmaps.spring.entites.Version;
import hrmaps.spring.repositories.CommentaireRepository;
import hrmaps.spring.repositories.DemandeClientTypeRepository;
import hrmaps.spring.repositories.EmployeeRepository;
import hrmaps.spring.repositories.EtatRepository;
import hrmaps.spring.repositories.UploadImageDemandeClientRepository;
import hrmaps.spring.repositories.VersionRepository;
import hrmaps.spring.services.DemandeClientTypeService;



@Service
@Transactional
public class DemandeClientTypeServiceImp implements DemandeClientTypeService {

	@Autowired
	private DemandeClientTypeRepository demandeclientTypeRepository;
	@Autowired
	private UploadImageDemandeClientRepository ImageRepository;
	@Autowired
	EtatRepository etatDao;
	@Autowired
    private MailServiceImpl emailService;
	@Autowired
    CommentaireRepository commentaireRep ;
	@Autowired
	EmployeeRepository employeeDao;


	@Override
	public List<DemandeClientType> getListDemandeClientType() {
		List <DemandeClientType> DemandeClientTypes=(List<DemandeClientType>) demandeclientTypeRepository.findAll();
		return DemandeClientTypes;
	}

	@Override
	public DemandeClientType save(DemandeClientType demandeclientType) {
		Etat etat = etatDao.findById(3).get();
		demandeclientType.setEtat(etat);
		
		return demandeclientTypeRepository.save(demandeclientType);
	}

	@Override
	public void updateDemandeClientType(DemandeClientType demandeclientType) {
		/*try {
			Optional<Etat> etat = etatDao.findById(etatId);
			demandeclientType.setEtat(etat.get());
		demandeclientTypeRepository.save(demandeclientType);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		demandeclientTypeRepository.save(demandeclientType);
		
	}

	@Override
	public void deleteById(Integer demandeclientTypeId) {
		//List<Commentaire> commentaires = commentaireRep.findByDemandeClientTypeId(demandeclientTypeId);
		//commentaires.forEach(commentaire -> commentaire.setDemandeClientTypeId(null));
		//commentaireRep.deleteByDemandeClientTypeId(demandeclientTypeId);
		demandeclientTypeRepository.deleteById(demandeclientTypeId);
	}
	@Override
	 public void deleteCommentaire(Integer commentaireId) {
		 commentaireRep.deleteById(commentaireId);
	    }
	@Override
	 public List<Commentaire> getCommentairesByDemandeId(Integer demandeclientTypeId) {
	        return commentaireRep.findByDemandeClientTypeId(demandeclientTypeId);
	    }
	@Override
    public void deleteCommentairesByDemandeClientTypeId(Integer demandeClientTypeId) {
		//commentaireRep.deleteByDemandeClientTypeId(demandeClientTypeId);
		
		    List<Commentaire> commentaires = commentaireRep.findByDemandeClientTypeId(demandeClientTypeId);
		    for (Commentaire commentaire : commentaires) {
		        commentaire.setDemandeClientTypeId(null);  // Mettre à jour le champ id_comm avec null ou une autre valeur appropriée
		        commentaireRep.save(commentaire);
		    }
		}
    
	

	@Override
	public DemandeClientType findDemandeClientTypeById(int id) {
		return this.demandeclientTypeRepository.findById(id).orElse(null);
	}
	@Override
	public UploadImageDemandeClient saveImage(UploadImageDemandeClient p){
        return ImageRepository.save(p);

    }
	@Override
	public void affecterClientAccepte( int demandeClientTypeId) {
		DemandeClientType demandeClient = demandeclientTypeRepository.findById(demandeClientTypeId).orElseThrow() ;
		Etat etat = etatDao.findById(4).get();
        demandeClient.setEtat(etat);
        demandeclientTypeRepository.save(demandeClient);
        //emailService.sendAcceptanceEmail(demandeClient.getEmail());
    }
		// TODO Auto-generated method stub
		
		/*try {
			
			Etat etat = etatDao.findById(4).get();
			client.setEtat(etat);
			demandeclientTypeRepository.save(client);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		

	@Override
	public void affecterClientRefuse( int demandeClientTypeId) {
		// TODO Auto-generated method stub
		
		DemandeClientType demandeClient = demandeclientTypeRepository.findById(demandeClientTypeId).orElseThrow() ;
		Etat etat = etatDao.findById(5).get();
        demandeClient.setEtat(etat);
        demandeclientTypeRepository.save(demandeClient);
        //emailService.sendAcceptanceEmail(demandeClient.getEmail());
    }
	@Override
	public List<DemandeClientType> getDemandeClientTypeByMembre(Membre membre) {
        return demandeclientTypeRepository.findByMembreId(membre);
    
    }
	@Override
	public void affecteremployeedemande(int employeeId, DemandeClientType demandeclientType) {
		// TODO Auto-generated method stub
		
		try {
			
			
			Employee employee= employeeDao.findById(employeeId).get();
			demandeclientType.setEmployeeId(employee);
			demandeclientTypeRepository.save(demandeclientType);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	

}

