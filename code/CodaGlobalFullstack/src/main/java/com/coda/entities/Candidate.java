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
@Table(name="candidate")
@DynamicUpdate
@DynamicInsert
public class Candidate {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="candidateIdGenerator")
	@SequenceGenerator(name="candidateIdGenerator", initialValue=100)
	private int candidateId;
	
	@Column(name="candidate_name")
	private String candidateName;
	
	@Column(name="number_of_challanges")
	private int numberOfChallanges;
	
	@Column(name="expertise")
	private String expertise;
	
	@Column(name="voted")
	private boolean voted;

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public int getNumberOfChallanges() {
		return numberOfChallanges;
	}

	public void setNumberOfChallanges(int numberOfChallanges) {
		this.numberOfChallanges = numberOfChallanges;
	}

	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	
	
}
