package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name="etats")




public class Etat implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3590903908883962286L;
   
	private int etatId;
	private EtatCategorie etatCategorie;

	private String etatLibelle;
	private int etatOrdre;
	private String couleur;
	
	public Etat(int etatId, EtatCategorie etatCategorie, String etatLibelle,
			int etatOrdre) {
		super();
		this.etatId = etatId;
		this.etatCategorie = etatCategorie;
		this.etatLibelle = etatLibelle;
		this.etatOrdre = etatOrdre;
	}
	public Etat() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "etatId", unique = true, nullable = false)
	public int getEtatId() {
		return etatId;
	}
	public void setEtatId(int etatId) {
		this.etatId = etatId;
	}
	@ManyToOne
	@JoinColumn(name="etatCategorieId",insertable=true,updatable=true)
	public EtatCategorie getEtatCategorie() {
		return etatCategorie;
	}
	public void setEtatCategorie(EtatCategorie etatCategorie) {
		this.etatCategorie = etatCategorie;
	}
	@Column(name="etatLibelle")
	public String getEtatLibelle() {
		return etatLibelle;
	}
	public void setEtatLibelle(String etatLibelle) {
		this.etatLibelle = etatLibelle;
	}
	@Column(name="etatOrdre")
	public int getEtatOrdre() {
		return etatOrdre;
	}
	public void setEtatOrdre(int etatOrdre) {
		this.etatOrdre = etatOrdre;
	}
	
	@Column(name="etatImageCouleur")
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	

	

}
