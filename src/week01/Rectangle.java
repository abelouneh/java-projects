package week01;
public class Rectangle {
    private int width;   // Width of the rectangle
    private int height;  // Height of the rectangle

    // Constructor to initialize width and height of the rectangle
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Method to draw the rectangle using '*' characters
    public void draw() {
        // Draw the top border
        for (int i = 0; i < width; i++) {
            System.out.print("* ");  // Print '*' followed by space for better visibility
        }
        System.out.println(); // Move to the next line after top border

        // Draw the middle part of the rectangle (sides only, empty inside)
        // Only do this if height is more than 2 (because we need space between top and bottom)
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*"); // Left side border

            // Print spaces between left and right borders
            // (width - 2) * 2 + 1 to align with the spacing from "* "
            for (int j = 0; j < (width - 2) * 2 + 1; j++) {
                System.out.print(" ");
            }

            System.out.println("*"); // Right side border and move to next line
        }

        // Draw the bottom border only if the height is more than 1
        if (height > 1) {
            for (int i = 0; i < width; i++) {
                System.out.print("* "); // Same as top border
            }
            System.out.println(); // Move to next line after bottom border
        }

        // Print a blank line to separate rectangles in output
        System.out.println();
    }
}