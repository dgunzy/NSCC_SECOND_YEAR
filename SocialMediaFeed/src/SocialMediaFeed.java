import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Locale;

public class SocialMediaFeed {

    public static void main(String[] args) {


        User Jim = new User("Jim");

        Follower Frank = new Follower("Frank");

        Follower Ted = new Follower("Ted");

        Jim.addFollower(Frank);

        Jim.addFollower(Ted);

        Jim.userPost(Jim, "Hey Y'all how are you doing today??");

        User Alice = new User("Alice");

        Alice.addObserver(Frank);

        Alice.userPost(Alice, "Sooo tired of halloween lol");

        Jim.deleteObserver(Ted);

        Jim.userPost(Jim, "I hate ted haha");
    }
}
