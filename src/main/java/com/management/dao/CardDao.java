package com.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.entity.Card;

@Repository
public interface CardDao extends JpaRepository<Card, Long>{
	

}
