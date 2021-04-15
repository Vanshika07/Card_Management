package com.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.management.dto.PayloadDto;
import com.management.service.CardService;

@Controller
public class CardSchemeController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("/card-scheme/verify/{card_no}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response getCardDetails(@PathParam("card_no") Long cardNumber) {
        System.out.println("chla chla");
        PayloadDto payloadDto = cardService.getCardDetails(cardNumber);
        Response response = Response.ok().entity(payloadDto).build();
        return response;
        
    }
	
	
	@GetMapping("/card-scheme")
    public ModelAndView homesPage(Model model) {
        System.out.println("chla chla");
        return new ModelAndView("index");
    }

}
