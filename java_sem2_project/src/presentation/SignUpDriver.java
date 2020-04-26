package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

public class SignUpDriver extends JFrame {

	private static final long serialVersionUID = -7375105576939219626L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textAddress;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textCarModel;
	private JTextField textCarNumber;
	private JButton btnSignUp;
	private JButton btnExit;
	private JLabel lblAge;
	private JSpinner spinner;
	private JLabel lblLicenceNumber_1;
	private JTextField textLicence;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmPreviousPage;
	private JMenuItem mntmExit;
	private JMenu mnAbout;
	private JMenuItem mntmVersion;
	private JMenu mnHelp;
	private JMenuItem mntmCheckForUpdate;
	private JMenuItem mntmDeveloperInfo;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpDriver frame = new SignUpDriver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SignUpDriver() {
		setTitle("Driver Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		mntmPreviousPage = new JMenuItem("Previous Page");
		mntmPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUpFrame su = new SignUpFrame();
				su.setVisible(true);
			}
		});
		mntmPreviousPage.setMnemonic('P');
		mntmPreviousPage.setMnemonic(KeyEvent.VK_P);
		mnFile.add(mntmPreviousPage);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmExit.setMnemonic('E');
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		mnAbout = new JMenu("About");
		mnAbout.setMnemonic('A');
		mnAbout.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnAbout);
		
		mntmVersion = new JMenuItem("Version");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application Version is 2020.01 ");
			}
		});
		mntmVersion.setMnemonic('V');
		mntmVersion.setMnemonic(KeyEvent.VK_V);
		mnAbout.add(mntmVersion);
		
		mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		mnHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnHelp);
		
		mntmCheckForUpdate = new JMenuItem("Check for update");
		mntmCheckForUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This is the latest version of Application");
			}
		});
		mntmCheckForUpdate.setMnemonic('U');
		mntmCheckForUpdate.setMnemonic(KeyEvent.VK_U);
		mnHelp.add(mntmCheckForUpdate);
		
		mntmDeveloperInfo = new JMenuItem("Developer Info");
		mntmDeveloperInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Developed by Vijaykumar Thakar and Karan Gajjar.");
			}
		});
		mntmDeveloperInfo.setMnemonic('D');
		mntmDeveloperInfo.setMnemonic(KeyEvent.VK_D);
		mnHelp.add(mntmDeveloperInfo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("Username");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(89, 11, 126, 26);
		contentPane.add(lblFirstName);
		
		textUsername = new JTextField();
		textUsername.setBounds(235, 11, 203, 26);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblLastname = new JLabel("Password");
		lblLastname.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastname.setBounds(89, 48, 126, 26);
		contentPane.add(lblLastname);
		
		textPassword = new JTextField();
		textPassword.setBounds(235, 48, 203, 26);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setBounds(89, 218, 126, 26);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(235, 212, 203, 38);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblLicenceNumber = new JLabel("Email");
		lblLicenceNumber.setBounds(89, 85, 126, 26);
		contentPane.add(lblLicenceNumber);
		
		textEmail = new JTextField();
		textEmail.setBounds(235, 85, 203, 26);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblCarNumber = new JLabel("Phone Number");
		lblCarNumber.setBounds(89, 122, 126, 26);
		contentPane.add(lblCarNumber);
		
		textPhone = new JTextField();
		textPhone.setBounds(235, 125, 203, 26);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblCarNumber_1 = new JLabel("Car Model");
		lblCarNumber_1.setBounds(89, 297, 126, 26);
		contentPane.add(lblCarNumber_1);
		
		textCarModel = new JTextField();
		textCarModel.setBounds(235, 300, 203, 26);
		contentPane.add(textCarModel);
		textCarModel.setColumns(10);
		
		JLabel lblExperience = new JLabel("Car Number Plate");
		lblExperience.setBounds(89, 334, 126, 26);
		contentPane.add(lblExperience);
		
		textCarNumber = new JTextField();
		textCarNumber.setBounds(235, 334, 203, 26);
		contentPane.add(textCarNumber);
		textCarNumber.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Experience");
		lblPhoneNumber.setBounds(89, 371, 126, 26);
		contentPane.add(lblPhoneNumber);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = textUsername.getText().toString();
				String Password = textPassword.getText().toString();
				String Email = textEmail.getText().toString();
				String Phone = textPhone.getText().toString();
				String Address = textAddress.getText().toString();
				String CarModel = textCarModel.getText().toString();
				String CarNumberPlate = textCarNumber.getText().toString();
				String Licence = textLicence.getText().toString();
				
				if (Username.equals("")) {
					JOptionPane.showMessageDialog(null, "Username is mendatory.");
					textUsername.requestFocus();

				}
				else if (Password.equals("")) {
					JOptionPane.showMessageDialog(null,"Password is mendatory");
					textPassword.requestFocus();
				}
				else if (Email.equals("")) {
					JOptionPane.showMessageDialog(null,"Email is mendatory");
					textEmail.requestFocus();

				}
				else if (Phone.equals("")) {
					JOptionPane.showMessageDialog(null,"Phone is mendatory");
					textPhone.requestFocus();
				}
				else if (Address.equals("")) {
					JOptionPane.showMessageDialog(null,"Address is mendatory");
					textAddress.requestFocus();

				}
				else if (Licence.equals("")) {
					JOptionPane.showMessageDialog(null,"Licence is mendatory");
					textLicence.requestFocus();
				}
				else if (CarModel.equals("")) {
					JOptionPane.showMessageDialog(null,"Car Model is mendatory");
					textCarModel.requestFocus();
				}
				else if (CarNumberPlate.equals("")) {
					JOptionPane.showMessageDialog(null,"Number plate Number is mendatory");
					textCarNumber.requestFocus();
				}
				
				
				else{
					
					if (isValidData()) 
					{

						business.Driver driver = new business.Driver(Username,Password,Email,Phone,1, Address,CarModel,CarNumberPlate,Licence,"exp");
						driver.DriverDAO dDAO = data.DAOFactory.getDriverDAO();
						if (dDAO.addDriver(driver))
						{
							//String result = "Name : " + firstName + " " + lastName + "\n" + "Age : " + age + "\n" + "Gender : "
							//		+ gender;
							JOptionPane.showMessageDialog(null, "Driver Data is saved\n" + "ss", " Save Person",
									JOptionPane.INFORMATION_MESSAGE);

							DriverFrame dv = new DriverFrame();
							dv.setVisible(true);
						}
					}
					
					
				}
				
			}
		});
		
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				DriverFrame dv = new DriverFrame();
				dv.setVisible(true);
			}
		});
		btnSignUp.setBounds(535, 119, 195, 51);
		contentPane.add(btnSignUp);
		
		btnExit = new JButton("Clear");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textUsername.setText(null);
				textPassword.setText(null);
				textPhone.setText(null);
				textEmail.setText(null);
				textAddress.setText(null);
				textCarModel.setText(null);
				textCarNumber.setText(null);
				textLicence.setText(null);
				spinner.setValue(18);
				comboBox.setSelectedIndex(0);
				driver.DriverDAO dDAO = data.DAOFactory.getDriverDAO();

				String targetName = textUsername.getText();
				if (targetName.length() > 0) 
				{
					business.Driver driver = dDAO.getDriver(targetName);

					if (dDAO != null) 
					{
						textPassword.setText(driver.getPassword());
						textPhone.setText(driver.getPhoneNumber());
						textEmail.setText(driver.getEmail());
//						if (driver.getGender().equalsIgnoreCase("Male"))
//							rdMale.setSelected(true);
//						else
//							rdFemale.setSelected(true);
						
						//spinAge.setValue(person.getAge());
					}
					
				   else 
						JOptionPane.showMessageDialog(null, textUsername.getText() + " is not found", "Find Person",JOptionPane.INFORMATION_MESSAGE);
				} 
				
			   else  
			   {
				//displayArea.setText("");
				   String myData = "";
				ArrayList<business.Driver> drivers = dDAO.getDrivers();
				
				for (business.Driver p : drivers) 
				   {
					myData += p.getUserName() + " " + p.getPassword() + " " + p.getPhoneNumber() + " " + p.getEmail()+ " "+p.getAddress()+" "+p.getCarModel()+" "+p.getCarModel()+" "+p.getCarNumberPlate()+" "+p.getExperience() +"\n";
					
				   }
				JOptionPane.showMessageDialog(null, "Driver Data is saved\n" + myData, " Save Driver",
						JOptionPane.INFORMATION_MESSAGE);

			   }
				
			}
		});
		btnExit.setBounds(535, 221, 195, 48);
		contentPane.add(btnExit);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(89, 165, 126, 26);
		contentPane.add(lblAge);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		spinner.setBounds(235, 165, 203, 26);
		contentPane.add(spinner);
		
		lblLicenceNumber_1 = new JLabel("Licence Number");
		lblLicenceNumber_1.setBounds(89, 259, 126, 27);
		contentPane.add(lblLicenceNumber_1);
		
		textLicence = new JTextField();
		textLicence.setBounds(235, 262, 203, 27);
		contentPane.add(textLicence);
		textLicence.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItem("Fresher");
		comboBox.addItem("1 Year");
		comboBox.addItem("2 Year");
		comboBox.addItem("More than 2 year");
		comboBox.setBounds(235, 371, 203, 26);
		contentPane.add(comboBox);
	}
	public boolean isValidData() 
	{
		if (!business.Validator.isPresent(textUsername, "First Name"))
			return false;
		
		if (!business.Validator.isPresent(textPassword, "Last Name"))
			return false;
		
		return true;
	}
}
