package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.Conge;
import hrmaps.spring.entites.Employee;

public interface CongeService {
	public List<Conge> getListConge();

	public Conge save(Conge conge);


	public Conge update(Conge conge);


	public void deleteById(Long id);

	public Conge findCongeById(Long id);
	void affecterCongeAccepte( Long id);
	void affecterCongeRefuse( Long id);
	List<Conge> getCongeByEmployee(Employee employee);
}
