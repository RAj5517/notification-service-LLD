package strategy;

public class EmailStrategy implements INotificationStrategy {

    private final String email;

    public EmailStrategy(String email) {
        this.email = email;
    }

    @Override
    public void send(String content) {
        System.out.println("Sending Email to " + email);
        System.out.println(content);
        System.out.println("----------------------------------");
    }
}
