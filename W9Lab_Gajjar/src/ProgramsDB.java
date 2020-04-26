import javax.swing.*;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProgramsDB extends JFrame {
	private JTextField txtId;
	private JTextField txtTitle;
	private JTextField txtMaxSeats;
	private JTextField txtSemester;
	private Connection c;
	private ResultSet rs;
	
	public ProgramsDB() {
		getContentPane().setLayout(null);
		
		JLabel lblProgramID = new JLabel("Program ID:");
		lblProgramID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProgramID.setBounds(102, 47, 75, 13);
		getContentPane().add(lblProgramID);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitle.setBounds(102, 90, 46, 13);
		getContentPane().add(lblTitle);
		
		JLabel lblMaxSeats = new JLabel("Max Seats:");
		lblMaxSeats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxSeats.setBounds(102, 135, 75, 13);
		getContentPane().add(lblMaxSeats);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSemester.setBounds(102, 178, 75, 13);
		getContentPane().add(lblSemester);
		
		txtId = new JTextField();
		txtId.setBounds(187, 45, 131, 19);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(187, 88, 131, 19);
		getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		txtMaxSeats = new JTextField();
		txtMaxSeats.setBounds(187, 133, 131, 19);
		getContentPane().add(txtMaxSeats);
		txtMaxSeats.setColumns(10);
		
		txtSemester = new JTextField();
		txtSemester.setBounds(187, 176, 131, 19);
		getContentPane().add(txtSemester);
		txtSemester.setColumns(10);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				showProgram();
			}
		});
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFirst.setBounds(28, 226, 89, 21);
		getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!rs.isFirst())
						rs.previous();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				showProgram();
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrevious.setBounds(120, 226, 89, 21);
		getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!rs.isLast())
						rs.next();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				showProgram();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNext.setBounds(212, 226, 89, 21);
		getContentPane().add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.last();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				showProgram();
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLast.setBounds(302, 226, 89, 21);
		getContentPane().add(btnLast);
				
		DBAccess db = new DBAccess();
		c = db.connect();
		rs = db.getPrograms();
		try {
			rs.first();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		showProgram();
		this.setSize(423,312);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e)
		    {
		    	try {
		    		if (!rs.isClosed())
		    			rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
		});
	}
	private void showProgram() {
		try {
			txtId.setText(rs.getString("id"));
			txtTitle.setText(rs.getString("name"));
			txtMaxSeats.setText(rs.getString("seats"));
			txtSemester.setText(rs.getString("semester"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}