package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.ClientType;


public interface ClientTypeService {
	
	public List<ClientType> findAllClientTypes();
	public void saveClientTypes(ClientType clientType);
	public void editClientTypes(ClientType clientType);
	public void deleteClientTypes(ClientType clientType);
	


}
