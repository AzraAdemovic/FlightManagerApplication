package test;

import com.flight_manager.*;
import static org.junit.Assert.*;



import org.junit.Test;

public class SystemManagerTest {
	SystemManager manager = new SystemManager();

	String name = "YES";
	String name0 = "WHY";
	String name1 = "NO";
	String name2 = ".3S.";
	String name3 = "line";
	String name4 = "Airline";
	String name5 = "A";
	Integer broj = 12;
	Integer ID = 80;
	String city= "Sarajevo";
	//String location1 = "Frankfurt";
	Airline airline = new Airline(name3);
	Airport airport = new Airport(name);
	Integer broj1 = 11;
	String origin= "Mostar";
	String destination = "Bangladeš";
	Airline airline1 = new Airline("nesto");
	Airport airport1 = new Airport("ABC");

	@Test
	public void shouldReturnTrueWhenLenghtIs3letters() {
		manager.nameLengthAirport(name);
		assertTrue(manager.nameLengthAirport(name));

	}

	@Test
	public void shouldReturnFalseWhenLenghtIsNot3letters() {
		manager.nameLengthAirport(name1);
		assertFalse(manager.nameLengthAirport(name1));

	}

	@Test
	public void shouldReturnTrueOnlyWhenAllCharactersAreLetters() {
		manager.nameCheck(name);
		assertTrue(manager.nameCheck(name));

	}

	@Test
	public void shouldReturnFalseWhenAnyCharacterIsNotLetter() {
		manager.nameCheck(name2);
		assertFalse(manager.nameCheck(name2));

	}

	@Test
	public void shouldReturnFalseWhenNameofAirportdoesExist() {
		Airport airport = new Airport(name);
		manager.getListOfAirports().add(airport);
		assertFalse(manager.doesExistAirport(name));
	}

	@Test
	public void shouldReturnTrueWhenNamedoesNotExist() {
		@SuppressWarnings("unused")
		Airport airport = new Airport(name1);
		assertTrue(manager.doesExistAirport(name1));
	}

	@Test
	public void shouldReturnTrueWhenLenghtIs5orLessletters() {
		manager.nameLengthAirline(name3);
		assertTrue(manager.nameLengthAirline(name3));
	}

	@Test
	public void shouldReturnFalseWhenLenghtIsMoreThan5letters() {
		manager.nameLengthAirline(name4);
		assertFalse(manager.nameLengthAirline(name4));
		
	}

	@Test
	public void shouldReturnFalseWhenLenghtIslessThan2letters() {
		manager.nameLengthAirport(name5);
		assertFalse(manager.nameLengthAirport(name5));
	}

	@Test
	public void shouldReturnTrueWhenLenghtIs2letters() {
		manager.nameLengthAirport(name1);
		assertFalse(manager.nameLengthAirport(name1));
	}

	@Test
	public void shouldReturnFalseWhenNameofAirlinedoesExist() {
		Airline airline = new Airline(name);
		manager.getListOfAirlines().add(airline);
		assertFalse(manager.doesExistAirline(name));
	}
	@Test
	public void shouldReturnTrueWhenNameofAirlinedoesNotExist() {
		Airline airline = new Airline(name);
		manager.getListOfAirlines().add(airline);
		assertTrue(manager.doesExistAirline(name0));
	}


	@Test
	public void shouldReturnTrueWhenFlightisCorrect() {
		Airport airport = new Airport(name);
		manager.getListOfAirports().add(airport);
		manager.flightIsCorrect(city);
		assertTrue(manager.flightIsCorrect(city));
	}

	@Test
	public void shouldReturnFAlseWhenFlightisNotCorrect() {
		Airport airport = new Airport(name);
		manager.getListOfAirports().add(airport);
		manager.flightIsCorrect(name1);
		assertFalse(manager.flightIsCorrect(name1));
	}

	@Test
	public void shouldReturnFAlseWhenIDisnotAvaliable() {
		Flight flight = new Flight(broj, airline, airport, "Sarajevo", "Frankfurt");
		manager.getListOfFlights().add(flight);
		assertFalse(manager.idAvaliable(broj));

	}

	@Test
	public void shouldReturnTrueWhenIDisAvaliable() {
		Flight flight = new Flight(broj, airline, airport, "Sarajevo", "Frankfurt");
		manager.getListOfFlights().add(flight);
		assertTrue(manager.idAvaliable(broj1));

	}
	@Test 
	public void shouldReturnNullWhenAirportIsNotCreated() {
		Airport airport = new Airport(name);
		manager.getListOfAirports().add(airport);
		assertNull(manager.createAirport(name));
	}
	@Test
	public void shouldReturnValueWhenAirportIsCreated() {
	assertNotNull(manager.createAirport(name));
	
	}
	@Test
	public void shouldReturnValueWhenAirlineIsCreated() {	
	assertNotNull(manager.createAirline(name3));
	
	}
	@Test
	public void shouldReturnNullWhenAirlineIsNotCreated() {	
	assertNull(manager.createAirline(name4));
	
	}
  /* @Test
	public void shouldReturnValueWhenFlightIsCreated() {
	   Airline aa = new Airline("WAA");
		Airport ar = new Airport("AGP", "Tuzla");
		Airport ar1 = new Airport("ASD", "Istanbul");
		manager.getListOfAirports().add(ar1);
		manager.getListOfAirports().add(ar);
		manager.getListOfAirlines().add(aa);
	assertNotNull(manager.createFlight(9, aa, ar, "Istanbul", "Ljubljana", 24));
		
}*/
	
	@Test
	public void shouldReturnNullWhenFlightIsNotCreated() {
		
		
		assertNull(manager.createFlight(13, airline, airport, "Sarajevo", "Basel", broj1));
		
		
	}

	
	@Test
	public void shouldReturnNullWhenFlightsisNotAvaliable() {
		
		assertNull(manager.findAvailableFlights("Tuzla", "Istan"));
	}
	@Test
    public void shouldReturnAvailableFlights() {
	Flight flight1 = new Flight(broj, airline, airport, "Sarajevo", "Frankfurt");
	Flight flight2 = new Flight(broj1, airline1, airport1, "Sarajevo", "Frankfurt");
	manager.getListOfFlights().add(flight1);
	manager.getListOfFlights().add(flight2);
	assertNotNull(manager.findAvailableFlights("Sarajevo", "Frankfurt"));
}
	 @Test
	    public void shouldReturnSeatsArrayListWhenisCorrect() {
			Flight flight1 = new Flight(broj, airline, airport, "Sarajevo", "Frankfurt");
		manager.getListOfFlights().add(flight1);
		assertNotNull(manager.createSeats("Trip", broj , 4));
	}
	
	
}
