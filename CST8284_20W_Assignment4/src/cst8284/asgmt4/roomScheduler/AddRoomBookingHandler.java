package cst8284.asgmt4.roomScheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomBookingHandler implements ActionListener {
	//RoomBookingDialog r = new RoomBookingDialog();
	@Override
	public void actionPerformed(ActionEvent e) {
		//r.dispose();;
        
		//RoomBookingDialog mf = new RoomBookingDialog();
		/*javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {*/
				RoomBookingDialog.showAppointmentDialog();
				RoomBookingDialog.getSearchBtn().setEnabled(false);
				
			}
		//});
	}


