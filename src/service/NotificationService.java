package service;

import notification.INotification;
import observer.NotificationObservable;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private static NotificationService instance;

    private final NotificationObservable observable;
    private final List<INotification> history;

    // Private constructor (Singleton)
    private NotificationService() {
        this.observable = new NotificationObservable();
        this.history = new ArrayList<>();
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public NotificationObservable getObservable() {
        return observable;
    }

    public void sendNotification(INotification notification) {
        // Store in history
        history.add(notification);

        // Notify observers
        observable.setNotification(notification);
    }

    public List<INotification> getHistory() {
        return history;
    }
}
