package com.management.dto;

import java.io.Serializable;

public class PayLoadDto implements Serializable{

	@Override
	public String toString() {
		return "PayLoadDto [success=" + success + ", payload=" + payload + "]";
	}

	public PayLoadDto(boolean success, CardDto payload) {
		super();
		this.success = success;
		this.payload = payload;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6968498781883073078L;
	
	private boolean success;
	
	private CardDto payload;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CardDto getPayload() {
		return payload;
	}

	public void setPayload(CardDto payload) {
		this.payload = payload;
	}

}
