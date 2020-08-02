package com.coda.service;

import java.util.List;

import com.coda.entities.Candidate;
import com.coda.exception.VoteException;

public interface IService {

	public List<Candidate> displayAllCandidate();
	public String voteByCandidate(int candidateId) throws VoteException;
	public int displayAllVotes();
	
}
