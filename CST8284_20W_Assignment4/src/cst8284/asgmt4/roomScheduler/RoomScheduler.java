/*File name:[RoomScheduler.java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[get user's choice and  execute user's choice] 
*/ 
package cst8284.asgmt4.roomScheduler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Collections;
import cst8284.asgmt4.room.*;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author:Ziyue Wang
 * @version 1.0
*/ 
 
public class RoomScheduler {

	
	private static Scanner scan = new Scanner(System.in);
	
	/** an object arrayList roomBookings*/
	private  ArrayList<RoomBooking> roomBookings = new ArrayList<RoomBooking>();
	
	/** The room. */
	private Room room;
	
	/** The Constant DISPLAY_ROOM_INFORMATION. */
	private static final int DISPLAY_ROOM_INFORMATION = 1;
	
	/** The Constant ENTER_ROOM_BOOKING. */
	private static final int ENTER_ROOM_BOOKING = 2;
	
	/** The Constant DELETE_BOOKING. */
	private static final int DELETE_BOOKING = 3;
	
	/** The Constant CHANGE_BOOKING. */
	private static final int CHANGE_BOOKING = 4;
	
	/** The Constant DISPLAY_BOOKING. */
	private static final int DISPLAY_BOOKING = 5;
	
	/** The Constant DISPLAY_DAY_BOOKING. */
	private static final int DISPLAY_DAY_BOOKING = 6;
	
	/** The Constant SAVE_BOOKINGS_TO_FILE. */
	private static final int SAVE_BOOKINGS_TO_FILE = 7;
	
	/** The Constant LOAD_BOOKINGS_FROM_FILE. */
	private static final int LOAD_BOOKINGS_FROM_FILE = 8;
	
	/** The Constant EXIT. */
	private static final int EXIT = 0;
	
	/** The date format is used for determine whether the date format is good. */
	private static DateFormat dateFormat= new SimpleDateFormat("ddMMyyyy");
	

	/**
	 * Instantiates a new roomScheduler.
	 * set the Room object
	 *  
	 * @param room 		the room
	 */
	public RoomScheduler(Room room) {
		setRoom(room);

	}

	/**
	 * it calls two methods, one for displaying the menu to the
	 * user and returning their choice(displayMenu()) and the second for
	 * executing the menu choice selected(executeMenuItem())
	 */
	public void launch() {
		loadBookingsFromFile();
		RoomSchedulerDialog.loadAndShowWords();
//		int choice = 0;
//		do {
//			choice = displayMenu();
//			executeItem(choice);
//		} while (choice != 0);

	}

	/**
	 * It is used for displaying the menu and parses the user's
	 * respond to integer then returns it.
	 *
	 * @return 	the integer which is parsed from user's respond.
	 */
//	private int displayMenu() {
//		System.out.println("");
//		String menu = "Enter a selection from the following menu:" + "\n1. Display room information"
//				+ "\n2. Enter a room booking" + "\n3. Delete booking" + "\n4. Change booking" + "\n5. Display a booking"
//				+ "\n6. Display room bookings for the whole day" + "\n7. Back up current booking to file"
//				+ "\n8. Load booking from file" + "\n0. Exit program\n";
//		String response = getResponseTo(menu);
//		System.out.println("");
//		return Integer.parseInt(response);
//	}

	/**
	 * This method is used for executing item.
	 * Using switch statement to implement different items
	 * if user inputs unexpected value,it will display a default 
	 * message. 
	 *
	 * @param choice 	user's choice
	 */
//	private void executeItem(int choice) {
//		switch (choice) {
//		case DISPLAY_ROOM_INFORMATION:
//			displayRoomInfo();
//			break;
//		case ENTER_ROOM_BOOKING:
//			saveRoomBooking(makeBookingFromUserInput());
//			break;
//		case DELETE_BOOKING:
//			System.out.println("Enter booking to delete");
//			deleteBooking(makeCalendarFromUserInput(null, true));
//			break;
//		case CHANGE_BOOKING:
//			System.out.println("Enter booking to change");
//			changeBooking(makeCalendarFromUserInput(null, true));
//			break;
//		case DISPLAY_BOOKING:
//			RoomBooking booking = displayBooking(makeCalendarFromUserInput(null, true));
//			if (booking != null) {
//				System.out.println(booking.toString());
//			}
//			break;
//		case DISPLAY_DAY_BOOKING:
//			displayDayBookings(makeCalendarFromUserInput(null, false));
//			break;
//		case SAVE_BOOKINGS_TO_FILE:
//			saveBookingToFile();
//			if(saveBookingToFile()) {
//				System.out.println("Current room bookings backed up to file");
//			}
//			break;
//		case LOAD_BOOKINGS_FROM_FILE:
//			roomBookings = loadBookingsFromFile();
//			break;
//		case EXIT:
//			saveBookingToFile();
//			System.out.println("Exiting Room Booking Application");
//			break;
//		default:
//			System.out.println("Invalid input");
//		}
//	}

