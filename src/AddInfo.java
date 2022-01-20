import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class AddInfo extends JFrame implements ActionListener
{
	JLabel label;
	JButton addTeacher;
	JButton addStudent;
	JButton displayInfo;
	JButton back;
	private String account;
	
	public AddInfo(String title , String account)
	{
		super(title);
		this.account = account;
		setLayout(null);
		
		label = new JLabel("Add Student and Teacher Information");
		label.setBounds(175, 10 , 580 , 50);
		label.setFont(new Font("Serif", Font.BOLD, 35));
		add(label);
		
		addTeacher = new JButton("Add Teacher");
		addTeacher.setFont(new Font("Serif", Font.BOLD, 15));
		addTeacher.setBounds(400 , 100 , 140 , 40);
		addTeacher.setBackground(Color.GRAY);
		addTeacher.addActionListener(this);
		add(addTeacher);
		
		addStudent = new JButton("Add Student");
		addStudent.setFont(new Font("Serif", Font.BOLD, 15));
		addStudent.setBounds(400 , 175 , 140 , 40);
		addStudent.setBackground(Color.GRAY);
		addStudent.addActionListener(this);
		add(addStudent);
		
		displayInfo = new JButton("See Information");
		displayInfo.setFont(new Font("Serif", Font.BOLD, 15));
		displayInfo.setBounds(400 , 250 , 140 , 40);
		displayInfo.setBackground(Color.GRAY);
		displayInfo.addActionListener(this);
		add(displayInfo);
		
		back = new JButton("<Back");
		back.setFont(new Font("Serif", Font.BOLD, 15));
		back.setBackground(Color.GRAY);
		back.setBounds(10 , 420 , 105 , 30);
		back.addActionListener(this);
		add(back);
	}	

	public String getName()
	{
		return this.account;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == addTeacher)
		{
			System.out.println(getName());
			AddTeacher frame = new AddTeacher("Add a Teacher" , getName());
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
		    frame.pack();
		    frame.setSize(400 , 300);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible( true );
		}
		
		if (e.getSource() == addStudent)
		{
			AddStudent frame = new AddStudent("Add Student Information" , getName());
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
			frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
		    frame.pack();
		    frame.setSize(400 , 300);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible( true );
		}
		
		if (e.getSource() == displayInfo)
		{
			Display display = new Display();
			display.runDisplay();
		}
		
	}
}

