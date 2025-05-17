package Week03;
/*
 * This is the base class for all types of books in our store.
 * It holds the common information every book has:
 * - ISBN code
 * - Title
 * - Price
 * - Author
 * Since books can be of different types (printed, digital, audiobook),
 * this class is abstract and expects subclasses to provide their specific details.
 */
public abstract class Book {

    private String isbn;
    private String title;
    private double price;
    private String author;

    /*
     * Constructor to create a new Book.
     * @param isbn   The unique ISBN code of the book.
     * @param title  The title of the book.
     * @param price  The price of the book.
     * @param author The author of the book.
     */
    public Book(String isbn, String title, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    // Simple getters for the basic fields
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    /*
     * This method will return a description of the specific book type,
     * like pages for printed books, size for digital books, or narrator for audiobooks.
     * Every subclass must implement this method.
     *
     * @return a String describing the unique attributes of the book type.
     */
    public abstract String getDescription();

    /*
     * Returns a nicely formatted String representing the whole book information,
     * including general info plus the specific description from subclasses.
     */
    @Override
    public String toString() {
        return String.format(
                "ISBN: %s\nTitle: %s\nAuthor: %s\nPrice: $%.2f\n%s",
                isbn, title, author, price, getDescription());
    }
}
