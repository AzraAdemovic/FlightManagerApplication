package com.flight_manager;
/**
 * 
 * @author Ademoviæ Azra
 *
 */

public class Airport {
	private String name;
	//private String location;

	public Airport() {

	}

	public Airport(String name) {
		this.name = name;
		//this.location = location;

	}
	/**
	 * 
	 * @return name of airport
	 */

	/*public String getLocation() {
	return location;}

	public void setLocation(String location) {
		this.location = location;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Airport [name=" + name + "]";
	}

}
