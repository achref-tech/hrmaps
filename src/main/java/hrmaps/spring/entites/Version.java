package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "version")
public class Version implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5196076758286887105L;
	private Integer versionId;
	private String versionLibelle;
	private String versionEmplacement;
	private TypeVersion versionType;
	
	private String versionResponsable;
	private String versionEmailResponsable;

	
	public Version() {
	}
	public Version(String versionLibelle, String versionEmplacement,
			 String versionResponsable,
			String versionEmailResponsable) {
		
		this.versionLibelle = versionLibelle;
		this.versionEmplacement = versionEmplacement;
		this.versionResponsable = versionResponsable;
		this.versionEmailResponsable = versionEmailResponsable;
	}
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "versionId", unique = true, nullable = false)
	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

	@Column(name = "versionLibelle")
	public String getVersionLibelle() {
		return versionLibelle;
	}

	public void setVersionLibelle(String versionLibelle) {
		this.versionLibelle = versionLibelle;
	}

	@Column(name = "versionEmpalcement")
	public String getVersionEmplacement() {
		return versionEmplacement;
	}

	public void setVersionEmplacement(String versionEmplacement) {
		this.versionEmplacement = versionEmplacement;
	}

	

	@Column(name = "versionResponsable", length = 254)
	public String getVersionResponsable() {
		return versionResponsable;
	}

	public void setVersionResponsable(String versionResponsable) {
		this.versionResponsable = versionResponsable;
	}

	@Column(name = "versionEmailResponsable", length = 254)
	public String getVersionEmailResponsable() {
		return versionEmailResponsable;
	}

	public void setVersionEmailResponsable(String versionEmailResponsable) {
		this.versionEmailResponsable = versionEmailResponsable;
	}
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="versionType")
	public TypeVersion getVersionType() {
		return versionType;
	}
	public void setVersionType(TypeVersion versionType) {
		this.versionType = versionType;
	}
	
	
	
}



