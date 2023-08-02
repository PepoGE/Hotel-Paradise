package com.josegarza.hotelparadise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josegarza.hotelparadise.models.Reserva;
import com.josegarza.hotelparadise.services.ReservaService;

@RestController
public class TestController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/test")
    public ResponseEntity<String> testConnection() {
        try {
            List<Reserva> reservas = reservaService.getReservas();
            if (reservas != null && !reservas.isEmpty()) {
                return ResponseEntity.ok("Conexión a la base de datos exitosa.");
            } else {
                return ResponseEntity.ok("No se encontraron reservas en la base de datos.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
