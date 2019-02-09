package com.flight_manager;
/**
 * 
 * @author Azra Ademoviæ
 * 
 *
 */

public class Airline {
	
	private String name;
	public Airline (String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return name of airline
	 */

	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name name of airline
	 */

	public void setName(String name) {
		this.name = name;
	}	
	

	@Override
	public String toString() {
		return "Airline [name=" + name + "]";
	}
	
	
	

}
