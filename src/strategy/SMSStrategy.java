package strategy;

public class SMSStrategy implements INotificationStrategy {

    private final String phoneNumber;

    public SMSStrategy(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String content) {
        System.out.println("Sending SMS to " + phoneNumber);
        System.out.println(content);
        System.out.println("----------------------------------");
    }
}
