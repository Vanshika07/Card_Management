package com.management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.dao.CardDao;
import com.management.dto.CardDto;
import com.management.dto.PayLoadDto;
import com.management.dto.StatDto;
import com.management.entity.Card;

@Service
public class CardService {

	@Autowired
	private CardDao cardDao;

	public PayLoadDto getCardDetails(Long card_number) {
		boolean isValid = validateCardNumber(String.valueOf(card_number));
		PayLoadDto payLoadDto = null;
		CardDto cardDto = null;
		if (isValid) {
			Card card = cardDao.findById(card_number);

			if (card!=null) {
				cardDto = new CardDto(card.getScheme(), card.getType(), card.getBank());
				payLoadDto = new PayLoadDto(true,cardDto);
			}
		}

		return payLoadDto;

	}
	
	
	public StatDto getstats(int st,int lt) {
		StatDto statDto = null;
		List<Object[]> card = cardDao.findAll(st,lt);
		if(card != null) {
		Map<Long,Integer> mp= new HashMap<Long,Integer> ();
		for(int i=st; i<=lt;i++) {
			mp.put(Long.valueOf((card.get(i)[0]).toString()),(int)card.get(i)[4]);
		}
		statDto = new StatDto();
		statDto.setPayload(mp);
		statDto.setLimit(lt);
		statDto.setStart(st);
		statDto.setSuccess(true);
		}
		
		return statDto;
		
	}

	public boolean validateCardNumber(String card_number) {
		if (card_number.length() < 3 || Long.valueOf(card_number) == 0) {
			return false;
		}
		return true;
	}
}
