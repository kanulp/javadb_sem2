package W4LAB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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
            //JOptionPane.showMessageDialog(null, "Data saved", "Save Person", JOptionPane.INFORMATION_MESSAGE);
           
        }
    }
    private class SaveButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	
    
        	
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            String phone = txtPhone.getText();
            
            if(firstName.isEmpty()) {
                JOptionPane.showMessageDialog(null,"First name is required","Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(lastName.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Last name is required","Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(email.isEmpty()) {
                JOptionPane.showMessageDialog(null,"email name is required","Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(phone.isEmpty()) {
                JOptionPane.showMessageDialog(null,"phone name is required","Message", JOptionPane.ERROR_MESSAGE);
                if (phone.matches("[0-9]+") && phone.length() > 2) {
                    JOptionPane.showMessageDialog(null,"Phone should contain only number","Message", JOptionPane.ERROR_MESSAGE);

                }
                return;
            }
            

            String result = "Name: " + firstName + " " + lastName + "\n" + "phone: " + phone + "\n" + "Email:" + email;
            JOptionPane.showMessageDialog(null, result,"Result", JOptionPane.INFORMATION_MESSAGE);
            try {
                System.out.println("Data saved to file.");
                String home = System.getProperty("user.home");
                File f = new File(home + File.separator + "Desktop" + File.separator + "Testing" + File.separator + "Java.txt");

                File test = new File("/Users/kanu/Desktop/JAVA2/W4LAB/MyFile.txt");
                FileOutputStream outputStream = new FileOutputStream(test);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write("Name : "+txtFirstName.getText()+" "+txtLastName.getText());
                bufferedWriter.newLine();
                bufferedWriter.write("Email : "+txtEmail.getText());
                bufferedWriter.newLine();
                bufferedWriter.write("Phone : "+txtPhone.getText());
                System.out.println("Data saved to file.");
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
                e1.toString();
            }
        }
    }

    private class CancelButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Operation is cancelled", "Save Person", JOptionPane.WARNING_MESSAGE);
        }
    }
}