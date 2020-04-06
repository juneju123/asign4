package cst8284.asgmt4.roomScheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayDayHndler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DisplayDayBookingDialog.showAppointmentDialog();

	}

}
