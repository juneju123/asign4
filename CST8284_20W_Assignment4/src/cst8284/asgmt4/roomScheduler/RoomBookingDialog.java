package cst8284.asgmt4.roomScheduler;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import cst8284.asgmt4.room.ComputerLab;
import cst8284.asgmt4.room.Room;

/* Adapted, with considerable modification, from 
 * http://www.java2s.com/Code/Java/Swing-JFC/TextAcceleratorExample.htm,
 * which is sloppy code and should not be emulated.
 */

public class RoomBookingDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final GridBagConstraints labelConstraints = new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1,
			1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 20), 0, 0);
	private static final GridBagConstraints textConstraints = new GridBagConstraints(1, GridBagConstraints.RELATIVE, 1,
			1, 1, 1, // gridx, gridy, gridwidth, gridheight, weightx, weighty
			GridBagConstraints.EAST, 0, new Insets(5, 5, 5, 10), 20, 20); // anchor, fill, insets, ipadx, ipady
	private static final GridBagConstraints btnConstraints = new GridBagConstraints(0, GridBagConstraints.RELATIVE, 2,
			1, 0.5, 0.5, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 20), 0, 0);
	private static Panel cp = new Panel();
	private static final int labelWidth = 24;
	private static final Font defaultFont = new Font("SansSerif", Font.PLAIN, 20);
	private static final FlowLayout btnRow = new FlowLayout();
	private static final JPanel btnPanel = new JPanel();
	private static JButton searchBtn, saveBtn, deleteBtn, exitBtn;
	private static String txtName, txtNumber, txtDate, txtStartTime, txtEndTime, txtOrgnization, txtCategory,txtDescription;
	public static JTextField name,number,date,startTime,endTime,organization,category,description;
			
	private static Room rom = new ComputerLab();
	private static RoomScheduler scheduler = new RoomScheduler(rom);