	/**
	 * It used for displaying room information by using 
	 * getter of Room 
	 */
	public void displayRoomInfo() {
		System.out.println(getRoom().toString());
	}

	/**
	 * Allows the user to remove a Booking based on 
	 * its Calendar date and time.
	 * It returns true if the booking is found and removed successfully.
	 *
	 * @param cal 	calendar parameter used for finding current existing booking
	 * @return true, if successful
	 */
	protected  void deleteBooking(Calendar cal) {
		int index = getRoomBookings().indexOf(findBooking(cal));// find index of the booking in roombooking
		getRoomBookings().remove(index);
//		if (findBooking(cal) != null) {
//			System.out.println(displayBooking(cal).toString());
//			String response = getResponseTo("Press 'Y' to confirm deletion, any other key to abort: ");
//			if (response.contentEquals("Y")) {
//				int index = getRoomBookings().indexOf(findBooking(cal));// find index of the booking in roombooking
//				getRoomBookings().remove(index);// remove corresponding element of the index
//				System.out.println("Booking deleted");
//				return true;
//			} else {
//				System.out.println("deleting aborted.");
//				return false;
//			}
//		} else {
//			System.out.println("no booking records found, deleting failed");
			//return false;
	}

	/**
	 *Allows the user to change time of an existing
	 *RoomBooking. Obtain a Calendar object from the user, use 
	 *findBooking() to locate and return the existing RoomBooking 
	 *(if it exists).
	 *<p>
	 *After locating the existing RoomBooking and it will check if new
	 *booking cal is conflict with current bookings, if there is no 
	 *conflict, it will modify its current TimeBlock to the
	 *new date and time.
	 *
	 * @param cal 	calendar parameter used for finding current existing booking
	 * @return true, if changing successfully.
	 */
	
//	  private boolean changeBooking(Calendar cal) { 
//		boolean isConflict = false;
//		if (findBooking(cal) != null) {
//			System.out.println(displayBooking(cal).toString());
//			RoomBooking currentBooking = findBooking(cal);
//			Calendar newStart = makeCalendarFromUserInput(cal, false);
//			System.out.print("Enter New ");
//			Calendar newEnd = makeCalendarFromUserInput(newStart, true);
//			TimeBlock newTb = new TimeBlock(newStart, newEnd);
//			for (RoomBooking booking : getRoomBookings()) {
//				if (!currentBooking.equals(booking) && booking.getTimeBlock().overlaps(newTb)) {
//					isConflict = true;
//					break;
//				}
//			}
//			if (isConflict) {
//				System.out.println("can not change to that time, room is booked");
//				return false;
//			} else {
//				currentBooking.setTimeBlock(newTb);
//				System.out.println("Booking has been changed to: ");
//
//				System.out.println(currentBooking.toString());
//				return true;
//			}
//		} else {
//			System.out.println("No booking records found, changing failed");
//			return false;
//		}
//
//	  }
	 
	
	/**
	 * Saves a booking into the roomBookings array. it checks that the
	 * RoomBooking passed to the method is not null, and make sure the
	 * RoomBooking’s TimeBlock does not conflict with an existing 
	 * RoomBooking already in the array.
	 * sort elements in the getRoomBookings() every time after saving a new booking
	 *
	 * @param booking 	the booking used for saving 
	 * @return true, if successful
	 */
	//source:the original code of saveRoomBooking(RoomBooking booking) is from professor Dave Houtman
	 protected boolean saveRoomBooking(RoomBooking booking) {
		int index = getRoomBookings().size();
		TimeBlock tb = booking.getTimeBlock();  // Check this TimeBlock to see if already booked
		Calendar cal = (Calendar)tb.getStartTime().clone(); // use its Calendar
		int hour = cal.get(Calendar.HOUR_OF_DAY);//Get first hour of block
		for (; hour < tb.getEndTime().get(Calendar.HOUR_OF_DAY); hour++){ //Loop through each hour in TimeBlock
			cal.set(Calendar.HOUR_OF_DAY, hour); // set next hour
		    if (findBooking(cal)!=null) {  // TimeBlock already booked at that hour, can't add appointment
		    	//System.out.println("Cannot save booking; that time is already booked");
				return false;
		    }	
		}  // else time slot still available; continue loop to next hour
		getRoomBookings().add(index, booking);
		Collections.sort(getRoomBookings(),new SortRoomBookingsByCalendar());
		//System.out.println("Booking time and date saved.");
		return true;
	}

