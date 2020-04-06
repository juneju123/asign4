/*File name:[Classroom.java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[information about class room ] 
*/ 
package cst8284.asgmt4.room;
/**
 * @author:Ziyue Wang
 * @version 1.0
*/ 
public final class Classroom extends Room {
	
	/** The number of default seats is 120. */
	private static int DEFAULT_SEATS = 120;
	
	/** The seats. */
	private int seats;
	
	/**
	 * Instantiates a new classroom.
	 */
	public Classroom() {
		
	}
	
	/**
	 * Gets the room type.
	 * the roomType can be accessed by this methods
	 * the default value is "class room"
	 * @return the room type
	 */
	@Override
	protected String getRoomType() {
		return "class room";
	}

	/**
	 * Gets the seats.
	 * field seats can be accessed by this method
	 * the default value of seats is DEFAULT_SEATS;
	 * @return the seats
	 */
	@Override
	protected int getSeats() {
		return seats;
	}

	/**
	 * Gets the details of classroom.
	 *
	 * @return the details
	 */
	@Override
	protected String getDetails() {
		// TODO Auto-generated method stub
		return "contains overhead projector";
	}

}
