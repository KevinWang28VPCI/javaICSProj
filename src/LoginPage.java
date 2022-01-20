import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

// things to add with the login screen
//	- make it so that a user cannot be created if the user name is the same as a previously stored user name

/*
 *  Resources used: 
 *  	https://beginnersbook.com/2015/07/java-swing-tutorial/  - (Simple login screen for beginners)
 */
public class LoginPage extends JFrame implements ActionListener {
	private String encryptedUser;
	private static JTextField userNameText, userPassText;
	private static JButton login, createUser;
	private static JLabel correctLogin;
	private JFrame loginFrame = new JFrame("User Login");
	private JPanel loginPanel = new JPanel();
	private JButton back;

	private char key = 'P';

	/**
	 * Xor algorithm(exclusive or) encryption algorithm. Works the same with
	 * encryption and decryption
	 * 
	 * @param key:     The key to encrypt/decrypt with the message with
	 * @param message: the string to encrypt/decrypt
	 * @return: the encrypted/decrypted string
	 */
	
	public String Xorcrypt(char key, String message) {
		char xorKey = key;
		String outputString = "";
		int len = message.length();

		for (int i = 0; i < len; i++) {
			outputString = outputString + Character.toString((char) message.charAt(i) ^ xorKey);
		}

		return outputString;
	}

	public LoginPage() {

		JLabel loginTitle = new JLabel("Login to Student Manager", JLabel.CENTER); // label
		loginTitle.setFont(new Font("Ariel", Font.BOLD, 35)); // font type and size
		loginTitle.setBounds(150, 0, 600, 75);
		loginPanel.add(loginTitle); // adds

		JLabel userName = new JLabel("User Name: ");
		userName.setFont(new Font("Ariel", Font.BOLD, 20)); // font type and size
		userName.setBounds(50, 130, 175, 25);
		loginPanel.add(userName);

		userNameText = new JTextField(10); // gets users input
		userNameText.setBounds(175, 132, 165, 25); // set bounds
		loginPanel.add(userNameText); // adds the text box

		JLabel userPass = new JLabel("Password: "); // label
		userPass.setFont(new Font("Ariel", Font.BOLD, 20)); // font type and size
		userPass.setBounds(50, 10, 900, 400);
		loginPanel.add(userPass); // adds label

		userPassText = new JPasswordField(10); // text box
		userPassText.setBounds(175, 199, 165, 25); // set bound
		loginPanel.add(userPassText); // adds text box

		login = new JButton("Login"); // login button
		login.setBounds(50, 249, 105, 25);
		login.addActionListener(this); // what happens when action is performed
		loginPanel.add(login); // adds button on panel

		createUser = new JButton("Create User"); // button to create new user
		createUser.setBounds(185, 249, 105, 25);
		createUser.addActionListener(this);
		loginPanel.add(createUser);

		correctLogin = new JLabel("");
		correctLogin.setBounds(50, 100, 300, 25);
		loginPanel.add(correctLogin);

		JLabel createUser = new JLabel(
				"*To create a new account enter a user name and a password then press the Create User button");
		createUser.setBounds(50, 400, 600, 30);
		loginPanel.add(createUser);
		
	}

	
	// buttons events if clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {

			// create bufferedWriter to write to user/pass files
			BufferedWriter userNames = new BufferedWriter(new FileWriter("User Names.txt", true));
			BufferedWriter passwords = new BufferedWriter(new FileWriter("Passwords.txt", true));

			// create bufferedReader to read to user/pass files
			BufferedReader readUsers = new BufferedReader(new FileReader("User Names.txt"));
			BufferedReader readPasswords = new BufferedReader(new FileReader("Passwords.txt"));

			boolean sameUser = false;
			String line1, line2, line3;

			// changed two lines - global within this section?
			// this way is able to check if encrypted user is same as already stored(encrypted user)
			String newEncryptedUser = Xorcrypt(key, userNameText.getText());
			
