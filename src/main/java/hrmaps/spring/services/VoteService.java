package hrmaps.spring.services;

import java.util.List;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Vote;

public interface VoteService   {
	List<Vote> retrieveAllVote();
    Vote findVoteById(int r);
    //Vote addVoteLike( int demandeclientTypeId , int employeeId, int note);
    Vote findLikeByDemandeClientTypeAndEmployee(DemandeClientType d, Employee employee);
	

}
