package com.flight_manager;

import java.util.ArrayList;
/**
 * 
 * @author Azra Ademoviæ
 * class for creating a flight
 *
 */
public class Flight {
	/**unique ID*/
	private Integer id;
	
	/**which airline owns this flight*/
	private Airline airline;
	
	/**from which airport flight takes of*/
	private Airport airport;
	
	/**all seats in this flight*/
	private ArrayList<Seat> seats;
	
	/**city where it takes off from*/
	private String origin;
	
	/**city where the flight is going*/
	private String destination;
	
	
	public Flight() {
		
	}
	/***
	 * 
	 * @param id unique ID for each flight
	 * @param airline airline name
	 * @param airport airport name
	 * @param origin name of city where you taking off
	 * @param destination name of city where you want to go
	 */

	public Flight(Integer id, Airline airline, Airport airport, String origin, String destination) {
		
		this.id = id;
		this.airline = airline;
		this.airport = airport;
		this.origin = origin;
		this.destination = destination;
	}

/**
 * 
 * @return flight
 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 
	 * @return id of flight
	 */

	public Airline getAirline() {
		return airline;
	}
	/**
	 * 
	 * @param airline name of airline
	 */

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	/**
	 * 
	 * @return airline
	 */

	public ArrayList<Seat> getSeats() {
		return seats;
	}
	/**
	 * 
	 * @param seats seats in the airplain
	 */

	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	/**
	 * 
	 * @return ArrayList
	 */

	public String getOrigin() {
		return origin;
	}
	/**
	 * 
	 * @param origin  name of city where you taking off
	 */

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}
	/**
	 * 
	 * @param destination name of city where you want to go 
	 */

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public Airport getAirport() {
		return airport;
	}
	/**
	 * 
	 * @param airport name of airport
	 */

	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	

	@Override
	public String toString() {
		return "Flight [id=" + id + ", airline=" + airline + ", seats=" + seats + ", origin=" + origin
				+ ", destination=" + destination + "]";
	}
	
	

}
