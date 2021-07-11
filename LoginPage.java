import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class LoginPage{

    protected static JFrame loginFrame;
    protected static JPanel titleBar, loginPanel;
    protected static JButton adminButton, userButton, loginButton, loginSelButton;
    protected static JPasswordField passwordField;
    protected static JTextField usernameField;
    protected static String username;
    protected static char[] password;
    protected static JLabel loginInfo;

    LoginPage() {

        loginFrame = SharedComponents.Frame.getFrame(500, 500);
        titleBar = SharedComponents.TitleBar.getTitleBar(500, 50);

        loginFrame.add(titleBar);
        loginFrame.add(Box.createHorizontalGlue());
        loginFrame.add(setLoginSel(500, 50));
        loginFrame.add(Box.createHorizontalGlue());
        loginFrame.add(setLoginPanel(500, 400));
        loginFrame.setVisible(true);
        titleBar.setVisible(true);
        
    };
    
    private JPanel setLoginSel (int width, int height) {
        
        JPanel loginSelPanel = new JPanel();
        loginSelPanel.setBackground(Color.DARK_GRAY);
        loginSelPanel.setPreferredSize(new Dimension(width, height));
        loginSelPanel.setLayout(new GridLayout(1, 0));

        adminButton = setLoginSelButton("Admin");
        userButton = setLoginSelButton("User");
        userButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

        loginSelPanel.add(adminButton);
        loginSelPanel.add(userButton);

        return loginSelPanel;

    };

    private JButton setLoginSelButton(String txt) {

        loginSelButton = new JButton(txt);
        loginSelButton.setPreferredSize(new Dimension(250, 50));
        loginSelButton.setFont(new Font("ink free", Font.BOLD, 30));
        loginSelButton.setForeground(Color.BLACK);
        loginSelButton.setFocusPainted(false);
        loginSelButton.setContentAreaFilled(false);
        loginSelButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
        SharedComponents.Listeners.setActionListener(loginSelButton);
        
        return loginSelButton;

    };
    
    private JPanel setLoginPanel (int width, int height) {

        loginPanel = new JPanel();
        loginPanel.setBackground(Color.LIGHT_GRAY);
        loginPanel.setPreferredSize(new Dimension(width, height));;
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.PAGE_AXIS));
        loginPanel.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 50));
        passwordField.setFont(new Font("ink free", Font.BOLD, 30));

        usernameField = SharedComponents.TextFields.getTextField();
        
        JPanel formsPanel = new JPanel();
        formsPanel.setSize(new Dimension(500, 275));
        formsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 55));
        formsPanel.setBackground(Color.LIGHT_GRAY);
        formsPanel.add(SharedComponents.Labels.getLabel("Username: "));
        formsPanel.add(usernameField);
        formsPanel.add(SharedComponents.Labels.getLabel("Password: "));
        formsPanel.add(passwordField);

        loginInfo = SharedComponents.Labels.getLabel("");
        loginInfo.setPreferredSize(new Dimension(250, 25));

        loginButton = SharedComponents.Buttons.getButton(250, 75, "Login");

        loginPanel.add(formsPanel);
        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(loginInfo);
        loginPanel.add(Box.createVerticalGlue());
        loginPanel.add(loginButton);
        return loginPanel;

    };
};
    

