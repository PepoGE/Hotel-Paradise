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
	
	@RequestMapping(value = "/search/deleteReservaById/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteReservaById(@PathVariable Long id){
		reservaService.deleteReservaById(id);
		return "redirect:/search";
	}
	
	
	
	
}
