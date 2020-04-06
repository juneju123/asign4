package cst8284.asgmt4.room;
/**
 * @author:Ziyue Wang
 * @version 1.0
*/ 
public final class ComputerLab extends Room {
	
	/** The number default seats is 30. */
	private static int DEFAULT_SEATS = 30;
	
	/** The seats. */
	private int seats;
	
	/**
	 * Instantiates a new computer lab.
	 */
	public ComputerLab() {
		
	}

	/**
	 * Gets the room type.
	 * the roomType can be accessed by this methods
	 * the default value is "computer lab"
	 * @return the room type
	 */
	@Override
	protected String getRoomType() {
		return "computer lab";
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
	 * Gets the details of the ComputerLab.
	 *
	 * @return the details
	 */
	@Override
	protected String getDetails() {
		return "contains outlets for 30 laptops";
	}

}
