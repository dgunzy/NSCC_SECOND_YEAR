import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ebook extends Book {


    public ebook(String title, String author, Integer ISBN, LocalDate dueDate) {
        super(title, author, ISBN, dueDate);
    }

    public void downloadEbook() {
        System.out.println("This ebook has been downloaded");
    }
}
