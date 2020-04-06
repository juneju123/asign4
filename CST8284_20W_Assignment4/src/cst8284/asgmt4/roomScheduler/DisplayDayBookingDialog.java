package cst8284.asgmt4.roomScheduler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Toolkit;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import cst8284.asgmt4.room.ComputerLab;
import cst8284.asgmt4.room.Room;
public class DisplayDayBookingDialog {
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
	private static final JTextArea scrollText = new JTextArea();
	private static JButton searchBtn, exitBtn;
	public static JTextField date;
	private static String txtDate;
	private static final Toolkit tk = Toolkit.getDefaultToolkit();
	private static final Dimension screenSize = tk.getScreenSize();
	public static void showAppointmentDialog() {
		cp.removeAll();
		cp.repaint();
		JFrame f = new JFrame("");
		cp.setLayout(new GridBagLayout());
		int screenY = (int) (screenSize.getHeight() / 2);
		
		// Set the first seven rows with Label/TextField
		
		date = setRow("Enter Booking Date (DDMMYYYY):", 'e');
		f.getContentPane().add(getCenterPanel(scrollText, screenY), BorderLayout.CENTER);

		// Load the buttons across the bottom
		btnPanel.removeAll();//remove and repaint panel whenever needs to reload the panel
		btnPanel.repaint();
		btnPanel.setLayout(btnRow);
		setSearchBtn(setBtnRow("   Search   ", 'r'));
		setExitBtn(setBtnRow("    Exit    ", 'x'));
		btnPanel.revalidate();
		//getBtnAction();

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
	public static JButton getSearchBtn() {
		return searchBtn;
	}
	public static void setSearchBtn(JButton searchBtn) {
		DisplayDayBookingDialog.searchBtn = searchBtn;
	}
	public static JButton getExitBtn() {
		return exitBtn;
	}
	public static void setExitBtn(JButton exitBtn) {
		DisplayDayBookingDialog.exitBtn = exitBtn;
	}
	public static void setTxtDate(String date) {
		DisplayDayBookingDialog.txtDate = date;
	}
	public static String getTxtDate() {
		return txtDate;
	}
	public static JPanel getCenterPanel(JTextArea jta, int height) {
		JScrollPane centerPane = new JScrollPane(jta);
		centerPane.setPreferredSize(new Dimension(400, 7 * height / 8));
		JPanel jp = new JPanel();
		jp.add(centerPane);
		return jp;
	}
	public static String readDayBooking(Calendar cal) {
		String s = " ";
		for(int i = 0; i < RoomScheduler.displayDayBookings(cal).size();i++) {
			s += RoomScheduler.displayDayBookings(cal).get(i) +"\n";
		}
		return s;
	}
	public static void reloadJTextArea(Calendar cal) {
		scrollText.removeAll();
		scrollText.repaint();
		scrollText.setText(readDayBooking(cal));
		scrollText.revalidate();
		}
		
	private static class SearchBtnHndler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setTxtDate(date.getText());
			Calendar cal = RoomScheduler.makeCalendarFromUserInput(getTxtDate(), "0");
			RoomSchedulerDialog.reloadJTextArea(cal);
			

}
	}
}
