package hrmaps.spring.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.ClientType;
import hrmaps.spring.repositories.ClientTypeRepository;
import hrmaps.spring.services.ClientTypeService;



@Service
public class ClientTypeServiceImp implements ClientTypeService{

	@Autowired
	ClientTypeRepository clientTypeDao;
	@Autowired
	
	
	
//	@Autowired
//	private ReunionTypeDao reunionTypeDao;

	public List<ClientType> findAllClientTypes() {
		// TODO Auto-generated method stub
		return clientTypeDao.findAll();
	}

	public void saveClientTypes(ClientType clientType) {
		// TODO Auto-generated method stub
		clientTypeDao.save(clientType);
	}

	public void editClientTypes(ClientType clientType) {
		// TODO Auto-generated method stub
		clientTypeDao.save(clientType);
	}

	public void deleteClientTypes(ClientType clientType) {
		// TODO Auto-generated method stub
		clientTypeDao.delete(clientType);
	}
	 
	
	    }


	


