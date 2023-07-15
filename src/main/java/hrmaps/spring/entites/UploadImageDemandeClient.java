package hrmaps.spring.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Base64;

@Entity
@Table (name="uploadImageDemandeClient")
public class UploadImageDemandeClient {
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	//@JsonIgnore
	@Lob
	private byte[] data;
	
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private DemandeClientType demandeclient;
	
    
	
	@Transient
	private String dataValue;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public String getDataValue() {
		return Base64.getEncoder().encodeToString(this.data);
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public DemandeClientType getDemandeclient() {
		return demandeclient;
	}
	public void setDemandeclient(DemandeClientType demandeclient) {
		this.demandeclient = demandeclient;
	}


	
	
}


