package W2LAB;

import javax.swing.JInternalFrame;
import javax.swing.*;
import java.awt.event.*;

public class PersonInternalFrame extends JInternalFrame{

    private JPanel panel;

    public PersonInternalFrame(JPanel panel){
        this.panel = panel;
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Person Gui");
        this.setIconifiable(true);
        this.setClosable(true);
        this.setSize(250,150);
    }
}