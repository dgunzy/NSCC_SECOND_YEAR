public class EmailNotificationService implements  NotificationService{

    @Override
    public void sendNotification(String name) {
        System.out.println("An email Has been sent " + name + ". You have a late book!");
    }
}
