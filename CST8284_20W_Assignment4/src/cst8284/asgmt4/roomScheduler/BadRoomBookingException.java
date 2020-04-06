/*File name:[BadRoomBookingException .java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[customize an exception for RoomBooking application] 
*/ 
package cst8284.asgmt4.roomScheduler;

/**
 * @author:Ziyue Wang
 * @version 1.0
 * 
*/ 
public class BadRoomBookingException extends RuntimeException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The header. */
	private String header;
	
	/**
	 * chaining to next constructor to initialize
	 * default header and message
	 */
	public BadRoomBookingException() {
		this("Bad room booking enterd","Please try again");
	}
	
	/**
	 * Instantiates a new bad room booking exception.
	 * it calls super(String s) constructor to pass message
	 * it uses header setter to pass string header 
	 * @param header the header
	 * @param message the message
	 */
	public BadRoomBookingException(String header,String message) {
		super(message);
		setHeader(header);
	}
	
	/**
	 * Sets the header.
	 * header can be set and modified by this method
	 * @param header the new header
	 */
	public void setHeader(String header) {
		this.header = header;	
	}
	
	/**
	 * Gets the header.
	 * head can be accessed by this method 
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}
}
