package com.josegarza.hotelparadise.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="huespedes")
@Entity(name = "Huesped")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Huesped {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String apellido;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaNacimiento;
	@Enumerated(EnumType.STRING)
	private Nacionalidades nacionalidades;
	private Long telefono;
	
	@ManyToOne
	@JoinColumn(name="reservaid", insertable = false, updatable = false)
	private Reserva reserva;
	private Long reservaid;
	
	
	
	
	
}
