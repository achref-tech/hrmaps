package hrmaps.spring.entites;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "civilitee")
public class Civilite  {

	/**
		 * 
		 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "civiliteId", unique = true, nullable = false)
	private int civiliteId;
	private String civiliteLibelle;
	private String civiliteAcronyme;
	

}

