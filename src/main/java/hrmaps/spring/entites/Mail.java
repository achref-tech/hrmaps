package hrmaps.spring.entites;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mail")
public class Mail implements java.io.Serializable
{
	private static final long serialVersionUID = -5196076758286887105L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String to;
    private String subject;
    private String text;
    
    
    public Mail() {
    	super();
    }
    public Mail(String to,String subject,String text) {
    	super();
    	this.to=to;
    	this.subject=subject;
    	this.text=text;
    	
    }
    @Override
	public String toString() {
		return "Mail [to=" + to + ", subject=" + subject + ", text=" + text +  "]";
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
    
    
}
	/**
	 * 
	 */
	/*
	private static final long serialVersionUID = -5196076758286887105L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String destinataire;
    private String objet;
    private String message;
    
    public Mail() {
    	super();
    }
    public Mail(long id,String destinataire,String objet,String message) {
    	super();
    	this.id=id;
    	this.destinataire=destinataire;
    	this.objet=objet;
    	this.message=message;
    }
    
	@Override
	public String toString() {
		return "Mail [id=" + id + ", destinataire=" + destinataire + ", objet=" + objet + ", message=" + message + "]";
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    
    
}  */ 
    
   