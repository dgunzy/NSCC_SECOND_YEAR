import java.util.ArrayList;
import java.time.LocalDate;

public class Student implements LibraryUser{

    private String name;

    private final EmailNotificationService emailNotification;

    public Student(String name, EmailNotificationService emailNotification) {
        this.name = name;
        this.emailNotification = emailNotification;
    }

    ArrayList<Book> checkedOutBooks = new ArrayList<>();
    @Override
    public void borrowBook(Book book) {
        book.setDueDate(LocalDate.now().plusWeeks(2));
        this.checkedOutBooks.add(book);
    }

    public Book returnBook(Book book) {
        checkedOutBooks.remove(book);
        return book;
    }
    public void checkBookDueDates() {
        if (checkedOutBooks.isEmpty()) {
            System.out.println("No overdue books!");
        } else {
            for (int i = 0; i < checkedOutBooks.size(); i++) {
                if (checkedOutBooks.get(i).getDueDate().isAfter(LocalDate.now().minusDays(1))) {
                    emailNotification.sendNotification(this.name);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
