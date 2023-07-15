package hrmaps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.Vote;
import hrmaps.spring.services.DemandeClientTypeService;
import hrmaps.spring.services.EmployeeService;
import hrmaps.spring.services.VoteService;
import hrmaps.spring.servicesImp.VoteServiceImpl;



@RestController
public class VoteControlleur {


	@Autowired
	VoteServiceImpl voteService ;
	@Autowired
	DemandeClientTypeService demandeService;
	@Autowired
	EmployeeService employeeService ;

	@GetMapping("/retrieve-all-Vote")
	@ResponseBody
	public List<Vote> getComment() {
		List<Vote> list = voteService.retrieveAllVote();
		return list;
	}

	@GetMapping("/retrieve-vote/{id}")
	@ResponseBody
	public Vote retrieveVote(@PathVariable("id") int id) {
		return voteService.findVoteById(id);
	}


	@GetMapping("/retrieve-voteByDemandeandEmployee/{id}/{employeeId}")
	@ResponseBody
	public Vote retrieveVoteByDemandeandEmployee(@PathVariable("id") int id, @PathVariable("employeeId") int employeeId) {
		return voteService.findLikeByDemandeClientTypeAndEmployee(demandeService.findDemandeClientTypeById(employeeId),employeeService.findEmployeeById(employeeId));
	}



	/*@PostMapping("/add-votelike/{demandeclienttypeId}/{employeeId}/{note}")
	@ResponseBody
	public Vote addVoteLike(@PathVariable("demandeclienttypeId") int demandeclienttypeId,@PathVariable("employeeId") int employeeId,@PathVariable("note") int note) {
		Vote vote = voteService.addVoteLike(demandeclienttypeId,employeeId,note);
		return vote ;
	}*/

}

