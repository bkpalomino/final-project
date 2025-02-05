package util;

import entity.Logon;
import entity.Person;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import views.FrameMain;
import views.PanelHelp;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Util class that serves as a program wide state manager. Must be instantiated, but user info can be retreived anywhere.
 */
public class StateManager {

    private static String currentState;

    private FrameMain mainFrame;
    private JPanel mainPanel;
    private JPanel previousPanel;
    private JPanel helpPanel;

    private static Person currentUser;
    public static boolean refresh = false;

    public static final Color COLOR_CYAN = new Color(0, 153, 153);
    public static final Color COLOR_ORANGE = new Color(204, 102, 0);

    public StateManager(FrameMain mainFrame, JPanel mainPanel) {
        this.helpPanel = new PanelHelp(this);
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        currentState = "Logon";
    }

    // Changes the state of the mainPanel
    public void changePanel(JPanel newPanel) {

        try {
            previousPanel = (JPanel) mainPanel.getComponents()[0];
        } catch (Exception ex) {
            System.out.println("Previous state not saved");
        }

        currentState = (currentUser != null) ? currentUser.getLogon().getPositionTitle() : "Logon";
        mainFrame.switchToolBar(currentState);
        
        System.out.println(currentState);

        // Set up main panel
        mainPanel.removeAll();

        mainPanel.add(newPanel, BorderLayout.CENTER);

        // Repaint Revalidate / Dispose of old panel
        mainPanel.repaint();
        mainPanel.revalidate();

        System.gc();
    }

    // Changes the state of the mainFrame
    public void changeFrameState(String state) {
        mainFrame.switchToolBar(state);
    }

    // Shows help
    public void showHelp() {
        changePanel(helpPanel);
    }

    // Get the current state    
    public String getCurrentState() {
        return currentState;
    }

    // Get the previous state
    public JPanel getPreviousPanel() {
        return previousPanel;
    }

    // Get the active frame
    public FrameMain getMainFrame() {
        return mainFrame;
    }

    // Get a user
    public static Person getCurrentUser() {
        return currentUser;
    }

    // Set a user
    public void setCurrentUser(Logon logon, Person person) {
        if (logon != null && person != null) {
            person.setLogon(logon);
            this.currentUser = person;
        } else {
            this.currentUser = null;
        }
    }

}
