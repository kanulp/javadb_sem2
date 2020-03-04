package W3LAB;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiWithComboBox extends GuiWithRadioButton{

    private String[] messages={"Hello World","Greetings","Welcome","Good morning"};
    public JComboBox jcbo = new JComboBox(messages);

	public GuiWithComboBox(){
        JPanel jpComboBox = new JPanel();
        jpComboBox.setLayout(new FlowLayout());
        jpComboBox.add(new JLabel("Select Message"));
        jpComboBox.add(jcbo);
        this.add(jpComboBox,BorderLayout.NORTH);
        
        jcbo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                messagePanel.setMessage(jcbo.getSelectedItem().toString());
            }
        });
        
        jcbo.addItem("This is new message");

        jcbo.setSelectedIndex(0);
        messagePanel.setMessage(jcbo.getSelectedItem().toString());
   

    }

    public static void main(String[] args) {
    	GuiWithComboBox frame = new GuiWithComboBox();
	        frame.setLocationRelativeTo(null); // Center Frame
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setTitle("GUI With ComboBox");
	        frame.setSize(500, 200);
	        frame.setVisible(true);
	        
    }


}