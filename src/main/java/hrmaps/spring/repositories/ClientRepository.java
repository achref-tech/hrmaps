package hrmaps.spring.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import hrmaps.spring.entites.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {

	Iterable<Client> findByClientVolonte(String s);

	Iterable<Client> findByClientDescription(String s);

	Iterable<Client> findByVersionVersionId(int s);

	@Query(value = "Select r From Client r where r.version.versionId=:id and"
			+ "	((Year((:dateSelected))=Year(r.clientDateDebutDemande) or"
			+ "	Year((:dateSelected))=Year(r.clientDateFinDemande)) and"
			+ "	(Month((:dateSelected)) = Month(r.clientDateDebutDemande) or"
			+ "	Month((:dateSelected))=Year(r.clientDateFinDemande))"
			+ "	and ((Day((:dateSelected)) = Day(r.clientDateDebutDemande) or"
			+ "	Day((:dateSelected)) > Day(r.clientDateDebutDemande)) and"
			+ "	(Day((:dateSelected)) = Day(r.clientDateFinDemande)"
			+ "	or Day((:dateSelected)) < Day(r.clientDateFinDemande))))")
	Iterable<Client> listeClientsByVersionIdAndDates(@Param(value = "id") Long id, @Param(value = "dateSelected") Date dateSelected);
	
	@Query(value = "Delete FROM DemandeClient p where p.client.clientId=:clientId")
	void deleteDemandeClientByIDClient(@Param(value = "clientId") int id);

}

