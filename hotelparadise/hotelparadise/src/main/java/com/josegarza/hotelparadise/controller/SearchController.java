package com.josegarza.hotelparadise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josegarza.hotelparadise.models.Huesped;
import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.services.HuespedService;
import com.josegarza.hotelparadise.services.ReservaService;

@Controller
public class SearchController {
	
	@Autowired
	private ReservaService reservaService;

	@Autowired
	private HuespedService huespedService;
	

	@GetMapping("/search/reservas")
	public String goBusquedasReservas(Model model) {
		
		List<Reserva> reservaList = reservaService.getReservas();
				
		model.addAttribute("reservas",reservaList);
		
		return "menu-busqueda-reservas";
	}
	
	@GetMapping("/search/huespedes")
	public String goBusquedasHuespedes(Model model) {
		
		List<Huesped> huespedList = huespedService.getHuespedes();
		
		model.addAttribute("huespedes", huespedList);
		
		
		return "menu-busqueda-huespedes";
	}
	
	
	
}
