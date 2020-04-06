package cst8284.asgmt4.room;
/**
 * @author:Ziyue Wang
 * @version 1.0
*/ 
public abstract class Room {
	
	/** The Constant DEFAULT_ROOM_NUMBER. */
	private static final String DEFAULT_ROOM_NUMBER = "unknown room number";
	
	/** The room number. */
	private String roomNumber;
	
	/**
	 * chaining to next constructor
	 */
	protected Room() {this(DEFAULT_ROOM_NUMBER);}
	
	/**
	 * Instantiates a new room with a roomNum as parameter.
	 * it calls setter to set the roomNumber
	 * 
	 * @param roomNum 	the room number used to set room number
	 */
	protected Room(String roomNum) { setRoomNumber(roomNum); }
	
	/**
	 * Sets the room number.
	 * The field roomNumber can be set and modified by this method
	 * 
	 * @param roomNum  sets the new room number
	 */
	public void setRoomNumber(String roomNum) {
		roomNumber = roomNum;
		}
	
	/**
	 * 
	 * Gets the room number.
	 * field roomNumber can be accessed by this methods
	 * @return the room number
	 */
	public String getRoomNumber() {
		return roomNumber;
		}
	
    /**
     * Abstract getter guarantees its concrete subclass to override it 
     * Gets the room type.
     * the roomType can be accessed by this methods
     * @return the room type
     */
    protected abstract String getRoomType() ;
	
	/**
	 * Abstract getter guarantees its concrete subclass to override it 
	 * Gets the seats.
	 * field seats can be accessed by this method
	 * @return the seats
	 */
	protected abstract int getSeats();
	
	/**
	 * Abstract getter guarantees its concrete subclass to override it 
	 * Gets the details.
	 *  Gets the details of the current room
	 * @return the details
	 */
	protected abstract String getDetails();
	
	/**
	 * it calls getters to get the information about the 
	 * room's type, seats and details.
	 * 
	 * @return the string with information  
	 */
	public String toString( ) { 
		return getRoomNumber() + " is a " +
		getRoomType() + " with " + getSeats() + " seats; " + getDetails() +"\n" ;}
}
