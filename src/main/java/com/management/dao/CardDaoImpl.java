package com.management.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.entity.Card;

@Repository
public class CardDaoImpl implements CardDao{
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public Card getCardDetails(Long card_number) {
		String q = "SELECT u from Card where u.cardNumber=:cardNUmber";
		EntityManager manager=emf.createEntityManager();
		Query query = manager.createNativeQuery(q);
		query.setParameter("cardNUmber",card_number);
		Card card = (Card) query.getSingleResult();
		return card;
	}

}
