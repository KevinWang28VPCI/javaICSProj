import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Add text to tell user if student has been properly created
 * Check to see if all fields have been filled before creating a student
 */

public class AddTeacher extends JFrame implements ActionListener
{
	JLabel label, created;
	JButton addInfo, remove;
	JTextField name, specialty, number, address;
	private String account;
	
	AddTeacher(String title , String account)
	{
		super(title);
		this.account = account;
		setLayout(null);
		
		//MenuPage menuPage = new MenuPage(null, null);
		//System.out.println(menuPage.getName());
		
		label = new JLabel("Enter Teacher information");
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
		
		label = new JLabel("Enter specialty:");
		label.setBounds(40 , 90 , 100 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);
		
		specialty = new JTextField();
		specialty.setBounds(140 , 90 , 100 , 20);
		add(specialty);
		
		label = new JLabel("Enter address:");
		label.setBounds(40 , 130 , 150 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);
		
		address = new JTextField();
		address.setBounds(140 , 130 , 100 , 20);
		add(address);
		
		label = new JLabel("Enter phone number:");
		label.setBounds(40 , 170 , 150 , 20);
		label.setFont(new Font("Serif", Font.BOLD, 13));
		add(label);

		number = new JTextField();
		number.setBounds(170 , 170 , 100 , 20);
		add(number);
		
		addInfo = new JButton ("Add");
		addInfo.setBounds(40 , 210 , 75 , 30);
		addInfo.setBackground(Color.GRAY);
		addInfo.addActionListener(this);
		add(addInfo);
		
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
		// TODO Auto-generated method stub
		

		if (e.getSource() == addInfo)
		{
			String teacherName = name.getText();
			String teacherSpecialty = specialty.getText();
			String teacherAddress = address.getText();
			String teacherNumber = number.getText();
			
			
			if (teacherName.equals("") || teacherSpecialty.equals("") || teacherAddress.equals("") || teacherNumber.equals(""))
			{
				created.setText("Enter all fields of text");
			}
			
			else
			{
				created.setText("");

				Teacher teacher = new Teacher(name.getText() , address.getText() , specialty.getText(), number.getText());
				
				Classroom classroom = new Classroom(getName());
				classroom.addTeacher(teacher);
				classroom.updateClassroom();
				
				created.setText("Teacher Succesfully created!");
				created.setForeground(Color.GREEN);
				
				name.setText("");
				specialty.setText("");
				address.setText("");
				number.setText("");
			}
		}
	}
}


