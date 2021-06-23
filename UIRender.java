package Project;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.geom.*;
import java.awt.event.*;

public class UIRender extends MouseAdapter implements ActionListener{

    //declaring instance variable
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
        mainFrame.setShape(new RoundRectangle2D.Double(0, 0, 500, 500, 75, 75));

        mainFrame.addMouseListener(this);
        mainFrame.addMouseMotionListener(this);
        setTitleBar();
        setLoginPanel();

        mainFrame.setVisible(true);

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
    private void setTitleBar() {

        //setting a panel instead of the default title bar for custom look and feel
        titleBarPanel = new JPanel();
        titleBarPanel.setBackground(Color.BLACK);
        titleBarPanel.setLayout(new BoxLayout(titleBarPanel, BoxLayout.LINE_AXIS));
        titleBarPanel.setPreferredSize(new Dimension(500, 50));

        //adding a button to close program
        closeButton = new JButton("X");
        closeButton.setFont(new Font("Dialog", Font.BOLD, 20));
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setFocusPainted(false);
        closeButton.setForeground(Color.WHITE);

        closeButton.addActionListener(this);

        // adding a button to minimize the program
        minimizeButton = new JButton("-");
        minimizeButton.setFont(new Font("Dialog", Font.BOLD, 40));
        minimizeButton.setBorderPainted(false);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setForeground(Color.WHITE);

        minimizeButton.addActionListener(this);

        //adding a text and image for title
        JLabel titleTxt = new JLabel();
        titleTxt.setText("سامانه مدیریت کتابخانه");
        titleTxt.setForeground(Color.WHITE);
        titleTxt.setFont(new Font("Dialog", Font.BOLD, 20));

        ImageIcon titleIcon = new ImageIcon(getClass().getResource("HUT-logo.png"));


        JLabel titleImg = new JLabel();
        titleImg.setIcon(titleIcon);

        //adding components to panel
        titleBarPanel.add(titleImg);
        titleBarPanel.add(Box.createHorizontalGlue());
        titleBarPanel.add(titleTxt);
        titleBarPanel.add(Box.createHorizontalGlue());
        titleBarPanel.add(minimizeButton);
        titleBarPanel.add(closeButton);
        titleBarPanel.setVisible(true);

        //adding panel to main frame
        mainFrame.add(titleBarPanel, BorderLayout.NORTH);

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

    //the method to render login panel
    private void setLoginPanel () {

        //to switch between admin and user login
        JPanel loginPanelSel = new JPanel();
        
        loginPanelSel.setBackground(Color.DARK_GRAY);
        loginPanelSel.setPreferredSize(new Dimension(500, 50));

        JButton adminButton = new JButton("Admin");
        
        adminButton.setPreferredSize(new Dimension(200, 50));
        adminButton.setFont(new Font("Dialog", Font.BOLD, 30));
        adminButton.setBorderPainted(false);
        adminButton.setContentAreaFilled(false);
        adminButton.setFocusPainted(false);
        adminButton.setForeground(Color.BLACK);
        
        JButton userButton = new JButton("User");

        userButton.setPreferredSize(new Dimension(200, 50));
        userButton.setFont(new Font("Dialog", Font.BOLD, 30));
        userButton.setBorderPainted(false);
        userButton.setContentAreaFilled(false);
        userButton.setFocusPainted(false);
        userButton.setForeground(Color.BLACK);
        
        loginPanelSel.add(adminButton);
        loginPanelSel.add(userButton);

        //username and password fields
        JPanel loginFields = new JPanel();

        loginFields.setPreferredSize(new Dimension(500, 400));
        loginFields.setBackground(Color.LIGHT_GRAY);
        loginFields.setLayout(new BoxLayout(loginFields, BoxLayout.Y_AXIS));

        //to make the username password fields centeral
        JPanel centerFields = new JPanel();
        centerFields.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 30));
        centerFields.setPreferredSize(new Dimension(250, 200));
        centerFields.setBackground(Color.LIGHT_GRAY);

        JLabel username = new JLabel("Username:");

        JLabel password = new JLabel("Password:");

        JTextField usernameTxtFld = new JTextField();
        usernameTxtFld.setPreferredSize(new Dimension(200, 50));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 50));

        JButton loginBtn = new JButton("Login");

        //adding fields to centeral panel
        centerFields.add(username);
        centerFields.add(usernameTxtFld);
        centerFields.add(password);
        centerFields.add(passwordField);
        centerFields.add(loginBtn);

        //adding centeral panel to main panel
        loginFields.add(Box.createVerticalGlue());
        loginFields.add(Box.createHorizontalGlue());
        loginFields.add(centerFields);
        loginFields.add(Box.createHorizontalGlue());
        loginFields.add(Box.createVerticalGlue());

        //adding panel to main frame
        mainFrame.add(loginPanelSel, BorderLayout.CENTER);
        mainFrame.add(loginFields, BorderLayout.SOUTH);

    };

};


