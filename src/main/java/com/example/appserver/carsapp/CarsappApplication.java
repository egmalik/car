package com.example.appserver.carsapp;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.appserver.carsapp.da.CarRepository;
import com.example.appserver.carsapp.da.DriverRepository;
import com.example.appserver.carsapp.da.OwnerRepository;
import com.example.appserver.carsapp.da.TripRepository;
import com.example.appserver.carsapp.domain.Car;
import com.example.appserver.carsapp.domain.CarOfDriver;
import com.example.appserver.carsapp.domain.Driver;
import com.example.appserver.carsapp.domain.Owner;
import com.example.appserver.carsapp.domain.Trip;

@SpringBootApplication
public class CarsappApplication {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CarsappApplication.class);

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private OwnerRepository ownerRepo;
	
	@Autowired
	private TripRepository tripRepo;
	
	@Autowired
	private DriverRepository driverRepo;

	public static void main(String[] args) {
		
		SpringApplication.run(CarsappApplication.class, args);
		
	     logger.info("Hello from carsapp server app");
		
	}
	
	 @Bean
     CommandLineRunner runner(){
       return args -> {
         // Place your code here
    	   
    	   
    	   Owner o2=new Owner("Pini", "Cohen");
    	   Owner o1=new Owner("Sergey", "Aleynov");
    	   o2.setFirstname("Abdalla");
    	   
    	   //need to persist owners state
    	   ownerRepo.save(o1);
    	   ownerRepo.save(o2);
    	   
    	   Trip t1=new Trip("tsafona");
     	  Trip t2=new Trip("daroma");
     	  
     	  tripRepo.save(t1);
     	  tripRepo.save(t2);
     	  
     	  
     	  
     	 Set<Trip> set_trip_1= new HashSet<Trip>();
   	  set_trip_1.add(t1);
   	  set_trip_1.add(t2);
   	  
   	Set<Trip> set_trip_2= new HashSet<Trip>();
 	  set_trip_2.add(t1);
 	  set_trip_2.add(t2);
     	  
  Car c1=new Car("Ford", "Mustang", "Red","ADF-1121", 2017, 59000,o1, set_trip_1);
  Car c2=new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000,o1, set_trip_1);
  Car c3=new Car("Toyota", "Prius", "Silver","KKO-0212", 2018, 39000,o1, set_trip_2);
    	   
          carRepository.save(c1 );
    	  carRepository.save(c2);    
    	  carRepository.save( c3  );
    	  
    	  Set<CarOfDriver> set_cars_driver= new HashSet<CarOfDriver>();
    	  set_cars_driver.add(new CarOfDriver(c1, true));
    	  set_cars_driver.add(new CarOfDriver(c2, true));

    	  driverRepo.save(
        		  new Driver("Sara", set_cars_driver)
        		  );	  
    	  
    	 
    	  
    	  
    	  
    	  
    	  

    	   
    	   
       };
     } 


}
