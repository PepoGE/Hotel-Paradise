package com.josegarza.hotelparadise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josegarza.hotelparadise.models.Huesped;
import com.josegarza.hotelparadise.models.Pais;
import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.repositories.ReservaRepository;
import com.josegarza.hotelparadise.services.HuespedService;
import com.josegarza.hotelparadise.services.PaisService;
import com.josegarza.hotelparadise.services.ReservaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HuespedController {

	@Autowired
	private HuespedService huespedService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private ReservaService reservaService;
	
	    
	
	@GetMapping("/huespedes")
	public String goHuespedes(Model model) {
		List<Pais> paises = paisService.getPaises();
		int reservaid = reservaService.getLastIdReserva() + 1;
		
		model.addAttribute("idReserva", reservaid);
        model.addAttribute("paises", paises);
        
        
		return "menu-huespedes";
	}
	

	
	@PostMapping("/huespedes/addNew")
	public String addNewHuesped(Huesped huesped, HttpSession session) {
	    Reserva reservaTemp = (Reserva) session.getAttribute("tempReserva"); // Recupera la reserva de la sesión
	    
	    if (reservaTemp != null) {
			reservaService.saveReserva(reservaTemp);
			huesped.setReserva(reservaTemp);
			huespedService.saveHuesped(huesped);

	    }
	    
	    // Limpia los datos temporales de la sesión
	    session.removeAttribute("tempReserva");
	    
	    return "redirect:/search/reservas"; // Redirige a la página deseada QUEDA PENDIENTE HACER PAGINA DE SEARCH UNICA Y MANDAR A ESA 
	}

	
	
	@PostMapping("/search/huespedes/updateHuesped")
	public String updateHuesped(Huesped huesped) {
		huespedService.updateHuesped(huesped);
		return "redirect:/search/huespedes";
	}

	
	@RequestMapping(value = "/huespedes/deleteHuespedById/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteHuespedById(@PathVariable Long id){
		huespedService.deleteHuespedById(id);
		return "redirect:/search/huespedes";
	}
	
	
}
