import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserUI {

    UserUI() {

        JPanel mainTitleBar = SharedComponents.TitleBar.getTitleBar(750, 100);
        JPanel sideBar = SharedComponents.SideBar.getSideBar(200, 650);

        JPanel workPanel = new JPanel();
        workPanel.setBackground(Color.GRAY);
        workPanel.setPreferredSize(new Dimension(550, 650));
        
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(750, 650));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        mainPanel.add(sideBar);
        mainPanel.add(workPanel);

        JFrame mainFrame = SharedComponents.Frame.getFrame(750, 750);
        mainFrame.setVisible(true);
        
        mainFrame.add(mainTitleBar);
        mainFrame.add(mainPanel);
        

    };

    // protected class HomePage {



        // private JTable setStatsTable() {

        // };

        // protected JTable getStatsTable() {

        // };

    // };

    // protected class BookManagement {

        // private JPanel setBookManagement() {

        // };

        // protected JPanel getBookManagement() {

        // };

    // };

}
