import java.time.LocalDate;

public class PhysicalBook extends Book {
    private Boolean isHardCover;

    public PhysicalBook(String title, String author, Integer ISBN, LocalDate dueDate) {
        super(title, author, ISBN, dueDate);
    }


    public Boolean getHardCover() {
        return isHardCover;
    }

    public void setHardCover(Boolean hardCover) {
        isHardCover = hardCover;
    }
}
