package com.josegarza.hotelparadise.controller.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josegarza.hotelparadise.models.Huesped;
import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.services.HuespedService;
import com.josegarza.hotelparadise.services.ReservaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReservaHTMLController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private HuespedService huespedService;
	
	@GetMapping("/reservas")
	public String goReservas() {
		return "menu-reservas";
	}
	
	@PostMapping("/reservas/addNew")
	public String addNewReserva(Reserva reserva, HttpSession session) {
	    session.setAttribute("tempReserva", reserva); // Almacena la reserva en la sesión
	    return "redirect:/huespedes"; // Redirige al formulario de huéspedes
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
