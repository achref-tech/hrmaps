package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// Reunion
@Entity
@Table(name = "client")
public class Client  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196076758286887105L;
	private Integer clientId;
	private Double clientVolonte;
	@NotBlank
	private String clientDescription;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	@Column(name="clientDateDebutDemande")
	private Date clientDateDebutDemande;
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	@Column(name="clientDateFinDemande")
	private Date clientDateFinDemande;
	private Etat etat;
    private Version version;


	private Integer clientTypeId;
	
	private ClientType clientType;
    private UploadImageClient image ;
	
	
	
	
	public Client() {
	}

	public Client(Double clientVolonte, String clientDescription,
			
			Date clientDateDebutDemande, Date clientDateFinDemande,
			Integer clientTypeId,
			ClientType clientType,Version version,Etat etat ) {
		super();
		this.clientVolonte = clientVolonte;
		this.clientDescription = clientDescription;
		this.clientDateDebutDemande = clientDateDebutDemande;
		this.clientDateFinDemande = clientDateFinDemande;
		this.clientTypeId = clientTypeId;
		this.clientType = clientType;
		this.version=version;
		this.etat=etat;
		
		
	}


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "clientId", unique = true, nullable = false)
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Column(name = "clientVolonte", length = 254)
	public Double getClientVolonte() {
		return clientVolonte;
	}

	public void setClientVolonte(Double clientVolonte) {
		this.clientVolonte = clientVolonte;
	}

	@Column(name = "clientDescription", length = 254)
	public String getclientDescription() {
		return clientDescription;
	}

	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	

	public Integer getClientTypeId() {
		return clientTypeId;
	}

	

	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	@ManyToOne
	@JoinColumn(name="clientTypeId",referencedColumnName = "clientTypeId", insertable = false, updatable = false)
	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientDateDebutDemande=" +clientDateDebutDemande
				+ ", clientDateFinDemande=" +clientDateFinDemande + "]";
	}

	public Date getClientDateDebutDemande() {
		return clientDateDebutDemande;
	}

	public void setClientDateDebutDemande(Date clientDateDebutDemande) {
		this.clientDateDebutDemande = clientDateDebutDemande;
	}

	public Date getClientDateFinDemande() {
		return clientDateFinDemande;
	}

	public void setClientDateFinDemande(Date clientDateFinDemande) {
		this.clientDateFinDemande = clientDateFinDemande;
	}

	
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "etatId")
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clientVersionId")
	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}
	@OneToOne

	public UploadImageClient getImage() {
        return image;
    }

    public void setImage(UploadImageClient image) {
        this.image = image;
    }
	
	
	
}
