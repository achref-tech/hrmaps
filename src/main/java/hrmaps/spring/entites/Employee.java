package hrmaps.spring.entites;


import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "employees")
public class Employee implements Serializable {


	private int employeeId;
	private String employeeNom;
	private String employeePrenom;
	private String employeeAdresseMail;
	private String employeeMdp;
	private String employeeCMdp;
	private String code;
   // private Set<Vote> votes;

	
	public Employee(int employeeId, String employeeNom, String employeePrenom,
			String employeeAdresseMail,String code, String employeeMdp, String employeeCMdp) {
		super();
		this.code=code;
		this.employeeId = employeeId;
		this.employeeNom = employeeNom;
		this.employeePrenom = employeePrenom;
		this.employeeAdresseMail = employeeAdresseMail;
		this.employeeMdp = employeeMdp;
		this.employeeCMdp = employeeCMdp;
	}
	public Employee() {
		super();
	}


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "employeeId", unique = true, nullable = false)
	public int getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public String getEmployeeNom() {
		return employeeNom;
	}



	public void setEmployeeNom(String employeeNom) {
		this.employeeNom = employeeNom;
	}



	public String getEmployeePrenom() {
		return employeePrenom;
	}



	public void setEmployeePrenom(String employeePrenom) {
		this.employeePrenom = employeePrenom;
	}



	public String getEmployeeAdresseMail() {
		return employeeAdresseMail;
	}



	public void setEmployeeAdresseMail(String employeeAdresseMail) {
		this.employeeAdresseMail = employeeAdresseMail;
	}



	public String getEmployeeMdp() {
		return employeeMdp;
	}



	public void setEmployeeMdp(String employeeMdp) {
		this.employeeMdp = employeeMdp;
	}



	public String getEmployeeCMdp() {
		return employeeCMdp;
	}



	public void setEmployeeCMdp(String employeeCMdp) {
		this.employeeCMdp = employeeCMdp;
	}
    
	


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/*@OneToMany(mappedBy = "employee")

	public Set<Vote> getVotes() {
		return votes;
	}
	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}*/
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeNom=" + employeeNom + ", employeePrenom="
				+ employeePrenom + ", employeeAdresseMail=" + employeeAdresseMail + ", employeeMdp=" + employeeMdp
				+ ", employeeCMdp=" + employeeCMdp + "]";
	}
    
	
	
	
}

