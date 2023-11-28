import java.time.LocalDate;

public class SocialMediaPost {
    public SocialMediaPost(User author, String content, LocalDate postCreationDate) {
        this.author = author;
        this.content = content;
        this.postCreationDate = postCreationDate;
    }

    private User author;

    private String content;

    private LocalDate postCreationDate;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getPostCreationDate() {
        return postCreationDate;
    }

    public void setPostCreationDate(LocalDate postCreationDate) {
        this.postCreationDate = postCreationDate;
    }
}
