package com.josegarza.hotelparadise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.repositories.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	
	public List<Reserva> getReservas(){
		return reservaRepository.findAll();
	}
	
	public void saveReserva(Reserva reserva) {
		reservaRepository.save(reserva);
	}
	
	public void updateReserva(Reserva reserva) {
		reservaRepository.save(reserva);
	}
	
}
