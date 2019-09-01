package com.example.appserver.carsapp.da;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.appserver.carsapp.domain.Car;


public interface CarRepository extends JpaRepository <Car, Long> {
	
	
	 @Query(value = "SELECT * FROM CAR WHERE Car.brand = ?1",nativeQuery = true)
	  List<Car> findByBrand3(String brand);
	
	
	// Fetch cars by brand using SQL
	@Query
	  ("select c from Car c where c.brand like ?1")
	// Fetch cars by brand using SQL
	
	
	  // Fetch cars by brand and model
	  List<Car> findByBrandAndModel(String brand, String model);

	  // Fetch cars by brand or color
	  List<Car> findByBrandOrColor(String brand, String color); 
	  
	// Fetch cars by brand or color
	  List<Car> findByBrandOrderByYearAsc(String brand);

	  
	 

	}
