package hrmaps.spring.utils;

import hrmaps.spring.entites.Civilite;
import hrmaps.spring.entites.Membre;

public class MembreModel {
	
	private Membre membre;
	private String posteMembre;
	private Integer typeMembre;
	private String origineMembre;
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
	private boolean membrePresence;
	private String membrePresenceString;
	
	
	public MembreModel(int membreId, String membreMatricule, String membreLibelle, String membreCivilite,
			String membreNom, String membrePrenom, String membreFonction, String membreAdresseMail, String membreTel,
			String membreCell, String membreDescription,boolean membrePresence) {
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
		this.membrePresence=membrePresence;
	}
	
	public MembreModel() {
		super();
	}
	
	public MembreModel(int membreId, String membreMatricule, String membreNom, String membrePrenom,
			String membreFonction) {
		super();
		this.membreId = membreId;
		this.membreMatricule = membreMatricule;
		this.membreNom = membreNom;
		this.membrePrenom = membrePrenom;
		this.membreFonction = membreFonction;
	}
	
	public MembreModel(int membreId, String membreMatricule, String membreNom, String membrePrenom,
			String membreFonction,String membrePresenceString) {
		super();
		this.membreId = membreId;
		this.membreMatricule = membreMatricule;
		this.membreNom = membreNom;
		this.membrePrenom = membrePrenom;
		this.membreFonction = membreFonction;
		this.membrePresenceString = membrePresenceString;
	}
	
	public MembreModel(Membre membre,boolean membrePresence) {
		super();
		this.membre = membre;
		this.membrePresence=membrePresence;
	}
	
	public MembreModel(int membreId, String membreMatricule, String membreNom, String membrePrenom,
			String membreFonction, boolean membrePresence) {
		super();
		this.membreId = membreId;
		this.membreMatricule = membreMatricule;
		this.membreNom = membreNom;
		this.membrePrenom = membrePrenom;
		this.membreFonction = membreFonction;
		this.membrePresence = membrePresence;
	}
	
	public Integer getTypeMembre() {
		return typeMembre;
	}
	public void setTypeMembre(Integer typeMembre) {
		this.typeMembre = typeMembre;
	}
	public Membre getMembre() {
		return membre;
	}
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	public String getOrigineMembre() {
		return origineMembre;
	}
	public void setOrigineMembre(String origineMembre) {
		this.origineMembre = origineMembre;
	}
	public String getPosteMembre() {
		return posteMembre;
	}
	public void setPosteMembre(String posteMembre) {
		this.posteMembre = posteMembre;
	}
	public int getMembreId() {
		return membreId;
	}
	public void setMembreId(int membreId) {
		this.membreId = membreId;
	}
	public String getMembreMatricule() {
		return membreMatricule;
	}
	public void setMembreMatricule(String membreMatricule) {
		this.membreMatricule = membreMatricule;
	}
	public String getMembreNom() {
		return membreNom;
	}
	public void setMembreNom(String membreNom) {
		this.membreNom = membreNom;
	}
	public String getMembrePrenom() {
		return membrePrenom;
	}
	public void setMembrePrenom(String membrePrenom) {
		this.membrePrenom = membrePrenom;
	}
	public String getMembreFonction() {
		return membreFonction;
	}
	public void setMembreFonction(String membreFonction) {
		this.membreFonction = membreFonction;
	}
	public String getMembreAdresseMail() {
		return membreAdresseMail;
	}
	public void setMembreAdresseMail(String membreAdresseMail) {
		this.membreAdresseMail = membreAdresseMail;
	}
	public String getMembreTel() {
		return membreTel;
	}
	public void setMembreTel(String membreTel) {
		this.membreTel = membreTel;
	}
	public String getMembreCell() {
		return membreCell;
	}
	public void setMembreCell(String membreCell) {
		this.membreCell = membreCell;
	}
	public String getMembreDescription() {
		return membreDescription;
	}
	public void setMembreDescription(String membreDescription) {
		this.membreDescription = membreDescription;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public boolean isMembrePresence() {
		return membrePresence;
	}
	public void setMembrePresence(boolean membrePresence) {
		this.membrePresence = membrePresence;
	}
	public String getMembrePresenceString() {
		return membrePresenceString;
	}
	public void setMembrePresenceString(String membrePresenceString) {
		this.membrePresenceString = membrePresenceString;
	}

}

