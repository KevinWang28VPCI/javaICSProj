import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuPage extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAttendence;
	private JButton btnStudent;
	private JLabel lblNewLabel;
	private JButton btnClassList;
	private JButton btnTeacher;
	private JButton btnMarks;

	public void runMenuPage() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.LIGHT_GRAY);
		setTitle("School Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAttendence = new JButton("Attendance");
		btnAttendence.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));

		btnAttendence.setBounds(109, 140, 158, 82);
		contentPane.add(btnAttendence);
		
		btnStudent = new JButton("Add Student");
		btnStudent.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));

		btnStudent.setBounds(315, 140, 301, 82);
		contentPane.add(btnStudent);
		
		lblNewLabel = new JLabel("Menu Page/ Options");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 54));
		lblNewLabel.setBounds(295, 50, 334, 50);
		contentPane.add(lblNewLabel);
		
		btnMarks = new JButton("Marks");

		btnMarks.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnMarks.setBounds(109, 273, 158, 82);
		contentPane.add(btnMarks);
		
		JButton btnClassList = new JButton("Main Menu");

		btnClassList.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnClassList.setBounds(679, 273, 158, 82);
		contentPane.add(btnClassList);
		
		btnClassList = new JButton("Class List");
		btnClassList.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnClassList.setBounds(679, 150, 158, 82);
		contentPane.add(btnClassList);
		
		btnTeacher = new JButton("Add Teacher");
		btnTeacher.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnTeacher.setBounds(315, 273, 301, 82);
		contentPane.add(btnTeacher);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {


	}

}
