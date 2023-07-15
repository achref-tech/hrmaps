package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrmaps.spring.entites.Etat;


public interface EtatRepository extends JpaRepository<Etat, Integer>{
	
	@Query(value = "SELECT E FROM Etat E WHERE E.etatLibelle LIKE '%?1%'")
	public Etat findByEtatLibelle(String libelle);
	

}
