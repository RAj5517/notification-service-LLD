package notification;

public class SimpleNotification implements INotification {

    private final String message;

    public SimpleNotification(String message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message;
    }
}
