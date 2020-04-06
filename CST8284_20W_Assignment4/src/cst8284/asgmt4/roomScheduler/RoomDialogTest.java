package cst8284.asgmt4.roomScheduler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;

public class RoomDialogTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomDialogTest frame = new RoomDialogTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RoomDialogTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton addBookingBtn = new JButton("Add Booking");
		GridBagConstraints gbc_addBookingBtn = new GridBagConstraints();
		gbc_addBookingBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_addBookingBtn.insets = new Insets(0, 0, 5, 5);
		gbc_addBookingBtn.gridx = 1;
		gbc_addBookingBtn.gridy = 1;
		contentPane.add(addBookingBtn, gbc_addBookingBtn);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 2;
		gbc_textArea.gridheight = 5;
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 2;
		gbc_textArea.gridy = 1;
		contentPane.add(textArea, gbc_textArea);
		
		JButton displayBookingsBtn = new JButton("Display Exisiting Booking");
		GridBagConstraints gbc_displayBookingsBtn = new GridBagConstraints();
		gbc_displayBookingsBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_displayBookingsBtn.insets = new Insets(0, 0, 5, 5);
		gbc_displayBookingsBtn.gridx = 1;
		gbc_displayBookingsBtn.gridy = 2;
		contentPane.add(displayBookingsBtn, gbc_displayBookingsBtn);
		
		JButton backupBtn = new JButton("Backup bookings to file");
		GridBagConstraints gbc_backupBtn = new GridBagConstraints();
		gbc_backupBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_backupBtn.insets = new Insets(0, 0, 5, 5);
		gbc_backupBtn.gridx = 1;
		gbc_backupBtn.gridy = 3;
		contentPane.add(backupBtn, gbc_backupBtn);
		
		JButton loadBtn = new JButton("Loading bookings from File");
		GridBagConstraints gbc_loadBtn = new GridBagConstraints();
		gbc_loadBtn.insets = new Insets(0, 0, 5, 5);
		gbc_loadBtn.gridx = 1;
		gbc_loadBtn.gridy = 4;
		contentPane.add(loadBtn, gbc_loadBtn);
		
		JButton exitBtn = new JButton("Exit");
		GridBagConstraints gbc_exitBtn = new GridBagConstraints();
		gbc_exitBtn.insets = new Insets(0, 0, 0, 5);
		gbc_exitBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_exitBtn.gridx = 1;
		gbc_exitBtn.gridy = 5;
		contentPane.add(exitBtn, gbc_exitBtn);
	}

}
