package com.management.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Card")
public class Card implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7769431954260720339L;

	@Id
	@Column 
	private Long cardNumber;
	
	@Column 
	private String scheme;
	
	public Card(Long cardNumber, String scheme, String type, String bank, int noOfHits) {
		super();
		this.cardNumber = cardNumber;
		this.scheme = scheme;
		this.type = type;
		this.bank = bank;
		this.noOfHits = noOfHits;
	}
	@Column 
	private String type;
	
	@Column 
	private String bank;
	
	@Column
	private int noOfHits;
	
	public int getNoOfHits() {
		return noOfHits;
	}
	public void setNoOfHits(int noOfHits) {
		this.noOfHits = noOfHits;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Card() {
		
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getScheme() {
		return scheme;
	}
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}

}
