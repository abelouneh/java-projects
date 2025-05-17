package Week03;
/*
 * This class models a digital book (like pdf, e-pub, kindle).
 *
 * Besides the basic book information, a digital book has:
 * - Size in kilobytes (KB)
 */
public class EBook extends Book {

    private int sizeKB;

    /*
     * Constructor to create a DigitalBook with its unique properties.
     */
    public EBook(String isbn, String title, double price, String author, int sizeKB) {
        super(isbn, title, price, author);
        this.sizeKB = sizeKB;
    }

    // Getter for size
    public int getSizeKB() {
        return sizeKB;
    }

    /*
     * Description for digital book, which shows the file size.
     */
    @Override
    public String getDescription() {
        return String.format("Type: Digital\nSize: %d KB", sizeKB);
    }
}
