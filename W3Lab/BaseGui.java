package W3LAB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaseGui extends JFrame{ 

	protected MessagePanel messagePanel=new MessagePanel("Welcome to Java");
	private JButton jbLeft=new JButton("Left");
	private JButton jbRight=new JButton("Right");
	private JCheckBox jchkbold  = new JCheckBox();


	public BaseGui() {
        //Set the background color of the mesagePanel
				messagePanel.setBackground(Color.white);
				
				//Create Panel jpButtons to hold two Buttons "<=" and "right =>"
				JPanel jpButtons = new JPanel();
				jpButtons.setLayout(new FlowLayout());
				jpButtons.add(jbLeft);
				jpButtons.add(jbRight);
				
				//Set keyboard mnemonics
				jbLeft.setMnemonic('L');
				jbRight.setMnemonic('R');
				
				//Set tool tip next on the buttons
				jbLeft.setToolTipText("Move message to left");
				jbRight.setToolTipText("Move message to right");
				
				//Place panels in the frame
				setLayout(new BorderLayout());
				add(messagePanel, BorderLayout.CENTER);
				add(jpButtons, BorderLayout.SOUTH);

				jbLeft.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						messagePanel.moveLeft();
					}
				});
				

				jbRight.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						messagePanel.moveRight();
					}
				});
        
	}
	
	public static void main(String[] args) {
		
		BaseGui frame = new BaseGui();
		frame.setTitle("Base GUI");
		frame.setLocationRelativeTo(null);//Center the  frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 100);
		frame.setVisible(true);


	}

}
