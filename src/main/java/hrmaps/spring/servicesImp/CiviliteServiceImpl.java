package hrmaps.spring.servicesImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Civilite;
import hrmaps.spring.repositories.CivilityRepository;
import hrmaps.spring.services.CiviliteService;



@Service
public class CiviliteServiceImpl implements CiviliteService{
	
	@Autowired
	CivilityRepository civiliteDao;

	@Override
	public Iterable<Civilite> findAll() {
		// TODO Auto-generated method stub
		return civiliteDao.findAll();
	}

	@Override
	public Iterable<Civilite> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return civiliteDao.findAllById(ids);
	}

	@Override
	public void save(Civilite civilite) {
		// TODO Auto-generated method stub
		civiliteDao.save(civilite);
		
	}

	@Override
	public void delete(Civilite civilite) {
		// TODO Auto-generated method stub
		civiliteDao.delete(civilite);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		civiliteDao.deleteById(id);
	}

}

