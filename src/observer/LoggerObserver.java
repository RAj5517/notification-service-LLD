package observer;

public class LoggerObserver implements IObserver {

    private final NotificationObservable observable;

    public LoggerObserver(NotificationObservable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        String content = observable.getNotificationContent();
        System.out.println("Logging Notification:");
        System.out.println(content);
    }
}
