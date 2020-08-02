package com.coda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="vote_details")
@DynamicUpdate
@DynamicInsert
public class VoteDetails {

	@Id
	@Column(name="voteId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="voteIdGenerator")
	@SequenceGenerator(name="voteIdGenerator", initialValue=100)
	private int voteId;
	
	
	@Column(name="total_votes")
	private int totalVotes;

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	
	
}
