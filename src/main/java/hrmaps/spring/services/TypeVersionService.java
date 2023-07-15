package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.TypeVersion;


public interface TypeVersionService {

	public List<TypeVersion> getListTypeVersion();

	public TypeVersion save(TypeVersion typeVersion);

	public TypeVersion update(TypeVersion typeVersion);

	public void deleteById(Integer typeVersionId);

	public TypeVersion findTypeVersionById(Integer typeVersionId);

}
