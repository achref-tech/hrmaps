package hrmaps.spring.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmaps.spring.entites.Conge;
import hrmaps.spring.entites.Employee;


public interface CongeRepository extends JpaRepository<Conge, Long> {
	List<Conge> findByEmployeeId(Employee employee);
}
