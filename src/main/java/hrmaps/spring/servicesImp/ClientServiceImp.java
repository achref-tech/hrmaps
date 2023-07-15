package hrmaps.spring.servicesImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.DemandeClient;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Etat;
import hrmaps.spring.entites.UploadImageClient;
//import hrmaps.spring.entites.UploadImageClient;
import hrmaps.spring.entites.Version;
import hrmaps.spring.repositories.ClientRepository;
import hrmaps.spring.repositories.DemandeClientRepository;
import hrmaps.spring.repositories.DemandeClientTypeRepository;
import hrmaps.spring.repositories.EtatRepository;
import hrmaps.spring.repositories.ImageClientRepository;
//import hrmaps.spring.repositories.ImageClientRepository;
import hrmaps.spring.repositories.VersionRepository;
import hrmaps.spring.services.ClientService;
import hrmaps.spring.utils.MembreModel;


@Service
public class ClientServiceImp implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Autowired
	EtatRepository etatDao;
	
	@Autowired
	DemandeClientTypeRepository demandeclientTypeDao;
	
	@Autowired
	DemandeClientRepository demandeclientDao;
	
	@Autowired
	VersionRepository versionDao;
     
	@Autowired
    ImageClientRepository repositoryImagePub ;
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		List<Client> clients= (List<Client>)clientRepository.findAll();
		return clients;
	}

	@Override
	public Client save(Client client) {
		Etat etat = etatDao.findById(1).get();
		client.setEtat(etat);
		return clientRepository.save(client);
	}

	@Override
	public Client findById(int id) {
		// TODO Auto-generated method stub
		return this.clientRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<Client> findByClientVolonte(String s) {
		// TODO Auto-generated method stub
		return clientRepository.findByClientVolonte(s);
	}

	@Override
	public Iterable<Client> findByClientDescription(String s) {
		// TODO Auto-generated method stub
		return clientRepository.findByClientDescription(s);
	}

	@Override
	public Iterable<Client> findByVersionVersionId(int s) {
		// TODO Auto-generated method stub
		return clientRepository.findByVersionVersionId(s);
	}

	@Override
	public Iterable<Client> listeClientsByVersionIdAndDates(Long id, Date dateSelected) {
		// TODO Auto-generated method stub
		return clientRepository.listeClientsByVersionIdAndDates(id, dateSelected);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	@Override
	public void changeEtatClient(int etatId, Client client) {
		try {
			Optional<Etat> etat = etatDao.findById(etatId);
			client.setEtat(etat.get());
			clientRepository.save(client);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void affecterMembreClient(Client client, List<MembreModel> listeMembreModel) {

		clientRepository.deleteDemandeClientByIDClient(client.getClientId());
		
		listeMembreModel.stream().forEach(membre -> {
			DemandeClient demandeClient = new DemandeClient();
			demandeClient.setClient(client);
			demandeClient.setMembre(membre.getMembre());
			DemandeClientType typeDemandeClient = demandeclientTypeDao.findById(membre.getTypeMembre()).get();
			demandeClient.setTypeDemandeClient(typeDemandeClient);
			try {
				demandeclientDao.save(demandeClient);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		});

	}

	@Override
	public void affecterVersionClient(int idVersion, Client client) {
		// TODO Auto-generated method stub
		
		try {
			
			Etat etat = etatDao.findById(2).get();
			client.setEtat(etat);
			Version version= versionDao.findById(idVersion).get();
			client.setVersion(version);
			clientRepository.save(client);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public UploadImageClient saveImage(UploadImageClient p){
        return repositoryImagePub.save(p);

    }
	
	
	@Override
    public List<Client> findClientByRecentVersion() {
        List<Client> clients=(List<Client>)clientRepository.findAll();
        List<Client> recentversion = new ArrayList<>();
        double i = 0.0 ;
        for (Client c : clients) {
            if (c.getClientVolonte()>i)
                i=c.getClientVolonte();
        }

        for (Client c: clients) {
            System.out.println("i="+i);
            System.out.println("version="+c.getClientVolonte());
            if (c.getClientVolonte() >= i){
                recentversion.add(c);
                System.out.println("boucle="+c.getClientVolonte());
                System.out.println("recentversion="+recentversion.toString());
            }
        }



        return recentversion;
    }

     }







