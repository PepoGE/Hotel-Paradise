package com.josegarza.hotelparadise.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Reservas")
@Entity(name = "Reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_entrada")
	private Date fechaEntrada;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_salida")
	private Date fechaSalida;

	private float valor;

	@Column(name = "forma_pago")
	private String formaDePago;
	

}
