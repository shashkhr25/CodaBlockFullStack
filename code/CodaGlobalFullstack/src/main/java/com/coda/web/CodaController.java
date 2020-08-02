package com.coda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coda.dto.ResponseMessage;
import com.coda.entities.Candidate;
import com.coda.exception.VoteException;
import com.coda.service.IService;

@RestController
public class CodaController {

	@Autowired
	private IService service;
	
	@CrossOrigin
	@GetMapping("/displayAllCandidate")
	public List<Candidate> displayAllCandidate() {
		return service.displayAllCandidate();
	}
	
	@CrossOrigin
	@GetMapping("/vote/{candidateId}")
	public ResponseMessage voteByCandidate(@PathVariable(name="candidateId") int candidateId) throws VoteException {
		ResponseMessage msg= new ResponseMessage();
		msg.setMessage(service.voteByCandidate(candidateId));
		return msg;
	}
	
	@CrossOrigin
	@GetMapping("/displayAllVotes")
	public ResponseMessage displayAllVotes() {
		ResponseMessage msg = new ResponseMessage();
		String allVotes= ""+service.displayAllVotes();
		msg.setMessage(allVotes);
		return msg;
	}
}
