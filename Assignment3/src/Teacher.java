import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher implements LibraryUser {

    private final SMSPushNotificationService smsNotification;
    public Teacher( String name,SMSPushNotificationService smsNotification) {
        this.smsNotification = smsNotification;
        this.name = name;
    }

    private final ArrayList<Book> checkedOutBooks = new ArrayList<>();

    private String name;

    @Override
    public void borrowBook(Book book) {
        book.setDueDate(LocalDate.now().plusWeeks(2));
        this.checkedOutBooks.add(book);
    }

    public Book returnBook(Book book) {
        checkedOutBooks.remove(book);
        return book;
    }
    public void extendDueDate() {
        for(int i = 0; i < checkedOutBooks.size(); i++)
            checkedOutBooks.get(i).setDueDate(LocalDate.now().minusWeeks(10));
    }
    public void checkBookDueDates() {
        if (checkedOutBooks.isEmpty()) {
            System.out.println("No overdue books!");
        } else {
            for (int i = 0; i < checkedOutBooks.size(); i++) {
                if (checkedOutBooks.get(i).getDueDate().isAfter(LocalDate.now().minusDays(1))) {
                    smsNotification.sendNotification(this.name);
                } else {
                    System.out.println(checkedOutBooks.get(i).getTitle() + " is not overdue!" );
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
