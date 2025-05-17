package Week03;
/*
 * This class represents an audiobook.
 *
 * Audiobooks have some special properties, such as:
 * - Duration in minutes
 * - Narrator's name
 */
public class AudioBook extends Book {

    private int durationMinutes;
    private String narrator;

    /*
     * Create a new audiobook with all its info.
     */
    public AudioBook(String isbn, String title, double price, String author, int durationMinutes, String narrator) {
        super(isbn, title, price, author);
        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
    }

    // Getter for duration
    public int getDurationMinutes() {
        return durationMinutes;
    }

    // Getter for narrator name
    public String getNarrator() {
        return narrator;
    }

    /*
     * Description showing audiobook-specific details.
     */
    @Override
    public String getDescription() {
        return String.format("Type: Audiobook\nDuration: %d minutes\nNarrator: %s",
                durationMinutes, narrator);
    }
}
