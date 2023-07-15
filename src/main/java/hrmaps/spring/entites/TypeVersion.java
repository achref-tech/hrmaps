package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typeversion")
public class TypeVersion implements Serializable {

	private static final long serialVersionUID = 478291466683301275L;

	private int typeversionid;
	private String typeversionlibelle;
	private String typeversiondescription;
	private String typeversionlibellear;
	private String typeversiondescriptionar;

	public TypeVersion(int typeversionid, String typeversionlibelle) {
		super();
		this.typeversionid = typeversionid;
		this.typeversionlibelle = typeversionlibelle;
	}

	public TypeVersion() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column( unique = true, nullable = false)
	public int getTypeversionid() {
		return typeversionid;
	}

	public void setTypeversionid(int typeversionid) {
		this.typeversionid = typeversionid;
	}

	
	public String getTypeversionlibelle() {
		return typeversionlibelle;
	}

	public void setTypeversionlibelle(String typeversionlibelle) {
		this.typeversionlibelle = typeversionlibelle;
	}

	
	public String getTypeversiondescription() {
		return typeversiondescription;
	}

	public void setTypeversiondescription(String typeversiondescription) {
		this.typeversiondescription = typeversiondescription;
	}


	public String getTypeversionlibellear() {
		return typeversionlibellear;
	}

	public void setTypeversionlibellear(String typeversionlibellear) {
		this.typeversionlibellear = typeversionlibellear;
	}

	@Column(name = "typeversiondescriptionar")
	public String getTypeversiondescriptionar() {
		return typeversiondescriptionar;
	}

	public void setTypeversiondescriptionar(String typeversiondescriptionar) {
		this.typeversiondescriptionar = typeversiondescriptionar;
	}
}

