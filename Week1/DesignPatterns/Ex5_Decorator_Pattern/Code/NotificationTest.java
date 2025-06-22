package decoratorPattern;

public class NotificationTest {
    public static void main(String[] args) {
        Notifier notifier = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(
                                    new EmailNotifier()
                                )
                            );

        notifier.send("Server down at 3 AM.");
    }
}

