package Lab1;

import javax.swing.*;
import java.awt.*;

public class PersonFrame extends JFrame{
	public PersonFrame() {
		this.setTitle("Person Main");
		this.setLayout(new BorderLayout());
		this.add(new PersonPanel(), BorderLayout.CENTER);
		this.setSize(400, 200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}