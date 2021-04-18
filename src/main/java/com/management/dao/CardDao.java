package com.management.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.management.entity.Card;

@Repository
public interface CardDao {
	
	Card findById(Long id);
	
	List<Object[]> findAll(int st,int lt);
}
