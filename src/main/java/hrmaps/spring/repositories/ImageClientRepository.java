package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrmaps.spring.entites.UploadImageClient;


@Repository
public interface ImageClientRepository extends  JpaRepository<UploadImageClient, String>{

}
