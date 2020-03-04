package W3LAB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GuiWithRadioButton extends GuiWithCheckBox{

    private JRadioButton jRbRED; 
    private JRadioButton jRbGreen; 
    private JRadioButton jRbBlue; 
    
    public GuiWithRadioButton(){
        JPanel jPRadioButton = new JPanel();
        jPRadioButton.setLayout(new GridLayout(3,1));
        jPRadioButton.add(jRbRED = new JRadioButton("Red"));
        jPRadioButton.add(jRbGreen = new JRadioButton("Green"));
        jPRadioButton.add(jRbBlue = new JRadioButton("Blue"));
        this.add(jPRadioButton,BorderLayout.WEST);

        ButtonGroup group = new ButtonGroup();
        group.add(jRbRED);
        group.add(jRbGreen);
        group.add(jRbBlue);

        jRbRED.setMnemonic('e');
        jRbGreen.setMnemonic('g');
        jRbBlue.setMnemonic('u');
        
        jRbRED.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                messagePanel.setForeground(Color.RED);
			}
		});
        
        
        jRbGreen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                messagePanel.setForeground(Color.GREEN);				
			}
		});
        
        jRbBlue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                messagePanel.setForeground(Color.BLUE);				
			}
		});
        jRbBlue.setSelected(true);
		messagePanel.setForeground(Color.BLUE);
    }

    public static void main(String[] args) {
        
    	GuiWithRadioButton frame= new GuiWithRadioButton();
		frame.setTitle("GUI WITH RadioBox");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,200);
		frame.setVisible(true);

    }


}