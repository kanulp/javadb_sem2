package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class DriverFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5116041250801147938L;
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverFrame frame = new DriverFrame();
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
	public DriverFrame() {
		setTitle("DriverLogin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmPreviousMenu = new JMenuItem("Main Page");
		mntmPreviousMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CabMainFrame cm = new CabMainFrame();
				cm.setVisible(true);
				
			}
		});
		mntmPreviousMenu.setMnemonic('P');
		mntmPreviousMenu.setMnemonic(KeyEvent.VK_P);
		mnFile.add(mntmPreviousMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mntmExit.setMnemonic('E');
		mntmExit.setMnemonic(KeyEvent.VK_E);
		mnFile.add(mntmExit);
		
		JMenu mnAbout = new JMenu("About");
		mnAbout.setMnemonic('A');
		mnAbout.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnAbout);
		
		JMenuItem mntmVersion = new JMenuItem("Version");
		mntmVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Application Version is 2020.01 ");
			}
		});
		mntmVersion.setMnemonic('V');
		mntmVersion.setMnemonic(KeyEvent.VK_V);
		mnAbout.add(mntmVersion);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		mnHelp.setMnemonic(KeyEvent.VK_H);
		menuBar.add(mnHelp);
		
		JMenuItem mntmCheckForUpdate = new JMenuItem("Check for update");
		mntmCheckForUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This is the latest version of Application");
			}
		});
		mntmCheckForUpdate.setMnemonic('U');
		mntmCheckForUpdate.setMnemonic(KeyEvent.VK_U);
		mnHelp.add(mntmCheckForUpdate);
		
		JMenuItem mntmDeveloperInfo = new JMenuItem("Developer Info");
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
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setDisplayedMnemonic(KeyEvent.VK_U);
		lblUsername.setLabelFor(textUsername);
		lblUsername.setIcon(new ImageIcon(DriverFrame.class.getResource("/driver.png")));
		lblUsername.setBounds(140, 104, 209, 76);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setDisplayedMnemonic(KeyEvent.VK_P);
		lblPassword.setLabelFor(textUsername);
		lblPassword.setIcon(new ImageIcon(DriverFrame.class.getResource("/password.png")));
		lblPassword.setBounds(140, 207, 209, 80);
		contentPane.add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(379, 122, 271, 40);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(379, 227, 271, 40);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username = textUsername.getText().toString();
				String Password = textPassword.getText().toString();
				
				if (Username.equals("")) {
					JOptionPane.showMessageDialog(null, "Username is mendatory.");
				}
				else if (Password.equals("")) {
					JOptionPane.showMessageDialog(null,"Password is mendatory");
				}
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				DriverMain dm = new DriverMain();
				dm.setVisible(true);
			}
		});
		btnLogin.setMnemonic('L');
		btnLogin.setBounds(305, 333, 164, 49);
		contentPane.add(btnLogin);
	}

}