			if (e.getSource() == createUser) {

				if ((userNameText.getText().equals("") || userPassText.getText().equals(""))) // if no info in text
																								// boxes
				{
					correctLogin.setText("Please enter information in both fields"); // ask user to enter
					correctLogin.setForeground(Color.DARK_GRAY);
				}

				else {

					while ((line3 = readUsers.readLine()) != null) // goes through username file
					{
						if (line3.equals(newEncryptedUser)) // if line is same as the entered (encrypted) username
						{
							sameUser = true;
							break; // escape loop
						}
					}

					if (sameUser) {
						correctLogin.setText("this user name has already been taken"); // ask user to enter
						correctLogin.setForeground(Color.DARK_GRAY);
					}

					else if (sameUser == false) // writing
					{

						String newEncryptedPass = Xorcrypt(key, userPassText.getText());

						userNames.write(newEncryptedUser); // inputs the username in the username text file
						passwords.write(newEncryptedPass); // inputs the password in the password text file

						userNames.newLine();
						passwords.newLine();

						correctLogin.setText("Account succesfully created"); // ask user to enter
						correctLogin.setForeground(Color.GREEN);

					}

				}

			}

			if (e.getSource() == login) // if user has pressed the login button
			{
				// set user and pass to false
				boolean pass = false;
				boolean user = false;

				// counters set to 0
				int count1 = 0;
				int count2 = 0;

				if (userNameText.getText().equals("") || userPassText.getText().equals("")) // if both fields are blank
																							// prompt user for info
				{
					correctLogin.setText("Please enter information in both fields");
					correctLogin.setForeground(Color.DARK_GRAY); // text color to dark gray
				}

				else // if both text fields have info
				{
					while ((line1 = readUsers.readLine()) != null) // goes through username file
					{
						count1 += 1; // count 1 for each line read through
						encryptedUser = Xorcrypt(key, userNameText.getText());
						if (line1.equals(encryptedUser)) // if line is same as the entered username
						{
							user = true; // user = true
							break; // escape loop
						}
					}

					while ((line2 = readPasswords.readLine()) != null) // read through until nothing
					{
						count2 += 1; // count 1 for each line read

						if (count2 == count1) // if line read is equal to the line in username file where the correct
												// username was found
						{
							String encryptedPass = Xorcrypt(key, userPassText.getText());
							if (line2.equals(encryptedPass)) // check if the entered pass is the same as the
																// stored pass
							{
								pass = true; // set to true
								break; // out of loop
							}
						}
					}

					if ((user == true) && (pass == true)) // both true
					{
						correctLogin.setText("Correct Login Information"); // logged in
						correctLogin.setForeground(Color.green);
						
						MenuPage frame = new MenuPage("Menu Page", encryptedUser );
					    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
					    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					    frame.pack();
					    frame.setSize( 950, 500 );
					    frame.setLocationRelativeTo(null);    
					    frame.setVisible( true );
					    loginFrame.dispose();
					    

					}

					else 
					{
						System.out.println(count1 + "is not equal to " + count2); // not logged in
						correctLogin.setText("Incorrect Login Information");
						correctLogin.setForeground(Color.red);
					}

					count1 = 0; // re-set the counters
					count2 = 0;
				}
			}

			// closes BufferedReaders and BufferedWriters
			userNames.close();
			passwords.close();
			readUsers.close();
			readPasswords.close();
		}

		catch (IOException err) // catch error
		{
			System.out.println("Error " + err.getMessage()); // prints error
		}
	}

	public void loadLoginPage() {
		

		loginPanel.setBackground(Color.WHITE);

		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // just hide the frame

		loginFrame.pack();
		loginFrame.setSize(950, 500); // set size of screen
		loginFrame.setLocationRelativeTo(null); // screen will be in middle

		loginPanel.setLayout(null); // no defined setLayout
		loginFrame.add(loginPanel); // adds panel onto frame
		
		loginFrame.setVisible(true);

	}
}