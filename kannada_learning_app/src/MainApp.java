
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainApp() {
        setTitle("Kannada Language Learning App");
        setSize(1200, 900); // Default size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // Set the background color of the JFrame
        getContentPane().setBackground(new Color(230, 230, 255)); // Light blue background

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        getContentPane().add(cardPanel);

        // Welcome screen setup
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS)); // Using BoxLayout for vertical alignment
        welcomePanel.setBackground(new Color(255, 255, 255)); // White background for welcome screen
        welcomePanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Adding margin for spacing

        // Welcome label with introductory text
        JLabel welcomeLabel = new JLabel("<html><div style='text-align: center;'> <span style ='font-weight: bold; padding: 5px; border-radius: 5px;'>Welcome to Kannada learning app</span><br><br> <br>Hi, Hello, Namasthe! Welcome to Kannada learning through English.<br>"
                + "We have framed simple lessons through which you can learn Kannada easily.<br>"
                + "Kannada is the oldest language and is a very rich language.<br><br>"
                + "Click Continue to learn Kannada.</div></html>", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20)); // Larger, readable font
        welcomeLabel.setForeground(new Color(50, 50, 50)); // Dark grey color for text
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the text

        // Style for the Continue Button
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Larger, readable font
        continueButton.setForeground(Color.WHITE);
        continueButton.setBackground(new Color(0, 123, 255)); // Blue background for button
        continueButton.setFocusPainted(false);
        continueButton.setBorder(BorderFactory.createRaisedBevelBorder());
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button below text
        continueButton.setPreferredSize(new Dimension(200, 50)); // Make the button larger

        // Adding hover effect to the Continue button
        continueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueButton.setBackground(new Color(0, 102, 204)); // Darker blue on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueButton.setBackground(new Color(0, 123, 255)); // Original blue
            }
        });

        // When the continue button is clicked, show introduction panel
        continueButton.addActionListener(e -> cardLayout.show(cardPanel, "introduction"));

        // Adding components to welcomePanel
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(Box.createVerticalStrut(30)); // Add some space between the text and button
        welcomePanel.add(continueButton);

        // Options screen (for further lessons like Learn Letters and Learn Words)
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(2, 1, 10, 10)); // Grid with spacing
        optionsPanel.setBackground(new Color(255, 255, 255));

        // Buttons for options
        JButton optionsLetterButton = new JButton("Learn Letters");
        JButton optionsWordButton = new JButton("Learn Words");

        // Style buttons
        styleButton(optionsLetterButton);
        styleButton(optionsWordButton);

        optionsLetterButton.addActionListener(e -> cardLayout.show(cardPanel, "letters"));
        optionsWordButton.addActionListener(e -> cardLayout.show(cardPanel, "words"));

        optionsPanel.add(optionsLetterButton);
        optionsPanel.add(optionsWordButton);

        // Add panels to card layout
        cardPanel.add(welcomePanel, "welcome");
        cardPanel.add(optionsPanel, "options");

        // Add letters panel
        cardPanel.add(new LettersPanel(), "letters");

        // Add Swaragalu Panel
        cardPanel.add(new SwaragaluPanel(), "swaragalu");

        // Add Yogavahagalu Panel
        cardPanel.add(new YogavahagaluPanel(), "yogavahagalu");

        // Add TestLetter Panel
        cardPanel.add(new TestLetterPanel(), "testletter");

        // Add words panel
        cardPanel.add(new WordsPanel(), "words");

        // Add introduction panel
        cardPanel.add(new IntroductionPanel(cardLayout, cardPanel), "introduction");

        // Show the welcome screen initially
        cardLayout.show(cardPanel, "welcome");
    }

    // Helper method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 123, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}

