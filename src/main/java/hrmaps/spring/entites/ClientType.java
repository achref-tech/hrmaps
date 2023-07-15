package hrmaps.spring.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "clientType")
public class ClientType  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196076758286887105L;
	private Integer clientTypeId;
	private String clientTypeLibelle;
	private String clientTypeDescription;
	

	public ClientType() {
	}


	public ClientType( String clientTypeLibelle,
			String clientTypeDescription) {

		this.clientTypeLibelle = clientTypeLibelle;
		this.clientTypeDescription = clientTypeDescription;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "clientTypeId", unique = true, nullable = false)
	public Integer getClientTypeId() {
		return clientTypeId;
	}


	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	@Column(name = "clientTypeLibelle", length = 254)
	public String getClientTypeLibelle() {
		return clientTypeLibelle;
	}


	public void setClientTypeLibelle(String clientTypeLibelle) {
		this.clientTypeLibelle = clientTypeLibelle;
	}

	@Column(name = "clientTypeDescription", precision = 12, scale = 0)
	public String getClientTypeDescription() {
		return clientTypeDescription;
	}


	public void setClientTypeDescription(String clientTypeDescription) {
		this.clientTypeDescription = clientTypeDescription;
	}


	@Override
	public String toString() {
		return "clientType [clientTypeId=" + clientTypeId
				+ ", clientTypeLibelle=" + clientTypeLibelle
				+ ", clientTypeDescription=" + clientTypeDescription + "]";
	}
	
	
	
	

}
