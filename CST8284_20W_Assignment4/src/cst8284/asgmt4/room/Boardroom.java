
/*File name:[Boardroom.java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[information about board room ] 
*/ 
package cst8284.asgmt4.room;
/**
 * @author:Ziyue Wang
 * @version 1.0
*/ 
public final class Boardroom extends Room {
	
	/** The seats. */
	private int seats;
	
	/**
	 * Instantiates a new boardroom.
	 */
	public Boardroom() {
		
	}
	
	/**
	 * Gets the room type.
	 * the roomType can be accessed by this methods
	 * the default value is "board room"
	 * @return the room type
	 */
	@Override
	protected String getRoomType() {
		return "board room";
	}

	/**
	 * Gets the seats.
	 * field seats can be accessed by this method
	 * the default value of seats is 16 
	 * @return the  number of seats
	 */
	@Override
	protected int getSeats() {
		return 16;
	}

	/**
	 * Gets the details of the boardRoom.
	 *
	 * @return a string with the details of boardRoom
	 */
	@Override
	protected String getDetails() {
		return "conference call enabled";
	}

}
