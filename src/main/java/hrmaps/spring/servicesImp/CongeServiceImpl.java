package hrmaps.spring.servicesImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Conge;
import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Etat;
import hrmaps.spring.repositories.CongeRepository;
import hrmaps.spring.repositories.EmployeeRepository;
import hrmaps.spring.repositories.EtatRepository;
import hrmaps.spring.services.CongeService;


@Service

@Transactional
public class CongeServiceImpl implements CongeService {

	@Autowired
	private CongeRepository congeRepository;
	@Autowired
	EtatRepository etatDao;
	@Autowired
	EmployeeRepository empl;
	@Autowired
	EmployeeServiceImpl empll;

	@Override
	public List<Conge> getListConge() {
		return congeRepository.findAll();
	}

	@Override
	public Conge save(Conge conge) {
		Etat etat = etatDao.findById(6).get();
		conge.setEtat(etat);
		Conge co = congeRepository.save(conge);

		return co;
	}



	@Override
	public Conge update(Conge conge) {

		return congeRepository.save(conge);
	}

	
	@Override
	public void deleteById(Long id) {
		congeRepository.deleteById(id);
	}

	@Override
	public Conge findCongeById(Long id) {
		return congeRepository.findById(id).get();
	}
	@Override
	public void affecterCongeAccepte( Long id) {
		Conge cong = congeRepository.findById(id).orElseThrow() ;
		Etat etat = etatDao.findById(7).get();
        cong.setEtat(etat);
        congeRepository.save(cong);
        //emailService.sendAcceptanceEmail(demandeClient.getEmail());
    }
	@Override
	public void affecterCongeRefuse( Long id) {
		// TODO Auto-generated method stub
		
		Conge cong = congeRepository.findById(id).orElseThrow() ;
		Etat etat = etatDao.findById(8).get();
		cong.setEtat(etat);
		congeRepository.save(cong);
        //emailService.sendAcceptanceEmail(demandeClient.getEmail());
    }
	@Override
	public List<Conge> getCongeByEmployee(Employee employee) {
        return congeRepository.findByEmployeeId(employee);
    
    }

}

