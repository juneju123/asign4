package cst8284.asgmt4.roomScheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisChangeBtnHnlder implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		RoomBookingDialog.showAppointmentDialog();
		RoomBookingDialog.name.setEditable(false);
		RoomBookingDialog.number.setEditable(false);
		RoomBookingDialog.endTime.setEditable(false);
		RoomBookingDialog.category.setEditable(false);
		RoomBookingDialog.description.setEditable(false);
		RoomBookingDialog.organization.setEditable(false);;
		RoomBookingDialog.getSaveBtn().setEnabled(false);
		RoomBookingDialog.getDeleteBtn().setEnabled(false);
	}

}
