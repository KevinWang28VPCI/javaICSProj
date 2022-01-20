import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// add column stating if person is student or teacher, display teachers first then students
class theDisplay extends JFrame
{
	JTable table;
	JLabel label;
	
	theDisplay(String title)
	{
		super(title);
		
	    String col[] = { "Name", "Grade", "ID" }; // column headers
	    Object data[][] = {}; // no data for now
	    
		DefaultTableModel model = new DefaultTableModel(data , col); // table with size data and column 
		JTable table = new JTable(model); 


		// directly get information from bufferedWriter reading from files dont have to put in arrayList
		ArrayList<String> names = new ArrayList();
		ArrayList<String> id = new ArrayList();
		ArrayList<String> grade = new ArrayList();

		// code segment to add information into arralists, just for demo purposed right now
		names.add("a"); 
		names.add("b");
		names.add("c");
		
		id.add("1"); 
		id.add("2");
		id.add("3");
		
		grade.add("10"); 
		grade.add("9");
		grade.add("8");
		
		names.add("a"); 
		names.add("b");
		names.add("c");
		
		id.add("1"); 
		id.add("2");
		id.add("3");
		
		grade.add("10"); 
		grade.add("9");
		grade.add("8");
		
		names.add("a"); 
		names.add("b");
		names.add("c");
		
		id.add("1"); 
		id.add("2");
		id.add("3");
		
		grade.add("10"); 
		grade.add("9");
		grade.add("8");
		
		names.add("a"); 
		names.add("b");
		names.add("c");
		
		id.add("1"); 
		id.add("2");
		id.add("3");
		
		grade.add("10"); 
		grade.add("9");
		grade.add("8");
		
		names.add("a"); 
		names.add("b");
		names.add("c");
		
		id.add("1"); 
		id.add("2");
		id.add("3");
		
		grade.add("10"); 
		grade.add("9");
		grade.add("8");
		
		names.add("a"); 
		names.add("b");
		names.add("c");
		
		id.add("1"); 
		id.add("2");
		id.add("3");
		
		grade.add("10"); 
		grade.add("9");
		grade.add("8");
		

		// add rows to the JTable according to the amount of students there are 
		for (int start = 0; start < id.size(); start++)
		{
			// Append a row 
			model.addRow(new Object[] {names.get(start) ,id.get(start),grade.get(start)}); // add info to rows
			// put this inside the loop for bufferedReader to easily create new columns
		}

	     table.setRowHeight(25); // each row is 25 pix
	     table.setEnabled(false); // not editable

		JScrollPane scrollPane = new JScrollPane(table); // can scroll
		add(scrollPane); // add table to JFrame
	}
}

public class Display {

	public void runDisplay()
	{
		theDisplay frame = new theDisplay("Student Information");
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
	    frame.pack();
	    frame.setSize( 450 , 300 );
	    frame.setLocationRelativeTo(null);
	    
	    frame.setVisible( true );
				
	}
	
}
