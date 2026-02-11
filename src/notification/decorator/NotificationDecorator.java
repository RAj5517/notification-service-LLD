package notification.decorator;

import notification.INotification;

public abstract class NotificationDecorator implements INotification {

    protected INotification notification;

    public NotificationDecorator(INotification notification) {
        this.notification = notification;
    }

    @Override
    public abstract String getContent();
}
