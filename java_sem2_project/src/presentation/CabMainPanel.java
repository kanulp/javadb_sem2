package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CabMainPanel extends JPanel{
	
	
public CabMainPanel() {

		JPanel personGUI = new JPanel(new GridLayout(5, 2));
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JLabel lblSystem = new JLabel("System");
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblSystem.setForeground(Color.WHITE);
		lblSystem.setBounds(114, 213, 125, 42);
		this.add(lblSystem);
		
		JLabel lblCabManagementSystem = new JLabel("Cab Management");
		lblCabManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabManagementSystem.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblCabManagementSystem.setForeground(Color.WHITE);
		lblCabManagementSystem.setBounds(76, 133, 213, 136);
		this.add(lblCabManagementSystem);
		
		JLabel circle = new JLabel("");
		circle.setBackground(Color.WHITE);
		circle.setIcon(new ImageIcon(getClass().getResource("/circle3.png")));
		circle.setHorizontalAlignment(SwingConstants.CENTER);
		circle.setBounds(50, 70, 273, 280);
		this.add(circle);
		
		JLabel bgColor = new JLabel("");
		bgColor.setBackground(Color.LIGHT_GRAY);
		bgColor.setOpaque(true);
		bgColor.setBounds(0, 0, 374, 429);
		this.add(bgColor);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//this.dispose();
				//SignUp su = new SignUp();
				//su.setVisible(true);
			    
			}
		});
		btnSignUp.setIcon(new ImageIcon(getClass().getResource("/sign_up.png")));
		btnSignUp.setFont(new Font("Arial", Font.BOLD, 20));
		btnSignUp.setBounds(426, 51, 363, 73);
		this.add(btnSignUp);
		
		JButton btnDriver = new JButton("Driver");
		btnDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose();
				//Driver dv = new Driver();
				//dv.setVisible(true);
			}
		});
		btnDriver.setIcon(new ImageIcon(getClass().getResource("/driver.png")));
		btnDriver.setFont(new Font("Arial", Font.BOLD, 20));
		btnDriver.setBounds(426, 165, 363, 73);
		this.add(btnDriver);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//dispose();
				//Customer cs = new Customer();
				//cs.setVisible(true);
		
			}
		});
		btnCustomer.setIcon(new ImageIcon(getClass().getResource("/customer.png")));
		btnCustomer.setFont(new Font("Arial", Font.BOLD, 20));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCustomer.setBounds(426, 282, 363, 73);
		this.add(btnCustomer);
		
		JMenuBar menuBar = new JMenuBar();
		//setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
		
		JMenuItem mntmCheckForUpdate = new JMenuItem("Check for Update");
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
	}
	
}
