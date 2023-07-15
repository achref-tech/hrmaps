package hrmaps.spring.servicesImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrmaps.spring.entites.DemandeClientType;
import hrmaps.spring.entites.Employee;
import hrmaps.spring.entites.Vote;
import hrmaps.spring.repositories.VoteRepository;
import hrmaps.spring.services.DemandeClientTypeService;
import hrmaps.spring.services.EmployeeService;
import hrmaps.spring.services.VoteService;
@Service
@Transactional

public class VoteServiceImpl implements VoteService {
	@Autowired
    VoteRepository VoteRepo ;
	@Autowired
	EmployeeService empService;
	@Autowired
	DemandeClientTypeService demandeService;
	
	
	
	@Override
    public List<Vote> retrieveAllVote() {
        List<Vote> votes = (List<Vote>) VoteRepo.findAll();
        return votes;
    }

    @Override
    public Vote findVoteById(int r) {
        return this.VoteRepo.findById(r).get();
    }
    
   /* @Override
    @Transactional
    public Vote addVoteLike( int demandeclientTypeId , int employeeId, int note) {
    	DemandeClientType d = demandeService.findDemandeClientTypeById(demandeclientTypeId);
        Vote vote = findLikeByDemandeClientTypeAndEmployee(d,empService.findEmployeeById(employeeId));
        System.out.println(vote);
        if(vote==null)
        	vote = new Vote();
        
        vote.setEmployee(empService.findEmployeeById(employeeId));
        vote.setDemandeclienttype(demandeService.findDemandeClientTypeById(demandeclientTypeId));
        vote.setNote(note);
        vote =VoteRepo.save(vote);
        Map<String,Long> demande = VoteRepo.getDemandeClientNote(d);
        System.out.println("demande"+d);
        Long val1 =  demande.get("val1");
        Long val2 =  demande.get("val2");
        d.setNote((Double.valueOf(val1+"")/Double.valueOf(val2+"")));
        System.out.println("pub"+d.getNote());
        demandeService.updateDemandeClientType(d);
        return vote;

    }*/
    @Override

    public Vote findLikeByDemandeClientTypeAndEmployee(DemandeClientType d, Employee employee){
    	return  VoteRepo.SearchLike(d, employee);
    }
    
    
}
