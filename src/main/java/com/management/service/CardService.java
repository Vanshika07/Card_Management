package com.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.CardDao;
import com.management.dto.PayloadDto;
import com.management.entity.Card;

@Service
public class CardService {

	@Autowired
	private CardDao cardDao;

	public PayloadDto getCardDetails(Long card_number) {
		boolean isValid = validateCardNumber(String.valueOf(card_number));
		PayloadDto payloadDto = null;
		if (isValid) {
			Optional<Card> card = cardDao.findById(card_number);

			if (card.isPresent())
				payloadDto = new PayloadDto(card.get().getScheme(), card.get().getType(), card.get().getBank());
		}

		return payloadDto;

	}

	private boolean validateCardNumber(String card_number) {
		if (card_number.length() < 3 || Long.valueOf(card_number) == 0) {
			return false;
		}
		return true;
	}
}
