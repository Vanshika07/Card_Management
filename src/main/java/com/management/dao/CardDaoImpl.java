package com.management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.management.entity.Card;

@Repository
@Transactional
public class CardDaoImpl implements CardDao{

	@Autowired
	EntityManagerFactory emf;
	
	@Override
	public Card findById(Long id) {
		Card ob= null;
		EntityManager manager=emf.createEntityManager();
		Query qry=manager.createNativeQuery("SELECT * FROM Card WHERE cardNumber=:a");
		Query q2 = manager.createNativeQuery("UPDATE Card SET noOfHits=noOfHits+1 WHERE cardNumber=:a");
		q2.setParameter("a", id);
		qry.setParameter("a", id);
		manager.getTransaction().begin();
		q2.executeUpdate();
		manager.getTransaction().commit();
		Object [] abc= (Object[]) qry.getSingleResult();
		if(abc != null)
		{
			ob = new Card();
			ob.setCardNumber(id);
			ob.setScheme((String)abc[1]);
			ob.setType((String)abc[2]);
			ob.setBank((String)abc[3]);
			ob.setNoOfHits((Integer) abc[4]);
		}
		
		return ob;
	}

	@Override
	public List<Object[]> findAll(int st,int lt) {
		EntityManager manager=emf.createEntityManager();
		Query qry=manager.createNativeQuery("SELECT * FROM Card");
		@SuppressWarnings("unchecked")
		List<Object []> abc= (List<Object[]>) qry.getResultList();
		
		return abc;
	}}
