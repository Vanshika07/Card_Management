package com.management.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.management.dao.CardDao;
import com.management.dto.PayloadDto;
import com.management.entity.Card;

@Service
public class CardService  {
	
	@Resource
	private CardDao cardDao;

	public PayloadDto getCardDetails(String card_number) {
		boolean isValid = validateCardNumber(card_number);
		PayloadDto payloadDto = null;
		if(isValid)
		{
			Card card = cardDao.getCardDetails(Long.valueOf(card_number));
			payloadDto = new PayloadDto(card.getScheme(),card.getType(),card.getBank());
		}
		 
		return payloadDto;
		
	}
	
	private boolean validateCardNumber(String card_number)
	{
		if (card_number.length() < 12 || Long.valueOf(card_number) == 0)
		{
			return false;
		}
		return true;
	}
}
