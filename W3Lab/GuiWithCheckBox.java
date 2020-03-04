package W3LAB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import test.MessagePanel;


public class GuiWithCheckBox extends BaseGui {

    private JCheckBox jCheckBoxCentered = new JCheckBox("Centered");
    private JCheckBox jCheckBoxBold = new JCheckBox("Bold");
    private JCheckBox jCheckBoxItalic = new JCheckBox("Italic");


    public GuiWithCheckBox(){
        jCheckBoxCentered.setMnemonic('c');
        jCheckBoxBold.setMnemonic('b');
        jCheckBoxItalic.setMnemonic('i');

        JPanel jpcheckboxes = new JPanel();
        jpcheckboxes.setLayout(new GridLayout(3,1));

        jpcheckboxes.add(jCheckBoxCentered);
        jpcheckboxes.add(jCheckBoxBold);
        jpcheckboxes.add(jCheckBoxItalic);

        add(jpcheckboxes,BorderLayout.EAST);
        
        jCheckBoxCentered.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				(messagePanel).setCentered(jCheckBoxCentered.isSelected());
				
			}
		});
        
        jCheckBoxBold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewFont();
				
			}
		});

		jCheckBoxItalic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewFont();

			}
		});
        
    }
    private void setNewFont() {
		int fontStyle = Font.PLAIN;
		if(jCheckBoxBold.isSelected())
			fontStyle += Font.BOLD;
		if(jCheckBoxItalic.isSelected())
			fontStyle += Font.ITALIC;
		Font font = messagePanel.getFont();
		messagePanel.setFont(new Font(font.getName(),fontStyle,font.getSize()));
		
	}
	public static void main(String[] args) {
		GuiWithCheckBox frame= new GuiWithCheckBox();
		frame.setTitle("GUI WITH CHECKBOX");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,200);
		frame.setVisible(true);
	}

    
}