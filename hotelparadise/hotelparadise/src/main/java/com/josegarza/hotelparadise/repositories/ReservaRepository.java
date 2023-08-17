package com.josegarza.hotelparadise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.josegarza.hotelparadise.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT MAX(r.id) FROM Reserva r")
    int findLastReservaId();
	
}
