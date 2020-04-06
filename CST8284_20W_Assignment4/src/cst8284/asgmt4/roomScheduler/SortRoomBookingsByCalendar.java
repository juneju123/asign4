/*File name:[SortRoomBookingsByCalendar.java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[override compare() so that we can sort bookings ] 
*/ 
package cst8284.asgmt4.roomScheduler;
import java.util.Comparator;
import java.util.Calendar;
// TODO: Auto-generated Javadoc

/**
 *
 * @author:Ziyue Wang
 * @version 1.0
*/ 
 
public class SortRoomBookingsByCalendar implements Comparator<RoomBooking> {

	/**
	 * override compare() to compare tow bookings' startTime
	 *
	 * @param booking1 the booking 1
	 * @param booking2 the booking 2
	 * @return the int
	 */
	@Override
	public int compare(RoomBooking booking1, RoomBooking booking2) {
		//Comparator Interface in Java with Examples[web site]
		//retrieved from:https://www.geeksforgeeks.org/comparator-interface-java/
		
		return (booking1.getTimeBlock().getStartTime().compareTo(booking2.getTimeBlock().getStartTime()));
				
	}

}
