import java.util.ArrayList;

public class Library {
    ArrayList<Book> booksInStock = new ArrayList<>();

    public void addBook(Book book) {
        booksInStock.add(book);
    }

    public Book removeBook(Book book) {
        if(booksInStock.contains(book)){
            booksInStock.remove(book);
            return book;
        } else {
            return book;
        }
    }
    public void seeBooks() {
        for(int i = 0; i < booksInStock.size(); i++) {
            System.out.println(booksInStock.get(i).getTitle());
        }
    }
}
