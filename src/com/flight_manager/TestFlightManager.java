package com.flight_manager;

import java.util.Scanner;
/**
 * 
 * @author Azra Ademoviæ
 * first page for flight manager application
 *
 */
public class TestFlightManager {
	Airport airport = new Airport();
	Seat seat = new Seat("A", 1);

	static boolean running = true;

	public static void main(String[] args) {
		SystemManager manager = new SystemManager();
		

		Integer numberOfSeats = 30;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to flight manager :) ");

		while (running) {
			
			System.out.print("please choose an option :)"
		            + "\n" 
					+ "\n 0. => Create airport.\n"
					+ "\n 1. => Create airline.\n"
					+ "\n 2. => Create flight. \n" 
					+ "\n 3. =>Book a seat on a flight.\n"
					+ "\n 4. => exit. \n" );
			
			 
			/**
			 * creating an airplane
			 */

			int choice = input.nextInt();
			switch (choice) {
			case 0:
				System.out.println("Please insert name of airport:");
				String name = input.next();
				System.out.println("Insert city where airport is :");
				
				//String location = input.nextLine();
				manager.createAirport(name);
				System.out.println("Airport is created.");
				break;
                  /**
                  * creating an airline
                  */

			case 1:
				System.out.println("Please insert name of airline :");
				String name1 = input.next();
				manager.createAirline(name1);
				System.out.println("Airline is created.");
				break;
				/** 
				 * creating a flight
				 */


			case 2:

				System.out.println("If you want create a flight please insert Flight ID:");
				Integer id = input.nextInt();
				System.out.println("Insert name of airline :");
				name1 = input.next();
				Airline airline1 = new Airline(name1);
				System.out.println("Insert name of airport: ");
				name = input.next();
				//System.out.println("Location :");
				//location = input.nextLine();
				Airport airport1 = new Airport(name);
				System.out.println("Insert origin :");
				String origin = input.nextLine();
				String destination = input.nextLine();			
				System.out.println("Insert destination :");
				manager.createFlight(id, airline1, airport1, origin, destination, numberOfSeats);
				System.out.println("Your flight is created.");
				break;

			case 3:
				/**
				 * booking a seat
				 */
				System.out.println("For option book a seat follow the steps :");
				System.out.println("Please insert flight ID :");
				id = input.nextInt();
				System.out.println("Insert seat number :");
				int seatNumber = input.nextInt();
				System.out.println("Insert row:");
				String row = input.next();
				manager.bookSeat(id, seatNumber,row);
				System.out.println("Your seat is booked.");
				break;
			case 4:
				/**
				 * exit
				 */
				running = false;
				break;
				default : 
					System.out.println("Wrong input.");

			}

		}
		input.close();
	}
}
