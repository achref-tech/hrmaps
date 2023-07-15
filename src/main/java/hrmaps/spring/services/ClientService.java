package hrmaps.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.UploadImageClient;
import hrmaps.spring.utils.MembreModel;



public interface ClientService {

	public List<Client> findAll();

	public Client save(Client client);

	public Client findById(int id);

	public Iterable<Client> findByVersionVersionId(int s);

	public Iterable<Client> findByClientVolonte(String s);

	public Iterable<Client> findByClientDescription(String s);

	public Iterable<Client> listeClientsByVersionIdAndDates(Long id, Date dateSelected);

	public void deleteById(int s);

	void changeEtatClient(int etatId, Client client);

	void affecterMembreClient(Client client, List<MembreModel> listeMembreModel);
	
	void affecterVersionClient(int idVersion, Client client);
	
	UploadImageClient saveImage(UploadImageClient p);
	
	List<Client> findClientByRecentVersion();

}

