package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hrmaps.spring.entites.TypeVersion;


@Repository
public interface TypeVersionRepository extends JpaRepository<TypeVersion, Integer> {
	
}

