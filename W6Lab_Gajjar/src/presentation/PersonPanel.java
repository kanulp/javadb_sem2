package presentation;
import javax.swing.*;

import business.Person;
import data.DAOFactory;
import data.PersonDAO;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


class PersonPanel extends JPanel{
    private PersonDAO pDao = DAOFactory.getPersonDAO();

    private JLabel lblFirstName, lblLastName,lblGender, lblAge;
    private JTextField txtFirstName, txtLastName;
    private JSpinner spinnerAge;
    private JRadioButton rButtonMale,rButtonFemale;
	private JButton btnSave, btnFind;
    
    public PersonPanel(){
        initialize();
    }
    
	private void initialize() {
		lblFirstName = new JLabel("First Name");
		txtFirstName = new JTextField();
		lblLastName = new JLabel("Last Name");
		txtLastName = new JTextField();
		lblGender = new JLabel("Gender");
        lblAge = new JLabel("Age");
        spinnerAge = new JSpinner(new SpinnerNumberModel(20,0,100,1));
        rButtonFemale = new JRadioButton("Female",true);
        rButtonMale = new JRadioButton("Male");
		btnSave = new JButton("Save");
		btnFind = new JButton("Find");
		
		this.setLayout (new GridLayout(5, 2));
		this.add(lblFirstName);
		this.add(txtFirstName);
		this.add(lblLastName);
		this.add(txtLastName);
		this.add(lblAge);
		this.add(spinnerAge);
        this.add(lblGender);
        this.add(rButtonFemale);
        this.add(rButtonMale);


        JPanel rJPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rJPanel.add(rButtonMale);
        rJPanel.add(rButtonFemale);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rButtonMale);
        genderGroup.add(rButtonFemale);
        this.add(rJPanel);
        

		this.add(btnSave);
        this.add(btnFind);
        

        
        btnSave.addActionListener(new SaveButtonHandler());
        btnFind.addActionListener(new FindButtonHandler());
    }

    private class SaveButtonHandler implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
			if (!isValidData())
				return;
			String firstName = txtFirstName.getText();
			String lastName = txtLastName.getText();
			int age = Integer.parseInt(spinnerAge.getValue().toString());
			boolean gender = false;
			if(rButtonMale.isSelected())
				 gender = true;
			if (pDao.addPerson(new Person(firstName, lastName, age,gender))) {
				String result = "Person FirstName : " + firstName + "\n LastName : " + lastName + "\n Age: " + age+"\nGender : "+gender;
				JOptionPane.showMessageDialog(null, result, "Save Person", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Error, Not Saved!", "Save Person", JOptionPane.WARNING_MESSAGE);
			}
		}
    }

    private class FindButtonHandler implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
			String firstName = txtFirstName.getText();
			Person person = pDao.getPerson(firstName);
			if (person == null) {
				JOptionPane.showMessageDialog(null, "Person Not Found", "Find Person", JOptionPane.ERROR_MESSAGE);
			} else {
				System.out.println("data : "+person.getAge()+" "+person.getGender());
				txtLastName.setText(""+person.getLastName());
				spinnerAge.setValue(Integer.valueOf(person.getAge()));
				if(person.getGender()) {
					rButtonMale.setSelected(true);
					rButtonFemale.setSelected(false);

				}else {
					rButtonFemale.setSelected(true);
					rButtonMale.setSelected(false);

				}
			}
		}
    }
    private boolean isValidData() {
		if (!Validator.isPresent(txtFirstName, " First Name "))
			return false;
		if (!Validator.isPresent(txtLastName, " Last Name "))
			return false;
		
//		if (!Validator.isInteger(age, " Score Obtained "))
//			return false;
//		if (!Validator.isInteger(txtMaxScore, " Max Score "))
//			return false;
		return true;
	}
}