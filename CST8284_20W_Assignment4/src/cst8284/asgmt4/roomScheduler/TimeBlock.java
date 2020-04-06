/*File name:[TimeBlock .java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[get time block of user's booking,check if overlaps,calculate the duration of the booking] 
*/
package cst8284.asgmt4.roomScheduler;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author:Ziyue Wang
 * @version 1.0
 */

public class TimeBlock implements Serializable {

	private static final long serialVersionUID = 1L;
	private Calendar startTime = Calendar.getInstance();
	private Calendar endTime = Calendar.getInstance();

	/**
	 * Instantiates a new time block from 8:00 to 23:00. chaining next constructor
	 */
	public TimeBlock() {
		// Class Calendar.Builder.[website]retrieved from
		// https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.Builder.html
		this(new Calendar.Builder().set(Calendar.HOUR_OF_DAY, 8).build(),
				new Calendar.Builder().set(Calendar.HOUR, 23).build());
	}

	/**
	 * If calendar value is good,set start time and end time.
	 *
	 * @param startTime the start time of the booking
	 * @param endTime   the end time of the booking
	 */
	public TimeBlock(Calendar startTime, Calendar endTime) {
		if (!isBadCalendarValue(startTime, endTime)) {
			setStartTime(startTime);
			setEndTime(endTime);
		}
	}

	/**
	 * Sets the start time. field startTime is set and modified by this method
	 *
	 * @param startTime sets the new start time of a booking
	 */
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the start time. field startTime is accessed by this method
	 *
	 * @return the start time of a booking
	 */
	public Calendar getStartTime() {
		return startTime;
	}

	/**
	 * Sets the end time. field endTime is set and modified by this method
	 * 
	 * @param endTime sets the new end time of a booking
	 */
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the end time. field endTime is accessed by this method
	 * 
	 * @return the end time of a booking
	 */
	public Calendar getEndTime() {
		return endTime;
	}

	/**
	 * Overlaps. It checks whether a new TimeBlock will conflict with this
	 * TimeBlock. If newBlock ends after an existing block starts and if newBlock
	 * starts before this timeBlock ends. Then a booking conflict would occur, and
	 * the method should return true.
	 * 
	 * @param newBlock the new block is used for check if there is overlap
	 * @return true, if overlap occurs.
	 */
	// Class Calendar.[web page]retrieved from:
	// https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
	public boolean overlaps(TimeBlock newBlock) {
		return newBlock.getEndTime().after(this.getStartTime()) && newBlock.getStartTime().before(this.getEndTime());
	}

	/**
	 * get(Calendar.HOUR_OF_DAY) covert calendar to integer it returns
	 * endTime-starTime as duration
	 *
	 * @return the difference between two calendar
	 */
	public int duration() {
		return getEndTime().get(Calendar.HOUR_OF_DAY) - getStartTime().get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * this.getStartTime().getTime().toString() convert date to String, returns day
	 * mon date 00:00:00 EDT year,then use subString get the time result
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getStartTime().getTime().toString().substring(11, 16) + " - "
				+ this.getEndTime().getTime().toString().substring(11, 16) + "\n";

	}

	/**
	 * Checks if is bad calendar value. It returns true when startTime input after
	 * endTime startTime equals endTime
	 *
	 * @param startCal the startTime of a booking
	 * @param endCal   the endTime of a booking
	 * @return true, if is bad calendar value
	 * @throws BadRoomBookingException if startTime input after endTime or startTime
	 *                                 equals endTime
	 */
	private boolean isBadCalendarValue(Calendar startCal, Calendar endCal) {
		String errMsgHeader1 = "End time precedes start time";
		String errMsgHeader2 = "Zero time room booking";
		String errMsg1 = "booking starts time must occur before the end time of the room booking.";
		String errMsg2 = "Start and end time of the room booking are the same. The minimum time for a room booking is one hour. ";
		if (startCal.after(endCal)) {
			throw new BadRoomBookingException(errMsgHeader1, errMsg1);
		} else if (startCal.equals(endCal)) {
			throw new BadRoomBookingException(errMsgHeader2, errMsg2);
		}
		return startCal.after(endCal) && startCal.equals(endCal);
	}

}