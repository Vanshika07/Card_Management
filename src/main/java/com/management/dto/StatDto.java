package com.management.dto;

import java.io.Serializable;
import java.util.Map;

public class StatDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1011260722382090377L;
	
	private boolean success;
	
	private int start;
	
	private int limit;
	
	private int size;
	
	@Override
	public String toString() {
		return "StatDto [success=" + success + ", start=" + start + ", limit=" + limit + ", size=" + size + ", payload="
				+ payload + "]";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private Map<Long,Integer> payload;

	public Map<Long, Integer> getPayload() {
		return payload;
	}

	public void setPayload(Map<Long, Integer> payload) {
		this.payload = payload;
	}

}
