package hrmaps.spring.repositories;

import org.springframework.stereotype.Repository;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Membre;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@ Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Employee findByEmployeeAdresseMail(String employeeAdresseMail);
	/*@Query("SELECT v.employee FROM Vote v WHERE v.demandeclienttype.demandeClientTypeId = :demandeClientTypeId")
	List<Employee> findVotedEmployeesByDemandeClientTypeId(@Param("demandeClientTypeId") int demandeClientTypeId);*/

	
	@Query("SELECT e FROM Employee e WHERE e.employeeAdresseMail = :employeeAdresseMail AND e.employeeMdp = :employeeMdp")
	public Employee findByEmployeeAdresseMailAndEmployeeMdp(@Param("employeeAdresseMail") String employeeAdresseMail, @Param("employeeMdp") String employeeMdp);
}
