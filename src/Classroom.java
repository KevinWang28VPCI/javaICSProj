import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.util.*;

public class Classroom {
	private String classroomName;
	private char key = 'Q';
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public void updateClassroom() { // method to iterate through all the classroom student files and put them into the arraylist of the teachers and students, put this into the constructor
		File teacherData = new File("\\" + classroomName + "\\teacher\\" );
		File studentData = new File("\\" + classroomName + "\\teacher\\" );

		File 
		
		
	}
	
	
	public String Xorcrypt(char key, String message) {
		char xorKey = key;
		String outputString = "";
		int len = message.length();
		
		for(int i = 0; i < len; i++) {
			outputString = outputString + Character.toString((char)message.charAt(i) ^ xorKey);
		}
		
		return outputString;
	}
	
	public Classroom(String classroomName) {
		this.classroomName = classroomName;
	}
	
	/**
	 * @return
	 */
	public ArrayList<Teacher> getTeachers(){
		return teachers;
	}
	
    /**
     * @param teacher
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
		// create the data folder for the teacher
		try {
			File teacherData = new File("\\" + classroomName + "\\teacher\\" + teacher.name + ".txt");
			if (teacherData.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");

			}
		}
		catch(IOException e) {
			System.out.println("Error creating file");
		}
		
		
		try {
			BufferedWriter teacherText = new BufferedWriter(new FileWriter("\\classroom\\" + teacher.name + ".txt"));
			String encStudentData = Xorcrypt(key, (String) (teacher.specialty + " " + teacher.phoneNumber + " " + teacher.name + " " + teacher.address));
			teacherText.write(encStudentData);
			teacherText.close();
		} catch (IOException e) {
			System.out.println("Wrote student object");
			e.printStackTrace();
		}
        
    }
	
    /**
     * @param student
     */
    public void addStudent(Student student) {
        students.add(student);
        
		// create the data folder for the student
		try {
			File studentData = new File("\\" + classroomName + "\\student\\" + student.name + ".txt");
			if (studentData.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");

			}
		}
		catch(IOException e) {
			System.out.println("Error creating file");
		}
		
		
		try {
			BufferedWriter studentText = new BufferedWriter(new FileWriter("\\classroom\\" + student.name + ".txt"));
			String encStudentText = Xorcrypt(key, (String) (student.id + " " + student.grade + " " + student.name + " " + student.address));
			studentText.write(encStudentText);
			studentText.close();
		} catch (IOException e) {
			System.out.println("Wrote student object");
			e.printStackTrace();
		}
		
    }
	
    /**
     * @return
     */
    public ArrayList<Student> getStudents() {
        return students;
    }
}
