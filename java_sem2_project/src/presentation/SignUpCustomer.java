package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class SignUpCustomer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7007779926126466611L;
	private JPanel contentPane;
	private JTextField textUserName;
	private JTextField textPassword;
	private JTextField textEmail;
	private JTextField textPhone;
	private JTextField textAddress;
	private JTextField textCoupon;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpCustomer frame = new SignUpCustomer();
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
	public SignUpCustomer() {
		setTitle("Customer Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("Username");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setBounds(46, 29, 162, 33);
		contentPane.add(lblFirstName);
		
		textUserName = new JTextField();
		textUserName.setBounds(251, 32, 162, 27);
		contentPane.add(textUserName);
		textUserName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(46, 73, 162, 33);
		contentPane.add(lblNewLabel);
		
		textPassword = new JTextField();
		textPassword.setBounds(251, 76, 162, 27);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(46, 117, 162, 27);
		contentPane.add(lblNewLabel_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(251, 117, 162, 27);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(46, 155, 162, 33);
		contentPane.add(lblPhoneNumber);
		
		textPhone = new JTextField();
		textPhone.setBounds(251, 158, 162, 27);
		contentPane.add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(46, 245, 162, 33);
		contentPane.add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(251, 245, 162, 44);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username = textUserName.getText().toString();
				String Password = textPassword.getText().toString();
				String Email = textEmail.getText().toString();
				String Phone = textPhone.getText().toString();
				String Address = textAddress.getText().toString();

				
				if (Username.equals("")) {
					JOptionPane.showMessageDialog(null, "Username is mendatory.");
					textUserName.requestFocus();
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
				
				
				else{
					if (isValidData()) 
					{
						business.Person driver = new business.Person(
								1,
								Password,
								Email,
								Phone,
								18,
								Address,
								"coupons");
						person.PersonDAO dDAO = data.DAOFactory.getPersonDAO();
						if (dDAO.addPerson(driver))
						{
							//String result = "Name : " + firstName + " " + lastName + "\n" + "Age : " + age + "\n" + "Gender : "
							//		+ gender;

							JOptionPane.showMessageDialog(null,"Customer Data Saved");
							CustomerFrame cs = new CustomerFrame();
							cs.setVisible(true);
						}
					}
				}
			}
		});
		btnSignUp.setMnemonic('S');
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				CustomerFrame cs = new CustomerFrame();
				cs.setVisible(true);
			}
		});
		btnSignUp.setBounds(533, 89, 220, 63);
		contentPane.add(btnSignUp);
		
		JButton btnExit = new JButton("Clear");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUserName.setText(null);
				textPassword.setText(null);
				textPhone.setText(null);
				textEmail.setText(null);
				textAddress.setText(null);
				textCoupon.setText(null);
				spinner.setValue(0);
			}
		});
		
		btnExit.setBounds(533, 204, 220, 63);
		contentPane.add(btnExit);
		
		JLabel lblCoupons = new JLabel("Coupons*");
		lblCoupons.setBounds(46, 318, 180, 33);
		contentPane.add(lblCoupons);
		
		textCoupon = new JTextField();
		textCoupon.setBounds(251, 318, 162, 33);
		contentPane.add(textCoupon);
		textCoupon.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Note: *  Field is optional ");
		lblNewLabel_2.setBounds(46, 379, 381, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(46, 199, 162, 19);
		contentPane.add(lblAge);
		
	    spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 90, 1));
		spinner.setBounds(249, 196, 164, 27);
		contentPane.add(spinner);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 832, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmPreviousPage = new JMenuItem("Previous menu");
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
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmExit.setMnemonic('E');
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		JMenu mnVersion = new JMenu("About");
		mnVersion.setMnemonic('A');
		mnVersion.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnVersion);
		
		JMenuItem mntmVersion = new JMenuItem("Version");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application Version is 2020.01 ");
			}
		});
		mntmVersion.setMnemonic('V');
		mntmVersion.setMnemonic(KeyEvent.VK_V);
		mnVersion.add(mntmVersion);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		mnHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnHelp);
		
		JMenuItem mntmCheckFprUpdate = new JMenuItem("Check for Update");
		mntmCheckFprUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This is the latest version of Application");
			}
		});
		mntmCheckFprUpdate.setMnemonic('U');
		mntmCheckFprUpdate.setMnemonic(KeyEvent.VK_U);
		mnHelp.add(mntmCheckFprUpdate);
		
		JMenuItem mntmContribute = new JMenuItem("Developer Info");
		mntmContribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Developed by Vijaykumar Thakar and Karan Gajjar.");
			}
		});
		mntmContribute.setMnemonic('D');
		mntmContribute.setMnemonic(KeyEvent.VK_D);
		mnHelp.add(mntmContribute);
		
	}
	public boolean isValidData() 
	{
		if (!business.Validator.isPresent(textUserName, "First Name"))
			return false;
		
		if (!business.Validator.isPresent(textPassword, "Last Name"))
			return false;
		
		return true;
	}
}