//	public static void main(String[] args) {
//		RoomBookingDialog roomDialog = new RoomBookingDialog();
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//
//			public void run() {
//				showAppointmentDialog();
//			}
//		});
//	}

	public static void setTxtName(String name) {
		txtName = name;
	}

	public static String getTxtName() {
		return txtName;
	}

	public static void showAppointmentDialog() {
		cp.removeAll();
		cp.repaint();
		JFrame f = new JFrame("");
		cp.setLayout(new GridBagLayout());

		// Set the first seven rows with Label/TextField
		
		date = setRow("Booking Date (DDMMYYYY):", 'e');
		startTime = setRow("Start Time (2 p.m. or 14:00):", 't');
		endTime = setRow("End Time (2 p.m. or 14:00):", 'q');
		name = setRow("Client Name(FirstName LastName):", 'h');
		number = setRow("Phone Number (e.g. 613-555-1212):", 'p');
		organization = setRow("Organization (optional):", 'o');
		category = setRow("Event Category:", 'c');
		description = setRow("Description:", 'd');

		// Load the buttons across the bottom
		btnPanel.removeAll();//remove and repaint panel whenever needs to reload the panel
		btnPanel.repaint();
		btnPanel.setLayout(btnRow);
		setSearchBtn(setBtnRow("   Search   ", 'r'));
		setSaveBtn(setBtnRow("    Save    ", 's'));//.addActionListener(roomDialog.new SaveBtnHndler());
		setDeleteBtn(setBtnRow("   Delete   ", 'l'));
		setExitBtn(setBtnRow("    Exit    ", 'x'));
		btnPanel.revalidate();
		getBtnAction();

		cp.add(btnPanel, btnConstraints);
		f.add(cp);
		f.pack();
		cp.revalidate();

		// Close dialog
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

		f.setVisible(true);
	}
	private static void getBtnAction() {
		
		getSaveBtn().addActionListener(new RoomBookingDialog.SaveBtnHndler());
		getSearchBtn().addActionListener(new RoomBookingDialog.SearchBtnHndler());
		getDeleteBtn().addActionListener(new RoomBookingDialog.DeleteBtnHndler());
	}

	private static JTextField setRow(String label, char keyboardShortcut) {
		JLabel l;
		JTextField t;
		cp.add(l = new JLabel(label, SwingConstants.RIGHT), labelConstraints);
		l.setFont(defaultFont);
		l.setDisplayedMnemonic(keyboardShortcut);
		cp.add(t = new JTextField(labelWidth), textConstraints);
		t.setFont(defaultFont);
		t.setFocusAccelerator(keyboardShortcut);
		return t;
	}

	private static JButton setBtnRow(String label, char keyboardShortcut) {
		JButton btn = new JButton(label);
		btn.setFont(defaultFont);
		btn.setMnemonic(keyboardShortcut);
		btnPanel.add(btn);
		return btn;
	}

	

	
	public static JButton getSaveBtn() {
		return saveBtn;
	}

	public static void setSaveBtn(JButton saveBtn) {
		RoomBookingDialog.saveBtn = saveBtn;
	}
	public static void  getAllFieldsValue() {
		setTxtName(name.getText());
		setTxtNumber(number.getText());
		setTxtDate(date.getText());
		setTxtStartTime(startTime.getText());
		setTxtEndTime(endTime.getText());
		setTxtOrgnization(organization.getText());
		setTxtDescription(description.getText());
		setTxtCategory(category.getText());
	}
	
	public static String getTxtNumber() {
		return txtNumber;
	}

	public static void setTxtNumber(String txtNumber) {
		RoomBookingDialog.txtNumber = txtNumber;
	}

	public static String getTxtDate() {
		return txtDate;
	}

	public static void setTxtDate(String txtDate) {
		RoomBookingDialog.txtDate = txtDate;
	}

	public static String getTxtStartTime() {
		return txtStartTime;
	}

	public static void setTxtStartTime(String txtStartTime) {
		RoomBookingDialog.txtStartTime = txtStartTime;
	}

	public static String getTxtEndTime() {
		return txtEndTime;
	}

	public static void setTxtEndTime(String txtEndTime) {
		RoomBookingDialog.txtEndTime = txtEndTime;
	}

	public static String getTxtOrgnization() {
		return txtOrgnization;
	}

	public static void setTxtOrgnization(String txtOrgnization) {
		RoomBookingDialog.txtOrgnization = txtOrgnization;
	}

	public static String getTxtCategory() {
		return txtCategory;
	}

	public static void setTxtCategory(String txtCategory) {
		RoomBookingDialog.txtCategory = txtCategory;
	}

	public static String getTxtDescription() {
		return txtDescription;
	}

	public static void setTxtDescription(String txtEvent) {
		RoomBookingDialog.txtDescription = txtEvent;
	}
	private static Calendar startCal() {
		return RoomScheduler.makeCalendarFromUserInput(getTxtDate(),getTxtStartTime());

	}

	private static Calendar endCal() {
		return RoomScheduler.makeCalendarFromUserInput(getTxtDate(),getTxtEndTime());
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		String date = getTxtDate();
//		int endTime = RoomScheduler.processTimeString(getTxtEndTime());
//		int day = Integer.parseInt(date.substring(0, 2));
//		int month = Integer.parseInt(date.substring(2, 4)) - 1;
//		int year = Integer.parseInt(date.substring(4, 8));
//		cal.set(year, month, day, endTime, 0);
//		return (cal);

	}
	private static Calendar date() {
		return RoomScheduler.makeCalendarFromUserInput(getTxtDate(),"0");
//		Calendar cal = Calendar.getInstance();
//		cal.clear();
//		String date = getTxtDate();
//		int day = Integer.parseInt(date.substring(0, 2));
//		int month = Integer.parseInt(date.substring(2, 4)) - 1;
//		int year = Integer.parseInt(date.substring(4, 8));
//		cal.set(year, month, day, 0, 0);
//		return (cal);
	}

	public static JButton getSearchBtn() {
		return searchBtn;
	}

	public static void setSearchBtn(JButton searchBtn) {
		RoomBookingDialog.searchBtn = searchBtn;
	}


	public static JButton getDeleteBtn() {
		return deleteBtn;
	}

	public static void setDeleteBtn(JButton deleteBtn) {
		RoomBookingDialog.deleteBtn = deleteBtn;
	}


	public static JButton getExitBtn() {
		return exitBtn;
	}

	public static void setExitBtn(JButton exitBtn) {
		RoomBookingDialog.exitBtn = exitBtn;
	}


	private static class SaveBtnHndler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			getAllFieldsValue();
			String fullName = "A C";
			String firstName = "A";
			String lastName = "C";
			String number = "000-000-0000", category = "AC", event = "AC", organization = "";
			Calendar startCal = Calendar.getInstance();
			Calendar endCal = (Calendar) startCal.clone();
			endCal.add(Calendar.HOUR, 1);
			Activity act = new Activity(event, category);
			TimeBlock timeBlock = new TimeBlock(startCal, endCal);
			ContactInfo conInfo = new ContactInfo(firstName, lastName, number);
			boolean isInputValid = true;
			//do {
				try {
					fullName = getTxtName();

					RoomScheduler.isGoodGeneralInput(fullName);
					Pattern namePattern = Pattern.compile("[a-zA-Z]+\\s[a-zA-Z]+");
					Matcher nameMatcher = namePattern.matcher(fullName);
//				source:Lars Vogel,Regular expressions in Java - Tutorial[web site]
//				retrieved from:https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
					if (nameMatcher.matches()) {
						fullName = nameMatcher.group(0);
//				source:How to split a String by space?
//				[web page] retrieved from:https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
						String[] splitNamebySpace = fullName.split("\\s+");
						firstName = splitNamebySpace[0];
						lastName = splitNamebySpace[1];
					} else {
						firstName = " ";
						lastName = " ";
					}
					if (organization.equals("")) {
						conInfo = new ContactInfo(firstName, lastName, getTxtNumber());
					} else {
						conInfo = new ContactInfo(firstName, lastName, getTxtNumber(), getTxtOrgnization());
					}
					act = new Activity(getTxtCategory(), getTxtDescription());
					if (startCal.get(Calendar.HOUR_OF_DAY) < 8) {
						throw new BadRoomBookingException("Start Time less than 8:00", "only 8:00 -23:00 available");
					} else {
						timeBlock = new TimeBlock(startCal(), endCal());
					}
					//keepExcuting = false;
				} catch (BadRoomBookingException ex) {
					isInputValid = false;
					JOptionPane.showMessageDialog(null, ex.getMessage(),ex.getHeader(),  JOptionPane.ERROR_MESSAGE);

				}
			//} while (keepExcuting);
			RoomBooking booking = new RoomBooking(conInfo, act, timeBlock);
			
			if (isInputValid && scheduler.saveRoomBooking(booking)) {
				JOptionPane.showMessageDialog(null, "Booking time and date saved.");
			//	RoomSchedulerDialog.reloadJTextArea(startCal);
			} else {
				JOptionPane.showMessageDialog(null, "Cannot save booking; that time is already booked");
			}
		}

	}
	private static class SearchBtnHndler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			getAllFieldsValue();
			
			if (getTxtStartTime().equals("")) {
				JOptionPane.showMessageDialog(null, RoomSchedulerDialog.readDayBooking(date()));
			} else if (scheduler.displayBooking(startCal()) != null) {
				Object[] options = { "Yes", "No" };
				int n = JOptionPane.showOptionDialog(null, scheduler.displayBooking(startCal()).toString()+"\n Would you like to change your booking time?", "booking information",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[0]); 
				if(n==0) {
					changeBookingTime();				
				}else {getDeleteBtn().setEnabled(true);}
			}else {
				int time = RoomScheduler.processTimeString(getTxtStartTime()) + 1;
				String alertMesg = "There is no booking between " + getTxtStartTime() +" to " + String.valueOf(time)+":00";
				JOptionPane.showMessageDialog(null, alertMesg);
			}
		}
		private void changeBookingTime() {
			RoomBookingDialog.showAppointmentDialog();
			RoomBookingDialog.date.setEditable(false);
			RoomBookingDialog.name.setEditable(false);
			RoomBookingDialog.number.setEditable(false);
			RoomBookingDialog.category.setEditable(false);
			RoomBookingDialog.description.setEditable(false);
			RoomBookingDialog.organization.setEditable(false);
			RoomBooking currentBooking = scheduler.findBooking(startCal());
			getAllFieldsValue();
			boolean isConflict = false;
			Calendar newStart = startCal();
			Calendar newEnd = endCal();
			TimeBlock newTb = new TimeBlock(newStart, newEnd);
			for (RoomBooking booking : scheduler.getRoomBookings()) {
				if (!currentBooking.equals(booking) && booking.getTimeBlock().overlaps(newTb)) {
					isConflict = true;
					break;
				}
			}
			if (isConflict) {
				JOptionPane.showMessageDialog(null,"can not change to that time, room is booked");
			} else {
				currentBooking.setTimeBlock(newTb);
				JOptionPane.showMessageDialog(null,"Booking has been changed to: ",currentBooking.toString(),JOptionPane.INFORMATION_MESSAGE);
				} 
		}
			
		}
		
	private static class DeleteBtnHndler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Object[] options = { "Yes", "No" };
			int n = JOptionPane.showOptionDialog(null, scheduler.displayBooking(startCal()).toString(), "Comfirm your deletion:",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,options[0]); 
			if(n==0) {
				scheduler.deleteBooking(startCal());
				//RoomSchedulerDialog.reloadJTextArea(startCal());;
			}
		}
		
	}

}
