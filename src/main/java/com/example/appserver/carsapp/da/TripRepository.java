package com.example.appserver.carsapp.da;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.appserver.carsapp.domain.OwnersInTrip;
import com.example.appserver.carsapp.domain.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

	
	@Query(nativeQuery = true)
	ArrayList<OwnersInTrip> getOwnersInTrip(@Param("tripId") long tripId);

	
}
