import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

class theGrades extends JFrame implements ActionListener
{
	JTable table;
	JTextField assignmentText , removeText;
	JButton addAssignment;
	JButton finish , remove;
	ArrayList<String> assignmentNames = new ArrayList();
	ArrayList<Double> grades = new ArrayList();
	ArrayList<Double> studentAverage = new ArrayList();
	JLabel label;
	DefaultTableModel model;
	
	theGrades(String title)
	{
		super(title);
		
		assignmentNames.add("1");
		assignmentNames.add("2");
		assignmentNames.add("3");
		assignmentNames.add("1");
		assignmentNames.add("2");
		assignmentNames.add("3");
		
		setLayout(new FlowLayout(0 , 6 , 15));
		
		model = new DefaultTableModel();
		table = new JTable(model);
			
		model.addColumn("Assignment");

		for (int start = 0; start < assignmentNames.size(); start++)
		{			
			model.addColumn(assignmentNames.get(start));
		}
		
		//model.addRow(new Object[] {"Average Mark"});

		
		table.setRowHeight(70);

		new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	    table.setPreferredScrollableViewportSize(new Dimension(900 , 350));
	    table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table); // can scroll
		
		add(scrollPane);

		addAssignment = new JButton ("Add Assignment");
		addAssignment.setBackground(Color.GRAY);
		addAssignment.addActionListener(this);
		addAssignment.setFont(new Font("Serif", Font.BOLD, 17));
		add(addAssignment);
		
		assignmentText = new JTextField();
		assignmentText.setPreferredSize(new Dimension(150 , 35));
		add(assignmentText);
		
		remove = new JButton("Remove Assignment");
		remove.setBackground(Color.GRAY);
		remove.addActionListener(this);
		remove.setFont(new Font("Serif" , Font.BOLD , 17));
		add(remove);
		
		removeText = new JTextField();
		removeText.setPreferredSize(new Dimension(180 , 35));
		add(removeText);
		
		label = new JLabel("");
		label.setPreferredSize(new Dimension(250 , 35));
		add(label);
		
		finish = new JButton("Calculate Averate");
		finish.setBackground(Color.GRAY);
		finish.addActionListener(this);
		finish.setFont(new Font("Serif" , Font.BOLD, 17));
		add(finish);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		try
		{
			int count = 0;
			
			if (e.getSource() == addAssignment)
			{
				if (assignmentText.getText().equals(""))
				{
					label.setText("Input name");
				}
				
				else
				{
					model.addRow(new Object[] {assignmentText.getText()});
					assignmentText.setText("");
					label.setText("Added Assignment!");
				}
			}
			
			if (e.getSource() == remove)
			{
				
				if (removeText.getText().equals("Average Mark"))
				{
					label.setText("Invalid to remove");
				}
				
				else
				{
					for (int start = 1; start < model.getRowCount(); start++)
					{
						if (table.getModel().getValueAt(start , 0).equals(removeText.getText()))
						{
							((DefaultTableModel)table.getModel()).removeRow(start);
							assignmentNames.remove(removeText.getText());
							System.out.println(assignmentNames);
							label.setText("Removed Assignment!");
						}
					}
				}
				
				removeText.setText("");

			}
			
			if (e.getSource() == finish)
			{
				
				// get grades from row
				for (int i = 1; i < model.getColumnCount(); i++)
				{
					for (int j = 0; j < model.getRowCount(); j++)
					{
						Double grade = Double.valueOf(model.getValueAt(j , i).toString());
						grades.add(grade);

					}
				}
				
				System.out.println(grades);

				// add column for student averages
				model.addRow(new Object[] {"Average"});
				
				int counter = 0;
				double averages = 0;
				
				// calculate the students averages
				for (int one = 0; one < grades.size(); one++)
				{
					counter ++;
					averages += grades.get(one);
					//System.out.println("Grade " + averages);
					if ((counter % (model.getRowCount() - 1)) == 0)
					{
						studentAverage.add(averages / (model.getRowCount() - 1));
						System.out.println(averages / (model.getRowCount() - 1));
						averages = 0;
					}
				}
					
				System.out.println("Rows" + (model.getRowCount() - 1));
				
				// display
				int counter2 = 0;
				for (int l = 1; l < model.getColumnCount(); l++)
				{
					model.setValueAt(studentAverage.get(counter2) , model.getRowCount() - 1 , l);	
					counter2 ++;
				}
					
			}
		}
		
		catch(NumberFormatException err)
		{
			err.getMessage();
			label.setText("Use number for grades");
		}
		
		catch(IndexOutOfBoundsException err)
		{
			err.getMessage();
			label.setText("Enter in all fields");
		}

	}
}
public class Grades {

	public void runGrades()
	{
		theGrades frame = new theGrades("Student Grades");
		frame.getContentPane().setBackground(Color.WHITE);
		
	    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	    frame.pack();
	    frame.setSize(1070 , 550);
	    frame.setLocationRelativeTo(null);
	    
	    frame.setVisible( true );
		
	}
}
