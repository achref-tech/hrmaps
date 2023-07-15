package hrmaps.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "votes")

public class Vote implements Serializable {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int note;
    

   /* @ManyToOne
    @JsonIgnore
    private DemandeClientType demandeclienttype;
*/
    @ManyToOne
    //@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="demandeClientTypeId",referencedColumnName = "demandeClientTypeId")
    private DemandeClientType demandeclienttype;
    @ManyToOne
    private Employee employee;
    public Vote() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public DemandeClientType getDemandeclienttype() {
		return demandeclienttype;
	}

	public void setDemandeclienttype(DemandeClientType demandeclienttype) {
		this.demandeclienttype = demandeclienttype;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", note=" + note + ", demandeclienttype=" + demandeclienttype + ", employee="
				+ employee + "]";
	}
	
    
    
    
}