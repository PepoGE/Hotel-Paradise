package com.josegarza.hotelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HuespedController {

	@GetMapping("/huespedes")
	public String goReservas() {
		return "menu-huespedes";
	}
	
}
