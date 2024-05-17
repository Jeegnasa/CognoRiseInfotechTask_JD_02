import java.util.ArrayList;
//Task-02
class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public void checkOutBook(Book book) {
        if (!book.isCheckedOut()) {
            book.setCheckedOut(true);
            System.out.println("You have successfully checked out the book: " + book.getTitle());
        } else {
            System.out.println("Sorry, the book " + book.getTitle() + " is already checked out.");
        }
    }

    public void returnBook(Book book) {
        if (book.isCheckedOut()) {
            book.setCheckedOut(false);
            System.out.println("You have successfully returned the book: " + book.getTitle());
        } else {
            System.out.println("This book is already available in the library.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("Pride and Prejudice", "Jane Austen");

        // Create a library catalog
        LibraryCatalog catalog = new LibraryCatalog();

        // Add books to the catalog
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);

        // Search for books by title
        ArrayList<Book> searchResults = catalog.searchByTitle("To Kill a Mockingbird");
        if (!searchResults.isEmpty()) {
            System.out.println("Book(s) found by title:");
            for (Book book : searchResults) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        } else {
            System.out.println("No book found by title.");
        }

        // Search for books by author
        searchResults = catalog.searchByAuthor("F. Scott Fitzgerald");
        if (!searchResults.isEmpty()) {
            System.out.println("Book(s) found by author:");
            for (Book book : searchResults) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        } else {
            System.out.println("No book found by author.");
        }

        // Check out a book
        catalog.checkOutBook(book1);

        // Try to check out the same book again
        catalog.checkOutBook(book1);

        // Return a book
        catalog.returnBook(book1);
    }
}
