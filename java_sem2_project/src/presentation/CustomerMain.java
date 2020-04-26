package presentation;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class CustomerMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -118810907464937208L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMain frame = new CustomerMain();
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
	public CustomerMain() {
		setTitle("Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmMainPage = new JMenuItem("Main Page");
		mntmMainPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CabMainFrame cm = new CabMainFrame();
				cm.setVisible(true);
			}
		});
		mntmMainPage.setMnemonic('M');
		mntmMainPage.setMnemonic(KeyEvent.VK_M);
		mnFile.add(mntmMainPage);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGetARide = new JButton("Get a ride");
		btnGetARide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnGetARide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnGetARide.getText().toString();
				
			}
		});
		btnGetARide.setBounds(10, 25, 106, 29);
		contentPane.add(btnGetARide);
		
		JButton btnNotification = new JButton("Notification");
		btnNotification.setBounds(10, 75, 106, 29);
		contentPane.add(btnNotification);
		
		JButton btnRideHistory = new JButton("Ride History");
		btnRideHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRideHistory.setBounds(10, 124, 106, 29);
		contentPane.add(btnRideHistory);
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.setBounds(10, 175, 106, 29);
		contentPane.add(btnPayment);
		
		JButton btnPromos = new JButton("Promos");
		btnPromos.setBounds(10, 221, 106, 29);
		contentPane.add(btnPromos);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(10, 305, 106, 29);
		contentPane.add(btnHelp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(10, 351, 106, 29);
		contentPane.add(btnExit);
		
		JButton btnReview = new JButton("Review");
		btnReview.setBounds(10, 261, 106, 29);
		contentPane.add(btnReview);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(165, 25, 615, 344);
		contentPane.add(textPane);
		
	}
}
