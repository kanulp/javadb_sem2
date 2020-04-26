package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame frame = new SignUpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUpFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 848, 468);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmPreviousMenu = new JMenuItem("Previous menu");
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
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setDisplayedMnemonic(KeyEvent.VK_C);
		lblCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SignUpCustomer sc = new SignUpCustomer();
				sc.setVisible(true);
			}
		});
		lblCustomer.setBackground(UIManager.getColor("CheckBox.shadow"));
		lblCustomer.setOpaque(true);
		lblCustomer.setIcon(new ImageIcon(SignUpFrame.class.getResource("/customer-review.png")));
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Arial", Font.BOLD, 25));
		lblCustomer.setBounds(425, 0, 407, 429);
		contentPane.add(lblCustomer);
		
		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setDisplayedMnemonic(KeyEvent.VK_D);
		lblDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SignUpDriver sd = new SignUpDriver();
				sd.setVisible(true);
							}
		});
		lblDriver.setOpaque(true);
		lblDriver.setBackground(Color.CYAN);
		lblDriver.setIcon(new ImageIcon(SignUpFrame.class.getResource("/taxi-driver.png")));
		lblDriver.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriver.setFont(new Font("Arial", Font.BOLD, 25));
		lblDriver.setBounds(0, 0, 425, 429);
		contentPane.add(lblDriver);
	}

}
