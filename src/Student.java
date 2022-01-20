import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import java.util.*;

/**
 * This class is the base for the students in a classroom
 * This takes care of the students name, id, grades etc.
 * @author Kevin Wang
 *
 */
public class Student extends Person {
	protected String id;
	protected String grade;
	protected ArrayList<Double> marks = new ArrayList<Double>();
	protected ArrayList<Boolean> presence = new ArrayList<Boolean>();

	/**
	 * @param id: The student id of the student
	 * @param grade: The grade of the student
	 * @param name: The name of the student:
	 * @param address: The address of the student
	 */
	public Student(String studentarr, String studentarr2, String name, String address) {
		this.id = studentarr;
		this.grade = studentarr2;
		this.name = name;
		this.address = address;
		
	}

	/**
	 * Gets the mark at a specific index
	 * @param x: index to get the mark at
	 * @return: The mark at the given index
	 */
	public double GetMarks(int x) {
		return marks.get(x);
	}
	
	public void AddMark(double x) {
		marks.add(x);
	}

	/**
	 * Adds all the average marks up and divides by the number of marks to find the average mark
	 * @return: average mark of the student
	 */
	public double GetAverageMark() {
		double sum = 0;
		if (!marks.isEmpty()) {
			for (Double mark : marks) {
				sum += mark;
			}
			return sum / marks.size();
		}
		
		return sum;

	}
	
	/**
	 * @return
	 */
	public String GetPresence() {
		int here = 0;
		String response = "";

		for (Boolean present: presence) {
	        if (present.booleanValue()) {
	            here++;
	        }
		}
		response = "Student has been present " + here + "times " + ", and absent " + (presence.size() - here) ; 
		return response;
		
	}
	
	/**
	 * @param a
	 */
	public void addPresence(boolean a) {
		presence.add(a);
	}
	
    @Override
    public String toString() {
        return "Student's name : " + name;
    }

}

