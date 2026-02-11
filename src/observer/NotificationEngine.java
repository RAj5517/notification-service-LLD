package observer;

import strategy.INotificationStrategy;

import java.util.ArrayList;
import java.util.List;

public class NotificationEngine implements IObserver {

    private final NotificationObservable observable;
    private final List<INotificationStrategy> strategies = new ArrayList<>();

    public NotificationEngine(NotificationObservable observable) {
        this.observable = observable;
    }

    public void addStrategy(INotificationStrategy strategy) {
        strategies.add(strategy);
    }

    @Override
    public void update() {
        String content = observable.getNotificationContent();

        for (INotificationStrategy strategy : strategies) {
            strategy.send(content);
        }
    }
}
