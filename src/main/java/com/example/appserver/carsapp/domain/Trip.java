package com.example.appserver.carsapp.domain;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(
			name="ownersInTripMapping",
		    classes={
		        @ConstructorResult(
		        		targetClass=OwnersInTrip.class,
		            columns={
		                @ColumnResult(name="FIRSTNAME", type = String.class),
		                @ColumnResult(name="NAME", type = String.class),
		                @ColumnResult(name="TRIP_ID", type = BigInteger.class)
		            }
		        )
		    }
		)

	@NamedNativeQuery(name="Trip.getOwnersInTrip", query="SELECT OWNER.FIRSTNAME, TRIP.NAME, TRIP.TRIP_ID "
			+ "FROM TRIP INNER JOIN "
			+ "((OWNER INNER JOIN CAR ON OWNER.OWNERID = CAR.OWNER) "
			+ "INNER JOIN CAR_IN_TRIP ON CAR.ID = CAR_IN_TRIP.CAR_ID) "
			+ "ON TRIP.TRIP_ID = CAR_IN_TRIP.TRIP_ID "
			+ "WHERE (((TRIP.TRIP_ID)= :tripId))", resultSetMapping="ownersInTripMapping")

public class Trip {

	  
	  long trip_id;
String name;

 
private Set<Car> cars;

@ManyToMany(mappedBy = "trips")
public Set<Car> getCars() {
	return cars;
}
public void setCars(Set<Car> cars) {
	this.cars = cars;
}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public long getTrip_id() {
	return trip_id;
}
public void setTrip_id(long trip_id) {
	this.trip_id = trip_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Trip(String name, Set<Car> cars) {
	super();
	
	this.name = name;
	this.cars=cars;
}

public Trip(String name) {
	super();
	this.name = name;
	}
public Trip() {}


 

}
