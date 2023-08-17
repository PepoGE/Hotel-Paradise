package com.josegarza.hotelparadise.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josegarza.hotelparadise.models.Pais;
import com.josegarza.hotelparadise.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	
	public List<Pais> getPaises(){
		return paisRepository.findAll();
	}
	
	public void savePais(Pais pais) {
		paisRepository.save(pais);
	}
	
	public void updatePais(Pais pais) {
		paisRepository.save(pais);
	}
	
	public void deletePaisById(Long id) {
		paisRepository.deleteById(id);
	}
	
	
}
