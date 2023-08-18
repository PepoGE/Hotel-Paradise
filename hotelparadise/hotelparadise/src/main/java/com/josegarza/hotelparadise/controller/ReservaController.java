package com.josegarza.hotelparadise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		return "redirect:/huespedes";
	}
	
	@PostMapping("/search/reservas/updateReserva")
	public String updateReserva(Reserva reserva) {
		reservaService.updateReserva(reserva);
		return "redirect:/search/reservas";
	}
	
	@RequestMapping(value = "/reservas/deleteReservaById/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteReservaById(@PathVariable Long id){
		reservaService.deleteReservaById(id);
		return "redirect:/search/reservas";
	}
	
	
	
}
