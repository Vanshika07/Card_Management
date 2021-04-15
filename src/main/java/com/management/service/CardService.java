package com.management.service;

import org.springframework.stereotype.Service;

import com.management.dto.PayloadDto;

@Service
public class CardService  {

	public PayloadDto getCardDetails(Long card_number) {
		PayloadDto payloadDto = new PayloadDto(null, null, null);
		return payloadDto;
		
	}
}
