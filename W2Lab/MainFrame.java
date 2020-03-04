package W2LAB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import W2LAB.PersonPanel;
import W2LAB.PersonInternalFrame;

public class MainFrame extends JFrame{

    private JMenuBar mBar;
    private JMenu mFile;
    private JMenu mShow;
    private JMenuItem mItemExit;
    private JMenuItem mItemPerson;
    private JDesktopPane desktopPane;

    public MainFrame(){
        initialize();
        this.setTitle("Week 2");
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initialize(){
        mBar = new JMenuBar();
        desktopPane = new JDesktopPane();
        this.setContentPane(desktopPane);

        mFile = new JMenu("File");
        mFile.setMnemonic(KeyEvent.VK_F);

        mItemExit = new JMenuItem("Exit");
        mItemExit.setMnemonic(KeyEvent.VK_X);
        mItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        mItemExit.addActionListener(new ExitEventHandler());

        mShow = new JMenu("Show");
        mShow.setMnemonic(KeyEvent.VK_S);

        mItemPerson = new JMenuItem("Person");
        mItemPerson.setMnemonic(KeyEvent.VK_P);
        mItemPerson.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        mItemPerson.addActionListener(new PersonEventHandler());

        mFile.add(mItemExit);
        mShow.add(mItemPerson);

        mBar.add(mFile);
        mBar.add(mShow);
        this.setJMenuBar(mBar);

    }

    private class ExitEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    private class PersonEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JInternalFrame pInternalFrame = new PersonInternalFrame((new PersonPanel()));
            pInternalFrame.setVisible(true);
            MainFrame.this.desktopPane.add(pInternalFrame);
        }
    }
}