package com.flight_manager;

import java.util.ArrayList;

/**
 * 
 * @author Azra Ademoviæ
 *class with all methods 
 */
public class SystemManager {
	Airport airport = new Airport();
	Seat seat = new Seat("A", 1);

	private ArrayList<Airport> listOfAirports = new ArrayList<Airport>();
	private ArrayList<Flight> listOfFlights = new ArrayList<Flight>();
	private ArrayList<Airline> listOfAirlines = new ArrayList<Airline>();
	/**
	 * 
	 * @return listOfAirports
	 */

	public ArrayList<Airport> getListOfAirports() {
		return listOfAirports;
	}
	/**
	 * 
	 * @return listOfFlights
	 */

	public ArrayList<Flight> getListOfFlights() {
		return listOfFlights;
	}
	/**
	 * 
	 * @return listOfAirlines
	 */

	public ArrayList<Airline> getListOfAirlines() {
		return listOfAirlines;
	}
/***
 * 
 * @param name name of airport
 * @return airport
 */
	public Airport createAirport(String name) {
		Airport air = new Airport(name);
		if (nameCheck(name) && nameLengthAirport(name) && doesExistAirport(name)) {
			listOfAirports.add(air);

		} else {

			System.out.println("An airport can not be created.");
			return null;

		}
		return air;
	}
	/**
	 * 
	 * @param name name of airline
	 * @return airline
	 */

	public Airline createAirline(String name) {
		Airline line = new Airline(name);

		if (nameLengthAirline(name) && nameCheck(name) && doesExistAirline(name)) {
			listOfAirlines.add(line);
		} else {

			System.out.println("An airline can not be created.");
			return null;

		}
		return line;
	}
	/**
	 * 
	 * @param id id of flight
	 * @param airline name of airline
	 * @param airport name of airport
	 * @param origin place where taking off
	 * @param destination place where flight is going
	 * @param numberOfSeats number of seat
	 * @return flight
	 */

	public Flight createFlight(Integer id, Airline airline, Airport airport, String origin, String destination,
			Integer numberOfSeats) {
		Flight flight = new Flight();
		if (flightIsCorrect(origin) && flightIsCorrect(destination) && idAvaliable(id)) {
			listOfFlights.add(flight);
			createSeats(airline.getName(), id, numberOfSeats);
			System.out.println(" You successufully created a flight. ");
			return flight;
		}

		System.out.println(" Sorry, something went wrong. ");

		return null;

	}
	/**
	 * 
	 * @param airline name of airline
	 * @param flightID id of flight
	 * @param numberOfSeats number of seats
	 * @return seats
	 */

	public ArrayList<Seat> createSeats(String airline, Integer flightID, Integer numberOfSeats) {
		String rows = "ABCDEF";
		for (int i = 0; i < listOfFlights.size(); i++) {
			if (flightID == listOfFlights.get(i).getId()) {
				ArrayList<Seat> seats = new ArrayList<Seat>();
				for (i = 1; i <= numberOfSeats; i++) {
					for (int j = 0; j < seat.getRow().length(); j++) {
						seats.add(new Seat(Character.toString(rows.charAt(0)), i));
					}
				}
				return seats;

			}

		}
		return null;

	}
	/**
	 * 
	 * 
	 * @param origin city where flight taking off
	 * @param destination city where flight is going
	 * @return flights
	 */

	public ArrayList<Flight> findAvailableFlights(String origin, String destination) {
		ArrayList<Flight> flights = new ArrayList<Flight>();

		for (int i = 0; i < listOfFlights.size(); i++) {
		    if (listOfFlights.get(i).getOrigin().equals(origin)
			    && listOfFlights.get(i).getDestination().equals(destination)) {
			flights.add(listOfFlights.get(i));
		    }

		}
		if (flights.isEmpty()) {
		    System.out.println("That flight does not exist.");
		    return null;
		} else {
		    return flights;
		}
	}
	/**
	 * 
	 * @param flightID id of flight
	 * @param seatNumber number of seat
	 * @param row row of seats in airplane
	 * @return boolean
	 */
	

	 public boolean bookSeat(Integer flightID, int seatNumber, String row) {
			for (int i = 0; i < listOfFlights.size(); i++) {
			    if (flightID == listOfFlights.get(i).getId().intValue()) {
				for (int j = 0; j <listOfFlights.get(i).getSeats().size(); j++) {
				    if (seatNumber == listOfFlights.get(i).getSeats().get(j).getSeatNumber().intValue()
					    && row.equals(listOfFlights.get(i).getSeats().get(j).getRow())) {
					if (listOfFlights.get(i).getSeats().get(j).isAvailable()) {
					    listOfFlights.get(i).getSeats().get(j).setAvailable(false);
					    return true;
					} else {
					    System.out.println("Seat is not avaliable.");
					}
				    }
				}
			    }
			}
			return false;
		}
	 /**
	  * 
	  * @param name name of airport
	  * @return boolean
	  */

	public boolean nameLengthAirport(String name) {

		for (int i = 0; i < name.length(); i++) {
			if (name.length() == 3)
				return true;
		}
		System.out.println("Name should contain exactly three letters.");
		return false;
	}
	/**
	 * 
	 * @param name name of airplane/ airport
	 * @return boolean
	 */

	public boolean nameCheck(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (!(Character.isLetter(name.charAt(i)))) {
				System.out.println("Name should contain only letters.");

				return false;
			}

		}
		return true;

	}
	/**
	 * 
	 * @param name name of city where fligt is taking off or going to
	 * @return boolean
	 */

	public boolean doesExistAirport(String name) {
		for (int i = 0; i < getListOfAirports().size(); i++) {
			if (name.equals(getListOfAirports().get(i).getName())) {
				System.out.println("Name allready exist");

				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @param name name of airline
	 * @return boolean
	 */

	public boolean nameLengthAirline(String name) {

		for (int i = 0; i < name.length(); i++) {
			if (name.length() < 6 && name.length() >= 2)
				return true;
		}
		System.out.println("Name is not correct lenght. Please enter at least two letters but max 5 letters.");
		return false;
	}
	/**
	 * 
	 * @param name name of airline
	 * @return boolean
	 */

	public boolean doesExistAirline(String name) {
		for (int i = 0; i < getListOfAirlines().size(); i++) {
			if (name.equals(getListOfAirlines().get(i).getName())) {
				System.out.println("Name allready exist");

				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @param city name of city 
	 * @return boolean
	 */

	public boolean flightIsCorrect(String city) {
		for (int i = 0; i < listOfAirports.size(); i++) {
			if (city.equals(listOfAirports.get(i).getName())) {
				return true;
			}
		}
		System.out.println("We can not offer you a flight from origin to that destination. ");
		return false;
	}
	/**
	 * 
	 * @param ID id of flight
	 * @return boolean
	 */

	public boolean idAvaliable(int ID) {
		for (int i = 0; i < listOfFlights.size(); i++) {
			if (listOfFlights.get(i).getId() == ID) {
				System.out.println("Flight ID already taken , please choose anotherone.");
				return false;
			}
		}
		return true;
	}
	}
