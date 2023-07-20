package com.josegarza.hotelparadise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.josegarza.hotelparadise.models.Huesped;


@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Long> {

}
