package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "membres")
public class Membre implements Serializable {


	private int membreId;
	private String membreMatricule;
	private String membreNom;
	private String membrePrenom;
	private String membreFonction;
	private String membreAdresseMail;
	private String membreTel;
	private String membreCell;
	private String membreDescription;
	private Civilite civilite;
//	private ServiceMaitreDoeuvre serviceMaitreDoeuvre;
//	private AutoriteContractante autoriteContractante;

	public Membre(int membreId, String membreMatricule, String membreLibelle,
			String membreCivilite, String membreNom, String membrePrenom,
			String membreFonction, String membreAdresseMail, String membreTel,
			String membreCell, String membreDescription
			) {
		super();
		this.membreId = membreId;
		this.membreMatricule = membreMatricule;
		this.membreNom = membreNom;
		this.membrePrenom = membrePrenom;
		this.membreFonction = membreFonction;
		this.membreAdresseMail = membreAdresseMail;
		this.membreTel = membreTel;
		this.membreCell = membreCell;
		this.membreDescription = membreDescription;
//		this.serviceMaitreDoeuvre = serviceMaitreDoeuvre;
//		this.autoriteContractante = autoriteContractante;
	}

	public Membre() {
		super();
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "membreId", unique = true, nullable = false)
	public int getMembreId() {
		return membreId;
	}

	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}

	@Column(name = "membreDescription")
	public String getMembreDescription() {
		return membreDescription;
	}

	public void setMembreDescription(String membreDescription) {
		this.membreDescription = membreDescription;
	}

//	@ManyToOne
//	@JoinColumn(name = "serviceMaitreDoeuvreId", nullable = true)
//	public ServiceMaitreDoeuvre getServiceMaitreDoeuvre() {
//		return serviceMaitreDoeuvre;
//	}
//
//	public void setServiceMaitreDoeuvre(
//			ServiceMaitreDoeuvre serviceMaitreDoeuvre) {
//		this.serviceMaitreDoeuvre = serviceMaitreDoeuvre;
//	}

	@Column(name = "membreNom")
	public String getMembreNom() {
		return membreNom;
	}

	public void setMembreNom(String membreNom) {
		this.membreNom = membreNom;
	}

	@Column(name = "membrePrenom")
	public String getMembrePrenom() {
		return membrePrenom;
	}

	public void setMembrePrenom(String membrePrenom) {
		this.membrePrenom = membrePrenom;
	}

	@Column(name = "membreFonction")
	public String getMembreFonction() {
		return membreFonction;
	}

	public void setMembreFonction(String membreFonction) {
		this.membreFonction = membreFonction;
	}

	@Column(name = "membreAdresseMail")
	public String getMembreAdresseMail() {
		return membreAdresseMail;
	}

	public void setMembreAdresseMail(String membreAdresseMail) {
		this.membreAdresseMail = membreAdresseMail;
	}

	@Column(name = "membreTell")
	public String getMembreTel() {
		return membreTel;
	}

	public void setMembreTel(String membreTel) {
		this.membreTel = membreTel;
	}

	@Column(name = "membreCell")
	public String getMembreCell() {
		return membreCell;
	}

	public void setMembreCell(String membreCell) {
		this.membreCell = membreCell;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "civiliteId", insertable = true, updatable = true)
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}	

	@Column(unique=true, name = "membreMatricule" )
	public String getMembreMatricule() {
		return membreMatricule;
	}

	public void setMembreMatricule(String membreMatricule) {
		this.membreMatricule = membreMatricule;
	}

//	@Override
//	public String toString() {
//		return "Membre [membreId=" + membreId + ", membreMatricule=" + membreMatricule + ", membreNom=" + membreNom
//				+ ", membrePrenom=" + membrePrenom + "]";
//	}


	

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "autoriteContractanteId")
//	public AutoriteContractante getAutoriteContractante() {
//		return autoriteContractante;
//	}
//
//	public void setAutoriteContractante(AutoriteContractante autoriteContractante) {
//		this.autoriteContractante = autoriteContractante;
//	}
//
//	@Override
//	public String toString() {
//		return "Membre [membreId=" + membreId + ", membreMatricule="
//				+ membreMatricule + ", membreNom=" + membreNom
//				+ ", membrePrenom=" + membrePrenom + ", membreFonction="
//				+ membreFonction + ", membreAdresseMail=" + membreAdresseMail
//				+ ", membreTel=" + membreTel + ", membreCell=" + membreCell
//				+ ", membreDescription=" + membreDescription + ", civilite="
//				+ civilite + ", serviceMaitreDoeuvre=" + serviceMaitreDoeuvre
//				+ ", autoriteContractante=" + autoriteContractante + "]";
//	}

	
	
}