	/**
	 * If findBooking() is not null, it returns a RoomBooking object
	 * 
	 * @param cal  the calendar used for finding the booking record
	 * @return     the Roombooking object which is being looking for
	 * 			   retuns null if findBooking() returns null
	 *  
	 */
	protected  RoomBooking displayBooking(Calendar cal) {
		//  source:Class Calendar.[web page]
		// retrieved from:https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (findBooking(cal) != null) {
			return findBooking(cal);
		} else {
			//System.out.println("No booking scheduled between " + hour + ":00" + " and " + (hour + 1) + ":00");
			return null;
		}
	}

	/**
	 * This method is used for displaying day booking.
	 * it instantiates a new booking called dummyBooking by making a calendar cal2 which is 1 hour
	 * bigger than cal.
	 * <p>
	 * it looks for the first booking of the search day by Collections.binarySearch().
	 * it will start to find any booking between 0:00 and cal2 1:00, since  there is no
	 *  booking between 0:00-1:00,it returns the 
	 * number close to the index of first booking of searching day.The number is
	 * a negative number since the booking between 0:00 and 1:00 does not exist.
	 * The index of first booking equals -(the negative number + 1)
	 * it finds out the last booking index of the searching day by using the same strategy .
	 * <p>
	 * It loops through the firstBooking index and lastBooking index to get the 
	 * information of whole day room booking.
	 * if last and first booking index is equal, it turns out there is no booking 
	 * <p>
	 * 
	 * @param cal 		used for finding out the day booking
	 */

//	source:Binary Search in Java[web site]
//	retrieved from:https://www.geeksforgeeks.org/binary-search-in-java/
//	source:Chinmoy Lenka.Calendar add() Method in Java with Examples[website]
//	retrieved from: https://www.geeksforgeeks.org/calendar-add-method-in-java-with-examples/
	protected  ArrayList<String> displayDayBookings(Calendar cal) {
		ArrayList<String> displayOutPut = new ArrayList<>();
		Calendar cal2 = (Calendar) cal.clone();
		cal2.set(Calendar.HOUR_OF_DAY, 1);
		//instantiate a dummy roomBooking
		TimeBlock oneHourTB = new TimeBlock(cal, cal2);
		ContactInfo contact = new ContactInfo("AC","AC","000-000-0000","");
		Activity act = new Activity("AC","AC");
		RoomBooking dummyBooking = new RoomBooking(contact,act,oneHourTB);
//		source:Find a Fixed Point (Value equal to index) in a given array[web site]
//		retrieved from: https://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
//		source:JAVA array query binarySearch() method (written in Chinese)[web site]
//		retrieved from:https://blog.csdn.net/a1b2c3d4123456/article/details/51097161
		//find first booking of the search day
		int firstBookingIdx =-( Collections.binarySearch(getRoomBookings(), dummyBooking,new SortRoomBookingsByCalendar())+1);
		//find the closest index to the last booking index from next day session,set cal one day later
		cal.add(Calendar.DATE, 1);
		cal2.add(Calendar.DATE, 1);
		dummyBooking.getTimeBlock().setStartTime(cal);
		dummyBooking.getTimeBlock().setEndTime(cal2);
		int lastBookingIdx = -( Collections.binarySearch(getRoomBookings(), dummyBooking,new SortRoomBookingsByCalendar())+1);
		//looking for bookings between 8:00-23:00
		for (int i = 8; i < 24; i++) {
			//if firstBookingIdx greater than or equal to lastBookingIdx
			//no booking found
			if(firstBookingIdx >= lastBookingIdx) {
				displayOutPut.add("No booking scheduled between " + i + ":00" + " and " + (i + 1) + ":00");
				firstBookingIdx++;
				//if i:00 is equal to startTime of booking in firstBookingIdx
				//getRoomBookings().get(firstBookingIdx) is what we are looking for
			}else if(i == getRoomBookings().get(firstBookingIdx).getTimeBlock().getStartTime().get(Calendar.HOUR_OF_DAY)) {
				displayOutPut.add(getRoomBookings().get(firstBookingIdx).toString());
				firstBookingIdx++;
			}else {
				displayOutPut.add("No booking scheduled between " + i + ":00" + " and " + (i + 1) + ":00");
			}			
		}
		return displayOutPut;
		
	}

	/**
	 * This is method that prints out the String entered as
	 * a parameter, and then scans in, and returns
	 * the user’s response as another String.
	 *
	 * @param s 	String entered as a parameter
	 * @return  	the response from user input
	 */
	// the code below is from professor Dave Houtman
	private static String getResponseTo(String s) {
		System.out.print(s);
		return (scan.nextLine());
	}

	/**
	 * Make booking from user input.It returns RoomBooinking 
	 * based on user input.
	 * It catches BadRoomBookingException which indicates invalid user input.
	 * if all input is valid, the do while loop will be terminated.
	 * if there is invalid input, user will be prompt to input the information
	 * again until all the input meet the requirements.
	 * 
	 * 
	 * @return the roombooking
	 */
