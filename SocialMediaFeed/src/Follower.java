import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Follower implements Observer {

    public Follower(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(SocialMediaPost socialMediaPost) {
        System.out.println(socialMediaPost.getAuthor().getName() + " posted " + socialMediaPost.getContent() + " on " + socialMediaPost.getPostCreationDate());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof SocialMediaPost) {
            SocialMediaPost post = (SocialMediaPost) arg;
            System.out.println(name + ", there was a new post by a person you follow!");
            System.out.println(post.getAuthor().getName() + " posted " + post.getContent() + " on " + post.getPostCreationDate() + "\n");
        }
    }
}
