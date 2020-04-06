
/*File name:[ContactInfo.java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[collect user's contact information] 
*/

package cst8284.asgmt4.roomScheduler;

import java.io.Serializable;

/**
 * The Class ContactInfo.
 * 
 * @author:Ziyue Wang
 * @version 1.0
 */

public class ContactInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String organization;

	/**
	 * Instantiates a new contact info,when no organization information input, use
	 * this constructor to instantiate.
	 *
	 * @param firstName   the first name of user
	 * @param lastName    the last name of user
	 * @param phoneNumber the phone number of user
	 */

	public ContactInfo(String firstName, String lastName, String phoneNumber) {
		this(firstName, lastName, phoneNumber, "default oganization");
	}

	/**
	 * Instantiates a new contact info when there is an organization input. set all
	 * the fields
	 *
	 * @param firstName    the first name of user
	 * @param lastName     the last name of user
	 * @param phoneNumber  the phone number of user
	 * @param organization the organization of user
	 */
	public ContactInfo(String firstName, String lastName, String phoneNumber, String organization) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setOrganization(organization);
	}

	/**
	 * if all input is not null and name format is good Sets the first name of user.
	 * field firstName is modified by this method
	 * 
	 * @param firstName sets the new first name
	 */
	// setters and getters for all the private instances
	public void setFirstName(String firstName) {
		if (isNameGood(firstName))
			this.firstName = firstName;
	}

	/**
	 * if all input is not null and name format is good Sets the last name. field
	 * lastName is modified by this method
	 * 
	 * @param lastName sets the new last name
	 */
	public void setLastName(String lastName) {

		if (isNameGood(lastName))
			this.lastName = lastName;
	}

	/**
	 * Sets the organization. field organization is modified by this method
	 * 
	 * @param organization sets the new organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * if input is not null and phone number format is good then sets the phone
	 * number. field phoneNumber is modified by this method
	 *
	 * @param phoneNumber sets the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (RoomScheduler.isGoodGeneralInput(phoneNumber) && isGoodPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}
	}

	/**
	 * Gets the first name. field firstName is accessed by this method
	 * 
	 * @return the first name of user
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Gets the last name. field lastName is accessed by this method
	 * 
	 * @return the last name of user
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Gets the organization. field organization is accessed by this method
	 *
	 * @return the organization
	 */
	public String getOrganization() {
		return this.organization;
	}

	/**
	 * Gets the phone number. field phoneNumber is accessed by this method
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * returns different string output based on if there is organization information
	 * .
	 *
	 * @return the string about user's contact information
	 */
	@Override
	public String toString() {
		if (this.getOrganization().equals("default oganization")) {
			return "Contact Infomation: " + getFirstName() + " " + getLastName() + "\n" + "Phone: " + getPhoneNumber()
					+ "\n";
		} else {
			return "Contact Infomation: " + getFirstName() + " " + getLastName() + "\n" + "Phone: " + getPhoneNumber()
					+ "\n" + getOrganization() + "\n";
		}
	}

	/**
	 * This method return true when: All character of name string are alphabetic The
	 * length of name less than 30.
	 *
	 * @param name the name from user input
	 * @return true, if name good
	 * @throws BadRoomBookingException if name is not alphabetic or length exceeds
	 *                                 30
	 */
	private boolean isNameGood(String name) {
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isAlphabetic(name.charAt(i))) {
				throw new BadRoomBookingException("Name contains illegal" + "characters",
						"A name cannot include characters other than alphabetic\r\n"
								+ "characters, the dash (-), the period (.), and the apostrophe\r" + "(‘).");
			}
		}
		if (name.length() > 30) {
			throw new BadRoomBookingException("Name length exceeded",
					"The first or last name exceeds the 30 character maximum\r\n" + "allowed.");
		}
		return name.length() <= 30;
	}

	/**
	 * This method return true when: length of phone number(includes '-') equals 12.
	 * all number from user input are digital phone number from user input are in
	 * format as required(check if the index of 3 and 7 are '-')
	 *
	 * @param phoneNumber the phone number from user input
	 * @return true, if is good phone number
	 * @throws BadRoomBookingException if length or format or digit not good
	 */
	private boolean isGoodPhoneNumber(String phoneNumber) {
		String[] phoneSplit = phoneNumber.split("-");
		String errorMsgHeader = "Bad telephone number";
		String errorMsg = "The telephone number must be a 10-digit number,\r\n"
				+ "separated by ‘-‘ in the form, e.g. 613-555-1212";
		boolean isThreeDig;
		boolean isFourDig;
		if (phoneSplit.length != 3) {
			throw new BadRoomBookingException(errorMsgHeader, errorMsg);
		} else {
			for (int i = 0; i < 3; i++) {
				isThreeDig = (phoneSplit[i].length() == 3 && i < 2);
				isFourDig = (phoneSplit[i].length() == 4 && i == 2);
				if (isThreeDig || isFourDig) {
					try {
					//source:Integer decode() Method in Java[web site]
					//retrieved from: https://www.geeksforgeeks.org/integer-decode-method-in-java/
						Integer.decode(phoneSplit[i]);
					} catch (NumberFormatException e) {
						throw new BadRoomBookingException(errorMsgHeader, errorMsg);
					}
				} else {
					throw new BadRoomBookingException(errorMsgHeader, errorMsg);
				}
			}

		}
		return true;
	}
}
