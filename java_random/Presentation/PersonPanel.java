package Presentation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import Business.Validator;
import Data.DAOFactory;

public class PersonPanel extends JPanel {

	private Data.PersonDAO pDAO = DAOFactory.getPersonDAO();

	private JLabel lblFirstName, lblLastName, lblgender, lblage;
	private JTextField txtFirstname, txtLastName;
	private JRadioButton rdMale, rdFemale;
	private JSpinner spinAge;
	private JButton btnSave, btnFind;
	private JTextArea displayArea;

	public PersonPanel() {
		this.intialize();
		btnSave.addActionListener(new SaveButtonHandler());
		btnFind.addActionListener(new FindButtonHandler());
	}

	private void intialize() {
		lblFirstName = new JLabel("  First Name :");
		lblLastName = new JLabel("   Last Name :");
		lblgender = new JLabel("      Gender :");
		lblage = new JLabel("      Age :");


		txtFirstname = new JTextField();
		txtLastName = new JTextField();
		spinAge = new JSpinner(new SpinnerNumberModel(20, 0, 100, 1));

		rdMale = new JRadioButton("Male", true);
		rdFemale = new JRadioButton("Female", true);

		btnSave = new JButton("Save");
		btnFind = new JButton("Find");
		this.setLayout(new BorderLayout());
		JPanel personGUI = new JPanel(new GridLayout(5, 2));

		personGUI.add(lblFirstName);
		personGUI.add(txtFirstname);
		
		personGUI.add(lblLastName);
		personGUI.add(txtLastName);
		
		personGUI.add(lblgender);
		JPanel rdoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		rdoPanel.add(rdMale);
		rdoPanel.add(rdFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdMale);
		bg.add(rdFemale);
		personGUI.add(rdoPanel);
		
		personGUI.add(lblage);
		personGUI.add(spinAge);
		
		personGUI.add(btnSave);
		personGUI.add(btnFind);

		this.add(personGUI, BorderLayout.CENTER);
		this.add(displayArea = new JTextArea(), BorderLayout.SOUTH);
	}
	
	public boolean isValidData() 
	{
		if (!Validator.isPresent(txtFirstname, "First Name"))
			return false;
		
		if (!Validator.isPresent(txtLastName, "Last Name"))
			return false;
		
		return true;
	}

	private class SaveButtonHandler implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
		
			String firstName = txtFirstname.getText();
			String lastName = txtLastName.getText();
			
			int age = Integer.parseInt(spinAge.getValue().toString());
			
			String gender = "Male";
			
			if (rdFemale.isSelected())
				gender = "Female";
			
			if (isValidData()) 
			{
				Business.Person person = new Business.Person(firstName, lastName);
				person.setAge(age);
				person.setFirstName(firstName);
				person.setLastName(lastName);
				person.setGender(gender);
				if (pDAO.addPerson(person))
				{
					String result = "Name : " + firstName + " " + lastName + "\n" + "Age : " + age + "\n" + "Gender : "
							+ gender;
					JOptionPane.showMessageDialog(null, "Person Data is saved\n" + result, " Save Person",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

		private class FindButtonHandler implements ActionListener
		{
			public void actionPerformed(ActionEvent e) 
				{
					String targetName = txtFirstname.getText();
					if (targetName.length() > 0) 
					{
						Business.Person person = pDAO.getPerson(targetName);
						if (person != null) 
						{
							txtLastName.setText(person.getLastName());
							if (person.getGender().equalsIgnoreCase("Male"))
								rdMale.setSelected(true);
							else
								rdFemale.setSelected(true);
							
							spinAge.setValue(person.getAge());
						}
						
					   else 
							JOptionPane.showMessageDialog(null, txtFirstname.getText() + " is not found", "Find Person",
									JOptionPane.INFORMATION_MESSAGE);
					} 
					
				   else  
				   {
					displayArea.setText("");
					ArrayList<Business.Person> persons = pDAO.getPersons();
					for (Business.Person p : persons) 
					   {
						displayArea.append(p.getFirstName() + " " + p.getLastName() + " " + p.getGender() + " " + p.getAge()+"\n");
					   }
		   }
		}
	}
}