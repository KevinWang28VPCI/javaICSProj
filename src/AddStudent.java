import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddStudent extends JFrame implements ActionListener
{
	private JButton add, remove;
	private JLabel label, created;
	private JTextField name,grade,id,address;
	private String account;
	
	public AddStudent(String title , String account)
	{
		super(title);
		
		setLayout(null);
		this.account = account;
		label = new JLabel("Enter student information");
		label.setBounds(100 , 0 , 200 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 17));
		add(label);
		
		label = new JLabel("Enter name:");
		label.setBounds(40 , 50 , 100 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);
		
		name = new JTextField();
		name.setBounds(120 , 50 , 100 , 20);
		add(name);
		
		label = new JLabel("Enter Grade:");
		label.setBounds(40 , 90 , 100 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);
		
		grade = new JTextField();
		grade.setBounds(120 , 90 , 100 , 20);
		add(grade);
		
		label = new JLabel("Enter id:");
		label.setBounds(40 , 130 , 150 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);
		
		id = new JTextField();
		id.setBounds(100 , 130 , 100 , 20);
		add(id);
		
		label = new JLabel("Enter Address:");
		label.setBounds(40 , 170 , 150 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);
		
		address = new JTextField();
		address.setBounds(130 , 170 , 100 , 20);
		add(address);
		
		add = new JButton ("Add");
		add.setBounds(40 , 210 , 75 , 30);
		add.setBackground(Color.GRAY);
		add.addActionListener(this);
		add(add);
		
		remove = new JButton ("Remove");
		remove.setBounds(120 , 210 , 110 , 30);
		remove.setBackground(Color.GRAY);
		remove.addActionListener(this);
		add(remove);
		
		created = new JLabel("");
		created.setBounds(40 , 235 , 250 , 30);
		add(created);
	}


	public String getName()
	{
		return this.account;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try
		{
			
			if (e.getSource() == add)
			{
			

				String studentName = name.getText();
				String studentGrade = grade.getText();
				String studentID = id.getText();
				String studentAddress = address.getText();
				
				int studentGrades = Integer.valueOf(grade.getText());
				int studentIDS = Integer.valueOf(id.getText());
				
				if (name.getText().equals("") || grade.getText().equals("") || id.getText().equals("") || address.getText().equals(""))
				{
					created.setText("Enter all fields of text");
				}
					
				
				else
				{
					created.setText("");
					
					Student student = new Student(studentID , studentGrade , studentName , studentAddress);
					Classroom classroom = new Classroom(getName());
					classroom.addStudent(student);
					classroom.updateClassroom();
					
					System.out.println(student);
					
					created.setText("Student Succesfully created!");
					created.setForeground(Color.GREEN);
					
					name.setText("");
					grade.setText("");
					id.setText("");
					address.setText("");
				}
				
			}	
			
			if (e.getSource() == remove)
			{
				Classroom classroom = new Classroom(getName());
				classroom.removeStudent(name.getText());
				
				created.setText("Removed Student");
			}
		}
		
		catch(NumberFormatException err)
		{
			System.out.println(err.getMessage());
			created.setText("Invalid Grade or Student ID");
		}
	}
}


