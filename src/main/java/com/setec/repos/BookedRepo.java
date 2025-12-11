package com.setec.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setec.entites.Booked;

public interface BookedRepo extends JpaRepository<Booked, Integer> {
	
}
