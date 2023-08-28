package com.josegarza.hotelparadise.controller.html;

import java.util.List;
import java.util.Optional;

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
public class HuespedHTMLController {

	@Autowired
	private HuespedService huespedService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private ReservaService reservaService;
	
	    
	
	@GetMapping("/huespedes")
	public String goHuespedes(Model model) {
	    // Obtener la lista de países
	    List<Pais> paises = paisService.getPaises();
	    
	    // Obtener el último ID de reserva
	    Integer lastIdReserva = null;
	    try {
	        lastIdReserva = reservaService.getLastIdReserva();
	    } catch (Exception e) {
	        // Manejar la excepción, por ejemplo, imprimir un mensaje de error
	        System.err.println("Error al obtener el último ID de reserva: " + e.getMessage());
	    }
	    
	    // Si lastIdReserva no es nulo, incrementar en 1; si es nulo, asignar 1
	    int reservaid = (lastIdReserva != null) ? (lastIdReserva + 1) : 1;

	    // Agregar el ID de reserva y la lista de países al modelo
	    model.addAttribute("idReserva", reservaid);
	    model.addAttribute("paises", paises);

	    // Retornar la vista "menu-huespedes"
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
		
		if (huesped.getReserva() != null && huesped.getReserva().getId() == -1) {
	        huesped.setReserva(null);
	    }
		
		huespedService.updateHuesped(huesped);
		return "redirect:/search/huespedes";
	}

	
	@RequestMapping(value = "/huespedes/deleteHuespedById/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String deleteHuespedById(@PathVariable Long id) {
	    // Paso 1: Intenta obtener un Optional<Huesped> del servicio usando el ID
	    Optional<Huesped> optionalHuesped = huespedService.getHuespedById(id);

	    // Paso 2: Verifica si el Optional<Huesped> contiene un huésped
	    if (optionalHuesped.isPresent()) {
	        // Paso 3: Si el huésped está presente, obtén el objeto Huesped
	        Huesped huesped = optionalHuesped.get();
	        
	        // Paso 4: Verifica si el huésped tiene una reserva asociada
	        if (huesped.getReserva() != null) {
	            // Paso 5: Si hay una reserva asociada, elimínala utilizando el servicio de reservas
	        	reservaService.deleteReservaById((long) huesped.getReserva().getId());
	        }

	        // Paso 6: Elimina el huésped utilizando el servicio de huéspedes
	        huespedService.deleteHuespedById(id);
	    }

	    // Paso 7: Redirecciona a la página de búsqueda de huéspedes después de la operación
	    return "redirect:/search/huespedes";
	}

	
	
}


	
	

