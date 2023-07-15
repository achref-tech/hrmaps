package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmaps.spring.entites.Version;


public interface VersionRepository extends JpaRepository<Version, Integer> {

}
