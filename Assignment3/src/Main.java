import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        LocalDate goodDueDate = LocalDate.now().plusDays(1);

        EmailNotificationService email = new EmailNotificationService();

        SMSPushNotificationService sms = new SMSPushNotificationService();

        Library NSCCLibrary = new Library();

        PhysicalBook LOTR = new PhysicalBook("Fellowship of the Ring", "J.R.R Tolkien", 1, goodDueDate);

        LOTR.addCategory("Fantasy");

        NSCCLibrary.addBook(LOTR);

        PhysicalBook Narnia = new PhysicalBook("The lion the witch and the wardrobe", "C,S. Lewis", 2, goodDueDate);
        Narnia.addCategory("Fiction");

        ebook Blink = new ebook("Blink", "Jeremy", 3, goodDueDate);
        Blink.addCategory("Non Fiction");

        NSCCLibrary.addBook(Narnia);
        NSCCLibrary.addBook(Blink);

        NSCCLibrary.seeBooks();

        LOTR.seeBookCategories();

        LOTR.removeCategory("Fantasy");

        LOTR.seeBookCategories();

        LOTR.addCategory("Fantasy");
        LOTR.addCategory("Non Fiction");
        LOTR.seeBookCategories();

        NSCCLibrary.removeBook(Blink);

        Student Jim = new Student("Jim", email);

        Teacher Bob = new Teacher("Bob", sms);
        NSCCLibrary.seeBooks();
        Jim.borrowBook(NSCCLibrary.removeBook(Narnia));
        NSCCLibrary.seeBooks();
        Jim.checkBookDueDates();

        NSCCLibrary.addBook(Jim.returnBook(Narnia));
        NSCCLibrary.seeBooks();

        Bob.borrowBook(NSCCLibrary.removeBook(LOTR));

        Bob.checkBookDueDates();

        Bob.extendDueDate();


        Bob.checkBookDueDates();
    }
}