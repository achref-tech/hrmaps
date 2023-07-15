package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "demandeclient")
public class DemandeClient  implements java.io.Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer demandeClientId;
	private Membre membre;
	private Client client;
	private boolean membrePresence;
	
	private DemandeClientType demandeclienttype;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "demandeClientId", unique = true, nullable = false)
	public Integer getDemandeClientId() {
		return demandeClientId;
	}
	public void setDemandeClientId(Integer demandeClientId) {
		this.demandeClientId = demandeClientId;
	}
	@ManyToOne
	@JoinColumn(name="membreId",referencedColumnName = "membreId")
	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	@ManyToOne
	@JoinColumn(name="clientId",referencedColumnName = "clientId")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Column(name = "membrePresence")
	public boolean isMembrePresence() {
		return membrePresence;
	}
	public void setMembrePresence(boolean membrePresence) {
		this.membrePresence = membrePresence;
	}
	@ManyToOne
	@JoinColumn(name="demandeclientTypeId",referencedColumnName = "demandeclientTypeId")
	public DemandeClientType getTypeDemandeClient() {
		return demandeclienttype;
	}
	public void setTypeDemandeClient(DemandeClientType demandeclienttype) {
		this.demandeclienttype = demandeclienttype;
	}

}

