package com.josegarza.hotelparadise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josegarza.hotelparadise.models.Pais;
import com.josegarza.hotelparadise.services.PaisService;

@Controller
public class PaisController {

	@Autowired
	private PaisService paisService;
		
	
}
