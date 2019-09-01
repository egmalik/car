package com.example.springsprint.carApp.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appserver.carsapp.da.TripRepository;
import com.example.appserver.carsapp.domain.OwnersInTrip;

@RestController
public class TripController {
	@Autowired
	private TripRepository repository;

	  @RequestMapping("/ownersintrip/{id}")
	  public ArrayList<OwnersInTrip> getOwnersInTrip(@PathVariable long id) {
	    return repository.getOwnersInTrip(id);
	  }
}
