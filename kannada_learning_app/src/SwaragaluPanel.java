import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SwaragaluPanel extends JPanel {

    public SwaragaluPanel() {
        setLayout(new BorderLayout());

        // Panel for Swaragalu (Vowels)
        JPanel swaragaluPanel = new JPanel();
        swaragaluPanel.setLayout(new GridLayout(0, 5, 10, 10)); // 5 columns for Swaragalu buttons
        swaragaluPanel.setBackground(Color.WHITE);

        // Panel for the title
        JPanel swaragaluTitlePanel = new JPanel();
        swaragaluTitlePanel.setLayout(new BorderLayout());
        swaragaluTitlePanel.add(new JLabel("<html><body style='font-family: Arial, sans-serif;text-align: center; padding: 20px;'><h2>Swaragalu (Vowels)</h2><br><p>Kannada alphabets have 13 vowels and these vowels are known as <b>Kannada Swaragalu</b>.</p></body></html>", JLabel.CENTER), BorderLayout.CENTER);

        // Add title panel to the main panel
        add(swaragaluTitlePanel, BorderLayout.NORTH);

        try {
            // Fetch Swaragalu (vowels) images and phonetic info
            ResultSet vowels = DatabaseHelper.getVowels(); // Fetch vowels from the database

            // Add buttons for Swaragalu (Vowels)
            for (int i = 1; i <= 13; i++) {
                if (vowels.next()) {
                    String image = vowels.getString("letter_image");
                    String phonetic = vowels.getString("english_phonetic");

                    // Create a button with the image for each vowel
                    LetterButton vowelButton = new LetterButton(image, phonetic);
                    swaragaluPanel.add(vowelButton);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Add Swaragalu panel to the main panel
        JScrollPane swaragaluScrollPane = new JScrollPane(swaragaluPanel);
        swaragaluScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(swaragaluScrollPane, BorderLayout.CENTER);
        
        // Continue button to move to the next panel (LetterButtonsPanel)
        JButton continueButton = new JButton("Continue");
        continueButton.setFont(new Font("Arial", Font.PLAIN, 18));
        continueButton.setBackground(new Color(0, 123, 255));
        continueButton.setForeground(Color.WHITE);
        continueButton.setPreferredSize(new Dimension(200, 50));
        continueButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        continueButton.addActionListener(e -> {
            // Transition to Swaragalu Panel
            ((CardLayout) getParent().getLayout()).show(getParent(), "yogavahagalu");
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(continueButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
    } 
}
