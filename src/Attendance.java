import java.awt.*;
import javax.swing.*;

public class Attendance {

	public static void main (String[] args) //runAttendance()
	{
		
		JFrame attendanceFrame = new JFrame("Menu");
		JPanel attendancePanel = new JPanel();
		
		attendancePanel.setBackground(Color.WHITE);
		attendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		attendancePanel.setLayout(null);
		
		attendanceFrame.pack();
		attendanceFrame.setSize(950 , 500);
		attendanceFrame.setLocationRelativeTo(null);
		
		attendanceFrame.add(attendancePanel);
		
		attendanceFrame.setVisible(true);
		
	}
}
