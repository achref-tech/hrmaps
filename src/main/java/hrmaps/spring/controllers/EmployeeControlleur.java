package hrmaps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.services.DemandeClientTypeService;
import hrmaps.spring.servicesImp.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins="*")

public class EmployeeControlleur {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private DemandeClientTypeService demandeclientService;
	
	@GetMapping(value = "/employees", produces = "application/json")
	public List <Employee> getAllEmployees() {
		return employeeService.findAll();
	}
	@GetMapping(value = "/employee/{id}", produces = "application/json")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findEmployeeById(id);
	} 
	@PostMapping(value = "/registreEmployee", produces = "application/json")
	public Employee registreEmployee(@RequestBody Employee employee) throws Exception {
		String employeeAdresseMail=employee.getEmployeeAdresseMail();
		if (employeeAdresseMail!=null && !"" .equals(employeeAdresseMail)) {
			
			Employee EmployeeObj = employeeService.FetchEmployeeByEmail(employeeAdresseMail);
			if (EmployeeObj != null) {
				throw new Exception("Membre with "+employeeAdresseMail+" is already exist");
				
			}
			
		}

		Employee employeeObj = null;
		employeeObj = employeeService.saveEmployee(employee);
		return employeeObj;
	}
	
	@PostMapping(value = "/loginn", produces = "application/json")
	public Employee loginEmployee(@RequestBody Employee employee) throws Exception {
		String employeeAdresseMail = employee.getEmployeeAdresseMail();
		String employeeMdp = employee.getEmployeeMdp();
		Employee EmployeeObj = null;
		if (employeeAdresseMail !=null && employeeMdp != null) {
			EmployeeObj= employeeService.FetchEmployeeByEmailandPassword(employeeAdresseMail, employeeMdp);
		}
		if (EmployeeObj == null) {
			throw new Exception("Bad credentials");
			
		}
		return EmployeeObj;
	}
	/*@GetMapping("/votedEmployees/{demandeClientTypeId}")
    public List<Employee> getVotedEmployees(@PathVariable("demandeClientTypeId") int demandeClientTypeId) {
		DemandeClientType demandeClientType = demandeclientService.findDemandeClientTypeById(demandeClientTypeId);
      return employeeService.getVotedEmployeesByDemandeClientTypeId(demandeClientTypeId);
    }*/
	

}

