import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Is the base class for the student and teacher classes
 * @author Kevin Wang
 */

public class Person {
	public String name;
	public int age;
	protected String address;
	
	/**
	 * returns the name of the person
	 * @return name of the person
	 */
	public String GetName() {
		return name;
	}
	
	/**
	 * Xor algorithm(exclusive or) encryption algorithm. Works the same with encryption and decryption
	 * @param key: The key to encrypt/decrypt with the message with
	 * @param message: the string to encrypt/decrypt
	 * @return: the encrypted/decrypted string
	 */
	
	public String Xorcrypt(char key, String message) {
		char xorKey = key;
		String outputString = "";
		int len = message.length();
		
		for(int i = 0; i < len; i++) {
			outputString = outputString + Character.toString((char)message.charAt(i) ^ xorKey);
		}
		
		return outputString;
	}
	
	/**
	 * returns the address of the person
	 * @return address of the person
	 */
	public String GetAddress() {
		return address;
	}
	
	
	/**
	 * returns the age of the person
	 * @return age of the person
	 */
	public int getAge() {
		return age;
	}
}
