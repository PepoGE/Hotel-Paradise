package com.josegarza.hotelparadise.models;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="paises")
@Entity(name = "Pais")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of ="id")
public class Pais {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pais")
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "prefijo_telefono", nullable = false)
    private String prefijoTelefono;

    @Column(name = "nacionalidad", nullable = false)
    private String nacionalidad;

    @JsonManagedReference
    @OneToMany(mappedBy = "pais")
    private Set<Huesped> huespedes;

    // Getters, setters y constructores
	
	
	
	
	
}
