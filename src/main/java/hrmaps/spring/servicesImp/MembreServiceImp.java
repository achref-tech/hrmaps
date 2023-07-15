package hrmaps.spring.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Client;
import hrmaps.spring.entites.Membre;
import hrmaps.spring.entites.Version;
import hrmaps.spring.repositories.MembreRepository;
import hrmaps.spring.services.MembreService;

@Service
public class MembreServiceImp implements MembreService {
	@Autowired
	MembreRepository membreRepository;
	 
	@Override
	public List<Membre> findAll() {
		// TODO Auto-generated method stub
		List<Membre> membres= (List<Membre>)membreRepository.findAll();
		return membres;
	}
	@Override
	public Membre saveMembre(Membre membre) {
		return membreRepository.save(membre);
	}
	@Override
	public Membre findMembreById(int membreId) {
		return membreRepository.findById(membreId).orElse(null);
	}
	@Override
	public Membre FetchMembreByEmail(String membreAdresseMail) {
		return membreRepository.findBymembreAdresseMail(membreAdresseMail);
		
	}
	@Override
	
	public Membre FetchMembreByEmailandPassword(String membreAdresseMail,String membreCell) {
		return membreRepository.findBymembreAdresseMailAndMembreCell(membreAdresseMail, membreCell);
	}

}
