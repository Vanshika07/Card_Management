package com.management.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.management.dto.PayloadDto;
import com.management.service.CardService;

@RestController
@CrossOrigin
public class CardSchemeController {
	
	@Autowired
	private CardService cardService;
	
	@RequestMapping(value="/card-scheme/verify/{card_no}",method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
    public Response getCardDetails(@PathVariable("card_no") Long cardNumber) {
        System.out.println("chla chla");
        PayloadDto payloadDto = cardService.getCardDetails(cardNumber);
        Response response = Response.ok().entity(payloadDto).build();
        return response;
        
    }
	
	
	@GetMapping(value = "/")
    public ModelAndView homesPage(Model model) {
        System.out.println("chla chla");
        return new ModelAndView("index");
    }
	
	@GetMapping(value = "/lala/{ab}")
    public String homePage(@PathVariable("ab") String ab) {
        System.out.println("chla chla");
        return ab;
    }

}
