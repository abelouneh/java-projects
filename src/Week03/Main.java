package Week03;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the main class where our bookstore lives.
 * We create some sample books and display them to the user.
 */
public class Main {

    public static void main(String[] args) {
        // This list will hold all our books (printed, digital, audiobooks)
        List<Book> books = new ArrayList<>();

        // Let's add some printed books to our store
        books.add(new PhysicalBook(
                "978-0134685991",
                "Effective Java",
                45.00,
                "Joshua Bloch",
                PhysicalBook.CoverType.HARDCOVER,
                416,
                "Addison-Wesley",
                12
        ));

        books.add(new PhysicalBook(
                "978-0596009205",
                "Head First Java",
                30.00,
                "Kathy Sierra",
                PhysicalBook.CoverType.PAPERBACK,
                720,
                "O'Reilly Media",
                5
        ));

        // Now add some digital books
        books.add(new EBook(
                "978-1491950357",
                "Learning Python",
                25.50,
                "Mark Lutz",
                5000  // size in KB
        ));

        books.add(new EBook(
                "978-1449331818",
                "JavaScript: The Good Parts",
                20.00,
                "Douglas Crockford",
                2000  // size in KB
        ));

        // Finally, add some audiobooks
        books.add(new AudioBook(
                "978-1501128035",
                "Becoming",
                15.00,
                "Michelle Obama",
                1140,  // duration in minutes
                "Michelle Obama"
        ));

        books.add(new AudioBook(
                "978-0385543767",
                "The Midnight Library",
                10.00,
                "Matt Haig",
                420,  // duration in minutes
                "Carey Mulligan"
        ));

        // Time to display all our books in the bookstore!
        System.out.println("Welcome to the E-Book Store!");
        System.out.println("Here is our collection of books:");

        for (Book book : books) {
            // Print each book's full info (thanks to toString method)
            System.out.println("--------------------------------------------------");
            System.out.println(book);
        }
    }
}
/*
* for the data of all books I asked chat gpt to create them
* but only the ISBN , Title , Author , Price , Type , Pages , Publisher , Available copies , Size , Duration , and narrator
* */