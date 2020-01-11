package Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PersonPanel extends JPanel{
	private JLabel lblFirstName, lblLastName, lblEmail, lblPhone;
	private JTextField txtFirstName, txtLastName, txtEmail, txtPhone;
	private JButton butSave, butCancel;
    
    public PersonPanel(){
        initialize();
    }
    
	private void initialize() {
		lblFirstName = new JLabel("First Name");
		txtFirstName = new JTextField();
		lblLastName = new JLabel("Last Name");
		txtLastName = new JTextField();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField();
		lblPhone = new JLabel("Phone");
		txtPhone = new JTextField();
		butSave = new JButton("Save");
		butCancel = new JButton("Cancel");
		
		this.setLayout (new GridLayout(5, 2));
		this.add(lblFirstName);
		this.add(txtFirstName);
		this.add(lblLastName);
		this.add(txtLastName);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblPhone);
		this.add(txtPhone);
		this.add(butSave);
        this.add(butCancel);
        
        butSave.addActionListener(new SaveButtonHandler());
        butCancel.addActionListener(new CancelButtonHandler());
    }


    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Data saved", "Save Person", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private class SaveButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();

            String result = "Name: " + firstName + " " + lastName + "\n" + "phone: " + phone + "\n" + "Email:" + email;
            JOptionPane.showMessageDialog(null, result,"Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class CancelButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Operation is cancelled", "Save Person", JOptionPane.WARNING_MESSAGE);
        }
    }
}