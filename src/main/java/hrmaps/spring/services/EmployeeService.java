package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Membre;

public interface EmployeeService {
	
public List<Employee> findAll();
	
	Employee saveEmployee(Employee employee);
	public Employee findEmployeeById(int employeeId);
	Employee FetchEmployeeByEmail(String employeeAdresseMail);
	Employee FetchEmployeeByEmailandPassword(String employeeAdresseMail,String employeeMdp);
	//List<Employee> getVotedEmployees(int demandeClientTypeId);
	//public List<Employee> getVotedEmployees(DemandeClientType demandeclientType);
	 //List<Employee>getVotedEmployeesByDemandeClientTypeId(int demandeClientTypeId);

}
