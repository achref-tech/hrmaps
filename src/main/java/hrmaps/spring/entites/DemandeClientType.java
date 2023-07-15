
package hrmaps.spring.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "demandeClientType")
public class DemandeClientType implements java.io.Serializable {

/**
*
*/
private static final long serialVersionUID = -5196076758286887105L;
private Integer demandeClientTypeId;
private String demandeclientTypeLibelle;
private String demandeclientTypeDescription;
private String demandeclientTypeNom;
private String demandeclientTypePrenom;
private Double demandeclientTypeVersion;
@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
@Column(name="demandeclientDateDebutDemande")
private Date demandeclientDateDebutDemande;
@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
@Column(name="demandeclientDateFinDemande")
private Date demandeclientDateFinDemande;
private Etat etat;
    private Integer note;
    @OneToOne
private UploadImageDemandeClient image ;

private Employee employeeId;
private Membre membreId;
private Set<Vote> votes;
//private Set<Integer>votes;
/*@OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//@OneToMany(mappedBy = "demandeClientTypeId", cascade = CascadeType.ALL, orphanRemoval = true)
//@OneToMany(mappedBy = "demandeClientTypeId",fetch = FetchType.LAZY)
@JsonIgnore
@JoinColumn(name = "idComm")*/
//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Commentaire.class)
//@JoinColumn(name = "demandeClientTypeId")
private List<Commentaire> commentaires;
   





public DemandeClientType() {
}

public DemandeClientType(String demandeclientTypeLibelle, String demandeclientTypeDescription,String demandeclientTypeNom
,String demandeclientTypePrenom,Double demandeclientTypeVersion,Etat etat,Date demandeclientDateFinDemande
,Date demandeclientDateDebutDemande,Integer demandeclientTypeId, List<Commentaire> commentaires) {
super();
this.demandeclientTypeLibelle = demandeclientTypeLibelle;
this.demandeclientTypeDescription = demandeclientTypeDescription;
this.demandeclientTypeNom = demandeclientTypeNom;
this.demandeclientTypePrenom=demandeclientTypePrenom;
this.demandeclientTypeVersion=demandeclientTypeVersion;
this.etat=etat;
this.demandeclientDateDebutDemande=demandeclientDateDebutDemande;
this.demandeclientDateFinDemande=demandeclientDateFinDemande;
this.demandeClientTypeId=demandeclientTypeId;
this.commentaires=commentaires;
}

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name = "demandeclientTypeId", unique = true, nullable = false)
public Integer getDemandeClientTypeId() {
return this.demandeClientTypeId;
}

public void setDemandeClientTypeId(Integer demandeclientTypeId) {
this.demandeClientTypeId = demandeclientTypeId;
}

@Column(name = "demandeclientTypeLibelle", length = 254)
public String getDemandeClientTypeLibelle() {
return this.demandeclientTypeLibelle;
}

public void setDemandeClientTypeLibelle(String demandeclientTypeLibelle) {
this.demandeclientTypeLibelle = demandeclientTypeLibelle;
}

@Column(name = "demandeclientTypeDescription", precision = 12, scale = 0)
public String getDemandeClientTypeDescription() {
return this.demandeclientTypeDescription;
}

public void setDemandeClientTypeDescription(String demandeclientTypeDescription) {
this.demandeclientTypeDescription = demandeclientTypeDescription;
}
@Column(name = "demandeclientTypeNom", length = 254)
public String getDemandeclientTypeNom() {
return demandeclientTypeNom;
}

public void setDemandeclientTypeNom(String demandeclientTypeNom) {
this.demandeclientTypeNom = demandeclientTypeNom;
}
@Column(name = "demandeclientTypePrenom", length = 254)
public String getDemandeclientTypePrenom() {
return demandeclientTypePrenom;
}

public void setDemandeclientTypePrenom(String demandeclientTypePrenom) {
this.demandeclientTypePrenom = demandeclientTypePrenom;
}
@Column(name = "demandeclientTypeVersion")
public Double getDemandeclientTypeVersion() {
return demandeclientTypeVersion;
}

public void setDemandeclientTypeVersion(Double demandeclientTypeVersion) {
this.demandeclientTypeVersion = demandeclientTypeVersion;
}
@Override
public String toString() {
return "DemandeClientType [demandeClientTypeId=" + demandeClientTypeId + ", demandeclientDateDebutDemande=" +demandeclientDateDebutDemande
+ ", demandeclientDateFinDemande=" +demandeclientDateFinDemande + "]";
}
public Date getDemandeclientDateDebutDemande() {
return demandeclientDateDebutDemande;
}

public void setDemandeclientDateDebutDemande(Date demandeclientDateDebutDemande) {
this.demandeclientDateDebutDemande = demandeclientDateDebutDemande;
}

public Date getDemandeclientDateFinDemande() {
return demandeclientDateFinDemande;
}

public void setDemandeclientDateFinDemande(Date demandeclientDateFinDemande) {
this.demandeclientDateFinDemande = demandeclientDateFinDemande;
}
@ManyToOne(fetch= FetchType.EAGER)
@JoinColumn(name = "etatId")
public Etat getEtat() {
return etat;
}

public void setEtat(Etat etat) {
this.etat = etat;
}

@OneToOne
public UploadImageDemandeClient getImage() {
return image;
}

public void setImage(UploadImageDemandeClient image) {
this.image = image;
}

@ManyToOne
@JoinColumn(name="employeeId",referencedColumnName = "employeeId")
public Employee getEmployeeId() {
return employeeId;
}

public void setEmployeeId(Employee employeeId) {
this.employeeId = employeeId;
}
@ManyToOne
@JoinColumn(name="membreId",referencedColumnName = "membreId")
public Membre getMembreId() {
return membreId;
}

public void setMembreId(Membre membreId) {
this.membreId = membreId;
}

@OneToMany(fetch= FetchType.EAGER)
//@OneToMany(mappedBy = "demandeClientType")
@JsonIgnore
@JoinColumn(name = "id")
public Set<Vote> getVotes() {
return votes;
}

public void setVotes(Set<Vote> votes) {
this.votes = votes;
}

public Integer getNote() {
return note;
}

public void setNote(Integer note) {
this.note = note;
}

//@OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//@OneToMany(mappedBy = "demandeClientTypeId", cascade = CascadeType.ALL, orphanRemoval = true)
//@OneToMany(mappedBy = "demandeClientTypeId",fetch = FetchType.LAZY)
//@JsonIgnore
//@JoinColumn(name = "idComm")
@OneToMany(mappedBy = "demandeClientTypeId", cascade = CascadeType.ALL)
@JsonIgnore
public List<Commentaire> getCommentaires() {
return commentaires;
}

public void setCommentaires(List<Commentaire> commentaires) {
this.commentaires = commentaires;
}




}