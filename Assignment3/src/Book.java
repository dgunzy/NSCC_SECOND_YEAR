import java.util.ArrayList;
import java.time.LocalDate;

public class Book {
    public Book(String title, String author, Integer ISBN, LocalDate dueDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.dueDate = dueDate;
    }

    private String title;
    private String author;
    private Integer ISBN;
    private LocalDate dueDate;

    ArrayList<String> bookCategories = new ArrayList<>();


    public void addCategory(String category) {
        this.bookCategories.add(category);
    }
    public void removeCategory(String category) {
        try {
            this.bookCategories.remove(category);
        } catch (Exception e) {
            System.out.println("No book category of that type.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ArrayList<String> getBookCategories() {
        return bookCategories;
    }
    public void seeBookCategories() {
        for (String bookCategory : bookCategories) {
            System.out.println(bookCategory);
        }
    }
}
