package hrmaps.spring.repositories;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {


	@Query("SELECT v FROM Vote v WHERE v.demandeclienttype= :demandeclienttype AND v.employee= :employee")
    Vote SearchLike(@Param("demandeclienttype") DemandeClientType demandeclienttype, @Param("employee") Employee employee);

    @Query("SELECT sum(note)as val1 ,count(*) as val2 FROM Vote v WHERE v.demandeclienttype= :demandeclienttype")
    Map<String,Long>  getDemandeClientNote (@Param("demandeclienttype") DemandeClientType demandeclienttype);
    
}
