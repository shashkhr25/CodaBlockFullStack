package com.coda.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coda.dao.IDao;
import com.coda.entities.Candidate;
import com.coda.exception.VoteException;

@Service
@Transactional
public class IServiceImpl implements IService {

	@Autowired
	private IDao dao;
	
	@Override
	public List<Candidate> displayAllCandidate() {
		return dao.displayAllCandidate();
	}

	@Override
	public String voteByCandidate(int candidateId) throws VoteException {
		if(dao.alreadyVotes(candidateId)) {
			throw new VoteException("Already voted, cannot vote twice");
		}
		dao.addVote(candidateId);
		dao.addVoteCount();
		return "Vote added";
	}
	
	public int displayAllVotes() {
		return dao.displayAllVotes();
	}

}
