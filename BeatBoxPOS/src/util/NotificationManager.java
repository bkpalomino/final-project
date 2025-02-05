package util;

import entity.Notification;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.util.Timer;
import javax.swing.JLabel;
import views.manager.PanelManager;

public class NotificationManager {

    private JToggleButton display;
    private PanelManager panelManager;
    private ImageIcon bellIcon;
    private ImageIcon bellActiveIcon;

    private Timer notificationClock;
    private TimerTask check;

    private ArrayList<Notification> notifications;

    int i = 0;

    public NotificationManager(PanelManager panelManager, JToggleButton display) {
        this.display = display;
        this.panelManager = panelManager;
        this.bellActiveIcon = ResourceLoader.getResourceIcon("icons/bell-active.png", ImageManager.SIZE_ICON);
        this.bellIcon = ResourceLoader.getResourceIcon("icons/bell.png", ImageManager.SIZE_ICON);

        this.display.setIcon(bellIcon);

        notificationClock = new Timer();
        notifications = new ArrayList<>();

        startNotifications();
    }

    private void startNotifications() {

        check = new TimerTask() {
            @Override
            public void run() {
                routineCheck();
            }
        };

        notificationClock.schedule(check, 0, 5000);
    }

    public void routineCheck() {
        notifications = DatabaseManager.getStockNotifications();
        if (notifications.size() > 0) {
            display.setIcon(bellActiveIcon);
            display.setText(String.valueOf(notifications.size()));
        } else {
            display.setIcon(bellIcon);
            display.setText("");
        }
        panelManager.loadNotifications();
        panelManager.refreshPages();
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

}
