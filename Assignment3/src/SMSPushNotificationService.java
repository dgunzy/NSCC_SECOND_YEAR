public class SMSPushNotificationService implements NotificationService{

    @Override
    public void sendNotification(String name) {
        System.out.println("A text has been sent " + name + ". You have a late book!");
    }
}
