import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;



public class SharedComponents {

    protected static class Frame extends JFrame {

        protected static JFrame frame;

        private static JFrame setFrame(int width, int height) {

            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setUndecorated(true);
            frame.setLocationRelativeTo(null);
            frame.setShape(new RoundRectangle2D.Double(0, 0, width, height, 75, 75));
            frame.setIconImage(new ImageIcon("src/HUT-logo.png").getImage());
            frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            return frame;

        };

        protected static JFrame getFrame(int width, int height) {

            frame = setFrame(width, height);
            return frame;
            
        };

    };

    protected static class TitleBar extends JPanel{

        protected static JButton minimizeButton, closeButton;
        protected static JPanel titleBar;

        private static JPanel setTitleBar(int width, int height) {
            
            titleBar = new JPanel();
            titleBar.setBackground(Color.BLACK);
            titleBar.setLayout(new BoxLayout(titleBar, BoxLayout.LINE_AXIS));
            titleBar.setPreferredSize(new Dimension(width, height));

            closeButton = getTitleBarButton("X");
            
            minimizeButton = getTitleBarButton("-");
            minimizeButton.setFont(new Font("Dialog", Font.BOLD, 40));

            JLabel titleTxt = Labels.getLabel("Integrated Library System");

            JLabel titleImg = new JLabel();
            titleImg.setIcon(new ImageIcon("src/HUT-logo.png"));

            titleBar.add(titleImg);
            titleBar.add(Box.createHorizontalGlue());
            titleBar.add(titleTxt);
            titleBar.add(Box.createHorizontalGlue());
            titleBar.add(minimizeButton);
            titleBar.add(closeButton);
            Listeners.setMouseListener(titleBar);
            Listeners.setMouseMotionListener(titleBar);

            return titleBar;

        };

        protected static JPanel getTitleBar(int width, int height) {
            
            titleBar = setTitleBar(width, height);
            return titleBar;
        };

        private static JButton setTitleBarButton(String txt) {

            JButton button = new JButton();
            button = new JButton(txt);
            button.setFont(new Font("Dialog", Font.BOLD, 20));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setForeground(Color.WHITE);
            Listeners.setActionListener(button);
            
            return button;

        };
        protected static JButton getTitleBarButton(String txt) {

            JButton button = setTitleBarButton(txt);
            return button;

        }

    };

    protected static class SideBar extends JPanel{

        private static JPanel setSideBar (int width, int height) {

            JPanel sidePanel = new JPanel();
            sidePanel.setBackground(Color.BLACK);
            sidePanel.setPreferredSize(new Dimension(width, height));
            sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));

            JLabel home = Labels.getLabel("Home");
            JLabel bookMgr = Labels.getLabel("Book Management");
            JLabel logout = Labels.getLabel("Logout");

            sidePanel.add(home);
            sidePanel.add(Box.createVerticalGlue());
            sidePanel.add(bookMgr);
            sidePanel.add(Box.createVerticalGlue());
            sidePanel.add(logout);
            sidePanel.add(Box.createVerticalGlue());

            
            
