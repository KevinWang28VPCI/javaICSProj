import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* resources used
 * get current date and time copied from: https://www.tutorialspoint.com/how-to-get-today-s-date-in-java8
 * JTable guide - https://www.youtube.com/watch?v=wniqpx8OQxo&t=242s
 */

public class Attendance extends JFrame implements ActionListener {
	private JButton button;
	private JLabel created;
	private JComboBox box;
	private JTable table;
	private ArrayList<String> presence = new ArrayList();
	private DefaultTableModel model;
	private String account;

	public Attendance(String title, String account) {
		super(title);
		setLayout(new BorderLayout());
		this.account = account;
		
		ArrayList<String> names = new ArrayList();

		Classroom classroom = new Classroom(account);
		classroom.updateClassroom();
		System.out.println(classroom.getStudents());
		
		System.out.println(account);
		
		names.add("a");
		names.add("b");
		names.add("C");
		names.add("a");
		names.add("C");
		names.add("a");

		String[] options = { "Present", "Late", "Absent" };
		box = new JComboBox(options);

		String col[] = { "Name", "Presence" }; // column headers
		Object data[][] = {}; // no data for now

		model = new DefaultTableModel(data, col); // table with size data and column
		table = new JTable(model);

		for (int start = 0; start < names.size(); start++) {
			// Append a row
			model.addRow(new Object[] { names.get(start) }); // add info to rows
			// put this inside the loop for bufferedReader to easily create new columns
		}

		TableColumn testColumn = table.getColumnModel().getColumn(1);
		testColumn.setCellEditor(new DefaultCellEditor(box));

		table.setRowHeight(50);

		table.setPreferredScrollableViewportSize(new Dimension(700, 500));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table); // can scroll

		add(scrollPane);

		button = new JButton("Finish Selection");
		button.setBackground(Color.GRAY);
		button.addActionListener(this);
		button.setFont(new Font("Serif", Font.BOLD, 15));
		add(button, BorderLayout.PAGE_END);

		Date date = new Date();
		String dateFormatString = "EEEEEEE, MMMMMMMM dd, yyyy";
		DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		String currentDate = dateFormat.format(date);

		JLabel label = new JLabel(currentDate);
		label.setFont(new Font("Serif", Font.BOLD, 15));
		add(label, BorderLayout.PAGE_START);

		System.out.println("Current date: " + currentDate);

		created = new JLabel("");
		created.setFont(new Font("Serif", Font.BOLD, 15));
		add(created, BorderLayout.WEST);
	}
	
	public String getName()
	{
		return this.account;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try
		{
			if (e.getSource() == button) {
				System.out.println("Click");
				for (int i = 0; i < model.getRowCount(); i++) {
					presence.add(model.getValueAt(i, 1).toString());
				}

				System.out.println(presence);

				button.setEnabled(false);
				System.out.println("no more click");

				created.setText("Attendance Finished");
				created.setForeground(Color.GREEN);
			}
		}
		
		catch(NullPointerException err) {
			
			System.out.println(err.getMessage());
			created.setText("Select prescence");
		}
		
	}
}
