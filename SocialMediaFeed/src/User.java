import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable {

    public User(String name) {
        this.name = name;
    }

    private String name;

    private ArrayList<SocialMediaPost> posts = new ArrayList<>();


    private ArrayList<Follower> followerList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void userPost(User user, String content) {
        SocialMediaPost post = new  SocialMediaPost(user, content, LocalDate.now());
        this.posts.add(post);
        setChanged();
        notifyObservers(post);
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    public void addFollower(Follower follower) {
        this.followerList.add(follower);
        addObserver(follower);
    }
    public void removeFollower(Follower follower) {
        if(this.followerList.contains(follower)) {
            followerList.remove(follower);
            deleteObserver(follower);

        } else  {
            System.out.println("User not in followers");
        }
    }
}
