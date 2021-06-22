package Project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.*;
import java.awt.event.*;

public class UIRender extends MouseAdapter implements ActionListener{

    //declaring some variables outside of methods to be accessed from outside
    private JButton closeButton;
    private JButton minimizeButton;
    private JFrame mainFrame;
    private JPanel titleBarPanel;
    private int xPos, yPos, secondXPos, secondYPos;

    //class constructor
    UIRender(){

        //creating the main frame
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setUndecorated(true);
        mainFrame.setVisible(true);
        mainFrame.setShape(new RoundRectangle2D.Double(0, 0, 500, 500, 75, 75));
        
        mainFrame.add(setTitleBar());
        mainFrame.add(setLoginPanel());
        mainFrame.addMouseListener(this);
        mainFrame.addMouseMotionListener(this);

    };
        
    //to make the frame draggable
    @Override
    public void mousePressed(MouseEvent e) {
        xPos = e.getX();
        yPos = e.getY();
    };
    
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        secondXPos = e.getXOnScreen() - xPos;
        secondYPos = e.getYOnScreen() - yPos;

        mainFrame.setLocation(secondXPos,secondYPos);
    };

    //the setter method for title bar
    private JPanel setTitleBar() {

        //setting a panel instead of the default title bar for custom look and feel
        titleBarPanel = new JPanel();                                                            
        titleBarPanel.setBackground(Color.black);                                                       
        titleBarPanel.setBounds(0, 0, 500, 50);                                                        
        titleBarPanel.setLayout(null);                                                                  
        titleBarPanel.setVisible(true);                                                                 

        //adding a button to close program
        closeButton = new JButton("X");                                                                 
        closeButton.setBounds(450, 0, 50, 50);                                                          
        closeButton.setFont(new Font("Dialog", Font.BOLD, 20));                                         
        closeButton.setBorderPainted(false);                                                            
        closeButton.setContentAreaFilled(false);                                                        
        closeButton.setFocusPainted(false);                                                             
        closeButton.setForeground(Color.WHITE);                                                         

        closeButton.addActionListener(this);                                        

        // adding a button to minimize the program
        minimizeButton = new JButton("-");                                                              
        minimizeButton.setBounds(400, 0, 50, 50);                                                       
        minimizeButton.setFont(new Font("Dialog", Font.BOLD, 40));                                      
        minimizeButton.setBorderPainted(false);                                                         
        minimizeButton.setContentAreaFilled(false);                                                     
        minimizeButton.setFocusPainted(false);                                                          
        minimizeButton.setForeground(Color.WHITE);                                                      

        minimizeButton.addActionListener(this);
        
        titleBarPanel.add(closeButton);
        titleBarPanel.add(minimizeButton);

        return titleBarPanel;
        
    };
    
    //the getter method for titlebar
    public JPanel getTitleBar() {
        final JPanel TitleBar = setTitleBar();
        return TitleBar;
    };
    
    // to be able to use the buttons
    @Override
    public void actionPerformed(ActionEvent e) {                                                        
        if (e.getSource() == closeButton) {                                                             
            System.exit(0);                                                                             
        } else if(e.getSource() == minimizeButton) {                                                    
            mainFrame.setState(JFrame.ICONIFIED);
        };
    };

    private JPanel setLoginPanel () {

        JPanel loginPanel = new JPanel();

        loginPanel.setBounds(0, 50, 500, 450);
        loginPanel.setBackground(Color.RED);

        JButton adminButton = new JButton("Admin");
        JButton userButton = new JButton("User");

        adminButton.setBounds(0, 50, 250, 50);                                                          
        adminButton.setFont(new Font("Dialog", Font.BOLD, 10));                                         
        adminButton.setBorderPainted(false);                                                            
        adminButton.setContentAreaFilled(false);                                                        
        adminButton.setFocusPainted(false);                                                             
        adminButton.setForeground(Color.BLACK);
        adminButton.setVerticalAlignment(alignment);

        userButton.setBounds(250, 50, 250, 50);                                                          
        userButton.setFont(new Font("Dialog", Font.BOLD, 10));                                         
        userButton.setBorderPainted(false);                                                            
        userButton.setContentAreaFilled(false);                                                        
        userButton.setFocusPainted(false);                                                             
        userButton.setForeground(Color.BLACK);

        loginPanel.add(adminButton);
        loginPanel.add(userButton);

        return loginPanel;


    };

};


