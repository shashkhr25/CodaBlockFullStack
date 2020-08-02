package com.coda.dao;

import java.util.List;

import com.coda.entities.Candidate;

public interface IDao {

	public List<Candidate> displayAllCandidate();
	public boolean addVote(int candidateId);
	public boolean addVoteCount();
	public int displayAllVotes();
	public boolean alreadyVotes(int candidateId);
	
}
