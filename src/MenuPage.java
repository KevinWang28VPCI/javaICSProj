import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MenuPage extends JFrame implements ActionListener// adds JLabels to home screen + buttons
{
	private JLabel label; // global variable
	private JButton buttonInfo; // global variable
	private JButton buttonAttendance;
	private JButton buttonGrades;
	private JPanel contentPane;
	private JButton exitButton;
	private JButton back;
	private String account;
	
	public MenuPage(String title, String account)
	{
		super(title);
		setLayout(null);
				
		this.account = account;
		
		Classroom classroom = new Classroom(account);
		
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
		
		
		label = new JLabel("Menu Page/Options" , JLabel.CENTER);
		label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		label.setBounds(295, 50, 334, 50);
		contentPane.add(label);
		
		buttonInfo = new JButton("Add Info");
		buttonInfo.setForeground(Color.DARK_GRAY);
		buttonInfo.setVerticalAlignment(SwingConstants.TOP);
		buttonInfo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		buttonInfo.setBounds(74, 140, 192, 175);
		buttonInfo.addActionListener(this);
		
		buttonInfo.setOpaque(false);
		buttonInfo.setContentAreaFilled(false);
		buttonInfo.setBorderPainted(false);
		
		contentPane.add(buttonInfo);
		
		buttonAttendance = new JButton("Attendance");
		buttonAttendance.setVerticalAlignment(SwingConstants.TOP);
		buttonAttendance.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		buttonAttendance.setBounds(355, 140, 192, 175);
		buttonAttendance.addActionListener(this);
		
		buttonAttendance.setOpaque(false);
		buttonAttendance.setContentAreaFilled(false);
		buttonAttendance.setBorderPainted(false);

		contentPane.add(buttonAttendance);
		
		buttonGrades = new JButton("Student Grades");
		buttonGrades.setVerticalAlignment(SwingConstants.TOP);
		buttonGrades.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		buttonGrades.setBounds(646, 140, 192, 175);
		buttonGrades.addActionListener(this);
		
		buttonGrades.setOpaque(false);
		buttonGrades.setContentAreaFilled(false);
		buttonGrades.setBorderPainted(false);

		contentPane.add(buttonGrades);
		
		exitButton = new JButton("Exit");
		exitButton.setVerticalAlignment(SwingConstants.TOP);
		exitButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		exitButton.addActionListener(this);
		exitButton.setBounds(30, 20, 90, 67);

		exitButton.setOpaque(false);
		exitButton.setBorderPainted(false);
		
		contentPane.add(exitButton);
		
		back = new JButton("<Back");
		back.setFont(new Font("Serif", Font.BOLD, 15));
		back.setBackground(Color.GRAY);
		back.setBounds(10 , 420 , 105 , 30);
		back.addActionListener(this);
		contentPane.add(back);

	}
	

	public String getName()
	{
		return this.account;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == buttonInfo)
		{
			AddInfo frame = new AddInfo("Add Student Info" , getName());
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			
			frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		    frame.pack();
		    frame.setSize( 950, 500 );
		    frame.setLocationRelativeTo(null);
		    
		    frame.setVisible( true );
			this.dispose();
		}
		
		if (e.getSource() == buttonAttendance) 
		{
			Attendance frame = new Attendance("Attendance" , getName());
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setSize(950, 500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			this.dispose();
		}
		
		if (e.getSource() == buttonGrades)
		{
			Grades grades = new Grades();
			grades.runGrades();
		}
		
		if (e.getSource() == back)
		{
			LoginPage login = new LoginPage();
			login.loadLoginPage();
			this.dispose();
		}
	}
}

