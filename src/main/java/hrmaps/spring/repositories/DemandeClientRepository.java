package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmaps.spring.entites.DemandeClient;


public interface DemandeClientRepository extends JpaRepository<DemandeClient, Integer> {

}
