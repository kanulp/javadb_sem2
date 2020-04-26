package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DriverMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2018077826786410343L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverMain frame = new DriverMain();
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
	public DriverMain() {
		setTitle("Driver ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmHome = new JMenuItem("Main Page");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CabMainFrame cm = new CabMainFrame();
				cm.setVisible(true);
			}
		});
		mntmHome.setMnemonic('M');
		mntmHome.setMnemonic(KeyEvent.VK_M);
		mnFile.add(mntmHome);
		
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
		
		JButton btnRide = new JButton("Ride");
		btnRide.setBounds(10, 25, 124, 30);
		contentPane.add(btnRide);
		
		JButton btnNotification = new JButton("Notification");
		btnNotification.setBounds(10, 82, 124, 30);
		contentPane.add(btnNotification);
		
		JButton btnRecent = new JButton("Recent rides");
		btnRecent.setBounds(10, 143, 124, 30);
		contentPane.add(btnRecent);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.setBounds(10, 201, 124, 30);
		contentPane.add(btnFeedback);
		
		JButton btnIssues = new JButton("Issues");
		btnIssues.setBounds(10, 259, 124, 30);
		contentPane.add(btnIssues);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(10, 316, 124, 30);
		contentPane.add(btnHelp);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(226, 48, 498, 315);
		contentPane.add(textPane);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(10, 367, 124, 30);
		contentPane.add(btnExit);
	}		
		
}
