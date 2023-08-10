package com.josegarza.hotelparadise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.services.ReservaService;

@Controller
public class SearchController {
	
	@Autowired
	private ReservaService reservaService;

	@GetMapping("/search")
	public String goBusquedas(Model model) {
		
		List<Reserva> reservaList = reservaService.getReservas();
		
		model.addAttribute("reservas",reservaList);
		
		return "menu-busqueda";
	}
	
	@PostMapping("/search/updateReserva")
	public String updateReserva(Reserva reserva) {
		reservaService.updateReserva(reserva);
		return "redirect:/search";
	}
	
	
	
}
