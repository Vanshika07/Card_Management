package com.management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.dto.PayLoadDto;
import com.management.dto.StatDto;
import com.management.service.CardService;

@RestController
@CrossOrigin
public class CardSchemeController {
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping(value="/card-scheme/verify/{card_no}",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
    public String getCardDetails(@PathVariable("card_no") Long cardNumber) throws JsonProcessingException {
        System.out.println("chla chla");
        PayLoadDto payloadDto = cardService.getCardDetails(cardNumber);
        ObjectMapper objectMapper = new ObjectMapper();
        if(payloadDto == null)
        {
        	return "NO DATA FOUND";
        }
        else
        	return objectMapper.writeValueAsString(payloadDto);
        
    }
	
	
	@RequestMapping(value="/card-scheme/stats",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
    public String getNoOfHits(final HttpServletRequest request) throws JsonProcessingException {
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		ObjectMapper objectMapper = new ObjectMapper();
        StatDto payload = cardService.getstats(Integer.valueOf(start), Integer.valueOf(limit));
        if(payload == null)
        {
        	return "NO DATA FOUND";
        }
        else {
        	return objectMapper.writeValueAsString(payload);
        }
    
        
    }
	
	@RequestMapping(value = "/")
    public String homesPage(Model model) {
        return "index";
    }
	


}
