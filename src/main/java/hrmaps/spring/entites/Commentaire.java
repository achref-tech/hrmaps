package hrmaps.spring.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
@Table(name = "commentaires")
public class Commentaire {

   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name = "idComm", unique = true, nullable = false)

   private Integer  idComm;

   @NotBlank
   private String comment ;
   
   @ManyToOne
   @JoinColumn(name="employeeId",referencedColumnName = "employeeId")
   private Employee employeeId;

   /*@ManyToOne
   //@ManyToOne(fetch = FetchType.LAZY)
   @JsonIgnore
   @JoinColumn(name="demandeClientTypeId",referencedColumnName = "demandeClientTypeId")*/
   //@ManyToOne(fetch = FetchType.LAZY)
   //@JoinColumn(name = "demandeClientTypeId")
   @ManyToOne
   //@ManyToOne(fetch = FetchType.LAZY)
   @JsonIgnore
   @JoinColumn(name="demandeClientTypeId",referencedColumnName = "demandeClientTypeId")
   private DemandeClientType demandeClientTypeId;
   
   
   public Commentaire(Integer  idComm, String comment,Employee employeeId,DemandeClientType demandeClientTypeId) {
super();
this.idComm=idComm;
this.comment = comment;
this.employeeId=employeeId;
this.demandeClientTypeId=demandeClientTypeId;

}
public Commentaire() {
super();
}

public Integer getIdComm() {
return idComm;
}

public void setIdComm(Integer idComm) {
this.idComm = idComm;
}

public String getComment() {
return comment;
}

public void setComment(String comment) {
this.comment = comment;
}

public Employee getEmployeeId() {
return employeeId;
}

public void setEmployeeId(Employee employeeId) {
this.employeeId = employeeId;
}




public DemandeClientType getDemandeClientTypeId() {
return demandeClientTypeId;
}
public void setDemandeClientTypeId(DemandeClientType demandeClientTypeId) {
this.demandeClientTypeId = demandeClientTypeId;
}
@Override
public String toString() {
return "Commentaire [idComm=" + idComm + ", comment=" + comment + ", employeeId=" + employeeId
+ ", demandeClientTypeId=" + demandeClientTypeId + "]";
}

}
 

