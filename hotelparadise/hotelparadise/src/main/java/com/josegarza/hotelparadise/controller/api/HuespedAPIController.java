package com.josegarza.hotelparadise.controller.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.josegarza.hotelparadise.models.Huesped;
import com.josegarza.hotelparadise.repositories.HuespedRepository;

@RestController
public class HuespedAPIController {

	@Autowired
    private HuespedRepository huespedRepository;

    @GetMapping("/api/huespedes/{id}")
    public Optional<Huesped> getHuesped(@PathVariable Long id) {
    	
            try {
                return huespedRepository.findById(id);
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Huésped no encontrado");
            }
        }
}


	
	

