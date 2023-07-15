package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="etatscategorie")
public class EtatCategorie  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8482301533794409041L;
	
	private int etatCategorieId;
	private String etatCategorieLibelle;
	private String etatCategorieDescription;
	
	public EtatCategorie(int etatCategorieId, String etatCategorieLibelle) {
		super();
		this.etatCategorieId = etatCategorieId;
		this.etatCategorieLibelle = etatCategorieLibelle;
	}
	public EtatCategorie() {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "etatCategorieId", unique = true, nullable = false)
	public int getEtatCategorieId() {
		return etatCategorieId;
	}
	public void setEtatCategorieId(int etatCategorieId) {
		this.etatCategorieId = etatCategorieId;
	}
	
	@Column(name="etatCategorieLibelle")
	public String getEtatCategorieLibelle() {
		return etatCategorieLibelle;
	}
	public void setEtatCategorieLibelle(String etatCategorieLibelle) {
		this.etatCategorieLibelle = etatCategorieLibelle;
	}
	
	@Column(name="etatCategorieDescription")
	public String getEtatCategorieDescription() {
		return etatCategorieDescription;
	}
	public void setEtatCategorieDescription(String etatCategorieDescription) {
		this.etatCategorieDescription = etatCategorieDescription;
	}
	
	
	

}

