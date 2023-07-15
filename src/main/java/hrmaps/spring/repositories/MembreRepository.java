package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hrmaps.spring.entites.Membre;
@ Repository

public interface MembreRepository extends JpaRepository<Membre, Integer> {
	
	//@Query(value = "Select FROM Membre p where p.membreAdresseMail=:membreAdresseMail")
	public Membre findBymembreAdresseMail(String membreAdresseMail);
	//@Query(value = "Select FROM Membre p where p.membreAdresseMail=:membreAdresseMail and" + 
			
		//	" p.membreCell=:membreCell "
			//)
	public Membre findBymembreAdresseMailAndMembreCell(String membreAdresseMail,String membreCell);

}
