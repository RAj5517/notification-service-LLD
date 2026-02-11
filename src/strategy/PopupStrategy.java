package strategy;

public class PopupStrategy implements INotificationStrategy {

    @Override
    public void send(String content) {
        System.out.println("Showing Popup Notification");
        System.out.println(content);
        System.out.println("----------------------------------");
    }
}
