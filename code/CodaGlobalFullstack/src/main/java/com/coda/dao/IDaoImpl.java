package com.coda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.coda.entities.Candidate;
import com.coda.entities.VoteDetails;

@Repository
public class IDaoImpl implements IDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Candidate> displayAllCandidate() {
		String Qstr="SELECT candidate FROM Candidate candidate";
		TypedQuery<Candidate> query=entityManager.createQuery(Qstr,Candidate.class);
		List<Candidate> listAllCandidates=query.getResultList();
		return listAllCandidates;
	}

	public boolean addVote(int candidateId) {
		String str= "SELECT candidate FROM Candidate candidate WHERE candidate.candidateId=:candidateId";
		TypedQuery<Candidate> query=entityManager.createQuery(str,Candidate.class);
		query.setParameter("candidateId", candidateId);
		try {
			Candidate candidate = query.getSingleResult();
			candidate.setVoted(true);
			entityManager.merge(candidate);
			return true;
		}catch(NoResultException e) {
			return false;
		}
	
	}

	@Override
	public boolean addVoteCount() {
		String str= "SELECT voteDetails FROM VoteDetails voteDetails";
		TypedQuery<VoteDetails> query=entityManager.createQuery(str,VoteDetails.class);
		VoteDetails votes= query.getSingleResult();
		votes.setTotalVotes(votes.getTotalVotes()+1);
		
		entityManager.merge(votes);
		return true;
	}

	
	public int displayAllVotes() {
		String str= "SELECT voteDetails FROM VoteDetails voteDetails";
		TypedQuery<VoteDetails> query=entityManager.createQuery(str,VoteDetails.class);
		VoteDetails votes= query.getSingleResult();	
		return votes.getTotalVotes();
	}

	@Override
	public boolean alreadyVotes(int candidateId) {
		String str= "SELECT candidate FROM Candidate candidate WHERE candidate.candidateId=:candidateId";
		TypedQuery<Candidate> query=entityManager.createQuery(str,Candidate.class);
		query.setParameter("candidateId", candidateId); 
		Candidate candidate = query.getSingleResult();
		return candidate.isVoted();
	}

}
