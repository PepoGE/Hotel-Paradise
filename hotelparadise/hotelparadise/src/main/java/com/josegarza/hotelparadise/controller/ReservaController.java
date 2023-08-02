package com.josegarza.hotelparadise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.services.ReservaService;

@Controller
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/reservas")
	public String goReservas() {
		return "menu-reservas";
	}
	
	@PostMapping("/reservas/addNew")
	public String addNewReserva(Reserva reserva) {
		reservaService.saveReserva(reserva);
		return "redirect:/search";
	}
	
}