package client;

import notification.INotification;
import notification.SimpleNotification;
import notification.decorator.SignatureDecorator;
import notification.decorator.TimestampDecorator;
import observer.LoggerObserver;
import observer.NotificationEngine;
import service.NotificationService;
import strategy.EmailStrategy;
import strategy.PopupStrategy;
import strategy.SMSStrategy;

public class Main {

    public static void main(String[] args) {

        // Get service instance
        NotificationService service = NotificationService.getInstance();

        // Get observable
        var observable = service.getObservable();

        // Register Logger
        LoggerObserver logger = new LoggerObserver(observable);
        observable.addObserver(logger);

        // Register Notification Engine
        NotificationEngine engine = new NotificationEngine(observable);
        engine.addStrategy(new EmailStrategy("user@example.com"));
        engine.addStrategy(new SMSStrategy("9999999999"));
        engine.addStrategy(new PopupStrategy());

        observable.addObserver(engine);

        // Create base notification
        INotification notification =
                new SimpleNotification("Your order has been shipped");

        // Decorate it
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification, "Customer Support");

        // Send
        service.sendNotification(notification);
    }
}
