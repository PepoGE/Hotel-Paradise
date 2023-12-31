package com.josegarza.hotelparadise.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josegarza.hotelparadise.models.Huesped;
import com.josegarza.hotelparadise.repositories.HuespedRepository;

@Service
public class HuespedService {

	@Autowired
	private HuespedRepository huespedRepository;
	
	
	public List<Huesped> getHuespedes(){
		return huespedRepository.findAll();
	}
	
	public Optional<Huesped> getHuespedById(Long id) {
        return huespedRepository.findById(id);
    }
	
	public void saveHuesped(Huesped huesped) {
		huespedRepository.save(huesped);
	}
	
	public void updateHuesped(Huesped huesped) {
		huespedRepository.save(huesped);
	}
	
	public void deleteHuespedById(Long id) {
		huespedRepository.deleteById(id);
	}
	
	
}
