package Presentation;

import javax.swing.*;
import java.awt.*;

public class PersonFrame extends JFrame {

	public PersonFrame() {
		this.setTitle("Enter Person Details");
		this.setLayout(new BorderLayout());
		this.add(new PersonPanel(), BorderLayout.NORTH);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}