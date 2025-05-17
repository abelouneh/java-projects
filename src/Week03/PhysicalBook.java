package Week03;
/*
 * This class represents a printed book.
 *
 * In addition to the general book info, printed books have:
 * - Cover type (hardcover or paperback)
 * - Number of pages
 * - Publisher name
 * - Number of copies available in stock
 */
public class PhysicalBook extends Book {

    // Enum to make cover type clear and limited to two choices
    public enum CoverType { HARDCOVER, PAPERBACK }

    private CoverType coverType;
    private int pages;
    private String publisher;
    private int availableCopies;

    /*
     * Constructor to create a PrintedBook object with all its properties.
     */
    public PhysicalBook(String isbn, String title, double price, String author,
                       CoverType coverType, int pages, String publisher, int availableCopies) {
        // Call the superclass constructor to set the common fields
        super(isbn, title, price, author);

        // Set the printed book specific fields
        this.coverType = coverType;
        this.pages = pages;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
    }

    // Getters for printed book properties
    public CoverType getCoverType() {
        return coverType;
    }

    public int getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    /*
     * Here we provide the description specific to printed books,
     * which will be appended to the general book info in the toString method.
     */
    @Override
    public String getDescription() {
        return String.format("Type: Printed (%s)\nPages: %d\nPublisher: %s\nAvailable Copies: %d",
                coverType, pages, publisher, availableCopies);
    }
}
