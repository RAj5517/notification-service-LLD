package notification.decorator;

import notification.INotification;

public class SignatureDecorator extends NotificationDecorator {

    private final String signature;

    public SignatureDecorator(INotification notification, String signature) {
        super(notification);
        this.signature = signature;
    }

    @Override
    public String getContent() {
        return notification.getContent()
                + "\n\nRegards,\n"
                + signature;
    }
}
