import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class Teacher extends Person {
	protected String specialty;
	protected String phoneNumber;

	/**
	 * Creates a new Teacher Object
	 * 
	 * @param name
	 * @param address
	 * @param specialty
	 * @param phoneNumber
	 */
	public Teacher(String name, String address, String specialty, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.specialty = specialty;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
    @Override
    public String toString() {
        return "Name of the Teacher: " + name;
    }
}
