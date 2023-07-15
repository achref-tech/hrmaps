package hrmaps.spring.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.repositories.EmployeeRepository;
import hrmaps.spring.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	 
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> employees= (List<Employee>)employeeRepository.findAll();
		return employees;
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public Employee findEmployeeById(int employeeId) {
		return this.employeeRepository.findById(employeeId).orElse(null);
	}
	
	@Override
	public Employee FetchEmployeeByEmail(String employeeAdresseMail) {
		return employeeRepository.findByEmployeeAdresseMail(employeeAdresseMail);
		
	}
	@Override
	
	public Employee FetchEmployeeByEmailandPassword(String employeeAdresseMail,String employeeMdp) {
		return employeeRepository.findByEmployeeAdresseMailAndEmployeeMdp(employeeAdresseMail, employeeMdp);
	}
	

	/*@Override
	public List<Employee>getVotedEmployeesByDemandeClientTypeId(int demandeClientTypeId) {
	    return employeeRepository.findVotedEmployeesByDemandeClientTypeId( demandeClientTypeId);
	  }
	*/
}