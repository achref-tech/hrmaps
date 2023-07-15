package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "conges")
public class Conge implements Serializable  {
    
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	@Column(name="startDate")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	@Column(name="endDate")
    private Date endDate;
    private String reason;
    private String name;
    private Etat etat;
    private Employee employeeId;
	
    
    @Override
	public String toString() {
		return "Conge [id=" + id + ",etat="+etat+", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason
				+ ", name=" + name + "]";
	}
    public Conge() {
		super();
	}
	
	public Conge( Date startDate, Date endDate,String reason,Etat etat) {
			
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.etat=etat;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	@ManyToOne
	@JoinColumn(name="employeeId",referencedColumnName = "employeeId")
	public Employee getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Employee employeeId) {
		this.employeeId = employeeId;
	}
	
	
    
    
    
}
