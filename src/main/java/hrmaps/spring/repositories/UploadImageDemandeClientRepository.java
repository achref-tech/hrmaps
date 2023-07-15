package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrmaps.spring.entites.UploadImageDemandeClient;



@Repository
public interface UploadImageDemandeClientRepository extends  JpaRepository<UploadImageDemandeClient, String>{

}
