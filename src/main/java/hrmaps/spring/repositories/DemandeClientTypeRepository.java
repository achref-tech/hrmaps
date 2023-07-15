package hrmaps.spring.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Membre;


public interface DemandeClientTypeRepository extends JpaRepository<DemandeClientType, Integer> {
	List<DemandeClientType> findByMembreId(Membre membre);
	
}

