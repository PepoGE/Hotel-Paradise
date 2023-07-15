package com.josegarza.hotelparadise.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="reservas")
@Entity(name = "Reserva")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Reserva {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaEntrada;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaSalida;
	
	private float valor;
	
	@Enumerated(EnumType.STRING)
	private FormaDePago formaDePago;
	
	
	
	
	
	
}
