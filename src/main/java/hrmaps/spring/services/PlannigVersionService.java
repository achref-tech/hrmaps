package hrmaps.spring.services;

import java.util.Date;

import hrmaps.spring.entites.Client;


public interface PlannigVersionService {

	
	public Iterable<Client> listeClientsByVersionIdAndDates(Long id, Date dateSelected);
	public Iterable<Client> listclientByVersionId(int versionId);
}

