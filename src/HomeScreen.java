import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
 *  Resources used:
 *  	https://chortle.ccsu.edu/java5/Notes/chap60/ch60_1.html (CHAPTER 60 — Swing JTextFields and JLabels)
 */

class MyFrame extends JFrame implements ActionListener // adds JLabels to home screen + buttons
{
	private JPanel contentPane;
	private JLabel schoolTitle;
	private JLabel txtAuthor;
	private JLabel txtCourse;
	private JLabel txtTeacher;
	private JLabel lblVersion;
	private JButton btnStart;

	public MyFrame() {
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

		schoolTitle = new JLabel("School Management System");
		schoolTitle.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 37));
		schoolTitle.setBounds(215, 100, 490, 60);
		contentPane.add(schoolTitle);

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnStart.setBounds(350, 170, 185, 75);
		contentPane.add(btnStart);


		txtAuthor = new JLabel("Author: Kevin and Piali");
		txtAuthor.setBounds(10, 335, 200, 20);
		contentPane.add(txtAuthor);

		txtCourse = new JLabel("Course: ICS3U7 - 02");
		txtCourse.setBounds(10, 360, 120, 20);
		contentPane.add(txtCourse);

		txtTeacher = new JLabel();
		txtTeacher.setText("Teacher: Ms. Xie");
		txtTeacher.setBounds(10, 385, 120, 20);
		contentPane.add(txtTeacher);

		lblVersion = new JLabel("Version: 2020-01-02");
		lblVersion.setBounds(10, 10, 200, 15);
		contentPane.add(lblVersion);
		
		
		btnStart.addActionListener(this);
		
	}

		

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStart) {
			LoginPage loginPage = new LoginPage();
			loginPage.loadLoginPage();
			this.dispose();
			
		}
		
	}

}

public class HomeScreen {
	public static void main(String[] args) {
		Initialization();
		
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
	}

	/**
	 * This Checks if the username and password files are already created, if they
	 * aren't, then create them
	 *
	 */
	public static void Initialization() {
		try {
			File users = new File("User Names.txt");
			File passes = new File("Passwords.txt");
			String classDir = "classroom";
			File file = new File(classDir);

			if (users.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");

			}

			if (passes.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");

			}

			if (!file.exists()) {
				file.mkdirs();
				System.out.println("Directory classroom created");
			} else {
				System.out.println("Directory already exists");

			}

		}

		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}

