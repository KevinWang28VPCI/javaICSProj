import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import java.util.*;

public class Classroom{
	private String classroomName;
	private char key = 'Q';
	private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	private ArrayList<Student> students = new ArrayList<Student>();

	public void updateClassroom() { // method to iterate through all the classroom student files and put them into
									// the arraylist of the teachers and students, put this into the constructor
		
		File teacherData = new File("classroom/" + classroomName + "/teacher/");
		File studentData = new File("classroom/" + classroomName + "/student/");

		File[] studentDataListing = studentData.listFiles();
		File[] teacherDataListing = teacherData.listFiles();

		// maybe turn into try/catch?
		if (!teacherData.exists()) {
			teacherData.mkdirs();
			System.out.println("Directory created");
		} else {
			System.out.println("Directory already exists");

		}
		if (!studentData.exists()) {
			studentData.mkdirs();
			System.out.println("Directory created");
		} else {
			System.out.println("Directory already exists");

		}

		// traverse through student files
		if (studentDataListing != null) {
			for (File child : studentDataListing) {
				if (child.getName().toLowerCase().endsWith(".txt")) {
					try {
						String fileName = child.getName();
						BufferedReader reader = new BufferedReader(new FileReader(fileName));
						String line = reader.readLine();
						String unencrypted = Xorcrypt(key, line);
						String[] studentarr = unencrypted.split("\\s+"); // white space regex
						Student student = new Student(studentarr[0], studentarr[1], studentarr[2], studentarr[3]);
						// add to attendence

						addStudent(student);
						File attendance = new File("classroom/" + classroomName + "/attendance/" + studentarr[0] + ".txt");
						
						if (!attendance.exists()) {
							attendance.mkdirs();
							System.out.println("Directory created");
						} else {
							System.out.println("Directory already exists");

						}
						
						

					} catch (IOException ex) {
						System.out.println("error");
					}

				} else {
					System.out.println("file not txt file!");
				}
			}

			// traverse through the teacher files
			if (teacherDataListing != null) {
				for (File child : teacherDataListing) {
					if (child.getName().toLowerCase().endsWith(".txt")) {
						try {
							String fileName = child.getName();
							BufferedReader reader = new BufferedReader(new FileReader(child));
							String line = reader.readLine();
							String unencrypted = Xorcrypt(key, line);
							String[] teacherarr = unencrypted.split("\\s+"); // white space regex
							Teacher teacher = new Teacher(teacherarr[0], teacherarr[1], teacherarr[2], teacherarr[3]);

							addTeacher(teacher);


						} catch (IOException ex) {
							System.out.println("error");
						}

					}

					else {
						System.out.println("file not a txt file");
					}

				}

			}
		}

	}

	public String Xorcrypt(char key, String message) {
		char xorKey = key;
		String outputString = "";
		int len = message.length();

		for (int i = 0; i < len; i++) {
			outputString = outputString + Character.toString((char) ((char) message.charAt(i) ^ xorKey));
		}

		return outputString;
	}

	public void updateAttendance(Student student, String status) {
		String name = student.name;
		File attendanceData = new File("classroom/" + classroomName + "/attendance/" + student.name + ".txt");
		try {
			BufferedWriter grade = new BufferedWriter(new FileWriter(attendanceData, true)); // true to append content to the
																						// file
			grade.write("\n");
			grade.write(status);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public Classroom(String classroomName) {
		this.classroomName = classroomName;
		updateClassroom();
	}

	public void removeStudent(String name) {
		File studentData = new File("classroom/" + classroomName + "/student/");
		File[] studentDataListing = studentData.listFiles();
		boolean deleted = false;
		if (studentDataListing != null) {
			for (File child : studentDataListing) {
				String fileName = child.getName();
				if (fileName.equals(name + ".txt")) {
					File deleteFile = new File(name + ".txt");

					if (deleteFile.delete()) {
						deleted = true;
						System.out.println("Deleted the file");
					} else {
						System.out.println("error has occured");
					}
				}
			}
		}

		if (!deleted) {
			System.out.println("error finding file");
		}
	}

	/**
	 * @return
	 */
	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}

	public void addGrade(Student student, int mark, int identifier) {
		String fileName = "classroom/" + classroomName + "/student/" + student.name + ".txt";
		try {
			BufferedWriter grade = new BufferedWriter(new FileWriter(fileName, true)); // true to append content to the
																						// file
			grade.write("\n");
			grade.write(mark + " " + identifier);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void removeGrade(Student student, int identifier) {
		File fileName = new File("classroom/" + classroomName + "/student/" + student.name + ".txt");
		File tempFile = new File("classroom/" + classroomName + "/student/" + student.name + "Temp" + ".txt");

		String id = Integer.toString(identifier);

		try {
			BufferedReader grade = new BufferedReader(new FileReader(fileName));
			BufferedWriter temp = new BufferedWriter(new FileWriter(tempFile));
			String line = grade.readLine();
			while (line != null) {
				String[] placeHolder = line.split(" ");
				if (placeHolder[1] == id) {
					continue;
				}

				temp.write(line + "/n");
				line = grade.readLine();
			}

			grade.close();
			temp.close();
			fileName.delete();
			tempFile.renameTo(fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
		// create the data folder for the teacher
		try {
			File teacherData = new File("classroom/" + classroomName + "/teacher/" + teacher.name + ".txt");
			if (teacherData.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");

			}
		} catch (IOException e) {
			System.out.println("Error creating file");
		}

		try {
			BufferedWriter teacherText = new BufferedWriter(
					new FileWriter("classroom/" + classroomName + "/teacher/" + teacher.name + ".txt"));
			String encTeacherData = Xorcrypt(key, (String) (teacher.specialty + " " + teacher.phoneNumber + " "
					+ teacher.name + " " + teacher.address));
			teacherText.write(encTeacherData);
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
			File studentData = new File("classroom/" + classroomName + "/student/" + student.name + ".txt");
			if (studentData.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");

			}
		} catch (IOException e) {
			System.out.println("Error creating file");
		}

		try {
			BufferedWriter studentText = new BufferedWriter(
					new FileWriter("classroom/" + classroomName + "/student/" + student.name + ".txt"));
			String encStudentText = Xorcrypt(key,
					(String) (student.id + " " + student.grade + " " + student.name + " " + student.address));
			studentText.write(encStudentText);
			studentText.close();
		} catch (IOException e) {
			System.out.println("Wrote student object");
			e.printStackTrace();
		}
		
		try {
			File attendanceData = new File("classroom/" + classroomName + "/attendance/" + student.name + ".txt");
			if (attendanceData.createNewFile()) {
				System.out.println("File Created");
			} else {
				System.out.println("File Already Created");
				}
			}
		
		catch(IOException e) {
			System.out.println("Error");
		}


	}

	/**
	 * @return
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}
}
