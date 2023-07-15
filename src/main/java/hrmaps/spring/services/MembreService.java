package hrmaps.spring.services;


import java.util.List;

import hrmaps.spring.entites.Membre;
import hrmaps.spring.entites.Version;

public interface MembreService {
	public List<Membre> findAll();
	
	Membre saveMembre(Membre membre);
	
	Membre FetchMembreByEmail(String membreAdresseMail);
	Membre FetchMembreByEmailandPassword(String membreAdresseMail,String membreCell);
	public Membre findMembreById(int membreId);
	

}
