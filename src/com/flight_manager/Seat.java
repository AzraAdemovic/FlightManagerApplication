package com.flight_manager;
/**
 * 
 * @author Azra Ademoviæ
 *class for creating seats
 */

public class Seat {
	/** row ("A", "B", "C", "D", "E", "F")*/
	private String row = "A B C D E F ";

	/** seat number ex. 1,5,16*/
	private Integer seatNumber;
	
	/**is it booked, or it is available*/
	private boolean available;
	/**
	 * 
	 * @param string label of row
	 * @param passangerSeat number of seat
	 */
	public Seat(String string, Integer passangerSeat) {
		
	}
	
	
	public Seat(String row, Integer seatNumber, boolean available) {
		super();
		this.row = row;
		this.seatNumber = seatNumber;
		this.available = true;
	}
	/**
	 * 
	 * @return seat
	 */


	public String getRow() {
		return row;
	}
	/**
	 * 
	 * @param row row of seats in airplane
	 */
	public void setRow(String row) {
		this.row = row;
	}
	public Integer getSeatNumber() {
		return seatNumber;
	}
	/**
	 * 
	 * @param seatNumber number of seat in a row
	 */
	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	public boolean isAvailable() {
		return available;
	}
	/**
	 * 
	 * @param available value is seat avaliable or not
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Seat [row=" + row + ", seatNumber=" + seatNumber + ", available=" + available + "]";
	}
	
	
	

}
