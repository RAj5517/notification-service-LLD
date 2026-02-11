package notification.decorator;

import notification.INotification;
import java.time.LocalDateTime;

public class TimestampDecorator extends NotificationDecorator {

    public TimestampDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String getContent() {
        return "[" + LocalDateTime.now() + "] "
                + notification.getContent();
    }
}