//	private RoomBooking makeBookingFromUserInput() {
//		String fullName ="A C";
//		String firstName = "A";
//		String lastName = "C";	
//		String number ="000-000-0000" ,category = "AC",event ="AC",organization="";
//		Calendar startCal = Calendar.getInstance();
//		Calendar endCal = (Calendar) startCal.clone();
//		endCal.add(Calendar.HOUR, 1);
//		Activity act = new Activity(event, category);
//		TimeBlock timeBlock = new TimeBlock(startCal, endCal);
//		ContactInfo conInfo=new ContactInfo(firstName, lastName, number);
//		boolean keepExcuting = true;
//		do {
//			try {
//				fullName = getResponseTo("Enter Client Name (as FirstName LastName): ");
//				isGoodGeneralInput(fullName);
//				Pattern namePattern = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+");
//				Matcher nameMatcher = namePattern.matcher(fullName);
////					source:Lars Vogel,Regular expressions in Java - Tutorial[web site]
////					retrieved from:https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
//				if (nameMatcher.matches()) {
//					fullName = nameMatcher.group(0);
////					source:How to split a String by space?
////					[web page] retrieved from:https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
//					String[] splitNamebySpace = fullName.split("\\s+");
//					firstName = splitNamebySpace[0];
//					lastName = splitNamebySpace[1];
//				}else {
//					firstName = " ";
//					lastName = " ";
//				}
//				number = getResponseTo("Phone Number (e.g. 613-555-1212): ");
//				organization = getResponseTo("Organization (Optional): ");
//				category = getResponseTo("Enter event category: ");
//				event = getResponseTo("Enter detailed description of event: ");
//				startCal = makeCalendarFromUserInput(null, true);
//				endCal = makeCalendarFromUserInput(startCal, true);
//
//				if (organization.equals("")) {
//					conInfo = new ContactInfo(firstName, lastName, number);
//				} else {
//					conInfo = new ContactInfo(firstName, lastName, number, organization);
//				}
//				act = new Activity(event, category);
//				if (startCal.get(Calendar.HOUR_OF_DAY) < 8) {
//					throw new BadRoomBookingException("Start Time less than 8:00", "only 8:00 -23:00 available");
//				}else {
//					timeBlock = new TimeBlock(startCal, endCal);
//				}				
//				keepExcuting = false;
//			} catch (BadRoomBookingException ex) {
//				System.out.println(ex.getHeader() + "," + ex.getMessage() + "\n");
//			}
//
//		} while (keepExcuting);
//
//		return new RoomBooking(conInfo, act, timeBlock);
//		
//	}

	 
	/**
	 * This method  is used for making  a calendar according to user input
	 * and then a returns the calendar.
	 * if initial calendar is null and hour is required,it prompts user to enter a date and start time,
	 * then it parses string to integer based on user input;
	 * if initial calendar is not null and hour is required,it prompts user to enter end time.
	 * it calls setDateFormat() to check if format of user input is correct
	 * it sets calendar with integers which is parsed from user input
	 * 
	 * @param initCal 	check if the initial calendar exists
	 * @param requestHour	check if the input of hour is required
	 * @return the calendar
	 * @throws BadRoomBookingException if format is not as required
	 */
	//source:The original code of makeCalendarFromUserInput() from professor Dave Houtman.
	protected static Calendar makeCalendarFromUserInput(String dateString, String timeString) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		String date = dateString;
		int time = processTimeString(timeString);
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4)) - 1;
		int year = Integer.parseInt(date.substring(4, 8));
		cal.set(year, month, day, time, 0);
		return (cal);
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		String date = "";
//		int hour = 0;
//		boolean needCal = (initCal == null);
//		if (needCal) {
//			date = getResponseTo("Event Date (entered as DDMMYYYY): ");
//			isGoodGeneralInput(date);
//			setDateFormat(date);
//			
//		}
//		int day = needCal ? Integer.parseInt(date.substring(0, 2)) : initCal.get(Calendar.DAY_OF_MONTH);
//		int month = needCal ? Integer.parseInt(date.substring(2, 4)) - 1 : initCal.get(Calendar.MONTH);
//		int year = needCal ? Integer.parseInt(date.substring(4, 8)) : initCal.get(Calendar.YEAR);
//		
//		if (!requestHour && !needCal) {
//			String time = getResponseTo("Enter New Start Time: ");
//			isGoodGeneralInput(time);
//			hour = processTimeString(time);
//		} else if(requestHour) {
//			String time = getResponseTo((needCal ? "Start" : "End") + " Time: ");
//			isGoodGeneralInput(time);
//			hour = processTimeString(time);
//			
//		}
//		
//		cal.set(year, month, day, hour, 0);
//		return (cal);
	}

	
	/**
	 * This method is used for processing time string.
	 * It parses string to integer.if format "8 am", split input by space.
	 * if format "8 pm", split input by " ", add 12;
	 * if format "8:00",split by colon.
	 *
	 * @param t 	t is time string from user input
	 * @return the int which is parsed from user input
	 */
	protected static int processTimeString(String t) {
		 //source:How to split a String by space?
		//* [webpage] retrieved from:https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
		String[] splitedbyAMPM = t.split("\\s+");
		String[] splitedbycolon = t.split(":");
		// if format "8 am", split input by space
		if (t.contains(" ") && (t.contains("am") || t.contains("a.m."))) {
			return Integer.parseInt(splitedbyAMPM[0]);
			// 
		} else if (t.contains(" ") && (t.contains("pm") || t.contains("p.m."))) {
			// 
			return Integer.parseInt(splitedbyAMPM[0]) + 12;
		} else {
			return Integer.parseInt(splitedbycolon[0]);
		}
	}

	/**
	 * Returns a room booking if it exits.
	 * This method is used for finding a specific room booking by calendar.
	 * By making a cal2 that is one hour later from CAL, we instantiate a new 
	 * TimeBlock, thus instantiating an dummy room booking.
	 * With Collections.binarySearch(), we can find the corresponding index.
	 * If the index is negative, it proves that the Booking does not exist, 
	 * then the method returns a null value.
	 * @param cal 	the start calendar we are trying to find out
	 * @return 		the room booking if it exists. If it does not exist , 
	 * 				it will return null
	 */
	protected   RoomBooking findBooking(Calendar cal) {
		// source:Chris Lercher. calendar.getInstance() or calendar.clone()
		//[web page] retrieved from: https://stackoverflow.com/questions/2595630/calendar-getinstance-or-calendar-clone
		Calendar cal2 = (Calendar) cal.clone();
		// source:Chinmoy Lenka.Calendar add() Method in Java with Examples
		//[web site]retrieved from: https://www.geeksforgeeks.org/calendar-add-method-in-java-with-examples/
			 
		cal2.add(Calendar.HOUR, 1);
		// cal2 is clone of cal, it is 1 hour bigger than cal
		TimeBlock oneHourTB = new TimeBlock(cal, cal2);
		ContactInfo contact = new ContactInfo("AC","AC","000-000-0000","");
		Activity act = new Activity("AC","AC");
		RoomBooking booking = new RoomBooking(contact,act,oneHourTB);
		
		Collections.sort(getRoomBookings(),new SortRoomBookingsByCalendar());
		
		int index = Collections.binarySearch(getRoomBookings(), booking, new SortRoomBookingsByCalendar());
		if(index < 0) {
			return null;
		}else {
			return getRoomBookings().get(index);
			}

	}

	/**
	 * Gets the room bookings.
	 * The roomBooking arrayList is accessed by getRoomBookings()
	 *
	 * @return the room bookings
	 */
	protected  ArrayList<RoomBooking> getRoomBookings() {
		return roomBookings;
	}

	/**
	 * Sets the room.
	 *
	 * @param room the new room
	 */
	private void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Gets the room.
	 * The room is accessed by getRoom()
	 *
	 * @return the room
	 */
	private Room getRoom() {
		return room;
	}
	
	/**
	 * This method is used for saving booking records to file.
	 * This method will check if file "currentRoomBookings" exits first, if
	 * it does not exit, it will create a file name "currentRoomBookings",then
	 * loop through whole roomBooking via its getter to write every single 
	 * booking record into the file.
	 * if not successful,it will catch IOException and return false
	 *
	 * @return true, if successful
	 * 
	 */
	protected  boolean saveBookingToFile() {
		//source:Java IO: ObjectOutputStream[web page]retrieved
		// from:http://tutorials.jenkov.com/java-io/objectoutputstream.html
		//source:Class IOException [web page]retrieved from:
		// * https://docs.oracle.com/javase/7/docs/api/java/io/IOException.html
			
		String path = "./CurrentRoomBookings.book";
		File currentRoomBookings = new File(path);
		try {
			if (!currentRoomBookings.exists() || currentRoomBookings.isDirectory()) {
				currentRoomBookings.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(currentRoomBookings);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (RoomBooking thisroomBooking : getRoomBookings()) {
				oos.writeObject(thisroomBooking);
			}
			oos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This method is used for loading the file contents into the RoomBookings
	 * ArrayList.This method will check if currentRoomBookings file exits and 
	 * is not a directory first, then starting loading file contents until
	 * the end of file.EOFException will be caught if loading is done. Otherwise
	 * other exceptions will be caught.
	 * 
	 *
	 * @return the array list of current booking records
	 * 
	 **/
	private ArrayList<RoomBooking> loadBookingsFromFile() {
		//source:Java IO: ObjectInputStream[web page]
		//retrieved from:http://tutorials.jenkov.com/java-io/objectinputstream.html
		ArrayList<RoomBooking> allBookings = new ArrayList<RoomBooking>();
		RoomBooking roomBookingFromFile;
		String path = "./CurrentRoomBookings.book";
		File currentRoomBookings = new File(path);
		try {
			if (currentRoomBookings.exists() && !currentRoomBookings.isDirectory()) {
				FileInputStream fis = new FileInputStream(currentRoomBookings);
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					while (true) {
						roomBookingFromFile = (RoomBooking) ois.readObject();
						allBookings.add(roomBookingFromFile);
					}
				} catch (EOFException e) {
					//System.out.println("Current  room booking loaded from file");
				} catch (FileNotFoundException ex) {
					System.out.println("File could not be found");
				} catch (ClassNotFoundException ex) {
					System.out.println("Class could not be found");
				} finally {
					fis.close();
					ois.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allBookings;
	}
	
	/**
	 * Sets the date format from the user input.If user input is not
	 * in good format,dateFormat.parse()will fail,then throws BadRoomBookingException
	 *
	 * @param date the new date format
	 * @throws BadRoomBookingException
	 */
	private static void setDateFormat(String date)  {
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch (ParseException ex) {
			throw new BadRoomBookingException("Bad Calendar format",
					"Bad calendar date was entered. The correct format is\r\n" + "DDMMYYYY.");
		}
		
	}
	/**
	 * Checks if  input is null or empty.
	 * if input is empty, it triggers BadRoomBookingException 
	 * it calls a string factory method,if input is null, it triggers  NullPointerException
	 *
	 * @param s 	get user input s
	 * @return true, if  input is null
	 * @throws BadRoomBookingException 
	 */
	public static boolean isGoodGeneralInput(String s)  {
		if (s.trim().equals("")) {
			throw new BadRoomBookingException("Missing value", "Missing an input value");
		}
		try {
			s.trim();//call string method,if input is null,it triggers NullPointerException
		}catch(NullPointerException ex ){
			throw new BadRoomBookingException("Null value entered", "An attemp was made"
					+ "to pass a null value to a variable");
		}
		return true;
		
	}

}
