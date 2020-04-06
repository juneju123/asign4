package cst8284.asgmt4.roomScheduler;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import cst8284.asgmt4.room.ComputerLab;
import cst8284.asgmt4.room.Room;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JTextArea;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RoomSchedulerDialog extends JFrame {
	public RoomSchedulerDialog() {
	}

	/**
	 * Launch the application.
	 */

	private static final long serialVersionUID = 1L;
	private static final Toolkit tk = Toolkit.getDefaultToolkit();
	private static final Dimension screenSize = tk.getScreenSize();
	private static final JTextArea scrollText = new JTextArea();
	private  static Room com = new ComputerLab();
	private  static RoomScheduler scheduler = new RoomScheduler(com);

	
	/*
	 * public static void main(String[] args) {
	 * javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() {
	 * loadAndShowWords();
	 * 
	 * } }); }
	 */

	protected static void loadAndShowWords() {
		JFrame frame = new JFrame();
		com.setRoomNumber("B119");
		String title = "Room Booking for"+com.getRoomNumber() +"for "+ calString(getCurrentCal());
		frame.setTitle(title);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int screenX = (int) screenSize.getWidth() / 2;
		int screenY = (int) (screenSize.getHeight() / 2);
		
		/*Uncomment the following code when you have finished TODO #1 and test your code.
		  Make sure the word list appears in the scroll pane.  Then remove this comment.*/
		  	
			frame.getContentPane().add(getWestPanel(), BorderLayout.WEST);
			frame.getContentPane().add(getCenterPanel(scrollText, screenY), BorderLayout.CENTER);
			frame.setPreferredSize(new Dimension(screenX, screenY));

			frame.pack();
			frame.setVisible(true);
			reloadJTextArea(getCurrentCal());
		
	}
	

	public static JPanel getCenterPanel(JTextArea jta, int height) {
		JScrollPane centerPane = new JScrollPane(jta);
		centerPane.setPreferredSize(new Dimension(400, 7 * height / 8));
		JPanel jp = new JPanel();
		jp.add(centerPane);
		return jp;
	}

	public static JPanel getWestPanel() {
		JPanel controlPanel = new JPanel(new GridLayout(6, 1));
		JPanel westPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.weighty = 1;
	
		 controlPanel.add(setWestPanelBtns("	Add Booking  ", new AddRoomBookingHandler()));
		 controlPanel.add(setWestPanelBtns("      Display Day Booking      ", new DisplayDayHndler()));
		 controlPanel.add(setWestPanelBtns("    Display & Change Existing Booking    ", new DisChangeBtnHnlder()));
		 controlPanel.add(setWestPanelBtns("   Backup Booking to File  ", new BackUpBookingHndlr()));
//		 controlPanel.add(setWestPanelBtns("      Loading Bookins to File      ", new RandomizeList()));
//		 controlPanel.add(setWestPanelBtns("   Exit  ", new RoomBookingHandler()));
		
		
		//JTextArea tf = new JTextArea(scheduler.displayDayBookings(temCal));
		//tf.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		//controlPanel.add(tf);
		
		
		westPanel.add(controlPanel, gbc);
		return westPanel;
	}

	private static String calString(Calendar cal) {

		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy ");
		String dateStr = sdf.format(cal.getTime());
		return dateStr;
	}
	private static Calendar getCurrentCal() {
		Calendar cal = Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.DATE);
		//int hour=cal.get(Calendar.HOUR);
		
		cal.set(year, month, day, 0, 0);
		
		return cal;
	}
	private static JButton setWestPanelBtns(String btnLabel, ActionListener act) {
		final Font font = new Font("SansSerif", Font.PLAIN, 20);
		JButton btn = new JButton(btnLabel);
		btn.setFont(font);
		btn.addActionListener(act);
		return btn;
	}

	// Adapted from: https://www.mkyong.com/swing/java-swing-jfilechooser-example/
//	private static File getFileFromUser(String fileName) {
//		File f = null;
//		JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		fc.setFileFilter(new FileNameExtensionFilter(".txt Files", "txt"));	
//		do {
//			int returnValue = fc.showOpenDialog(null);
//			if (returnValue == JFileChooser.APPROVE_OPTION) {
//				f = fc.getSelectedFile();
//				if (FileIO.fileExists(f))
//					return f;
//			} else if (returnValue == JFileChooser.CANCEL_OPTION)
//				return null;
//		} while (true);
//	}

//	public static ArrayList<String> getListOfStrings() {
//		return listOfStrings;
//	}
//
	public static String readDayBooking(Calendar cal ) {
		String s = " ";
		ArrayList<String> displayOutput = scheduler.displayDayBookings(cal);
		for(int i = 0; i < displayOutput.size();i++) {
			s += displayOutput.get(i) +"\n";
		}
		return s;
	}
	public static void reloadJTextArea(Calendar cal) {
		scrollText.removeAll();
		scrollText.repaint();
		scrollText.setText(readDayBooking(cal));
		scrollText.revalidate();
	}
	
	private static class BackUpBookingHndlr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(scheduler.saveBookingToFile()) {
				JOptionPane.showMessageDialog(null,
					    "Current room bookings backed up to file");
			}

		}

	}
}

