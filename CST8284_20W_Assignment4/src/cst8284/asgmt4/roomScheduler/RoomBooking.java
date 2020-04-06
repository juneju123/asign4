package cst8284.asgmt4.roomScheduler;
import java.io.Serializable;
/**
 * @author:Ziyue Wang
 * @version 1.0
*/ 
public class RoomBooking implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private ContactInfo contactInfo;
	private Activity activity;
	private TimeBlock timeBlock;

	/**
	 * Instantiates a new room booking.
	 *
	 * @param contactInfo   the contact info
	 * @param activity 		the activity
	 * @param timeBlock	    the time block
	 */
	public RoomBooking(ContactInfo contactInfo, Activity activity, TimeBlock timeBlock) {
		this.activity = activity;
		this.contactInfo = contactInfo;
		this.timeBlock = timeBlock;
	}

	/**
	 * Sets the contact info.
	 * contactInfo is set and modified by this method 
	 * 
	 * @param contactInfo 	sets the new contact info
	 */
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * Gets the contact info.
	 * cotactInfo is accessed by this method
	 * 
	 * @return 	the contact info of users
	 */
	public ContactInfo getContactInfo() {
		return this.contactInfo;
	}

	/**
	 * Sets the activity.
	 * activity is set and modified by this method 
	 * @param activity 		sets the new activity of users
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * Gets the activity.
	 * activity is accessed by this method
	 * 
	 * @return the activity of users
	 */
	public Activity getActivity() {
		return this.activity;
	}

	/**
	 * Sets the time block.
	 * timeBlock is set and modified by this method 
	 * 
	 * @param timeBlock 	sets the new time block of users
	 */
	public void setTimeBlock(TimeBlock timeBlock) {
		this.timeBlock = timeBlock;

	}

	/**
	 * Gets the time block.
	 * timeBlock is accessed by this method
	 *
	 * @return 	the time block of users
	 */
	public TimeBlock getTimeBlock() {
		return this.timeBlock;
	}

	/**
	 * It calls TimeBlock,Activity and ContactInfo's toString()
	 *
	 * @return  all the information about RoomBooking
	 */
	@Override
	public String toString() {
		return "--------------\n" + getTimeBlock().toString() + getActivity().toString() + getContactInfo().toString()
				+ "--------------";
}
}