package hrmaps.spring.servicesImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Client;
import hrmaps.spring.repositories.ClientRepository;
import hrmaps.spring.services.PlannigVersionService;



@Service
public class PlannigVersionServiceImp implements PlannigVersionService{

	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public Iterable<Client> listeClientsByVersionIdAndDates(Long id, Date dateSelected) {
		return clientRepository.listeClientsByVersionIdAndDates(id, dateSelected);
	}
	
	@Override
	public Iterable<Client> listclientByVersionId(int versionId) {
		return clientRepository.findByVersionVersionId(versionId);
	}

}

