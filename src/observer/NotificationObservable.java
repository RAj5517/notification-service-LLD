package observer;

import notification.INotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationObservable implements IObservable {

    private final List<IObserver> observers = new ArrayList<>();
    private INotification notification;

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }

    public void setNotification(INotification notification) {
        this.notification = notification;
        notifyObservers();
    }

    public String getNotificationContent() {
        return notification.getContent();
    }
}
