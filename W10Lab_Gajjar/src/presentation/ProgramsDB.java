package presentation;
import business.CProgram;
import javax.swing.*;
import data.DBAcess1;

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
	private JTextField txtName;
	private JTextField txtSeats;
	private JTextField txtSemesters;
	private DBAcess1 db=null;
	
	public void showProgram(CProgram program) {
		txtId.setText(program.getpID());
		txtName.setText(program.getpName());
		txtSeats.setText(""+program.getpSeats());
		txtSemesters.setText(""+program.getpSemesters());
	}
	public ProgramsDB() {
		setTitle("DB");
		addWindowListener(new WindowAdapter() {
			public void windowsClosing(WindowEvent e) {
				try {
					db.disconnect();
					System.exit(0);
				}
				catch(SQLException e1) {
					showException(e1);
					System.exit(1);
				}
			}
		});
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblID.setBounds(102, 45, 46, 13);
		getContentPane().add(lblID);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(102, 90, 46, 13);
		getContentPane().add(lblName);
		
		JLabel lblSeats = new JLabel("Max Seats:");
		lblSeats.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeats.setBounds(102, 135, 75, 13);
		getContentPane().add(lblSeats);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSemester.setBounds(102, 178, 75, 13);
		getContentPane().add(lblSemester);
		
		txtId = new JTextField();
		txtId.setBounds(187, 45, 131, 19);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(187, 88, 131, 19);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtSeats = new JTextField();
		txtSeats.setBounds(187, 133, 131, 19);
		getContentPane().add(txtSeats);
		txtSeats.setColumns(10);
		
		txtSemesters = new JTextField();
		txtSemesters.setBounds(187, 176, 131, 19);
		getContentPane().add(txtSemesters);
		txtSemesters.setColumns(10);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getFirst();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFirst.setBounds(28, 226, 89, 21);
		getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getPrevious();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrevious.setBounds(120, 226, 89, 21);
		getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getNext();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNext.setBounds(212, 226, 89, 21);
		getContentPane().add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CProgram program=db.getLast();
					if(program!=null)
						showProgram(program);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					showException(e1);
				}
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLast.setBounds(302, 226, 89, 21);
		getContentPane().add(btnLast);

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CProgram program = new CProgram(txtId.getText(), txtName.getText() , txtSeats.getText(), txtSemesters.getText());
					try{
						db.addProgram(program);
						JOptionPane.showMessageDialog(null,"Added successfully");
					}
					catch(SQLException e1) {
						JOptionPane.showMessageDialog(null,"Added Unsuccessfully");	
					}
				}});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInsert.setBounds(28, 290, 89, 21);
		getContentPane().add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					try{
						db.deleteProgram(txtId.getText());
						JOptionPane.showMessageDialog(null,"Deleted successfully");
					}
					catch(SQLException e1) {
						JOptionPane.showMessageDialog(null,"Deleted Unsuccessfully");	
					}
				}});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(120, 290, 89, 21);
		getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CProgram program = new CProgram(txtId.getText(), txtName.getText() , txtSeats.getText(), txtSemesters.getText());
					try{
						int c = db.updateProgram(program);
						System.out.print("Count is :"+c);
						JOptionPane.showMessageDialog(null,"Updated successfully");
					}
					catch(Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,"Updated Unsuccessfully "+e1.toString());	
					}
				}});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.setBounds(212, 290, 89, 21);
		getContentPane().add(btnUpdate);
		
		try {
			db=new DBAcess1();
			CProgram program=db.getFirst();
			if(program!=null)
				showProgram(program);
		}
		catch(ClassNotFoundException | SQLException sqle) {
			showException(sqle);
			System.exit(1);
		}
	}
	private void showException(Exception e) {
		JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}

}
		