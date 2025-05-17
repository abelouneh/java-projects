package Week05;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SchoolMain extends JFrame {

    // UI components for displaying the image, input field, feedback, and button
    private JLabel imageLabel;
    private JTextField inputField;
    private JLabel feedbackLabel;
    private JButton nextButton;

    // List of image file names located in the /images folder
    private String[] imageFiles = {
            "cat.jpg",
            "dog.jpg",
            "giraffe.jpg",
            "mouse.jpg",
            "rat.jpg",
            "elephant.jpg"
    };

    // Index of the currently displayed animal
    private int currentIndex = -1;

    public SchoolMain() {
        // Set up the main window
        setTitle("Preschool Animal Letter Game");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Image label to show the animal
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Panel for input and feedback
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1));

        // Text field for user input
        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputField.addActionListener(new CheckAnswerListener()); // Listener for pressing Enter
        bottomPanel.add(new JLabel("Enter the first letter of the animal:"));
        bottomPanel.add(inputField);

        // Label for feedback after user enters a letter
        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        bottomPanel.add(feedbackLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button to load the next random animal
        nextButton = new JButton("Next Animal");
        nextButton.addActionListener(e -> showRandomImage());
        add(nextButton, BorderLayout.NORTH);

        // Show the first animal when the app starts
        showRandomImage();

        setVisible(true); // Make the window visible
    }

    // Loads a random image and displays it in the label
    private void showRandomImage() {
        inputField.setText("");           // Clear previous input
        feedbackLabel.setText("");        // Clear previous feedback

        Random rand = new Random();
        currentIndex = rand.nextInt(imageFiles.length); // Pick a random index

        // Load the image from /images/ folder using classpath
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + imageFiles[currentIndex]));

        // Resize image to fit nicely in the label
        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);

        // Display the image
        imageLabel.setIcon(icon);
    }

    // Inner class to check if the user's input is correct
    private class CheckAnswerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = inputField.getText().trim().toLowerCase(); // Get and clean input
            if (input.length() != 1) {
                feedbackLabel.setText("Enter only one letter."); // Validate input length
                return;
            }

            // Get the correct first letter from the image file name
            String correctLetter = imageFiles[currentIndex].substring(0, 1).toLowerCase();

            // Compare user input with correct letter
            if (input.equals(correctLetter)) {
                feedbackLabel.setText("✅ Correct!");
            } else {
                feedbackLabel.setText("❌ Oops! Try again.");
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        new SchoolMain();
    }
}