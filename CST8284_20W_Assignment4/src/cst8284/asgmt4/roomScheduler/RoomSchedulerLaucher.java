/*File name:[RoomSchedulerLaucher .java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[instantiate a room object.instantiate a RoomScheduler object] 
*/ 
package cst8284.asgmt4.roomScheduler;
import cst8284.asgmt4.room.*;

/**
 * 
 * @author:Ziyue Wang
 * @version 1.0
*/
public class RoomSchedulerLaucher {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			new RoomScheduler(new ComputerLab()).launch();}
		});
	

}
}