            return sidePanel;


        };

        protected static JPanel getSideBar (int width, int height) {

            JPanel sidePanel = setSideBar(width, height);
            return sidePanel;

        };
        
    };

    protected static class Buttons extends JButton{

        private static JButton setButton (int width, int height, String txt) {

            JButton button = new JButton(txt);
            button.setPreferredSize(new Dimension(width, height));
            button.setMaximumSize(new Dimension(width, height));
            button.setMinimumSize(new Dimension(width, height));
            button.setFont(new Font("ink free", Font.BOLD, 30));
            button.setForeground(Color.BLACK);
            button.setBackground(Color.LIGHT_GRAY);
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            Listeners.setActionListener(button);
            Listeners.setMouseListener(button);

            return button;

        };

        protected static JButton getButton (int width, int height, String txt) {

            JButton button = setButton(width, height, txt);
            return button;

        };

    };
    
    protected static class TextFields extends JTextField{

        private static JTextField setTextField ()  {

            JTextField txtField = new JTextField();
            txtField.setPreferredSize(new Dimension(200, 50));
            txtField.setFont(new Font("ink free", Font.BOLD, 30));
            

            return txtField;

        };

        protected static JTextField getTextField () {

            JTextField txtField = setTextField();
            return txtField;

        };

    };

    protected static class Labels extends JLabel{

        private static JLabel setLabel (String txt) {

                JLabel label = new JLabel();
                label.setText(txt);
                label.setForeground(Color.WHITE);
                label.setFont(new Font("ink free", Font.BOLD, 20));
                label.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
                Listeners.setMouseListener(label);
    
                return label;
            };
            
            protected static JLabel getLabel (String txt) {
                JLabel label = setLabel(txt);
            return label;
        };

    };

    protected static class Listeners implements ActionListener,
                                                MouseListener,
                                                MouseMotionListener {

        Listeners() {
            correctUsername = true;
            correctPassword = true;
            adminLogin = false;
        };

        private static int xPos, yPos, secondXPos, secondYPos;
        private static boolean correctUsername, correctPassword, adminLogin;

                                            
        public static void setActionListener(JButton toListen) {

            toListen.addActionListener(new Listeners());
            
        };
        
        public static void setMouseListener(Container toListen) {
            
            toListen.addMouseListener(new Listeners());

        };

        public static void setMouseMotionListener(Container toListen) {

            toListen.addMouseMotionListener(new Listeners());

        };


        @Override
        public void mousePressed(MouseEvent e) {
    
            if(e.getSource() == SharedComponents.TitleBar.titleBar) {
    
            xPos = e.getX();
            yPos = e.getY();
    
            };
            
            if(e.getSource() == LoginPage.loginButton) {

                LoginPage.loginButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            };
            
        }
    
        @Override
        public void mouseDragged(MouseEvent e) {
    
            if(e.getSource() == SharedComponents.TitleBar.titleBar) {
    
    
            secondXPos = e.getXOnScreen() - xPos;
            secondYPos = e.getYOnScreen() - yPos;
    
            SharedComponents.Frame.frame.setLocation(secondXPos,secondYPos);
    
            };
            
        }
    
        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void mouseReleased(MouseEvent e) {
    
            if(e.getSource() == LoginPage.loginButton) {

                LoginPage.loginButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }
    
            
        }
    
        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == LoginPage.adminButton) {

                LoginPage.adminButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
                LoginPage.userButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            } else if (e.getSource() == LoginPage.userButton) {

                LoginPage.userButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
                LoginPage.adminButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));
    
            };
    
            if (e.getSource() == SharedComponents.TitleBar.closeButton) {

                System.exit(0);

            } else if (e.getSource() == SharedComponents.TitleBar.minimizeButton) {

                SharedComponents.Frame.frame.setState(JFrame.ICONIFIED);
            };   
            
            if (e.getSource() == LoginPage.loginButton) {
    
                LoginPage.username = LoginPage.usernameField.getText();
                LoginPage.password = LoginPage.passwordField.getPassword();
    
    
                if(correctUsername && correctPassword && adminLogin) {
    
                    LoginPage.loginInfo.setText("Admin Login Succesful");
                    LoginPage.loginFrame.dispose();
                    new AdminUI();
                    
                } else if (correctUsername && correctPassword && !adminLogin) {
                    
                    LoginPage.loginInfo.setText("User Login Succesful");
                    LoginPage.loginFrame.dispose();
                    new UserUI();
                    
                } else if (!correctUsername && correctPassword){
                    
                    LoginPage.loginInfo.setText("UserName Not Found");
                    
                } else if (correctUsername && !correctPassword) {
                    
                    LoginPage.loginInfo.setText("Wrong Password");
                    
                };
                
            };
            
        };
                                                    
    }

};
