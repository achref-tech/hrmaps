package hrmaps.spring.services;

import hrmaps.spring.entites.Civilite;

public interface CiviliteService {

	public Iterable<Civilite> findAll();

	public Iterable<Civilite> findAllById(Iterable<Integer> ids);

	public void save(Civilite civilite);

	public void delete(Civilite civilite);

	public void deleteById(int id);

}